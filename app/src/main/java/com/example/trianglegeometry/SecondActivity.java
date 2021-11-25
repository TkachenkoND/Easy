package com.example.trianglegeometry;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    TextView txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8, txt9;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        txt1 = (TextView) findViewById(R.id.txt1);
        txt2 = (TextView) findViewById(R.id.txt2);
        txt3 = (TextView) findViewById(R.id.txt3);
        txt4 = (TextView) findViewById(R.id.txt4);
        txt5 = (TextView) findViewById(R.id.txt5);
        txt6 = (TextView) findViewById(R.id.txt6);
        txt7 = (TextView) findViewById(R.id.txt7);
        txt8 = (TextView) findViewById(R.id.txt8);
        txt9 = (TextView) findViewById(R.id.txt9);

        insertText();
    }

    private void insertText() {
        Bundle arg = getIntent().getExtras();

        double[] angle = new double[3];
        angle = (double[]) arg.get("angle");

        double[] bisector = new double[3];
        bisector = (double[]) arg.get("bisector");

        int[] height = new int[3];
        height = (int[]) arg.get("height");

        int[] median = new int[3];
        median = (int[]) arg.get("median");


        txt1.setText("Кут А = " + angle[0] + ", кут В = " + angle[1] + ", кут C = " + angle[2]);
        txt2.setText("Радіус вписаного кола = " + arg.get("radius1"));
        txt3.setText("Радіус описаного кола = " + arg.get("radius2"));
        txt4.setText("Бісектриса1 = " + bisector[0] + ", Бісектриса2 = " + bisector[1] + ", Бісектриса3 = " + bisector[2]);
        txt5.setText("Висота1 = " + height[0] + ", Висота2 = " + height[1] + ", Висота3 = " + height[2]);
        txt6.setText("Медіана1 = " + median[0] + ", Медіана1 = " + median[1] + ", Медіана1 = " + median[2]);
        txt7.setText("Площа = " + arg.get("area"));
        txt8.setText("Периметр = " + arg.get("perimeter"));
        txt9.setText("Тип трикутника = " + arg.get("type"));

    }
}
