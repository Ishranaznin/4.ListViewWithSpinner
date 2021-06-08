package com.ishra.spinner_and_listview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
Integer[] quantity={1,4,7,8,9,11, 14,16,19};
Integer[] price={100,200,400,500,600,700,800,900};
Spinner spin;
ListView lv;
EditText e1,e2,e3;
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        spin=findViewById(R.id.spinner);
        e1=findViewById(R.id.ed1);
        e2=findViewById(R.id.ed2);
        e3=findViewById(R.id.ed3);
        lv=findViewById(R.id.lv1);
        b=findViewById(R.id.bt1);
        ArrayAdapter qq=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,quantity);
        spin.setAdapter(qq);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter pp=new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,price);
        lv.setAdapter(pp);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Integer pos=price[position];
                String value = String.valueOf(pos);
                e2.setText(value);
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String q1 = e1.getText().toString();
                String p1 = e2.getText().toString();
                Double iq1 = Double.valueOf(q1);
                Double ip1 = Double.valueOf(p1);
                Double multiple=iq1*ip1;
                String gmultiple=String.valueOf(multiple);
                e3.setText("Multiplication of two values is "+gmultiple);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
       Integer v=quantity[position];
        String value = String.valueOf(v);
        e1.setText(value);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
