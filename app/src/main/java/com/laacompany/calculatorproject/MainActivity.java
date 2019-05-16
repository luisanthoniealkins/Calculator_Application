package com.laacompany.calculatorproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

        private EditText mEditTextNum1;
        private EditText mEditTextNum2;

        private Spinner mSpinnerOperator;
        private TextView mTextViewResult;

        private Button mButtonCalculate;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            String[] arraySpinner = new String[] {
                    "+","-","*","/"
            };
            mSpinnerOperator = (Spinner) findViewById(R.id.id_spinner_operator);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arraySpinner);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mSpinnerOperator.setAdapter(adapter);

            mEditTextNum1 = findViewById(R.id.id_edt_num1);
            mEditTextNum2 = findViewById(R.id.id_edt_num2);

            mTextViewResult = findViewById(R.id.id_tv_result);

            mButtonCalculate = findViewById(R.id.id_btn_calculate);
            mButtonCalculate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    boolean error = false;

                    if (mEditTextNum1.getText().toString().equals("")) {
                        mEditTextNum1.setError("This field may not be blank");
                        error = true;
                    }

                    if (mEditTextNum2.getText().toString().equals("")) {
                        mEditTextNum2.setError("This field may not be blank");
                        error = true;
                    }

                    if (!error) {
                        float a = Float.valueOf(mEditTextNum1.getText().toString());
                        float b = Float.valueOf(mEditTextNum2.getText().toString());
                        float calc;

                        if (mSpinnerOperator.getSelectedItem() == "+") {
                            calc = a + b;
                            mEditTextNum1.setText(String.valueOf(a));
                            mEditTextNum2.setText(String.valueOf(b));
                            mTextViewResult.setText(String.valueOf(calc));
                        } else if (mSpinnerOperator.getSelectedItem() == "-") {
                            calc = a - b;
                            mEditTextNum1.setText(String.valueOf(a));
                            mEditTextNum2.setText(String.valueOf(b));
                            mTextViewResult.setText(String.valueOf(calc));
                        } else if (mSpinnerOperator.getSelectedItem() == "*") {
                            calc = a * b;
                            mEditTextNum1.setText(String.valueOf(a));
                            mEditTextNum2.setText(String.valueOf(b));
                            mTextViewResult.setText(String.valueOf(calc));
                        } else if (mSpinnerOperator.getSelectedItem() == "/") {
                            if (b == 0) {
                                mEditTextNum2.setError("Number 2 may not be 0 when using divide operator");
                                mTextViewResult.setText("0");
                            } else {
                                mEditTextNum1.setText(String.valueOf(a));
                                mEditTextNum2.setText(String.valueOf(b));
                                calc = a / b;
                                mTextViewResult.setText(String.valueOf(calc));
                            }

                        }
                    }

                }
            });

        }
}
