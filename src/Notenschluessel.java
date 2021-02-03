import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class Notenschluessel {

    private double maxPoints;
    private double gradeWithHalfPoints;
    private HashMap ExactPoints;
    private double[] grades;

    Notenschluessel(double maxPoints, double gradeWithHalfPoints) {
        this.maxPoints = maxPoints;
        this.gradeWithHalfPoints = gradeWithHalfPoints;

        createGrades();
        calcExactPoints(maxPoints, gradeWithHalfPoints);
        matchExactPoints(maxPoints, gradeWithHalfPoints);
    }

    private void calcExactPoints(double maxPoints, double gradeWithHalfPoints) {
        if(Double.compare(gradeWithHalfPoints, 3.5) == 0) {
            //ohne knick

            double step = calcStep(maxPoints);
            
        }
    }

    public double calcStep(double maxPoint) {
        return maxPoints / 50; // Anzahl der Noten -1
    }

    private void createGrades() {
        LinkedList<String> grades = null;
        for(int i=1; i<6; i++) {
            for(int dec=0; dec < 10; dec++) {
                grades.add(i+"."+dec);
            }
        }
        grades.add("6.0");

        Collections.reverse(grades);
    }

    private void matchExactPoints(double maxPoints, double gradeWithHalfPoints) {
        ExactPoints = new HashMap<Double, Double>();

        for(double grade : grades) {
            ExactPoints.put(grade, points);
        }
    }

    public double getMaxPoints() {
        return this.maxPoints;

    }

    public double getExactPoints(double grade) {
         return (double) ExactPoints.get(3.5);
    }
}
