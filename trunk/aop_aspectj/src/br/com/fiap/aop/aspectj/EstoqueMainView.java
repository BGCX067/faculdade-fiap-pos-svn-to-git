package br.com.fiap.aop.aspectj;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import br.com.fiap.atividade.bean.Cliente;
import br.com.fiap.atividade.bean.Pedido;
import br.com.fiap.atividade.bean.Produto;
import br.com.fiap.atividade.dao.ClienteDao;
import br.com.fiap.atividade.dao.ClienteDaoImpl;
import br.com.fiap.atividade.dao.EstoqueDao;
import br.com.fiap.atividade.dao.EstoqueDaoImpl;
import br.com.fiap.atividade.service.PedidoService;
import br.com.fiap.atividade.service.PedidoView;

/***
 * Classe que define a interface do sistema.
 * @author Carlos Barbero - carlosrgomes@gmail.com
 * Data: Jul 9, 2013 - 8:10:27 PM
 *
 */
public class EstoqueMainView {
	
	private Logger logger = Logger.getLogger(EstoqueMainView.class);

	protected Shell shell;
	private Text nrPedido;
	private Text textQuantidade;
	private Text txtTotalGeral;
	private Table table;
	private List<Pedido> pedidoList = null;
	private Double totalGeral = new Double(0);
	private Date dataSistema = new Date();

	/**
	 * Metodo principal da aplicao.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			EstoqueMainView window = new EstoqueMainView();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(505, 421);
		shell.setText("SWT Application");
		
		Label lblNroPedido = new Label(shell, SWT.NONE);
		lblNroPedido.setBounds(30, 23, 67, 14);
		lblNroPedido.setText("Nro. Pedido");
		
		nrPedido = new Text(shell, SWT.BORDER);
		nrPedido.setEditable(false);
		nrPedido.setBounds(103, 20, 83, 19);
		
		Label lblData = new Label(shell, SWT.NONE);
		lblData.setBounds(202, 23, 59, 14);
		lblData.setText("Data");
		
		final DateTime dateTime = new DateTime(shell, SWT.DATE);
		dateTime.setBounds(240, 10, 207, 27);
		dateTime.setCapture(true);
		
		dateTime.addSelectionListener (new SelectionAdapter () {
	        public void widgetSelected (SelectionEvent e) {
	        	System.out.println(dateTime.getMonth());
	            System.out.println(dateTime.getYear());
	            dataSistema = new Date(dateTime.getYear() -1900, dateTime.getMonth(), dateTime.getDay());
	        }
	    });
		
		Label lblTipoCliente = new Label(shell, SWT.NONE);
		lblTipoCliente.setBounds(30, 57, 67, 14);
		lblTipoCliente.setText("Tipo Cliente");
		
		final Combo comboTipoCliente = new Combo(shell, SWT.NONE);
		comboTipoCliente.setBounds(103, 53, 83, 22);
		comboTipoCliente.add(TipoCliente.FISICO.getDescricao());
		comboTipoCliente.add(TipoCliente.JURIDICO.getDescricao());
		comboTipoCliente.select(0);
		
		Label lblCliente = new Label(shell, SWT.NONE);
		lblCliente.setBounds(30, 95, 59, 14);
		lblCliente.setText("Cliente");
		
		final Combo comboCliente = new Combo(shell, SWT.NONE);
		comboCliente.setBounds(104, 90, 228, 35);
		ClienteDao clienteDao = new ClienteDaoImpl();
		List<Cliente> listClientes = clienteDao.getClientes();
		for (Cliente cliente : listClientes) {
			comboCliente.add(cliente.getNome());
		}
		
		
		Label lblProduto = new Label(shell, SWT.NONE);
		lblProduto.setBounds(30, 135, 59, 14);
		lblProduto.setText("Produto");
		
		final Combo comboProduto = new Combo(shell, SWT.NONE);
		comboProduto.setBounds(103, 131, 228, 22);
		
		EstoqueDao estoqueDao = new EstoqueDaoImpl();
		List<Produto> lisProdutos = estoqueDao.getProdutos();
		for (Produto produto : lisProdutos) {
			comboProduto.add(produto.getDscProduto());
		}
		
		
		Label lblQuantidade = new Label(shell, SWT.NONE);
		lblQuantidade.setBounds(337, 135, 67, 14);
		lblQuantidade.setText("Quantidade");
		
		textQuantidade = new Text(shell, SWT.BORDER);
		textQuantidade.setBounds(405, 132, 43, 19);
		
		final Cliente cliente = new Cliente();
		
		final ScrolledComposite scrolledComposite = new ScrolledComposite(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setBounds(30, 199, 452, 150);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		createTable(scrolledComposite);
		
		
		Button btnAdicionarProdutor = new Button(shell, SWT.NONE);
		btnAdicionarProdutor.addSelectionListener(new SelectionAdapter() {
			int primeiraVez = 0;
			@Override
			public void widgetSelected(SelectionEvent e) {
				getClient(comboCliente, cliente);
				getTipoCliente(comboTipoCliente, cliente);
				getProduto(comboProduto, cliente);
				getQuantidade(textQuantidade, cliente);
				getDataCompra(dateTime, cliente);
				
				
				EstoqueDao estoqueDao = new EstoqueDaoImpl();
				
				
				try {
					pedidoList = estoqueDao.salvarCompras(cliente, dataSistema );
					if(primeiraVez > 0){
						table.dispose();
						createTable(scrolledComposite);
					}
					
					
					List<PedidoView> lisPedidoViews = new PedidoService().sumarizar(pedidoList, dataSistema);
					
					for (PedidoView pedido : lisPedidoViews) {
						primeiraVez++;
						TableItem tableItem = new TableItem(table, SWT.NO);
						tableItem.setText(0, String.valueOf(pedido.getIdProduto()));
						tableItem.setText(1, pedido.getDescricaoProduto());
						tableItem.setText(2, pedido.getValorUnitario());
						tableItem.setText(3, pedido.getQuantidade());
						tableItem.setText(4, pedido.getDesconto() );
						tableItem.setText(5, pedido.getTotal());
						nrPedido.setText(pedido.getIdPedido().toString());
						txtTotalGeral.setText(pedido.getTotalPedido());
					}
					
					
				} catch (ClassNotFoundException | SQLException e1) {
					logger.error("Erro: ", e1);
				} 
			}

			

			private void getDataCompra(DateTime dateTime, Cliente cliente) {
				cliente.setDataCompra((Date)dateTime.getData());
			}

			private void getQuantidade(Text textQuantidade, Cliente cliente) {
				try{
					cliente.getProduto().setQtd(Long.parseLong(textQuantidade.getText()));
				}catch(NumberFormatException e){
					mensagemError("Informações!", "Informe a quantidade correta");
				}
			}

			private void getProduto(Combo comboProduto, Cliente cliente) {
				if(StringUtils.isNotBlank(comboProduto.getText())){
					for (String selecionado : comboProduto.getItems()) {
						if(comboProduto.getText().equals(selecionado)){
							Produto produto = new Produto();
							produto.setDscProduto(selecionado);
							cliente.setProduto(produto);
							break;
						}
					}
					
				}else{
					mensagemError("Informações!", "Selecione um Produto!");
				}
			}

			private void getTipoCliente(Combo comboTipoCliente, Cliente cliente) {
				if(StringUtils.isNotBlank(comboTipoCliente.getText())){
					cliente.setTipoCliente(comboTipoCliente.getText().equals("Fisica") ? TipoCliente.FISICO : TipoCliente.JURIDICO);
				}else{
					mensagemError("Informações!", "Selecione um Tipo de cliente!");
				}
			}

			private void getClient(final Combo comboCliente, final Cliente cliente) {
				if(StringUtils.isNotEmpty(comboCliente.getText())){
					cliente.setNome(comboCliente.getText());
				}else{
					mensagemError("Informações!", "Selecione um cliente!");
				}
			}

			private void mensagemError(String titulo, String mensagem) {
				MessageBox dialog = new MessageBox(shell, SWT.ERROR | SWT.OK);
				dialog.setText(titulo);
				dialog.setMessage(mensagem);
				dialog.open();
			}
			
			
			
		});
		btnAdicionarProdutor.setBounds(30, 165, 133, 28);
		btnAdicionarProdutor.setText("Adicionar Produto");
		
		Label lblTotalGeral = new Label(shell, SWT.NONE);
		lblTotalGeral.setBounds(239, 172, 67, 14);
		lblTotalGeral.setText("Total Geral");
		
		txtTotalGeral = new Text(shell, SWT.BORDER);
		txtTotalGeral.setBounds(304, 169, 148, 19);
		
		
		
		
		
		
		Button btnFinalizado = new Button(shell, SWT.CHECK);
		btnFinalizado.setBounds(30, 359, 93, 18);
		btnFinalizado.setText("Finalizado");
		
		Button btnAtualizarTotal = new Button(shell, SWT.NONE);
		btnAtualizarTotal.setBounds(371, 355, 111, 28);
		btnAtualizarTotal.setText("Atualizar Total");

	}
	
	private void createTable(final ScrolledComposite scrolledComposite) {
		table = new Table(scrolledComposite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(74);
		tblclmnNewColumn.setText("Id Produto");
		
		TableColumn tblclmnDescProduto = new TableColumn(table, SWT.NONE);
		tblclmnDescProduto.setWidth(106);
		tblclmnDescProduto.setText("Desc Produto");
		
		TableColumn tblclmnVlrUnitario = new TableColumn(table, SWT.NONE);
		tblclmnVlrUnitario.setWidth(80);
		tblclmnVlrUnitario.setText("Vlr Unit\u00E1rio");
		
		TableColumn tblclmnQde = new TableColumn(table, SWT.NONE);
		tblclmnQde.setWidth(38);
		tblclmnQde.setText("Qde");
		
		TableColumn tblclmnDesconto = new TableColumn(table, SWT.NONE);
		tblclmnDesconto.setWidth(79);
		tblclmnDesconto.setText("Desconto");
		
		TableColumn tblclmnTotal = new TableColumn(table, SWT.NONE);
		tblclmnTotal.setWidth(73);
		tblclmnTotal.setText("Total");
		scrolledComposite.setContent(table);
		scrolledComposite.setMinSize(table.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	}
}
