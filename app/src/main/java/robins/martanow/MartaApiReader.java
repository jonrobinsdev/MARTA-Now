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
                parseApiResult(strTemp);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return data;
    }

    private String parseApiResult(String result) {
        //parse into individual stations
        JSONArray trainJson = convertStringToJsonArray(result);

        //iterate through json array
        try {
            for (int i = 0; i < trainJson.length();  i++){
                JSONObject station = trainJson.getJSONObject(i);
                System.out.println(station.getString("STATION"));
                if (station.getString("STATION").equals("AIRPORT STATION")) {
                    System.out.println(station.toString());
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }

    private JSONArray convertStringToJsonArray(String result){
        JSONArray jsonObj = null;
        try {
            jsonObj = new JSONArray(result);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObj;
    }
}
