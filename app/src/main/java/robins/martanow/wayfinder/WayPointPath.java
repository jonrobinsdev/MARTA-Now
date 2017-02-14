package robins.martanow.wayfinder;

import java.util.ArrayList;

/**
 * Created by shaynemoore on 2/7/17.
 */

public class WayPointPath {

    ArrayList<WayPoint> wayPoints = new ArrayList<WayPoint>();

    public void addWayPoint(WayPoint wayPoint){
        wayPoints.add(wayPoint);
    }

    public WayPointPath getReversePath(){
        WayPointPath reversedPath = new WayPointPath();
        for(int i = (wayPoints.size()-1); i >= 0 ; i--){
            WayPoint reversedWayPoint = wayPoints.get(i).reverse();
            reversedPath.addWayPoint(reversedWayPoint);
        }
        return reversedPath;
    }

    public void addAll(WayPointPath wayPoints){
        this.wayPoints.addAll(wayPoints.getWayPoints());
    }

    protected ArrayList<WayPoint> getWayPoints(){
        return this.wayPoints;
    }

}
