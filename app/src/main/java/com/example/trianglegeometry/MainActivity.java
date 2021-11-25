package com.example.trianglegeometry;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.trianglegeometry.viewModel.Formulas;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText sideA, sideB, sideC;
    Button btn;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);

        sideA = (EditText)findViewById(R.id.sideA);
        sideB = (EditText)findViewById(R.id.sideB);
        sideC = (EditText)findViewById(R.id.sideC);

        btn = (Button)findViewById(R.id.btnCalculation);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        double a = Double.parseDouble(sideA.getText().toString());
        double b = Double.parseDouble(sideB.getText().toString());
        double c = Double.parseDouble(sideC.getText().toString());

        Formulas triangle = new Formulas(a,b,c);

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("angle", triangle.calculationOfAngles());
        intent.putExtra("radius1", triangle.calculationRadiusCircumscribedCircle());
        intent.putExtra("radius2", triangle.calculationRadiusInscribedCircle());
        intent.putExtra("bisector", triangle.bisectorCalculation());
        intent.putExtra("height", triangle.heightCalculation());
        intent.putExtra("median", triangle.calculationMedian());
        intent.putExtra("area", triangle.areaCalculation());
        intent.putExtra("perimeter", triangle.perimeterCalculation());
        intent.putExtra("type", triangle.typeOfTriangle());

        startActivity(intent);
    }
}