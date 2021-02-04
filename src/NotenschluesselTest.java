import org.junit.Assert;
import org.junit.Test;

public class NotenschluesselTest extends DoubleFormatter {

    @Test
    public void half_should_be_3_5() {
        /*
        arrange act assert
         */
        Notenschluessel schluessel = new Notenschluessel(40.0, 3.5);
        double halfPoints = schluessel.getMaxPoints()/2;
        double exactPoints = schluessel.getPointRange().getExactPoint(3.5);

        Assert.assertTrue(Double.compare(singleDec(halfPoints), singleDec(exactPoints)) == 0);
    }

    @Test
    public void first_exact_point_is_0_8() {
        Notenschluessel schluessel = new Notenschluessel(40.0, 3.5);
        double point = schluessel.getPointRange().getExactPoint(5.9);

        Assert.assertTrue(Double.compare(point, 0.8) == 0);
    }

    @Test
    public void step_should_be_0_8() {
        Notenschluessel schluessel = new Notenschluessel(40.0, 3.5);
        double step = schluessel.getPointRange().calcStep(schluessel.getMaxPoints());

        Assert.assertTrue(Double.compare(step, 0.8) == 0);
    }

    @Test
    public void should_round_up() {
        Notenschluessel schluessel = new Notenschluessel(40.0, 3.5);
        double point = schluessel.getPointRange().decideRounding(0.8, 40.0);

        Assert.assertTrue(Double.compare(point, 0.5) == 0);
    }

    @Test
    public void should_round_up2() {
        Notenschluessel schluessel = new Notenschluessel(40.0, 3.5);
        double point = schluessel.getPointRange().decideRounding(26.5, 40.0);

        Assert.assertTrue(Double.compare(point, 26.5) == 0);
    }

    @Test
    public void should_round_up3() {
        Notenschluessel schluessel = new Notenschluessel(40.0, 3.5);
        double point = schluessel.getPointRange().decideRounding(12.7, 40.0);

        Assert.assertTrue(Double.compare(point, 12.5) == 0);
    }

    @Test
    public void should_round_down() {
        Notenschluessel schluessel = new Notenschluessel(40.0, 3.5);
        double point = schluessel.getPointRange().decideRounding(11.1, 40.0);

        Assert.assertTrue(Double.compare(point, 11.0) == 0);
    }

    @Test
    public void should_round_down2() {
        Notenschluessel schluessel = new Notenschluessel(40.0, 3.5);
        double point = schluessel.getPointRange().decideRounding(27.4, 40.0);

        Assert.assertTrue(Double.compare(point, 27.0) == 0);
    }
}
