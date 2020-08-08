package com.example.teste1;

        import android.content.Context;
        import android.hardware.Sensor;
        import android.hardware.SensorEvent;
        import android.hardware.SensorEventListener;
        import android.hardware.SensorManager;


public class Gyroscope {

    public interface  Listener{
        void onRotation(float rx, float ry, float rz);
    }
    private Listener listener;
    public void setListener(Listener l){
        listener = l;
    }
    private SensorManager sensorManager;
    private SensorEventListener gyroscopeEventListener;
    private Sensor gyroscopeSensor;

    Gyroscope (Context context){
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        gyroscopeEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if(listener!=null){
                    listener.onRotation(event.values[0],event.values[1],event.values[2]);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
    }


    public void register(){
        sensorManager.registerListener(gyroscopeEventListener,gyroscopeSensor,SensorManager.SENSOR_DELAY_NORMAL);
    }
    public void unregister(){
        sensorManager.unregisterListener(gyroscopeEventListener);
    }
}
