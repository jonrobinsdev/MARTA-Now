package robins.martanow.wayfinder;

import java.util.ArrayList;

import robins.martanow.helper.AppEnums;

/**
 * Created by shaynemoore on 2/7/17.
 */

public class WayPoint {

    ArrayList<RailLineOption> railOptions = new ArrayList<RailLineOption>();
    AppEnums.Direction direction;
    AppEnums.Station start;
    AppEnums.Station end;

    //region Getters and Setters
    public AppEnums.Direction getDirection() {
        return direction;
    }

    public void setDirection(AppEnums.Direction direction) {
        this.direction = direction;
    }

    public AppEnums.Station getStart() {
        return start;
    }

    public void setStart(AppEnums.Station start) {
        this.start = start;
    }

    public AppEnums.Station getEnd() {
        return end;
    }

    public void setEnd(AppEnums.Station end) {
        this.end = end;
    }
    //endregion

    protected void addRailOption(AppEnums.Station station, AppEnums.RailLine railLine, AppEnums.Direction direction){
        RailLineOption railOption = new RailLineOption();
        railOption.setStation(station);
        railOption.setRailLine(railLine);
        railOption.setDirection(direction);
        railOptions.add(railOption);
    }

    public ArrayList<RailLineOption> getRailOptions(){
        return railOptions;
    }

    private void setRailOptions(ArrayList<RailLineOption> railOptions){
        this.railOptions = railOptions;
    }

    protected WayPoint reverse(){
        WayPoint reverseWayPoint = new WayPoint();
        reverseWayPoint.setStart(this.end);
        reverseWayPoint.setEnd(this.start);
        reverseWayPoint.setRailOptions(this.reverseRailOptions());
        return reverseWayPoint;
    }
    private ArrayList<RailLineOption> reverseRailOptions(){
        ArrayList<RailLineOption> reversedRailOptions = new ArrayList<RailLineOption>();
        for(RailLineOption option : railOptions){
            RailLineOption railLineOption = new RailLineOption();
            railLineOption.setRailLine(option.getRailLine());
            railLineOption.setDirection(option.getOppositeDirection());
            railLineOption.setStation(this.getEnd());
            reversedRailOptions.add(railLineOption);
        }
        return reversedRailOptions;
    }
}
