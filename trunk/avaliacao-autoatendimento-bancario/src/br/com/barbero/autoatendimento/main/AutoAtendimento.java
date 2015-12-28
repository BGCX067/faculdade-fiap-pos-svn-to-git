package br.com.barbero.autoatendimento.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import br.com.barbero.autoatendimento.bean.Cliente;
import br.com.barbero.autoatendimento.bean.Extrato;
import br.com.barbero.autoatendimento.dao.ClienteDaoImpl;
import br.com.barbero.autoatendimento.util.BancoUtil;

public class AutoAtendimento {

	/***
	 * Metodo responsavel por iniciar as chamadas ao terminal de atendimento.
	 * Principal metodo que inicia todo o ciclo de stack.
	 * @param cliente {@link Cliente}
	 * @throws {@link IOException} caso ocorra algum problema com o arquivo.
	 */
	protected static void processarAutoAtendimento(Cliente cliente)
			throws IOException {
				int operacao = imprimirMenu(cliente);
				operacaoBancaria(cliente, operacao);
			}

	/***
	 * Metodo controlado que as chamadas ao negocio do Atendimento Bancario.
	 * @param cliente {@link Cliente} 
	 * @param operacao {@link Integer} utilizado para saber qual menu o cliente deseja.
	 * @throws {@link IOException} caso ocorra algum problema com o arquivo.
	 */
	private static void operacaoBancaria(Cliente cliente, int operacao)
			throws IOException {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			
				switch (operacao) {
				case 1: 
					System.out.println("Saldo em "+simpleDateFormat.format(new Date()) +" no valor de "+BancoUtil.getValorFormatado(cliente.getConta().getSaldoDaConta()) );
					realizarOperacaoNovamente(cliente);
					break;
				case 2:
					System.out.println("Extrato em "+ simpleDateFormat.format(new Date()).toString());
					impressaoExtrato(cliente.getConta().getOperacoes(), cliente.getConta().getSaldoDaConta());
					realizarOperacaoNovamente(cliente);
					break;
				case  3:
					System.out.println("Realizando saque em" +simpleDateFormat.format(new Date()).toString());
					System.out.println("Digite o Valor do Saque:");
					Scanner saque = new Scanner(System.in);
					BigDecimal valorSaque = saque.nextBigDecimal();
					if(BancoUtil.isValidSaqueDeposito(valorSaque)){
						ClienteDaoImpl clienteDaoImpl = new ClienteDaoImpl();
						clienteDaoImpl.sacar(cliente, valorSaque);
						cliente = clienteDaoImpl.consultar(cliente.getId());
						realizarOperacaoNovamente(cliente);
					}else{
						System.out.println("Valor Para Saque errado!");
						realizarOperacaoNovamente(cliente);
					}
					
					break;
				case 4:
					System.out.println("Realizando deposito em: "+ simpleDateFormat.format(new Date()).toString());
					System.out.println("Digite o Valor do Deposito:");
					Scanner deposito = new Scanner(System.in);
					BigDecimal valorDepositor = deposito.nextBigDecimal();
					if(BancoUtil.isValidSaqueDeposito(valorDepositor)){
						ClienteDaoImpl clienteDaoImpl = new ClienteDaoImpl();
						clienteDaoImpl.depositar(cliente, valorDepositor);
						cliente = clienteDaoImpl.consultar(cliente.getId());
						realizarOperacaoNovamente(cliente);
					}else{
						System.out.println("Valor Para Depósito errado!");
						realizarOperacaoNovamente(cliente);
					}
					
					break;
				case 5:
					System.out.println("Gerando o extrato Impresso em "+ simpleDateFormat.format(new Date()).toString());
					String arquivo = impressaoExtratoPapel(cliente.getConta().getOperacoes(), cliente.getConta().getSaldoDaConta(), cliente);
					System.out.println("Seu extrato foi gerado: "+arquivo);
					realizarOperacaoNovamente(cliente);
					break;
				default:
					break;
				}
			}

	/***
	 * Metodo responsavel por iniciar novamente outras opcoes de menu do terminal de atendimento.
	 * @param cliente {@link Cliente}
	 * @throws {@link IOException} caso ocorra algum problema com o arquivo.
	 */
	private static void realizarOperacaoNovamente(Cliente cliente)
			throws IOException {
				System.out.println("Deseja Realizar outra operação? Digite S (SIM) N (Não)");
				@SuppressWarnings("resource")
				Scanner continuar =  new Scanner(System.in);
				String desejaContinuar =  continuar.next();
				if(desejaContinuar.equalsIgnoreCase("S")){
					processarAutoAtendimento(cliente);
				}else{
					System.exit(-1);
				}
			}

	/***
	 * Metodo inicializa o script sql para criacao do banco de dados e o insert de 3 clientes.
	 * @return {@link Cliente}
	 * @throws {@link FileNotFoundException}
	 * @throws {@link SQLException}
	 */
	@SuppressWarnings("resource")
	protected static Cliente inicializaAutoAtendimento()
			throws FileNotFoundException, SQLException {
				BancoUtil.cargaInicial();
				BancoUtil.impressaoNomeBanco();
				System.out.println("Informe o Número da Conta:");
				Scanner sc = new Scanner(System.in);
				long numeroConta = sc.nextLong();
				ClienteDaoImpl clienteDaoImpl = new ClienteDaoImpl();
				Cliente cliente = clienteDaoImpl.consultar(numeroConta);
				return cliente;
			}

	/***
	 * Metodo que inicializa o menu do terminal de atendimento.
	 * @param cliente {@link Cliente}
	 * @return {@link Integer} numero para saber como chamar o controlado de operacoes do terminal de atendimento.
	 */
	@SuppressWarnings("resource")
	private static int imprimirMenu(Cliente cliente) {
		System.out.println("Selecione a Operação que deseja:");
		System.out.println("1. Consultar Saldo");
		System.out.println("2. Extrato em Tela");
		System.out.println("3. Saque");
		System.out.println("4. Depósito");
		System.out.println("5. Extrato Impresso");
		Scanner opcoes = new Scanner(System.in);
		int op = opcoes.nextInt();
		
		return op;
	}

	/***
	 * Metodo responsavel pela impressao do extrato em tela.
	 * @param extratos {@link List} de {@link Extrato} onde contem as informacoes de todas as operacoes de saque e deposito do cliente.
	 * @param saldoAtual {@link BigDecimal} recebe o valor do saldo atual para informar no extrato.
	 */
	private static void impressaoExtrato(List<Extrato> extratos, BigDecimal saldoAtual) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		for (Extrato extrato : extratos) {
			
			System.out.println("Data: "+simpleDateFormat.format(extrato.getDataOperacao())
								+" "+ extrato.getTipoDaOperacao().getTipoOperacao()
								+" "+ BancoUtil.getValorFormatado(extrato.getValor()));
			
		}
		System.out.println("Saldo Atual: "+BancoUtil.getValorFormatado(saldoAtual));
	}

	/***
	 * Metodo responsavel por fazer a impressao em papel do extrato.
	 * @param extratos {@link List} de {@link Extrato} onde contem as informacoes de todas as operacoes de saque e deposito do cliente.
	 * @param saldoAtual {@link BigDecimal} recebe o valor do saldo atual para informar no extrato.
	 * @param cliente {@link Cliente} para ter informacoes a respeito da conta.
	 * @return {@link String} contendo onde o extrato foi salvo.
	 * @throws {@link IOException} caso ocorra algum problema com o arquivo.
	 */
	private static String impressaoExtratoPapel(List<Extrato> extratos, BigDecimal saldoAtual,
			Cliente cliente) throws IOException {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
				File extratoPapel = new File(new File("Extrato_"+cliente.getNome().replace(" ", "_")+"_conta_"+cliente.getConta().getId())+".txt");
				FileWriter fileWriter =  new FileWriter(extratoPapel);
				
				for (Extrato extrato : extratos) {
					
					fileWriter.write("Data: "+simpleDateFormat.format(extrato.getDataOperacao())
										+" "+ extrato.getTipoDaOperacao().getTipoOperacao()
										+" "+ BancoUtil.getValorFormatado(extrato.getValor()) +"\n");
					
				}
				fileWriter.write("Saldo Atual: "+BancoUtil.getValorFormatado(saldoAtual));
				fileWriter.flush();
				fileWriter.close();
				return extratoPapel.getAbsoluteFile().toString();
			}

	public AutoAtendimento() {
		super();
	}

}