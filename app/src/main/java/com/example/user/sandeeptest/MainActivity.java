package com.example.sandeeptest.MainActivity;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

public class SensorActivity extends Activity implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor mPressure;

    @Override
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mPressure = mSensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
    }

    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public final void onSensorChanged(SensorEvent event) {
        float millibars_of_pressure = event.values[0];

    }

    @Override
    protected void onResume() {

        super.onResume();
        mSensorManager.registerListener(this, mPressure, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);

    }
}
package com.example.user.sandeeptest;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

    public class MainActivity extends AppCompatActivity implements SensorEventListener {

        private SensorManager sensorManager;
        private Sensor light_sensor,accel_sensor,magn_sensor,prox_sensor;
        private TextView light,accel,magn,prox;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            light = (TextView)findViewById(R.id.light);
            prox = (TextView)findViewById(R.id.proximity);
            accel = (TextView)findViewById(R.id.accelerometer);
            magn = (TextView)findViewById(R.id.magnetic);

            sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
            light_sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
            prox_sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
            accel_sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            magn_sensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

            if (light_sensor!= null){
                // Success! There's a magnetometer.
                sensorManager.registerListener(this,light_sensor,SensorManager.SENSOR_DELAY_NORMAL);
            }
            else {
                // Failure! No magnetometer.
            }
            if (prox_sensor != null){
                sensorManager.registerListener(this,prox_sensor,SensorManager.SENSOR_DELAY_NORMAL);
            }
            else {

            }
            if (accel_sensor != null){
                sensorManager.registerListener(this,accel_sensor,SensorManager.SENSOR_DELAY_NORMAL);
            }
            else {
            }
            if (magn_sensor != null){
                sensorManager.registerListener(this,magn_sensor,SensorManager.SENSOR_DELAY_NORMAL);
            }
            else {
            }
        }

        @Override
        public void onSensorChanged(SensorEvent event){
            float value;
            Sensor sensor = event.sensor;
            if (sensor.getType() == Sensor.TYPE_ACCELEROMETER){
                value=event.values[0]*event.values[0]+event.values[1]*event.values[1]+event.values[2];
                accel.setText("Accelerometer :"+value);
            }
            else if (sensor.getType() == Sensor.TYPE_LIGHT){
                light.setText("LUX :"+event.values[0]);
            }
            else if (sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD){

                value=event.values[0]*event.values[0]+event.values[1]*event.values[1]+event.values[2];
                magn.setText("Accelerometer :"+value);
            }
            else if (sensor.getType() == Sensor.TYPE_PROXIMITY){
                prox.setText("Proximity :"+event.values[0]);
            }

        }
