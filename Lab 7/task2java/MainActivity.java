package com.example.task2java;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    // Global variables
    private SensorManager senseMan;
    private Sensor lightSensor, proximitySensor, humiditySensor;
    private TextView lightTextView, proximityTextView, humidityTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Map TextViews to resources
        lightTextView = findViewById(R.id.lightTextView);
        proximityTextView = findViewById(R.id.proximityTextView);
        humidityTextView = findViewById(R.id.humidityTextView);

        // Map SensorManager to system service
        senseMan = (SensorManager) getSystemService(SENSOR_SERVICE);

        // Map sensors
        lightSensor = senseMan.getDefaultSensor(Sensor.TYPE_LIGHT);
        proximitySensor = senseMan.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        humiditySensor = senseMan.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);

        // Check if sensors are found
        if (lightSensor != null) {
            Toast.makeText(this, "Light sensor found", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Light sensor not found", Toast.LENGTH_SHORT).show();
        }

        if (proximitySensor != null) {
            Toast.makeText(this, "Proximity sensor found", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Proximity sensor not found", Toast.LENGTH_SHORT).show();
        }

        if (humiditySensor != null) {
            Toast.makeText(this, "Relative Humidity sensor found", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Relative Humidity sensor not found", Toast.LENGTH_SHORT).show();
        }
    }

    // Rest of the code remains the same

    // Override onSensorChanged method
    @Override
    public void onSensorChanged(SensorEvent event) {
        // Check which sensor triggered the change
        if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
            lightTextView.setText("Light Level: " + event.values[0]);
        } else if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            proximityTextView.setText("Proximity: " + event.values[0]);
        } else if (event.sensor.getType() == Sensor.TYPE_RELATIVE_HUMIDITY) {
            humidityTextView.setText("Relative Humidity: " + event.values[0]);
        }
    }

    // Override onAccuracyChanged method
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Handle accuracy changes if needed
    }

    // Override onResume method
    @Override
    protected void onResume() {
        super.onResume();
        // Register listener for Sensor
        senseMan.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
        senseMan.registerListener(this, proximitySensor, SensorManager.SENSOR_DELAY_NORMAL);
        senseMan.registerListener(this, humiditySensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    // Override onPause method
    @Override
    protected void onPause() {
        super.onPause();
        // Unregister listener for senseMan
        senseMan.unregisterListener(this);
    }
}
