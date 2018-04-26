package com.example.apuitiza.darkskyapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.apuitiza.darkskyapi.Events.ClimaEvent;
import com.example.apuitiza.darkskyapi.Models.Clima;
import com.example.apuitiza.darkskyapi.Models.Currently;
import com.example.apuitiza.darkskyapi.Services.ClimaService;
import com.example.apuitiza.darkskyapi.Services.ClimaServiceProvider;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static  final String TAG = MainActivity.class.getSimpleName();

    private TextView tempTxtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestClimaActual(-12.1101715,-77.0497429);
        tempTxtView = findViewById(R.id.tempTextView);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onClimaEvent(ClimaEvent event) {
        Currently currently = event.getClima().getCurrently();
        String centigradosTemp = String.valueOf(Math.round(currently.getTemperature()));
        tempTxtView.setText(centigradosTemp);
    }

    private void requestClimaActual(double lat, double lng) {
        ClimaServiceProvider clima = new ClimaServiceProvider();
        clima.getWeather(lat,lng);
    }
}
