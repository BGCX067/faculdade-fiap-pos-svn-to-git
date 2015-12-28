package br.com.fiap;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CalculadoraActivity extends Activity {
	
    EditText valor  = null;
    EditText pocenagem = null;
	 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
        setContentView(R.layout.activity_calculadora);
        valor = (EditText) findViewById(R.id.editText1);
        pocenagem = (EditText) findViewById(R.id.editText2);
        
        Button btCalcular = (Button) findViewById(R.id.button1);
       
        

        
        btCalcular.setOnClickListener(new OnClickListener() {
			private AlertDialog create;

			@Override
			public void onClick(View v) {
				double valorc = Double.parseDouble(valor.getText().toString());
				double pocenagemc = Double.parseDouble(pocenagem.getText().toString());
				double resulado = valorc * (pocenagemc / 100);
				
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(v.getContext());
				alertDialogBuilder.setTitle("Resultado");
				alertDialogBuilder.setMessage("Resultado: "+resulado);
				alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				});

				create = alertDialogBuilder.create();
				create.show();
			}
		});
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_calculadora, menu);
        return true;
    }
    
}
