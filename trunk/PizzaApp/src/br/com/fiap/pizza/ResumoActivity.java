package br.com.fiap.pizza;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ResumoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resumo);

		MenuActivity menu = new MenuActivity();

		LinearLayout resumo = (LinearLayout) findViewById(R.id.resumoLayout);

		for (String p : menu.pedidos.keySet()) {
			PedidoHelper pedidoHelper = (PedidoHelper) menu.pedidos.get(p);
			System.out.println(pedidoHelper.getCount());
			Item item = (Item) pedidoHelper.getObj();
			Drawable drawable = getResources().getDrawable(
					getResources().getIdentifier(item.getTipo() + item.getId(),
							"drawable", getPackageName()));
			ImageButton btn = new ImageButton(getApplicationContext());
			btn.setImageDrawable(drawable);
			TextView nome = new TextView(getApplicationContext());
			nome.setText(item.getNome());

			TextView qtd = new TextView(getApplicationContext());
			qtd.setText(String.valueOf(pedidoHelper.getCount()) + "X");
			qtd.setTextAlignment(TextView.TEXT_ALIGNMENT_TEXT_START);

			TextView valor = new TextView(getApplicationContext());
			valor.setText("R$ " + item.getValor() * pedidoHelper.getCount());
			valor.setTextAlignment(TextView.TEXT_ALIGNMENT_TEXT_START);

			resumo.addView(qtd);
			resumo.addView(valor);

			resumo.addView(nome);
			resumo.addView(btn);
		}

		Button mapsBtn = (Button) findViewById(R.id.mapsBtn);
		mapsBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(v.getContext(), MapsActivity.class);
				startActivity(i);
			}
		});
	}

}
