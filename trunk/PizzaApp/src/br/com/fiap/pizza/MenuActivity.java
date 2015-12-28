package br.com.fiap.pizza;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends Activity {

	public static Map<String, PedidoHelper> pedidos;

	private List<Item> pizzas = new ArrayList<Item>();
	private List<Item> bebidas = new ArrayList<Item>();
	private ProdutosDAO produtosDAO;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);

		produtosDAO = new ProdutosDAO(this.getApplicationContext());

		SharedPreferences settings = getSharedPreferences("prefs", 0);
		boolean firstRun = settings.getBoolean("firstRun", true);
		if (firstRun) {
			produtosDAO.cargaInicial();
			Editor ed = settings.edit();
			ed.putBoolean("firstRun", false);
			ed.commit();
			System.out.println("********************************************************");
		}

		pedidos = new HashMap<String, PedidoHelper>();

		LinearLayout layoutPizza = (LinearLayout) findViewById(R.id.conteudoSubMenuPizza);
		layoutPizza.setVisibility(LinearLayout.INVISIBLE);

		LinearLayout layoutBebida = (LinearLayout) findViewById(R.id.conteudoSubMenuBebida);
		layoutBebida.setVisibility(LinearLayout.INVISIBLE);

		buttonActions(layoutPizza, layoutBebida);

		subMenuBebidasActions();
		subMenuPizzaActions();
	}

	private void buttonActions(final LinearLayout layoutPizza,
			LinearLayout layoutBebida) {
		ImageButton pizzaBtn = (ImageButton) findViewById(R.id.pizza);
		pizzaBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				LinearLayout layoutBebida = (LinearLayout) findViewById(R.id.conteudoSubMenuBebida);
				layoutBebida.setVisibility(LinearLayout.INVISIBLE);

				LinearLayout layoutPizza = (LinearLayout) findViewById(R.id.conteudoSubMenuPizza);
				layoutPizza.setVisibility(LinearLayout.VISIBLE);
			}
		});

		ImageButton bebidasBtn = (ImageButton) findViewById(R.id.drinks);
		bebidasBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				LinearLayout layoutBebida = (LinearLayout) findViewById(R.id.conteudoSubMenuBebida);
				layoutBebida.setVisibility(LinearLayout.VISIBLE);

				LinearLayout layoutPizza = (LinearLayout) findViewById(R.id.conteudoSubMenuPizza);
				layoutPizza.setVisibility(LinearLayout.INVISIBLE);
				System.out.println("entrou bebidas");
			}
		});

		Button proximoBtn = (Button) findViewById(R.id.proximoBtn);
		proximoBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(v.getContext(), ResumoActivity.class);
				startActivity(i);
			}
		});

	}

	private void subMenuBebidasActions() {
		LinearLayout layout = (LinearLayout) findViewById(R.id.conteudoSubMenuBebida);
		bebidas = produtosDAO.getProdutos("bebidas");
		for (int j = 0; j < bebidas.size(); j++) {
			ImageButton btn = new ImageButton(layout.getContext());

			LinearLayout linha = new LinearLayout(getApplicationContext());
			linha.setOrientation(LinearLayout.HORIZONTAL);
			linha.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
					LayoutParams.FILL_PARENT));
			Drawable drawable = getResources().getDrawable(
					getResources().getIdentifier(
							"bebidas" + bebidas.get(j).getId(), "drawable",
							getPackageName()));
			btn.setImageDrawable(drawable);
			TextView nome = new TextView(getApplicationContext());
			nome.setText(bebidas.get(j).getNome());

			TextView conteudo = new TextView(getApplicationContext());
			conteudo.setText(bebidas.get(j).getConteudo());
			conteudo.setTextAlignment(TextView.TEXT_ALIGNMENT_TEXT_START);

			linha.addView(conteudo);
			btn.setTag(bebidas.get(j));
			btn.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					addItem("bebidas", (Item) v.getTag());
				}
			});
			linha.addView(btn);
			layout.addView(nome);
			layout.addView(linha);
		}
	}

	private void subMenuPizzaActions() {
		LinearLayout layout = (LinearLayout) findViewById(R.id.conteudoSubMenuPizza);
		pizzas = produtosDAO.getProdutos("pizza");
		for (int j = 0; j < pizzas.size(); j++) {
			ImageButton btn = new ImageButton(layout.getContext());

			LinearLayout linha = new LinearLayout(getApplicationContext());
			linha.setOrientation(LinearLayout.VERTICAL);
			linha.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
					LayoutParams.FILL_PARENT));
			Drawable drawable = getResources().getDrawable(
					getResources().getIdentifier("pizza" + j, "drawable",
							getPackageName()));
			btn.setImageDrawable(drawable);
			TextView nome = new TextView(getApplicationContext());
			nome.setText(pizzas.get(j).getNome());

			TextView conteudo = new TextView(getApplicationContext());
			conteudo.setText(pizzas.get(j).getConteudo());
			conteudo.setTextAlignment(TextView.TEXT_ALIGNMENT_TEXT_START);

			TextView valor = new TextView(getApplicationContext());
			valor.setText("R$ " + pizzas.get(j).getValor().toString());
			valor.setTextAlignment(TextView.TEXT_ALIGNMENT_TEXT_START);

			linha.addView(conteudo);
			linha.addView(valor);
			btn.setTag(pizzas.get(j));
			btn.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					addItem("pizza", (Item) v.getTag());
				}
			});
			linha.addView(btn);
			layout.addView(nome);
			layout.addView(linha);
		}
	}

	private void addItem(String tipo, Item item) {
		if (pedidos.get(tipo + item.getNome()) == null) {
			pedidos.put(tipo + item.getNome(), new PedidoHelper(1, item));
		} else {
			PedidoHelper p = pedidos.get(tipo + item.getNome());
			p.addCount();
			System.out.println("teste");
		}
		Toast toast = Toast.makeText(getApplicationContext(),
				"Produto adicionado", 1000);
		toast.show();
		/*
		 * for(int j=0;j<pedidos.size();j++){ PedidoHelper p = (PedidoHelper)
		 * pedidos.values().toArray()[j]; System.out.println(p.getCount()); }
		 */
	}

}