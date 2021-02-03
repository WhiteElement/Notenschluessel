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

    }
}
