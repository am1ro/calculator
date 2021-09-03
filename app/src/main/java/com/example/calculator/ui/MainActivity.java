package com.example.calculator.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.calculator.R;
import com.example.calculator.domain.Calculatormpl;

import java.util.HashMap;


public class MainActivity extends AppCompatActivity implements Vieww {
    private TextView resultTextView;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.result);
        presenter = new MainPresenter(this, new Calculatormpl());
        HashMap<Integer, Integer> digits = new HashMap<>();
        digits.put(R.id.button0, 0);
        digits.put(R.id.button1, 1);
        digits.put(R.id.button2, 2);
        digits.put(R.id.button3, 3);
        digits.put(R.id.button4, 4);
        digits.put(R.id.button5, 5);
        digits.put(R.id.button6, 6);
        digits.put(R.id.button7, 7);
        digits.put(R.id.button8, 8);
        digits.put(R.id.button9, 9);

        View.OnClickListener digitsClicked = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onKeyPressed(digits.get(v.getId()));
            }
        };

        findViewById(R.id.button0).setOnClickListener(digitsClicked);
        findViewById(R.id.button1).setOnClickListener(digitsClicked);
        findViewById(R.id.button2).setOnClickListener(digitsClicked);
        findViewById(R.id.button3).setOnClickListener(digitsClicked);
        findViewById(R.id.button4).setOnClickListener(digitsClicked);
        findViewById(R.id.button5).setOnClickListener(digitsClicked);
        findViewById(R.id.button6).setOnClickListener(digitsClicked);
        findViewById(R.id.button7).setOnClickListener(digitsClicked);
        findViewById(R.id.button8).setOnClickListener(digitsClicked);
        findViewById(R.id.button9).setOnClickListener(digitsClicked);
        findViewById(R.id.button_plus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onKeyPlusPress();
            }
        });
        findViewById(R.id.button_minus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onKeyMinusPress();
            }
        });
        findViewById(R.id.button_ymnogenie).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onKeyMulPress();
            }
        });
        findViewById(R.id.button_delenie).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onKeyDivPress();
            }
        });

    }

    public void onClick(View view) {
        Button button = (Button) view;
        resultTextView.append(button.getText());
    }

    @Override
    public void showResult(String result) {
        resultTextView.setText(result);

    }
}