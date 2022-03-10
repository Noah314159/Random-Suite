package com.example.randomsuite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //constants for number of sides for each dice
    //(each value is n+1 due to upper bound for random function being non inclusive)
    private static final int D20_SIDES = 21;
    private static final int D4_SIDES = 5;
    private static final int D6_SIDES = 7;
    private static final int D8_SIDES = 9;
    private static final int D10_SIDES = 11;
    private static final int D12_SIDES = 13;
    private static final int D100_SIDES = 101;

    //initialize variables for the text views that display the current number of dice
    private TextView d20NumberOf;
    private TextView d4NumberOf;
    private TextView d6NumberOf;
    private TextView d8NumberOf;
    private TextView d10NumberOf;
    private TextView d12NumberOf;
    private TextView d100NumberOf;
    private TextView resultView;
    private TextView resultLongView;

    //initialize the number of each dice and the result to zero
    private int result = 0;
    private int numD20 = 0;
    private int numD4 = 0;
    private int numD6 = 0;
    private int numD8 = 0;
    private int numD10 = 0;
    private int numD12 = 0;
    private int numD100 = 0;

    //string to store individual dice results
    private String resultLong = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign variables to respective text views
        d20NumberOf = (TextView) findViewById(R.id.d20_numberOf);
        d4NumberOf = (TextView) findViewById(R.id.d4_numberOf);
        d6NumberOf = (TextView) findViewById(R.id.d6_numberOf);
        d8NumberOf = (TextView) findViewById(R.id.d8_numberOf);
        d10NumberOf = (TextView) findViewById(R.id.d10_numberOf);
        d12NumberOf = (TextView) findViewById(R.id.d12_numberOf);
        d100NumberOf = (TextView) findViewById(R.id.d100_numberOf);
        resultView = (TextView) findViewById(R.id.resultBox);
        resultLongView = (TextView) findViewById(R.id.resultLongBox);

        //update labels to show default values
        d20NumberOf.setText(String.valueOf(numD20));
        d4NumberOf.setText(String.valueOf(numD4));
        d6NumberOf.setText(String.valueOf(numD6));
        d8NumberOf.setText(String.valueOf(numD8));
        d10NumberOf.setText(String.valueOf(numD10));
        d12NumberOf.setText(String.valueOf(numD12));
        d100NumberOf.setText(String.valueOf(numD100));
        resultView.setText(String.valueOf(result));

        //link buttons to variables
        Button roll_button = (Button) findViewById(R.id.roll_button);

        Button d4Plus_button = (Button) findViewById(R.id.d4Plus_button);
        Button d4Minus_button = (Button) findViewById(R.id.d4Minus_button);

        Button d6Plus_button = (Button) findViewById(R.id.d6Plus_button);
        Button d6Minus_button = (Button) findViewById(R.id.d6Minus_button);

        Button d8Plus_button = (Button) findViewById(R.id.d8Plus_button);
        Button d8Minus_button = (Button) findViewById(R.id.d8Minus_button);

        Button d10Plus_button = (Button) findViewById(R.id.d10Plus_button);
        Button d10Minus_button = (Button) findViewById(R.id.d10Minus_button);

        Button d12Plus_button = (Button) findViewById(R.id.d12Plus_button);
        Button d12Minus_button = (Button) findViewById(R.id.d12Minus_button);

        Button d20Plus_button = (Button) findViewById(R.id.d20Plus_button);
        Button d20Minus_button = (Button) findViewById(R.id.d20Minus_button);

        Button d100Plus_button = (Button) findViewById(R.id.d100Plus_button);
        Button d100Minus_button = (Button) findViewById(R.id.d100Minus_button);

        //assign listeners
        roll_button.setOnClickListener(this);
        d4Plus_button.setOnClickListener(this);
        d4Minus_button.setOnClickListener(this);

        d6Plus_button.setOnClickListener(this);
        d6Minus_button.setOnClickListener(this);

        d8Plus_button.setOnClickListener(this);
        d8Minus_button.setOnClickListener(this);

        d10Plus_button.setOnClickListener(this);
        d10Minus_button.setOnClickListener(this);

        d12Plus_button.setOnClickListener(this);
        d12Minus_button.setOnClickListener(this);

        d100Plus_button.setOnClickListener(this);
        d100Minus_button.setOnClickListener(this);

        d20Plus_button.setOnClickListener(this);
        d20Minus_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        int buttonID = v.getId();
        //handle roll button
        if (buttonID == R.id.roll_button){

            //roll d20's
            rollDice(numD20, D20_SIDES);
            //roll d4's
            rollDice(numD4, D4_SIDES);
            //roll d6's
            rollDice(numD6, D6_SIDES);
            //roll d8's
            rollDice(numD8, D8_SIDES);
            //roll d10's
            rollDice(numD10, D10_SIDES);
            //roll d12's
            rollDice(numD12, D12_SIDES);
            //roll d100's
            rollDice(numD100, D100_SIDES);


            if (resultLong.length() >= 3){
                //remove last plus sign
                resultLong = resultLong.substring(0,resultLong.length() - 3);
            }

            //sets text views to results
            resultLong += " = " + String.valueOf(result);
            resultView.setText(String.valueOf(result));
            resultLongView.setText(resultLong);

            //reset variables to default for next roll
            result = 0;
            resultLong = "";
        //handle d20 buttons
        } else if (buttonID == R.id.d20Plus_button || buttonID == R.id.d20Minus_button){
            if (buttonID == R.id.d20Plus_button){
                numD20 += 1;
            } else {
                numD20 -= 1;
            }
            d20NumberOf.setText(String.valueOf(numD20));
        //handle d4 buttons
        } else if (buttonID == R.id.d4Minus_button || buttonID == R.id.d4Plus_button){
            if (buttonID == R.id.d4Plus_button){
                numD4 += 1;
            } else {
                numD4 -= 1;
            }
            d4NumberOf.setText(String.valueOf(numD4));

        } else if (buttonID == R.id.d6Minus_button || buttonID == R.id.d6Plus_button){
            if (buttonID == R.id.d6Plus_button){
                numD6 += 1;
            } else {
                numD6 -= 1;
            }
            d6NumberOf.setText(String.valueOf(numD6));

        } else if (buttonID == R.id.d8Minus_button || buttonID == R.id.d8Plus_button){
            if (buttonID == R.id.d8Plus_button){
                numD8 += 1;
            } else {
                numD8 -= 1;
            }
            d8NumberOf.setText(String.valueOf(numD8));

        } else if (buttonID == R.id.d10Minus_button || buttonID == R.id.d10Plus_button){
            if (buttonID == R.id.d10Plus_button){
                numD10 += 1;
            } else {
                numD10 -= 1;
            }
            d10NumberOf.setText(String.valueOf(numD10));

        } else if (buttonID == R.id.d12Minus_button || buttonID == R.id.d12Plus_button){
            if (buttonID == R.id.d12Plus_button){
                numD12 += 1;
            } else {
                numD12 -= 1;
            }
            d12NumberOf.setText(String.valueOf(numD12));

        } else if (buttonID == R.id.d100Minus_button || buttonID == R.id.d100Plus_button){
            if (buttonID == R.id.d100Plus_button){
                numD100 += 1;
            } else {
                numD100 -= 1;
            }
            d100NumberOf.setText(String.valueOf(numD100));
        //this should never be reached
        } else {
            Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();
        }
    }


    //rolls the specified number of dice with the corresponding amount of sides
    private void rollDice(int num, int sides) {
        int rollResult = 0;
        for (int i = 0; i < num; ++i){
            rollResult = getRandomNumber(1,sides);

            resultLong += String.valueOf(rollResult) + " + ";

            result += rollResult;
        }
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}