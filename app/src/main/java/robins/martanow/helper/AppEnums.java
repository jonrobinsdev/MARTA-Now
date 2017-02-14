package robins.martanow.helper;

/**
 * Created by shaynemoore on 2/7/17.
 */

public class AppEnums {

    public enum Direction {
        North ,
        South,
        East,
        West
    }

    public enum RailLine {
        Blue,
        Gold,
        Red,
        Green
    }
    public enum Station{
        Bankhead,
        HamiltonHolmes,
        WestLake,
        EastLake,
        Decatur,
        Avondale,
        Kinsington,
        IndianCreek,
        Ashby,
        VineCity,
        Dome,
        GeorgiaState,
        KingMemorial,
        InmanPark,
        Edgewood,
        NorthSprings,
        SandySprings,
        Dunwoody,
        MedicalCenter,
        Buckhead,
        Doraville,
        Chamblee,
        Lenox,
        Lindbergh,
        ArtCenter,
        Midtown,
        NorthAvenue,
        CivicCenter,
        PeachtreeCenter,
        Garnett,
        WestEnd,
        OaklandCity,
        Lakewood,
        EastPoint,
        CollegePark,
        Airport,
        FivePoints,
        Brookhaven
    }

    public static String getStationName(Station station){
        String name = "";
        switch(station){
            case Bankhead:
                name = "Bankhead";
                break;
            case HamiltonHolmes:
                break;
            case WestLake:
                break;
            case EastLake:
                break;
            case Decatur:
                break;
            case Avondale:
                break;
            case Kinsington:
                break;
            case IndianCreek:
                break;
            case Ashby:
                break;
            case VineCity:
                break;
            case Dome:
                break;
            case GeorgiaState:
                break;
            case KingMemorial:
                break;
            case InmanPark:
                break;
            case Edgewood:
                break;
            case NorthSprings:
                break;
            case SandySprings:
                break;
            case Dunwoody:
                break;
            case MedicalCenter:
                break;
            case Buckhead:
                break;
            case Doraville:
                break;
            case Chamblee:
                break;
            case Lenox:
                break;
            case Lindbergh:
                break;
            case ArtCenter:
                break;
            case Midtown:
                break;
            case NorthAvenue:
                break;
            case CivicCenter:
                break;
            case PeachtreeCenter:
                break;
            case Garnett:
                break;
            case WestEnd:
                break;
            case OaklandCity:
                break;
            case Lakewood:
                break;
            case EastPoint:
                break;
            case CollegePark:
                break;
            case Airport:
                break;
            case FivePoints:
                break;
        }
        return name;
    }
}
