import java.time.Period;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class Notenschluessel {

    private double maxPoints;
    private double gradeWithHalfPoints;
    private HashMap exactPointsMapping;
    private double[] exactPoints;
    LinkedList<String> grades = new LinkedList<>();

    Notenschluessel(double maxPoints, double gradeWithHalfPoints) {
        this.maxPoints = maxPoints;
        this.gradeWithHalfPoints = gradeWithHalfPoints;

        createGrades();

        PointRange pointRange = new PointRange(maxPoints, gradeWithHalfPoints);

    }

    public static void main(String[] args) {
        Notenschluessel schluessel = new Notenschluessel(40.0, 3.5);
        System.out.println(schluessel.getExactPoints(1.0));
    }


    public double calcStep(double maxPoint) {
        return maxPoints / 50; // Anzahl der Noten -1
    }

    private void createGrades() {
        for(int i=1; i<6; i++) {
            for(int dec=0; dec < 10; dec++) {
                grades.add(i+"."+dec);
            }
        }
        grades.add("6.0");

        Collections.reverse(grades);
    }
}
