package robins.martanow;

import org.junit.Test;

import java.util.ArrayList;

import robins.martanow.helper.AppEnums;
import robins.martanow.helper.MartaNowHelper;
import robins.martanow.wayfinder.RailLineOption;
import robins.martanow.wayfinder.WayFinder;
import robins.martanow.wayfinder.WayPoint;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void wayFinder_correctWayPoints(){
        WayFinder wayFinder = new WayFinder(AppEnums.Station.Decatur, AppEnums.Station.ArtCenter);
        ArrayList<WayPoint> wayPoints = wayFinder.getWayPoints();

        assertEquals(4 , wayPoints.size());

        assertEquals(AppEnums.Station.Decatur, wayPoints.get(0).getStart());
        assertEquals(AppEnums.Station.FivePoints, wayPoints.get(0).getEnd());

        assertEquals(AppEnums.Station.FivePoints, wayPoints.get(1).getStart());
        assertEquals(AppEnums.Station.ArtCenter, wayPoints.get(1).getEnd());

        assertEquals(AppEnums.Station.ArtCenter , wayPoints.get(2).getStart());
        assertEquals(AppEnums.Station.FivePoints, wayPoints.get(2).getEnd());

        assertEquals(AppEnums.Station.FivePoints, wayPoints.get(3).getStart());
        assertEquals(AppEnums.Station.Decatur, wayPoints.get(3).getEnd());

        ArrayList<RailLineOption> railOptions = wayPoints.get(0).getRailOptions();
        assertEquals(AppEnums.Station.Decatur, railOptions.get(0).getStation());
        assertEquals(AppEnums.Direction.West, railOptions.get(0).getDirection());

        railOptions = wayPoints.get(3).getRailOptions();
        assertEquals(AppEnums.Station.FivePoints, railOptions.get(0).getStation());
        assertEquals(AppEnums.Direction.East, railOptions.get(0).getDirection());
    }

    @Test
    public void martaNowHelper_onSameRail(){
        assertTrue(MartaNowHelper.stationsAreOnSameRailLine(AppEnums.Station.Decatur, AppEnums.Station.FivePoints));
    }

    @Test
    public void martaNowHelper_notOnSameRail(){
        assertFalse(MartaNowHelper.stationsAreOnSameRailLine(AppEnums.Station.Decatur, AppEnums.Station.ArtCenter));
    }

    @Test
    public void martaNowHelper_commonRails(){
        ArrayList<AppEnums.RailLine> railLines = MartaNowHelper.getCommonRailLines(AppEnums.Station.Decatur, AppEnums.Station.FivePoints);
        assertEquals(railLines.size(), 1);
        assertEquals(railLines.get(0), AppEnums.RailLine.Blue);
    }

}