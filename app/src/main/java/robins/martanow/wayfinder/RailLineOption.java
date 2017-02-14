package robins.martanow.wayfinder;

import robins.martanow.helper.AppEnums;

/**
 * Created by shaynemoore on 2/8/17.
 */

public class RailLineOption {

    AppEnums.Station station;
    AppEnums.RailLine railLine;
    AppEnums.Direction direction;
    String nextArrival;
    long waitTime;
    String waitText;
    String stationBasedDirection;

    //region Getters and Setters
    public String getNextArrival() {
        return nextArrival;
    }

    public void setNextArrival(String nextArrival) {
        this.nextArrival = nextArrival;
    }

    public long getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(long waitTime) {
        this.waitTime = waitTime;
    }


    public AppEnums.Station getStation() {
        return station;
    }

    public void setStation(AppEnums.Station station) {
        this.station = station;
    }

    public AppEnums.RailLine getRailLine() {
        return railLine;
    }

    public void setRailLine(AppEnums.RailLine railLine) {
        this.railLine = railLine;
    }

    public AppEnums.Direction getDirection() {
        return direction;
    }

    public void setDirection(AppEnums.Direction direction) {
        this.direction = direction;
    }

    public String getWaitText() {
        return waitText;
    }

    public void setWaitText(String waitText) {
        this.waitText = waitText;
    }

    public String getStationBasedDirection() {
        return stationBasedDirection;
    }

    public void setStationBasedDirection(String stationBasedDirection) {
        this.stationBasedDirection = stationBasedDirection;
    }
    //endregion

    protected AppEnums.Direction getOppositeDirection(){
        switch (this.direction){
            case East:
                return AppEnums.Direction.West;
            case South:
                return AppEnums.Direction.North;
            case West:
                return AppEnums.Direction.East;
            case North:
                return AppEnums.Direction.South;
        }
        return null;
    }
}
