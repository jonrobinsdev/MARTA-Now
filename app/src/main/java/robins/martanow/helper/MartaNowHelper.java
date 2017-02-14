package robins.martanow.helper;

import java.util.ArrayList;

/**
 * Created by shaynemoore on 2/8/17.
 */

public class MartaNowHelper {

    public static ArrayList<AppEnums.RailLine> getRailLine(AppEnums.Station station){
        ArrayList<AppEnums.RailLine> railLines = new ArrayList<AppEnums.RailLine>();
        switch(station){
            case Bankhead:
                railLines.add(AppEnums.RailLine.Green);
                break;
            case HamiltonHolmes:
            case WestLake:
            case EastLake:
            case Decatur:
            case Avondale:
            case Kinsington:
            case IndianCreek:
                railLines.add(AppEnums.RailLine.Blue);
                break;
            case Ashby:
            case VineCity:
            case Dome:
            case GeorgiaState:
            case KingMemorial:
            case InmanPark:
            case Edgewood:
                railLines.add(AppEnums.RailLine.Green);
                railLines.add(AppEnums.RailLine.Blue);
                break;
            case NorthSprings:
            case SandySprings:
            case Dunwoody:
            case MedicalCenter:
            case Buckhead:
                railLines.add(AppEnums.RailLine.Red);
                break;
            case Doraville:
            case Chamblee:
            case Lenox:
                railLines.add(AppEnums.RailLine.Gold);
                break;
            case Lindbergh:
            case ArtCenter:
            case Midtown:
            case NorthAvenue:
            case CivicCenter:
            case PeachtreeCenter:
            case Garnett:
            case WestEnd:
            case OaklandCity:
            case Lakewood:
            case EastPoint:
            case CollegePark:
            case Airport:
                railLines.add(AppEnums.RailLine.Red);
                railLines.add(AppEnums.RailLine.Gold);
                break;
            case FivePoints:
                railLines.add(AppEnums.RailLine.Green);
                railLines.add(AppEnums.RailLine.Blue);
                railLines.add(AppEnums.RailLine.Red);
                railLines.add(AppEnums.RailLine.Gold);
                break;
        }
        return railLines;
    }

    public static boolean stationsAreOnSameRailLine(AppEnums.Station station1, AppEnums.Station station2){
        ArrayList<AppEnums.RailLine> station1RailLines = getRailLine(station1);
        ArrayList<AppEnums.RailLine> station2RailLines = getRailLine(station2);

        if(station1RailLines.size() >= station2RailLines.size()){
            for(AppEnums.RailLine railLine : station1RailLines){
                if(station2RailLines.contains(railLine)){
                    return true;
                }
            }
        } else {
            for(AppEnums.RailLine railLine : station2RailLines){
                if(station1RailLines.contains(railLine)){
                    return true;
                }
            }
        }

        return false;
    }

    public static ArrayList<AppEnums.RailLine> getCommonRailLines(AppEnums.Station station1, AppEnums.Station station2){
        ArrayList<AppEnums.RailLine> commonRailLines = new ArrayList<AppEnums.RailLine>();

        ArrayList<AppEnums.RailLine> station1RailLines = getRailLine(station1);
        ArrayList<AppEnums.RailLine> station2RailLines = getRailLine(station2);

        if(station1RailLines.size() >= station2RailLines.size()){
            for(AppEnums.RailLine railLine : station1RailLines){
                if(station2RailLines.contains(railLine)){
                    commonRailLines.add(railLine);
                }
            }
        } else {
            for(AppEnums.RailLine railLine : station2RailLines){
                if(station1RailLines.contains(railLine)){
                    commonRailLines.add(railLine);
                }
            }
        }
        return commonRailLines;
    }

    public static boolean comingFromEast(AppEnums.Station startStation){
        switch(startStation){
            case EastLake:
            case Decatur:
            case Avondale:
            case Kinsington:
            case IndianCreek:
                return true;
            default:
                return false;
        }
    }

    public static boolean headedToBankhead(AppEnums.Station endStation){
        return endStation == AppEnums.Station.Bankhead;
    }

    public static boolean comingFromWest(AppEnums.Station startStation){
        switch (startStation){
            case WestLake:
            case HamiltonHolmes:
                return true;
            default:
                return false;
        }
    }

    public static String getStationName(AppEnums.Station station){
        String stationName = "";
        switch(station){
            case Bankhead:
                stationName = "Bankhead";
                break;
            case HamiltonHolmes:
                stationName = "Bankhead";
                break;
            case WestLake:
                stationName = "Bankhead";
                break;
            case EastLake:
                stationName = "Bankhead";
                break;
            case Decatur:
                stationName = "Bankhead";
                break;
            case Avondale:
                stationName = "Bankhead";
                break;
            case Kinsington:
                stationName = "Bankhead";
                break;
            case IndianCreek:
                stationName = "Bankhead";
                break;
            case Ashby:
                stationName = "Bankhead";
                break;
            case VineCity:
                stationName = "Bankhead";
                break;
            case Dome:
                stationName = "Bankhead";
                break;
            case GeorgiaState:
                stationName = "Bankhead";
                break;
            case KingMemorial:
                stationName = "Bankhead";
                break;
            case InmanPark:
                stationName = "Bankhead";
                break;
            case Edgewood:
                stationName = "Bankhead";
                break;
            case NorthSprings:
                stationName = "Bankhead";
                break;
            case SandySprings:
                stationName = "Bankhead";
                break;
            case Dunwoody:
                stationName = "Bankhead";
                break;
            case MedicalCenter:
                stationName = "Bankhead";
                break;
            case Buckhead:
                stationName = "Bankhead";
                break;
            case Doraville:
                stationName = "Bankhead";
                break;
            case Chamblee:
                stationName = "Bankhead";
                break;
            case Lenox:
                stationName = "Bankhead";
                break;
            case Lindbergh:
                stationName = "Bankhead";
                break;
            case ArtCenter:
                stationName = "Bankhead";
                break;
            case Midtown:
                stationName = "Bankhead";
                break;
            case NorthAvenue:
                stationName = "Bankhead";
                break;
            case CivicCenter:
                stationName = "Bankhead";
                break;
            case PeachtreeCenter:
                stationName = "Bankhead";
                break;
            case Garnett:
                stationName = "Bankhead";
                break;
            case WestEnd:
                stationName = "Bankhead";
                break;
            case OaklandCity:
                stationName = "Bankhead";
                break;
            case Lakewood:
                stationName = "Bankhead";
                break;
            case EastPoint:
                stationName = "Bankhead";
                break;
            case CollegePark:
                stationName = "Bankhead";
                break;
            case Airport:
                stationName = "Bankhead";
                break;
            case FivePoints:
                stationName = "Bankhead";
                break;
        }
        return stationName;
    }

    public static String getDirectionCode(AppEnums.Direction direction){
        switch(direction){
            case South:
                return "S";
            case East:
                return "E";
            case North:
                return "N";
            case West:
                return "W";
            default:
                return null;
        }
    }

    public static String getRailLineName(AppEnums.RailLine railLine){
        String railLineName = "";
        switch (railLine){
            case Blue:
                railLineName = "Blue";
                break;
            case Green:
                railLineName = "Blue";
                break;
            case Red:
                railLineName = "Blue";
                break;
            case Gold:
                railLineName = "Blue";
                break;
        }
        return railLineName;
    }
}
