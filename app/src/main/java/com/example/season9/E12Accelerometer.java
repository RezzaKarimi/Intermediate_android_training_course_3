package com.example.season9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import app.app;

public class E12Accelerometer extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager;
    AppCompatTextView text;

    long lastTime;
    long currentTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e12_accelerometer);

        init();
    }

    private void init(){
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        text = findViewById(R.id.text);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            float [] items = event.values;
            float x = items[0];
            float y = items[1];
            float z = items[2];

            text.setText("X : "+x+"\n Y : "+y+"\n Z : "+z);


            currentTime = event.timestamp;

            float temp = ((x*x + y*y + z*z)/SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);

            if (temp >= 100){
                if (currentTime-lastTime<200){
                    return;
                }else {

                    lastTime = currentTime;
                    app.toasty("Bingo");
                    app.l("Time  :  "+(currentTime-lastTime));
                    app.l("lastTime  :  "+(lastTime));
                    app.l("CurrentTime  :  "+(currentTime));
                }
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume() {
        sensorManager.registerListener(this , sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) , SensorManager.SENSOR_DELAY_NORMAL);
        super.onResume();
    }
}