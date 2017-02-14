package robins.martanow.wayfinder;

import java.util.ArrayList;
import java.util.HashMap;

import robins.martanow.MartaApiParser;
import robins.martanow.helper.AppEnums;
import robins.martanow.helper.MartaNowHelper;

/**
 * Created by shaynemoore on 2/7/17.
 */

public class WayFinder {

    HashMap<AppEnums.Station, Integer> RedLine = new HashMap<>();
    HashMap<AppEnums.Station, Integer> GoldLine = new HashMap<>();
    HashMap<AppEnums.Station, Integer> BlueLine = new HashMap<>();
    HashMap<AppEnums.Station, Integer> GreenLine = new HashMap<>();

    WayPointPath oneWayPath = new WayPointPath();
    WayPointPath reversePath = new WayPointPath();
    WayPointPath fullPath = new WayPointPath();

    public WayFinder(AppEnums.Station startStation, AppEnums.Station endStation){
        initializeRedLine();
        initializeGoldLine();
        initializeBlueLine();
        initializeGreenLine();

        if(MartaNowHelper.stationsAreOnSameRailLine(startStation, endStation)){
            WayPoint wayPoint =  createWayPoint(startStation, endStation);
            oneWayPath.addWayPoint(wayPoint);
        } else {

            if((MartaNowHelper.comingFromEast(startStation) || MartaNowHelper.comingFromWest(startStation)) && MartaNowHelper.headedToBankhead(endStation)){

                // Weird Case!!!
                WayPoint wayPoint1 = createWayPoint(startStation, AppEnums.Station.Ashby);
                oneWayPath.addWayPoint(wayPoint1);
                WayPoint wayPoint2 = createWayPoint(AppEnums.Station.Ashby, endStation);
                oneWayPath.addWayPoint(wayPoint2);


            } else {

                // Normal Case
                WayPoint wayPoint1 = createWayPoint(startStation, AppEnums.Station.FivePoints);
                oneWayPath.addWayPoint(wayPoint1);
                WayPoint wayPoint2 = createWayPoint(AppEnums.Station.FivePoints, endStation);
                oneWayPath.addWayPoint(wayPoint2);

            }
        }
        reversePath = oneWayPath.getReversePath();
        fullPath.addAll(oneWayPath);
        fullPath.addAll(reversePath);

    }

    //region initializers - Only needed for the helper method that gets the Direction
    private void initializeRedLine(){
        RedLine.put(AppEnums.Station.Airport,0);
        RedLine.put(AppEnums.Station.CollegePark,1);
        RedLine.put(AppEnums.Station.EastPoint,2);
        RedLine.put(AppEnums.Station.Lakewood,3);
        RedLine.put(AppEnums.Station.OaklandCity,4);
        RedLine.put(AppEnums.Station.WestEnd,5);
        RedLine.put(AppEnums.Station.Garnett,6);
        RedLine.put(AppEnums.Station.FivePoints,7);
        RedLine.put(AppEnums.Station.PeachtreeCenter,8);
        RedLine.put(AppEnums.Station.CivicCenter,9);
        RedLine.put(AppEnums.Station.NorthAvenue,10);
        RedLine.put(AppEnums.Station.Midtown,11);
        RedLine.put(AppEnums.Station.ArtCenter,12);
        RedLine.put(AppEnums.Station.Lindbergh,13);
        RedLine.put(AppEnums.Station.Buckhead,14);
        RedLine.put(AppEnums.Station.MedicalCenter,15);
        RedLine.put(AppEnums.Station.Dunwoody,16);
        RedLine.put(AppEnums.Station.SandySprings,17);
        RedLine.put(AppEnums.Station.NorthSprings,18);

    }

    private void initializeGoldLine(){
        GoldLine.put(AppEnums.Station.Airport,0);
        GoldLine.put(AppEnums.Station.CollegePark,1);
        GoldLine.put(AppEnums.Station.EastPoint,2);
        GoldLine.put(AppEnums.Station.Lakewood,3);
        GoldLine.put(AppEnums.Station.OaklandCity,4);
        GoldLine.put(AppEnums.Station.WestEnd,5);
        GoldLine.put(AppEnums.Station.Garnett,6);
        GoldLine.put(AppEnums.Station.FivePoints,7);
        GoldLine.put(AppEnums.Station.PeachtreeCenter,8);
        GoldLine.put(AppEnums.Station.CivicCenter,9);
        GoldLine.put(AppEnums.Station.NorthAvenue,10);
        GoldLine.put(AppEnums.Station.Midtown,11);
        GoldLine.put(AppEnums.Station.ArtCenter,12);
        GoldLine.put(AppEnums.Station.Lindbergh,13);
        GoldLine.put(AppEnums.Station.Lenox,14);
        GoldLine.put(AppEnums.Station.Brookhaven,15);
        GoldLine.put(AppEnums.Station.Chamblee,16);
        GoldLine.put(AppEnums.Station.Doraville,17);
    }

    private void initializeBlueLine(){
        BlueLine.put(AppEnums.Station.HamiltonHolmes,0);
        BlueLine.put(AppEnums.Station.WestLake,1);
        BlueLine.put(AppEnums.Station.Ashby,2);
        BlueLine.put(AppEnums.Station.VineCity,3);
        BlueLine.put(AppEnums.Station.Dome,4);
        BlueLine.put(AppEnums.Station.FivePoints,5);
        BlueLine.put(AppEnums.Station.GeorgiaState,6);
        BlueLine.put(AppEnums.Station.KingMemorial,7);
        BlueLine.put(AppEnums.Station.InmanPark,8);
        BlueLine.put(AppEnums.Station.Edgewood,9);
        BlueLine.put(AppEnums.Station.EastLake,10);
        BlueLine.put(AppEnums.Station.Decatur,11);
        BlueLine.put(AppEnums.Station.Avondale,12);
        BlueLine.put(AppEnums.Station.Kinsington,13);
        BlueLine.put(AppEnums.Station.IndianCreek,14);

    }

    private void initializeGreenLine(){
        GreenLine.put(AppEnums.Station.Bankhead,0);
        GreenLine.put(AppEnums.Station.Ashby,1);
        GreenLine.put(AppEnums.Station.VineCity,2);
        GreenLine.put(AppEnums.Station.Dome,3);
        GreenLine.put(AppEnums.Station.FivePoints,4);
        GreenLine.put(AppEnums.Station.GeorgiaState,5);
        GreenLine.put(AppEnums.Station.KingMemorial,6);
        GreenLine.put(AppEnums.Station.InmanPark,7);
        GreenLine.put(AppEnums.Station.Edgewood,8);
    }
    //endregion

    private WayPoint createWayPoint(AppEnums.Station startStation, AppEnums.Station endStation){

        ArrayList<AppEnums.RailLine> commonRailLines = MartaNowHelper.getCommonRailLines(startStation, endStation);

        WayPoint wayPoint = new WayPoint();
        wayPoint.setDirection(getDirection(startStation, endStation));
        wayPoint.setStart(startStation);
        wayPoint.setEnd(endStation);
        for(AppEnums.RailLine line : commonRailLines){
            wayPoint.addRailOption(startStation, line, getDirection(startStation,endStation));
        }
        return wayPoint;
    }

    //TODO: Move this to the helper method somehow
    private AppEnums.Direction getDirection(AppEnums.Station startStation, AppEnums.Station endStation){
        int compare = 0;
        AppEnums.Direction direction = null;

        // NOTE: Stations have to be on the same rail for this method to work!
        if(MartaNowHelper.stationsAreOnSameRailLine(startStation,endStation)){
            // Had to work out this logic in my head so bare with me
            // If the stations are on the same rail line, and there are more than one rails to get to the destination (ie. Red/Gold to Midtown)
            // Then it doesn't matter just take the first one (This can be enhanced to get both)
            // If the stations are on the same rail line, and there is only one rail to get to the destination (ie. Red to North Springs)
            // Then take the first and only one
            AppEnums.RailLine railLine = MartaNowHelper.getCommonRailLines(endStation, startStation).get(0);
            switch(railLine){
                case Blue:
                    compare = BlueLine.get(endStation).compareTo(BlueLine.get(startStation));
                    direction = (compare > 0) ? AppEnums.Direction.East : AppEnums.Direction.West;
                    break;
                case Green:
                    compare = GreenLine.get(endStation).compareTo(GreenLine.get(startStation));
                    direction = (compare > 0) ? AppEnums.Direction.East : AppEnums.Direction.West;
                    break;
                case Red:
                    compare = RedLine.get(endStation).compareTo(RedLine.get(startStation));
                    direction = (compare > 0) ? AppEnums.Direction.North : AppEnums.Direction.South;
                    break;
                case Gold:
                    compare = GoldLine.get(endStation).compareTo(GoldLine.get(startStation));
                    direction = (compare > 0) ? AppEnums.Direction.North : AppEnums.Direction.South;
                    break;
            }
        }
        return direction;
    }

    public void updateWayPointPath(String json){
        MartaApiParser parser = new MartaApiParser(json);
        for(WayPoint wayPoint : this.getWayPoints()){
            for(RailLineOption option : wayPoint.getRailOptions()){
                String stationName = MartaNowHelper.getStationName(option.getStation());
                String directionCode = MartaNowHelper.getDirectionCode(option.getDirection());
                String railLineName = MartaNowHelper.getRailLineName(option.getRailLine());
                if(parser.selectRecord(stationName,directionCode,railLineName)){
                    System.out.println(parser.getNextArrival());
                    System.out.println(parser.getWaitText());
                    System.out.println(parser.getWaitTime());
                    option.setNextArrival(parser.getNextArrival());
                    option.setWaitText(parser.getWaitText());
                    option.setWaitTime(parser.getWaitTime());
                }else{
                   // Not sure what to do if the select failed.
                }
            }
        }
    }

    public ArrayList<WayPoint> getWayPoints(){
        ArrayList<WayPoint> allWayPoints = new ArrayList<WayPoint>(0);
        allWayPoints.addAll(fullPath.getWayPoints());
        return allWayPoints;
    }
}
