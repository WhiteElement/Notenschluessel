import jdk.internal.access.JavaIOFileDescriptorAccess;
import jdk.internal.icu.text.UnicodeSet;

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
        createExactPoints(maxPoints, gradeWithHalfPoints);
    }

    private void createGrades() {
        LinkedList<String> tempGrades = null;
        for(int i=1; i<6; i++) {
            for(int dec=0; dec < 10; dec++) {
                tempGrades.add(i+"."+dec);
            }
        }
        tempGrades.add("6.0");

        for(int i=0; i < tempGrades.size(); i ++) {
            grades[i] = Double.parseDouble(tempGrades.get(i));
        }
        ArrayUtils.reverse(double[] grades)
    }

    private void createExactPoints(double maxPoints, double gradeWithHalfPoints) {
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
