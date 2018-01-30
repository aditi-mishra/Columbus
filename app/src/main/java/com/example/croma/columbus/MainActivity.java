package com.example.croma.columbus;

import android.app.Activity;
import android.app.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = (Spinner)findViewById(R.id.spinner2);
        spinner.setOnItemSelectedListener(this);
       // List&lt;String&gt;  a = new ArrayList&lt;String&gt;();
        ArrayList<String>a = new ArrayList<>();
        a.add("A");
        a.add("B");
        a.add("C");
        a.add("D");
        a.add("E");
        a.add("F");
        a.add("G");
        a.add("I");
        a.add("J");
        a.add("K");
        a.add("L");
        a.add("M");
        a.add("N");
        a.add("O");
        a.add("P");

        //ArrayAdapter&lt;String&gt;dataAdapter = new ArrayAdapter&lt;String&gt;(this,android.R.layout.simple_spinner_item,a);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,a);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        int h = i%2;
        changeFragment(h);
        Toast.makeText(adapterView.getContext(),"Select",Toast.LENGTH_SHORT).show();
    }

    public void changeFragment(int id){
        Fragment fragment;
        if(id ==0){
            fragment = new Fragment_one();
           FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.Fraggy,fragment);
            ft.commit();

        }
        else{
            Fragment f = new Fragment_home();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
             ft.replace(R.id.Fraggy, f);
            ft.commit();
        }

    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}