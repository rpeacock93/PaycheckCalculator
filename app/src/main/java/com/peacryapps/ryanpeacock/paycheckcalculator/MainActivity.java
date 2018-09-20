package com.peacryapps.ryanpeacock.paycheckcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // layout input declarations

    android.widget.EditText hours, breaks, payrate;
    android.widget.Button submit;
    android.widget.TextView result;
    android.widget.RadioButton thirty, hour;

    // double parsed and calculation variables

    double result_num;
    double pre_tax;
    final double TAX_RATE = 0.22;
    double num1, num2, num3, num4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        // syncs variables with item i.d.

        hours = (android.widget.EditText)findViewById(com.peacryapps.ryanpeacock.paycheckcalculator.R.id.hours);
        breaks = (android.widget.EditText)findViewById(com.peacryapps.ryanpeacock.paycheckcalculator.R.id.breaks);
        payrate = (android.widget.EditText)findViewById(com.peacryapps.ryanpeacock.paycheckcalculator.R.id.payrate);

        result = (android.widget.TextView)findViewById(com.peacryapps.ryanpeacock.paycheckcalculator.R.id.result);
        submit = (android.widget.Button)findViewById(com.peacryapps.ryanpeacock.paycheckcalculator.R.id.submit);

        thirty = (android.widget.RadioButton)findViewById(com.peacryapps.ryanpeacock.paycheckcalculator.R.id.thirty);
        hour = (android.widget.RadioButton)findViewById(com.peacryapps.ryanpeacock.paycheckcalculator.R.id.hour);

        // creates listener for submit button

        submit.setOnClickListener(new android.view.View.OnClickListener() {

            // when the submit button is clicked
            public void onClick(android.view.View v) {

                // if else statement to validate text input

                if (hours.getText().toString().isEmpty()) {

                    result.setText(String.valueOf("Fill in Hours"));

                }
                else if (breaks.getText().toString().isEmpty()) {

                    result.setText(String.valueOf("Fill in Breaks"));

                }
                else if (payrate.getText().toString().isEmpty()) {

                    result.setText(String.valueOf("Fill in pay rate"));
                }
                else {

                    // convert text input to double

                    num1 = Double.parseDouble(hours.getText().toString());
                    num2 = Double.parseDouble(breaks.getText().toString());
                    num3 = Double.parseDouble(payrate.getText().toString());

                    // handles radio button choice

                    if (thirty.isChecked()) {

                        num4 = num2 * 0.5;
                    }

                    else if (hour.isChecked()) {

                        num4 = num2;
                    }

                    // formula calculation 

                    pre_tax = (num1 - num4) * num3;
                    result_num = pre_tax - (pre_tax * TAX_RATE);
                    result.setText(String.format("$%.2f", result_num));


                }


            }

        });
    }
}
