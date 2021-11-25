package com.example.trianglegeometry.viewModel;

public class Formulas {

    private Double firstSide, secondSide, thirdSide;
    private static final int arraySize = 3;

    public Formulas(Double firstSide, Double secondSide, Double thirdSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
    }

    public double[] calculationOfAngles() {

        double[] result = new double[arraySize];

        result[0] = 180/3.14 * ((Math.pow(firstSide, 2) +
                Math.pow(thirdSide, 2) -
                Math.pow(firstSide, 2)) / (2 * firstSide * thirdSide));

        result[1] = 180/3.14 * ((Math.pow(firstSide, 2) +
                Math.pow(secondSide, 2) -
                Math.pow(thirdSide, 2)) / (2 * firstSide * secondSide));

        result[2] = 180 - (result[0] + result[1]);

        return result;
    }
    //вписанный радиус
    public double calculationRadiusCircumscribedCircle() {
        double result;

        result = Math.pow((((firstSide + secondSide - thirdSide) *
                (secondSide + thirdSide - firstSide) *
                (thirdSide + firstSide - thirdSide)) /
                (4 * (firstSide + secondSide + thirdSide))), 0.5);

        return result;
    }
    //описанный радиус
    public double calculationRadiusInscribedCircle() {
        double result;

        result = (firstSide * secondSide * thirdSide) / (4 * areaCalculation());

        return result;
    }

    public double[] bisectorCalculation() {
        double[] result = new double[arraySize];

        result[0] =  (2 * (
                (Math.pow((secondSide * thirdSide * (perimeterCalculation() / 2) * ((perimeterCalculation() / 2) - firstSide)) /
                        (secondSide * thirdSide), 0.5))
        ));

        result[1] =  (2 * (
                (Math.pow((firstSide * thirdSide * (perimeterCalculation() / 2) * ((perimeterCalculation() / 2) - secondSide)) /
                        (firstSide * thirdSide), 0.5))
        ));

        result[2] =  (2 * (
                (Math.pow((secondSide * firstSide * (perimeterCalculation() / 2) * ((perimeterCalculation() / 2) - thirdSide)) /
                        (firstSide * secondSide), 0.5))
        ));

        return result;
    }

    public int[] heightCalculation() {
        int[] result = new int[arraySize];

        result[0] = (int) ((2 * areaCalculation()) / firstSide);
        result[1] = (int) ((2 * areaCalculation()) / secondSide);
        result[2] = (int) ((2 * areaCalculation()) / thirdSide);

        return result;
    }

    public int[] calculationMedian() {
        int[] result = new int[arraySize];

        result[0] = (int) (0.5 * (Math.pow(((2 * Math.pow(secondSide, 2)) +
                (2 * Math.pow(thirdSide, 2)) -
                (Math.pow(firstSide, 2))), 0.5)));

        result[1] = (int) (0.5 * (Math.pow(((2 * Math.pow(firstSide, 2)) +
                (2 * Math.pow(thirdSide, 2)) -
                (Math.pow(secondSide, 2))), 0.5)));

        result[2] = (int) (0.5 * (Math.pow(((2 * Math.pow(firstSide, 2)) +
                (2 * Math.pow(secondSide, 2)) -
                (Math.pow(thirdSide, 2))), 0.5)));

        return result;
    }

    public double areaCalculation() {
        double result;
        double p;

        p = perimeterCalculation() / 2;

        result = Math.pow((p * (p - firstSide) * (p - secondSide) * (p - thirdSide)), 0.5);

        return result;
    }

    public double perimeterCalculation() {
        double result;

        result = firstSide + secondSide + thirdSide;

        return result;
    }

    public String typeOfTriangle() {

        if (calculationOfAngles()[0] < 90 && calculationOfAngles()[1] < 90 && calculationOfAngles()[2] < 90)
            return "Остроугольный треугольник";

        if (calculationOfAngles()[0] > 90 || calculationOfAngles()[1] > 90 || calculationOfAngles()[2] > 90)
            return "Тупоугольный треугольник";

        if (calculationOfAngles()[0] == 90 || calculationOfAngles()[1] == 90 || calculationOfAngles()[2] == 90)
            return "Прямоугольный треугольник";

        if (!firstSide.equals(secondSide) && !secondSide.equals(thirdSide))
            return "Разносторонний треугольник";

        if (firstSide.equals(secondSide) || firstSide.equals(thirdSide) || secondSide.equals(thirdSide))
            return "Равнобедренный треугольник";

        if (firstSide.equals(secondSide) && secondSide.equals(thirdSide))
            return "Равносторонним треугольник или правильный треугольник - все три стороны равны";

        return "Error (";
    }+
}
