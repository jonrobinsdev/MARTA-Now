package robins.martanow;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by shaynemoore on 2/8/17.
 */

public class MartaApiParser {

    String json;
    JSONObject currentRecord = null;

    public MartaApiParser(String json){
        this.json = json;
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

    public boolean selectRecord(String station, String direction, String railLine){

        //parse stations into array
        JSONArray records = convertStringToJsonArray(this.json);

        //iterate through json array
        try {
            for (int i = 0; i < records.length();  i++){
                JSONObject record = records.getJSONObject(i);
                //System.out.println(station.getString("STATION"));
                if ((record.getString("STATION").toUpperCase().equals(station.toUpperCase()))
                        && (record.getString("DIRECTION").toUpperCase().equals(direction.toUpperCase()))
                        && (record.getString("LINE").toUpperCase().equals(railLine.toUpperCase())))  {
                    this.currentRecord = record;
                    return true;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getNextArrival(){
        if(this.currentRecord != null){
            // Parse out next Arrival
        }
        return "";
    }

    public String getWaitText(){
        if(this.currentRecord != null){
            // Parse out wait text
        }
        return "";
    }

    public long getWaitTime(){
        if(this.currentRecord != null){
            // Parse out wait time
        }
        return 0;
    }
}
