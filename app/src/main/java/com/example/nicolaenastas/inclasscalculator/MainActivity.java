package com.example.nicolaenastas.inclasscalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView input;
    private TextView display;


    Calculator_Engine calculator_engine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = (TextView) findViewById(R.id.dataEntry);
        display = (TextView) findViewById(R.id.dataDisplay);
        calculator_engine = new Calculator_Engine();
    }


    private void updateScreen() {
        input.setText(calculator_engine.getDetails());
        display.setText(calculator_engine.getNumber());
    }

    public void onClickClear(View view) {
        calculator_engine.clear();
        updateScreen();
    }

    public void onClickNumber(View view) {
        switch (view.getId()) {
            case R.id.btn_num0: {
                calculator_engine.numberClicked(0);
                break;
            }
            case R.id.btn_num1: {
                calculator_engine.numberClicked(1);
                break;
            }
            case R.id.btn_num2: {
                calculator_engine.numberClicked(2);
                break;
            }
            case R.id.btn_num3: {
                calculator_engine.numberClicked(3);
                break;
            }
            case R.id.btn_num4: {
                calculator_engine.numberClicked(4);
                break;
            }
            case R.id.btn_num5: {
                calculator_engine.numberClicked(5);
                break;
            }
            case R.id.btn_num6: {
                calculator_engine.numberClicked(6);
                break;
            }
            case R.id.btn_num7: {
                calculator_engine.numberClicked(7);
                break;
            }
            case R.id.btn_num8: {
                calculator_engine.numberClicked(8);
                break;
            }
            case R.id.btn_num9: {
                calculator_engine.numberClicked(9);
                break;
            }
            case R.id.btn_decim: {
                calculator_engine.decimal(".");

                break;
            }
        }
        updateScreen();
    }

    public void onClickOperation(View view) {

        switch (view.getId()) {
            case R.id.btn_add: {
                calculator_engine.onClickOperation("+");
                break;
            }
            case R.id.btn_min: {
                calculator_engine.onClickOperation("-");
                break;
            }
            case R.id.btn_mut:{
                calculator_engine.onClickOperation("*");
                break;
            }
            case R.id.btn_dev: {
                calculator_engine.onClickOperation("/");
                break;
            }
            case R.id.btn_eql: {
                calculator_engine.onCLickEqual();
                break;
            }
            case R.id.btn_plusMinus: {
                calculator_engine.onClickPlusMinus();
                break;
            }
            case R.id.btn_modulo: {
                calculator_engine.onClickModulo();
                break;
            }
        }
        updateScreen();
    }

    public void onClickMemory(View view) {
        switch(view.getId()){
            case R.id.btn_Memory1: {
                calculator_engine.onClickMemory("M+");
                break;
            }
            case R.id.btn_Memory2: {
                calculator_engine.onClickMemory("M-");
                break;
            }
            case R.id.btn_Memory3: {
                calculator_engine.onClickMemory("MR");
                break;
            }
            case R.id.btn_Memory4: {
                calculator_engine.onClickMemory("MC");
                break;
            }
        }
        updateScreen();
    }
}


