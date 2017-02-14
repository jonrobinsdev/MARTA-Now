package robins.martanow;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class MartaApiReader extends AsyncTask<String, Void, String[]> {

    private static final String apiUrl = "http://developer.itsmarta.com/RealtimeTrain/RestServiceNextTrain/GetRealtimeArrivals?apikey=";
    private static final String apiKey = "b3f0909f-ce4b-4830-b374-1cb0d8a400c7";
    private String[] data = new String[4];

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String[] doInBackground(String... urls) {
        try {
            URL url = new URL(apiUrl + apiKey);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String strTemp = "";
            while (null != (strTemp = br.readLine())) {
                data[0] = strTemp;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return data;
    }

}
