package com.example.teste1;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class Accelerometer {

    public interface  Listener{
        void onTranslation(float x, float y, float z);
    }
    private Listener listener;
    public void setListener(Listener l){
        listener = l;
    }
    private SensorManager sensorManager;
    private SensorEventListener sensorEventListener;
    private Sensor sensor;
    float gravityV0,gravityV1,gravityV2;

    Accelerometer (Context context){
        sensorManager =(SensorManager) context.getSystemService(context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if(listener!=null){
                    final float alpha = 0.8f;
//gravity is calculated here
                    gravityV0 = alpha * gravityV0 + (1 - alpha) * event.values[0];
                    gravityV1 = alpha * gravityV1 + (1 - alpha)* event.values[1];
                    gravityV2 = alpha * gravityV2 + (1 - alpha) * event.values[2];
                    listener.onTranslation(event.values[0] - gravityV0,event.values[1] - gravityV1,event.values[2] - gravityV2);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
    }


    public void register(){
        sensorManager.registerListener(sensorEventListener,sensor,SensorManager.SENSOR_DELAY_NORMAL);/* 224ms - SENSOR_DELAY_NORMAL*/
    }
    public void unregister(){
        sensorManager.unregisterListener(sensorEventListener);
    }
}
