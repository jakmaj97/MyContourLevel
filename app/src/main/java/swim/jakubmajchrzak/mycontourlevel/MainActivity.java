package swim.jakubmajchrzak.mycontourlevel;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener, AppConstants {

    private TextView tvX;
    private TextView tvY;
    private TextView tvZ;

    private Sensor sensAccelerometer;
    private SensorManager sensmMySensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvX = (TextView) findViewById(R.id.tvX);
        tvY = (TextView) findViewById(R.id.tvY);
        tvZ = (TextView) findViewById(R.id.tvZ);

        sensmMySensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensAccelerometer = sensmMySensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensmMySensorManager.registerListener(this, sensAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        tvX.setText(getResources().getString(R.string.x_present) + df.format(event.values[iXVal]));
        tvY.setText(getResources().getString(R.string.y_present) + df.format(event.values[iYVal]));
        tvZ.setText(getResources().getString(R.string.z_present) + df.format(event.values[iZVal]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //Not in use
    }
}
