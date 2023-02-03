import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

import static java.lang.Math.*;
/**
 * Only one instance of the visualization class is used, primarily to handle the logic of
 * receiving values updated by the user and then using these values to draw the modulo visualization and
 * to then return this as a finished Canvas to the Main class
 */
public class Visualization {
    private boolean cycle = false;
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

    /**
     * does the math of calculating where to draw the lines and draws them onto a canvas with the given color
     * uses the number of points specified as well as the times table number that was also previously given
     * @return a finished canvas with the needed circle and lines correctly colored and placed
     */
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

    /**
     * used for getting if color cycling is on or not
     * @return true if color cycling is enabled false if color cycling is not
     */
    public boolean isCycle() { return cycle; }

    public void setCycle(boolean cycle) {
        this.cycle = cycle;
    }
}
