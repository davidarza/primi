package com.example.primitiva;

import java.util.Random;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

public class Generador extends Activity {
	TextView NumAle;
	 
	public void Numeros(View v){
		Random r=new Random();
    	int valor;
		String resultado = null;
		
		for (int i = 0; i <6; i++) {
			valor=r.nextInt(i);
			resultado=Integer.toString(valor);
					
		
		}
		NumAle.setText(resultado);
		
		
		//resultado=getText().toString().valueOf(resultado);
	}
}
