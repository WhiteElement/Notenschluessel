import java.time.Period;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class Notenschluessel {

    private double maxPoints;
    private double gradeWithHalfPoints;
    LinkedList<String> gradeNames = new LinkedList<>();
    LinkedList<Double> grades = new LinkedList<>();
    private PointRange pointRange;

    Notenschluessel(double maxPoints, double gradeWithHalfPoints) {
        this.maxPoints = maxPoints;
        this.gradeWithHalfPoints = gradeWithHalfPoints;

        createGrades();

        pointRange = new PointRange(maxPoints, gradeWithHalfPoints, getGrades());

    }

    public static void main(String[] args) {
        Notenschluessel ns = new Notenschluessel(40, 3.5);
        for(int i =0; i< ns.getGrades().size(); i++) {
            System.out.println("grade: " + ns.getGrades().get(i) +
                    ", low: " + ns.getPointRange().getLowPoints().get(i) +
                    ",  high: " + ns.getPointRange().getHighPoints().get(i) +
                    ", exact: " + ns.getPointRange().getExactPoints().get(i));
        }
}

    public double calcStep(double maxPoint) {
        return maxPoints / 50; // Anzahl der Noten -1
    }

    private void createGrades() {
        for(int i=1; i<6; i++) {
            for(int dec=0; dec < 10; dec++) {
                gradeNames.add(i+"."+dec);
            }
        }
        gradeNames.add("6.0");

        Collections.reverse(gradeNames);
        for( String gradeName : gradeNames) {
            grades.add(Double.parseDouble(gradeName));
        }
    }

    public LinkedList<Double> getGrades() {
        return this.grades;
    }
    public PointRange getPointRange() {
        return this.pointRange;
   }

    public double getMaxPoints() {
        return this.maxPoints;
    }
}
