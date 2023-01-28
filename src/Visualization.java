import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

import static java.lang.Math.*;

public class Visualization {
    private int numPoints = 10;
    private int timesTable = 2;
    private String color = "Black";

    public void setNumPoints(int n) {
        numPoints = n;
    }

    public void setColor(String c) {
        color = c;
    }

    public void setTimesTable(int n) {
        if (n > 360)
        {
            n = n % 360;
        }
        timesTable = n;
    }
    public int getTimesTable() {
        return timesTable;
    }

    public Canvas drawCircle() {
        Canvas visual = new Canvas(600,600);
        GraphicsContext gc = visual.getGraphicsContext2D();
        gc.setStroke(Paint.valueOf(color));
        gc.strokeOval(90,90, 400, 400);

        float degreeIncrement = (float) (360.0 / numPoints);
        double incrementInRadians = toRadians(degreeIncrement);

        for(int i = 0; i <= numPoints; i++) {
            double x = (-cos(incrementInRadians * i)*200)+289;
            double y = (sin(incrementInRadians * i)*200)+289;
            double x2 = (-cos(incrementInRadians * ((i*timesTable)%numPoints))*200) + 289;
            double y2 = (sin(incrementInRadians * ((i*timesTable)%numPoints))*200) + 289;
            gc.strokeLine(x,y,x2,y2);
        }
        return visual;
    }
}
