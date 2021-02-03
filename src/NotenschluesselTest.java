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
    public void step_should_be_0_8() {
        Notenschluessel schluessel = new Notenschluessel(40.0, 3.5);
        schluessel.calcStep(schluessel.getMaxPoints(), getGradeWithHalfPoints());
    }

    private double getGradeWithHalfPoints() {
        return this.getGradeWithHalfPoints();
    }
}
