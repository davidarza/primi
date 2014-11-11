package com.example.primitiva;



import java.util.ArrayList;
import java.util.Random;


import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

	TextView NumAle1;
	 
	  
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      
        NumAle1=(TextView)findViewById(R.id.NumAle);
        SharedPreferences prefe=getSharedPreferences("Numeros",Context.MODE_PRIVATE);
        NumAle1.setText(prefe.getString("numAl","")); 
      
    }
    
    public void Numeros(View v){
	
    	String resultado;    	
    	Random rd=new Random();
    	int numeros;
    	ArrayList<Integer> numAl=new ArrayList<Integer>();
    	
    	for (int i = 0; i <6; i++) {
    		numeros=(rd.nextInt(49)+1);
    		while(numAl.contains(numeros)){
    			numeros=(rd.nextInt(49)+1);
    		}
    		numAl.add(numeros);
		}
        resultado=""+numAl;
       NumAle1.setText(resultado);   
       
       SharedPreferences preferencias=getSharedPreferences("Numeros",Context.MODE_PRIVATE);
       Editor editor=preferencias.edit();
       editor.putString("numAl", NumAle1.getText().toString());
       editor.commit();      
       
      
      }
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
