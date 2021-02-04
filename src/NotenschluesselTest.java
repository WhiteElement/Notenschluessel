import org.junit.Assert;
import org.junit.Test;

public class NotenschluesselTest {

    @Test
    public void should_be_3_5() {
        /*
        arrange act assert
         */
        Notenschluessel schluessel = new Notenschluessel(40.0, 3.5);
        double halfPoints = schluessel.getMaxPoints()/2;
        double exactPoints = schluessel.getExactPoints(3.5);

        Assert.assertTrue(Double.compare(halfPoints, exactPoints) == 0);
    }

    @Test
    public void first_exact_point_is_0_8() {
        Notenschluessel schluessel = new Notenschluessel(40.0, 3.5);
        double point = schluessel.getExactPoints(1.1);

        Assert.assertTrue(Double.compare(point, 0.8) == 0);
    }

    @Test
    public void step_should_be_0_8() {
        Notenschluessel schluessel = new Notenschluessel(40.0, 3.5);
        double step = schluessel.calcStep(schluessel.getMaxPoints());

        Assert.assertTrue(Double.compare(step, 0.8) == 0);
    }
}
