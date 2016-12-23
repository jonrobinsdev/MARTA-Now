package robins.martanow;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import robins.martanow.TrainArrivalFragment;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    TrainArrivalFragment blueLineFragment;
    TrainArrivalFragment greenLineFragment;
    TrainArrivalFragment redLineFragment;
    TrainArrivalFragment goldLineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        blueLineFragment = (TrainArrivalFragment)getSupportFragmentManager().findFragmentById(R.id.blueLineFragment);
        greenLineFragment =(TrainArrivalFragment)getSupportFragmentManager().findFragmentById(R.id.greenLineFragment);
        redLineFragment =(TrainArrivalFragment)getSupportFragmentManager().findFragmentById(R.id.redLineFragment);
        goldLineFragment = (TrainArrivalFragment)getSupportFragmentManager().findFragmentById(R.id.goldLineFragment);

        setTrainFragmentColors();
        new MartaRestServiceReader().execute();
    }

    private void setTrainFragmentColors(){
        blueLineFragment.getView().setBackgroundResource(R.color.blueLineColor);
        greenLineFragment.getView().setBackgroundResource(R.color.greenLineColor);
        redLineFragment.getView().setBackgroundResource(R.color.redLineColor);
        goldLineFragment.getView().setBackgroundResource(R.color.goldLineColor);
    }
}
