
import java.util.LinkedList;

    enum StepsFor {
        ALL,
        TOONE,
        TOSIX
    }

public class PointRange {
    private final LinkedList<Double> grades;
    private LinkedList<Double> exactPoints = new LinkedList<>();
    private LinkedList<Double> lowPoints = new LinkedList<>();
    private LinkedList<Double> highPoints= new LinkedList<>();
    private double maxPoints;

    public PointRange(double maxPoints, double gradeWithHalfPoints, LinkedList<Double> grades) {

        this.grades = grades;
        this.maxPoints = maxPoints;

        calcExactPoints(maxPoints, gradeWithHalfPoints, grades);
        calcHighPoints();
        calcLowPoints();
    }

    private void calcHighPoints() {
        for(double point : exactPoints) {
            highPoints.add(decideRounding(point, this.maxPoints));
        }
    }

    public double decideRounding(double point, double maxPoints) {
        double roundedDown = Math.floor(point);
        double decimal = point - roundedDown;
        if (Math.abs(maxPoints-point) <= 0.001) return maxPoints;
        if(decimal >= .5) {
            return roundedDown + 0.5;
        }
        else {
            return roundedDown;
        }
    }

    private void calcLowPoints() {
       for(int numGrade= 0; numGrade < grades.size(); numGrade++) {
           if(numGrade == 0) {
               lowPoints.add(0.0);
               continue;
           }
           double lastHigh = highPoints.get(numGrade-1);
           lowPoints.add(lastHigh + 0.5);
       }

    }

    private void calcExactPoints(double maxPoints, double gradeWithHalfPoints, LinkedList<Double> grades) {
        if(Double.compare(gradeWithHalfPoints, 3.5) == 0) {
            //ohne knick

            double step = calcStep(maxPoints, StepsFor.ALL);
            double point = 0;

            for(int i=0; i<grades.size(); i++) {
                exactPoints.add(point);
                point += step;
            }

        }
        else if (Double.compare(gradeWithHalfPoints, 4.0) == 0) {
            double steptoOne = calcStep(maxPoints, StepsFor.TOONE);
            double stepToSix = calcStep(maxPoints, StepsFor.TOSIX);

            double point = 0;
            for(int i=0; i<20; i++) {
                exactPoints.add(point);
                point+=stepToSix;
            }
            point = maxPoints / 2;
            for(int i=0; i<31; i++) {
                if(i == 30) {
                    exactPoints.add(maxPoints);
                    break;
                }
                exactPoints.add(point);
                point+=steptoOne;
            }
        }
        else
            System.out.println("keine gültige Note für halbe Punktezahl angegeben");
    }

    public double calcStep(double maxPoints, StepsFor direction) {
        if(direction == StepsFor.ALL)
           return maxPoints / 50; // num of grades -1
        if(direction == StepsFor.TOONE) {
            final int numOfSteps = 30;
            return maxPoints / 2 / numOfSteps;
        }
        if(direction == StepsFor.TOSIX) {
            final int numOfSteps = 20;
            return maxPoints / 2 / numOfSteps;
        }
        return -1;
    }


    public double getExactPoint(double grade) {
        int index = grades.indexOf(grade);
        for (double g :grades) {
        }
        return exactPoints.get(index);
    }

    public double getHighPoint(double grade) {
        int index = grades.indexOf(grade);
        return highPoints.get(index);
    }

    public LinkedList<Double> getLowPoints() {
        return lowPoints;
    }

    public LinkedList<Double> getHighPoints() {
        return highPoints;
    }

    public LinkedList<Double> getExactPoints() {
        return exactPoints;
    }

}





