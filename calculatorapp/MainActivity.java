package com.composable.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView expressionField;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button buttonEquals;
    Button buttonAdd;
    Button buttonSubtract;
    Button buttonMultiply;
    Button buttonDivide;
    Button buttonClear;

    Integer num1;
    Integer num2;
    String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expressionField = findViewById(R.id.expressionField);
        button0 = findViewById(R.id.btn0);
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.btn3);
        button4 = findViewById(R.id.btn4);
        button5 = findViewById(R.id.btn5);
        button6 = findViewById(R.id.btn6);
        button7 = findViewById(R.id.btn7);
        button8 = findViewById(R.id.btn8);
        button9 = findViewById(R.id.btn9);
        buttonAdd = findViewById(R.id.btnAdd);
        buttonSubtract = findViewById(R.id.btnSubtract);
        buttonDivide = findViewById(R.id.btnDivide);
        buttonMultiply = findViewById(R.id.btnMultiply);
        buttonClear = findViewById(R.id.btnClear);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HandleNumberButtonClicked(0);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HandleNumberButtonClicked(1);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HandleNumberButtonClicked(2);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HandleNumberButtonClicked(3);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HandleNumberButtonClicked(4);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HandleNumberButtonClicked(5);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HandleNumberButtonClicked(6);
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HandleNumberButtonClicked(7);
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HandleNumberButtonClicked(8);
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HandleNumberButtonClicked(9);
            }
        });

        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HandleEqualButtonClicked(operator);
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HandleOperatorButtonClicked("+");
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HandleOperatorButtonClicked("-");
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HandleOperatorButtonClicked("*");
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HandleOperatorButtonClicked("/");
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                HandleClearButtonClicked();
            }
        });
    }


    void HandleButtonClicked(String pressedKey, boolean clearText){
        String priorText = expressionField.getText().toString();
        if (clearText){
            priorText = "";
        }
        String newText = priorText + pressedKey;
        expressionField.setText(newText);
    }

    void HandleNumberButtonClicked(int number){
        if (num1 != null && num2 != null){
            HandleButtonClicked(Integer.toString(number),true);
        } else if (num1 == null) {
            HandleButtonClicked(Integer.toString(number),false);
            num1 = number;
        }else {
            HandleButtonClicked(Integer.toString(number),false);
            num2 = number;
        }
    }

    void HandleClearButtonClicked(){
        expressionField.setText("");
        num1 = null;
        num2 = null;
    }

    void HandleOperatorButtonClicked(String operator){
        HandleButtonClicked(operator,false);
        this.operator = operator;
    }

    void HandleEqualButtonClicked(String operator){
        int result = 0;

        switch (operator){
            case "+":
                result = num1 + num2;
                break;

            case "-":
                result = num1 - num2;
                break;

            case "*":
                result = num1 * num2;

            case "/":
                result = (num2 == 0) ? -1 : num1/num2;
        }

        expressionField.setText(Integer.toString(result));
        num1 = null;
        num2 = null;

    }

}