package br.com.fiap.pizza;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.gms.maps.MapFragment;

public class MapsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.maps);
		MapFragment map = ((MapFragment) getFragmentManager().findFragmentById(
				R.id.fragmentMap));
		

	}
}
