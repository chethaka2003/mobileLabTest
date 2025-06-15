package codeSolution.com.s23010597.chethaka;

import static android.hardware.Sensor.TYPE_AMBIENT_TEMPERATURE;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Lab_4 extends AppCompatActivity implements SensorEventListener {
    //Variables to hold signals

    private TextView textView;
    private SensorManager sensorManager;
    private Sensor sensor;
    private float changedValue;
    float fahrenheit;

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab_4);

        textView = findViewById(R.id.temerature);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(TYPE_AMBIENT_TEMPERATURE);

    }

    @Override
    public void onSensorChanged(SensorEvent event){
        changedValue = event.values[0]; //Get the latest temperature from the sensor
        fahrenheit = (changedValue * 9 / 5) + 32;textView.setText(String.format("Temp: %.2f °C / %.2f °F", changedValue, fahrenheit));
        mediaPlayer = MediaPlayer.create(this,R.raw.song);
        if (fahrenheit >97){
            mediaPlayer.start();
        }
        //Only stops when media player is playing
        else{
            if (mediaPlayer.isPlaying()){
                mediaPlayer.stop();
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume(){
        super.onResume();
        sensorManager.registerListener(this,sensorManager.getDefaultSensor(TYPE_AMBIENT_TEMPERATURE),sensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

}
