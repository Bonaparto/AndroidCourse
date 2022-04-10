package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private android.widget.EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.textView);
        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getString(R.string.display).equals(display.getText().toString())) {
                    display.setText("");
                }
            }
        });
    }

    private void updateText(String strToAdd) {
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if (getString(R.string.display).equals(display.getText().toString())) {
            display.setText(strToAdd);
        } else {
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        }
        display.setSelection(cursorPos + 1);
    }

    public void zeroButton(View view) {
        updateText("0");
    }

    public void oneButton(android.view.View view) {
        updateText("1");
    }

    public void twoButton(android.view.View view) {
        updateText("2");
    }

    public void threeButton(android.view.View view) {
        updateText("3");
    }

    public void fourButton(android.view.View view) {
        updateText("4");
    }

    public void fiveButton(android.view.View view) {
        updateText("5");
    }

    public void sixButton(android.view.View view) {
        updateText("6");
    }

    public void sevenButton(android.view.View view) {
        updateText("7");
    }

    public void eightButton(android.view.View view) {
        updateText("8");
    }

    public void nineButton(android.view.View view) {
        updateText("9");
    }

    public void clearButton(android.view.View view) {
        updateText("");
    }

    public void addButton(android.view.View view) {
        updateText("+");
    }

    public void subtractButton(android.view.View view) {
        updateText("-");
    }

    public void plusMinusButton(android.view.View view) {
        updateText("-");
    }

    public void divideButton(android.view.View view) {
        updateText("÷");
    }

    public void multiplyButton(android.view.View view) {
        updateText("*");
    }

    public void pointButton(android.view.View view) {
        updateText(".");
    }

    public void equalsButton(android.view.View view) {

    }

    public void parenthesesButton(android.view.View view) {

    }

    public void exponentButton(android.view.View view) {
        updateText("^");
    }

    public void backspaceButton(android.view.View view) {
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0) {
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        }
    }

}