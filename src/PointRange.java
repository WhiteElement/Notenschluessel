import java.util.HashMap;
import java.util.LinkedList;

public class PointRange {
    private LinkedList<Double> exactPoints;
    private LinkedList<Double> lowPoints;
    private LinkedList<Double> highPoints;

    PointRange(double maxPoints, double gradeWithHalfPoints) {

        calcExactPoints();
        calcLowPoints();
        calcHighPoints();
    }


    private void calcExactPoints(double maxPoints, double gradeWithHalfPoints) {
        if(Double.compare(gradeWithHalfPoints, 3.5) == 0) {
            //ohne knick

            double step = calcStep(maxPoints);
            double point = 0;
            this.exactPoints = new double[grades.size()];

            for(int i=0; i<grades.size(); i++) {
                this.exactPoints[i] = point;
                point += step;
            }
        }
    }



    private void matchExactPoints(double maxPoints, double gradeWithHalfPoints) {
        exactPointsMapping = new HashMap<Double, Double>();

        for(int i =0; i<grades.size(); i++) {
            exactPointsMapping.put(grades.get(i), this.exactPoints[i]);
        }
    }

    public double getMaxPoints() {
        return this.maxPoints;
    }

    public double getExactPoints(double grade) {
        Double _grade = (Double) grade;
        return (double) this.exactPointsMapping.get(_grade);
    }
}
