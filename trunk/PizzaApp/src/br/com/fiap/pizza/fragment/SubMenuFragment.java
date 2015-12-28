package br.com.fiap.pizza.fragment;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import br.com.fiap.pizza.R;

public class SubMenuFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View myFragmentView = inflater.inflate(R.layout.submenu,
				container, false);
		return myFragmentView;
	}
}
