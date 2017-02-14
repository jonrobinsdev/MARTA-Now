package robins.martanow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import robins.martanow.helper.AppEnums;
import robins.martanow.wayfinder.WayFinder;

import static robins.martanow.helper.AppEnums.Station.Avondale;

public class MainActivity extends AppCompatActivity {

    TrainArrivalFragment blueLineFragment;
    TrainArrivalFragment greenLineFragment;
    TrainArrivalFragment redLineFragment;
    TrainArrivalFragment goldLineFragment;
    WayFinder wayFinder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        this.wayFinder = new WayFinder(AppEnums.Station.ArtCenter, Avondale);

        blueLineFragment = (TrainArrivalFragment)getSupportFragmentManager().findFragmentById(R.id.blueLineFragment);
        greenLineFragment =(TrainArrivalFragment)getSupportFragmentManager().findFragmentById(R.id.greenLineFragment);
        redLineFragment =(TrainArrivalFragment)getSupportFragmentManager().findFragmentById(R.id.redLineFragment);
        goldLineFragment = (TrainArrivalFragment)getSupportFragmentManager().findFragmentById(R.id.goldLineFragment);

        setTrainFragmentColors();
        setFragmentDataFromApi();
    }

    private void setTrainFragmentColors(){
        blueLineFragment.getView().setBackgroundResource(R.color.blueLineColor);
        greenLineFragment.getView().setBackgroundResource(R.color.greenLineColor);
        redLineFragment.getView().setBackgroundResource(R.color.redLineColor);
        goldLineFragment.getView().setBackgroundResource(R.color.goldLineColor);
    }

    private void setFragmentDataFromApi() {
        new MartaApiReader() {
            @Override
            protected void onPostExecute(String[] result ) {
                super.onPostExecute(result);
                System.out.println("Yo");
                wayFinder.updateWayPointPath(result[0]);
            }
        }.execute();
    }
}
