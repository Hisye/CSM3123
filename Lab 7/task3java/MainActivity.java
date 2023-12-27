package com.example.task3java;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor accelerometerSensor, gyroscopeSensor, magnetometerSensor;
    private TextView accelerometerTextView, gyroscopeTextView, magnetometerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Map TextViews to resources
        accelerometerTextView = findViewById(R.id.accelerometerTextView);
        gyroscopeTextView = findViewById(R.id.gyroscopeTextView);
        magnetometerTextView = findViewById(R.id.magnetometerTextView);

        // Map SensorManager to system service
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        // Map sensors
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        magnetometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

        // Check if sensors are found
        if (accelerometerSensor == null) {
            accelerometerTextView.setText("Accelerometer not found");
        }
        if (gyroscopeSensor == null) {
            gyroscopeTextView.setText("Gyroscope not found");
        }
        if (magnetometerSensor == null) {
            magnetometerTextView.setText("Magnetometer not found");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Register listeners for sensors
        sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, gyroscopeSensor, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, magnetometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Unregister listeners for sensors
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];

        // Check which sensor triggered the change
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            updateTextView(accelerometerTextView, "Accelerometer", x, y, z);
        } else if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
            updateTextView(gyroscopeTextView, "Gyroscope", x, y, z);
        } else if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            updateTextView(magnetometerTextView, "Magnetometer", x, y, z);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Handle accuracy changes if needed
    }

    private void updateTextView(TextView textView, String sensorType, float x, float y, float z) {
        String text = sensorType + "\nX: " + x + "\nY: " + y + "\nZ: " + z;
        textView.setText(text);
    }
}
