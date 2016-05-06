package by.gstu.choicecamera.domain.optimization;

import by.gstu.choicecamera.domain.Camera;
import by.gstu.choicecamera.domain.CameraWithMarks;
import by.gstu.choicecamera.domain.Manufacturers;
import by.gstu.choicecamera.domain.compare.*;

import java.util.ArrayList;
import java.util.List;

public class MultiCriterion {
    List<Camera> cameras;
    List<CameraWithMarks> cameraMarks;
    int countCriterion = 5;

    public MultiCriterion(List<Camera> cameras) {
        this.cameras = cameras;
    }

    public static double harrington(double value) {
        if (value <= 4.0 && value >= 3.5)
            return 0.2;
        if (value < 3.5 && value > 3.0)
            return (0.36 + 0.2) / 2;
        if (value <= 3.0 && value >= 2.9)
            return 0.36;
        if (value < 2.9 && value > 2.4)
            return (0.36 + 0.63) / 2;
        if (value <= 2.4 && value >= 2.2)
            return 0.63;
        if (value < 2.2 && value > 1.8)
            return (0.8 + 0.63) / 2;
        if (value == 1.8)
            return 0.8;
        if (value < 1.8)
            return 1;
        return 0;
    }

    public List<Camera> solve(double[][] expert) {
        getMarks();
        return mi(pareto(), rang(expert));
    }

    void getMarks() {
        cameraMarks = new ArrayList<>();
        cameras.sort(new CostCompare());
        double minCost = cameras.get(0).getPrice();
        cameras.sort(new DateCompare());
        double maxDate = cameras.get(cameras.size()-1).getReleaseDate();
        cameras.sort(new MatrixDotCompare());
        double maxMatrixDot = cameras.get(cameras.size()-1).getMatrixDot();
        cameras.sort(new ApertureCompare());
        double maxApert = (harrington(cameras.get(cameras.size()-1).getApertureMin()) + harrington(cameras.get(cameras.size()-1).getApertureMax())) / 2;
        cameras.sort(new ManufacturerCompare());
        double manuf = Manufacturers.valueOf(cameras.get(cameras.size()-1).getManufacturer().toUpperCase()).getValue();

        for (int i = 0; i < cameras.size(); i++) {
            cameraMarks.add(new CameraWithMarks(cameras.get(i), new double[countCriterion]));
            cameraMarks.get(i).marks[0] = minCost / cameras.get(i).getPrice();
            cameraMarks.get(i).marks[1] = cameras.get(i).getReleaseDate() / maxDate;
            cameraMarks.get(i).marks[2] = Manufacturers.valueOf(cameras.get(i).getManufacturer().toUpperCase()).getValue()/manuf;
            cameraMarks.get(i).marks[3] = ((harrington(cameras.get(i).getApertureMin()) + harrington(cameras.get(i).getApertureMax())) / 2) / maxApert;
            cameraMarks.get(i).marks[4] = cameras.get(i).getMatrixDot() / maxMatrixDot;
        }
    }

    public List<CameraWithMarks> pareto() {
        List<CameraWithMarks> result = cameraMarks;
        boolean isBetter, isComplete = false;
        int i = 0;
        int j = 1;
        while (!isComplete) {
            isBetter = true;
            for (int m = 0; m < result.get(i).marks.length; m++)
                if (result.get(i).marks[m] < result.get(j).marks[m]) {
                    isBetter = false;
                    break;
                }
            if (isBetter) {
                result.remove(j);
            } else {
                isBetter=true;
                for (int m = 0; m < result.get(i).marks.length; m++)
                    if (result.get(j).marks[m] < result.get(i).marks[m]) {
                        isBetter = false;
                        break;
                    }
                if (isBetter) {
                    result.remove(i);
                }
            }
            if (j < result.size() - 1)
                j++;
            else if (i < result.size() - 1 - 1) {
                i++;
                j=i+1;
            } else
                isComplete = true;
        }
        return result;
    }

    double[] rang(double[][] expert) {
        int m = expert.length;
        int n = expert[0].length;
        double[] arraySum = new double[n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++)
                arraySum[j] += expert[i][j];
        }

        double sum = 0;
        for (double i : arraySum) {
            sum += i;
        }

        double[] v = new double[n];
        for (int i = 0; i < n; i++) {
            v[i] = arraySum[i] / sum;
        }
        return v;
    }

    List<Camera> mi(List<CameraWithMarks> altern, double[] v) {

        for (int i = 0; i < altern.size(); i++)
            for (int j = 0; j < v.length; j++)
                altern.get(i).indicImpot += altern.get(i).marks[j] * v[j];

        altern.sort(new WeightCompare());

        List<Camera> cameras = new ArrayList<>();
        for (int i = altern.size()-1; i>=0 ; i--) {
            cameras.add(altern.get(i).camera);
        }

        return cameras;
    }
}
