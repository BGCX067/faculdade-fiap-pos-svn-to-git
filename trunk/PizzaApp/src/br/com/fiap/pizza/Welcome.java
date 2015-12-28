package br.com.fiap.pizza;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;

public class Welcome extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		
		int result = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());
		System.out.println(result  + " ********************************************************* " + ConnectionResult.SUCCESS);
		
		Button entrega = (Button) findViewById(R.id.entregaBtn);
		entrega.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(v.getContext(), MenuActivity.class);
				startActivity(i);
			}
		});
	}
}
