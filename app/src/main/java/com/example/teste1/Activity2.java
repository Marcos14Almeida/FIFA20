package com.example.teste1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import static java.lang.Thread.*;


public class Activity2 extends AppCompatActivity {
    LineGraphSeries<DataPoint> series,series2,series3;
    private Gyroscope gyroscope;
    private Accelerometer accelerometer;
    private TextView textoAcelerometroY,textoAcelerometroZ;
    private TextView checkBoxResultado,textoGiroscopio,textoAcelerometroX;
    private CheckBox op1,op2,op3;
    Button botaoRetorno;
    Button botaoCalculo;
    private SensorManager sensorManager;
    private SensorEventListener gyroscopeEventListener;
    private Sensor gyroscopeSensor;
    float Xanterior = 0,Yanterior=0;
    float Xvelocity = 0,Yvelocity = 0;
    float Xdistance = 0,Ydistance = 0;
    float tempo = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        op1 = findViewById(R.id.op1);
        op2 = findViewById(R.id.op2);
        op3 = findViewById(R.id.op3);
        checkBoxResultado = findViewById(R.id.checkBoxResultado);

        botaoRetorno = (Button) findViewById(R.id.botaoRetorno);

        final GraphView graph = (GraphView) findViewById(R.id.graph);
        series = new LineGraphSeries<DataPoint>();
        series2 = new LineGraphSeries<DataPoint>();
        series3 = new LineGraphSeries<DataPoint>();
        series2.setColor(Color.RED);
        series3.setColor(Color.GREEN);

        textoAcelerometroX = findViewById(R.id.textoAcelerometroX);
        textoAcelerometroY = findViewById(R.id.textoAcelerometroY);
        textoAcelerometroZ = findViewById(R.id.textoAcelerometroZ);


        accelerometer = new Accelerometer(this);
        accelerometer.setListener(new Accelerometer.Listener() {
            @Override
            public void onTranslation(float x, float y, float z) {
                Xvelocity = (x + Xvelocity);
                Xdistance = (Xvelocity + Xdistance);
                if(y<0){y=y+(float)0.01;}
                Yvelocity = (y*(float)0.4  + Yvelocity);
                Ydistance = (Yvelocity + Ydistance);
                tempo = tempo + 1;
                series2.appendData(new DataPoint(tempo/5, Xdistance), true, 100);
                series3.appendData(new DataPoint(tempo/5, Ydistance ), true, 100);
                graph.addSeries(series2);
                graph.addSeries(series3);

                if (x > 0.5f) {
                    getWindow().getDecorView().setBackgroundColor(Color.CYAN);
                }
                if (x < 0.5f) {
                    getWindow().getDecorView().setBackgroundColor(Color.WHITE);
                }
                textoAcelerometroX.setText(String.format("X: %.1f ", x));
                textoAcelerometroY.setText(String.format("Y: %.1f m/s", Xvelocity));
                textoAcelerometroZ.setText(String.format("Z: %.1f cm", Xdistance ));
            }
        });

        textoGiroscopio = findViewById(R.id.textoGiroscopio);

        gyroscope = new Gyroscope(this);
        gyroscope.setListener(new Gyroscope.Listener() {
            @Override
            public void onRotation(float rx, float ry, float rz) {
                if(rx >0.41f){
                    textoGiroscopio.setText(String.format("Giroscopio Valor: %.2f",rx));
                }
                if(rx <=0.41f){
                    textoGiroscopio.setText("Giroscopio Valor: 0");
                }

            }
        });

    }

    public void onResume(){
        super.onResume();
        accelerometer.register();
        gyroscope.register();
    }
    public void onPause(){
        super.onPause();
        accelerometer.unregister();
        gyroscope.unregister();
    }

    public void calculo(View view){
        String texto ="";
        if(op1.isChecked()) {
            texto="Orlando";
        }
        if(op2.isChecked()) {
            texto = texto + "Pirates";
        }
        if(op3.isChecked()) {
            texto= texto + "Opcao3";
        }
        checkBoxResultado.setText("teste: " + texto);
    }

    public void abrirActivity3(View view){
        Intent intent = new Intent(this, activity_3.class);
        startActivity(intent);
    }

}
