import java.io.IOException;
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

    public static void main(String[] args) throws IOException {
        double maxPoints = 40.0;
        double gradeWithHalfPoints = 4.0;
        Notenschluessel ns = new Notenschluessel(maxPoints, gradeWithHalfPoints);
        PDFWriter writer = new PDFWriter(gradeWithHalfPoints,
                ns.grades,
                ns.getPointRange().getLowPoints(),
                ns.getPointRange().getHighPoints());
        writer.save();
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
