import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class Main extends Application {
    public static void main(String[] args) {launch(args);}
    @Override
    public void start(Stage stage) {
        stage.setTitle("Modulo Visualization");

        BorderPane root = new BorderPane();
        VBox gui = new VBox(10);
        Button startBtn = new Button("Start");
        Button stopBtn = new Button("Stop");
        Slider speedSlider = new Slider(0, 3, 1);
        Label speedLabel = new Label("Delay in seconds");
        Label TimesTableLabel= new Label("Enter the times table number from 1 to 360");
        TextField timesTableField = new TextField();
        Label NumPointsLabel= new Label("Enter the number of points from 1 to 360");
        TextField numPointsField = new TextField();

        Visualization v = new Visualization();

        MenuItem red = new MenuItem("Red");
        MenuItem orange = new MenuItem("Orange");
        MenuItem yellow = new MenuItem("Yellow");
        MenuItem green = new MenuItem("Green");
        MenuItem blue = new MenuItem("Blue");
        MenuItem indigo = new MenuItem("Indigo");
        MenuItem violet = new MenuItem("Violet");
        MenuItem black = new MenuItem("Black");
        MenuItem lime = new MenuItem("Lime");
        MenuItem pink = new MenuItem("Pink");

        MenuButton color = new MenuButton("Color");
        color.getItems().addAll(
                red, orange, yellow, green, blue, indigo, violet, black, lime, pink
        );

        speedSlider.setShowTickMarks(true);
        speedSlider.setShowTickLabels(true);
        speedSlider.setMajorTickUnit(1);

        gui.getChildren().addAll(speedLabel, speedSlider,TimesTableLabel, timesTableField,
                NumPointsLabel, numPointsField, color, startBtn, stopBtn);

        root.setLeft(gui);
        root.setCenter(v.drawCircle());

        stage.setScene(new Scene(root,800,600));
        stage.show();

        AnimationTimer a = new AnimationTimer() {
            private long lastUpdate = 0;
            @Override
            public void handle (long now) {
                if ((now - lastUpdate) >= speedSlider.getValue()*1000000000)
                {
                    root.setCenter(null);
                    v.setTimesTable(v.getTimesTable() + 1);
                    root.setCenter(v.drawCircle());
                    lastUpdate = now;
                }
            }
        };
        startBtn.setOnAction(event -> a.start());

        stopBtn.setOnAction(event -> a.stop());

        numPointsField.setOnAction(event -> {
            int retrievedNumPoints = Integer.parseInt(numPointsField.getText());
            v.setNumPoints(retrievedNumPoints);
            root.setCenter(null);
            root.setCenter(v.drawCircle());
        });

        timesTableField.setOnAction(event -> {
            int retrievedTimesTable = Integer.parseInt(timesTableField.getText());
            v.setTimesTable(retrievedTimesTable);
            root.setCenter(null);
            root.setCenter(v.drawCircle());
        });


        red.setOnAction(event -> {
            root.setCenter(null);
            v.setColor("Red");
            root.setCenter(v.drawCircle());
        });

        orange.setOnAction(event -> {
            root.setCenter(null);
            v.setColor("Orange");
            root.setCenter(v.drawCircle());
        });

        yellow.setOnAction(event -> {
            root.setCenter(null);
            v.setColor("Yellow");
            root.setCenter(v.drawCircle());
        });

        green.setOnAction(event -> {
            root.setCenter(null);
            v.setColor("Green");
            root.setCenter(v.drawCircle());
        });

        blue.setOnAction(event -> {
            root.setCenter(null);
            v.setColor("Blue");
            root.setCenter(v.drawCircle());
        });

        indigo.setOnAction(event -> {
            root.setCenter(null);
            v.setColor("Indigo");
            root.setCenter(v.drawCircle());
        });

        violet.setOnAction(event -> {
            root.setCenter(null);
            v.setColor("Violet");
            root.setCenter(v.drawCircle());
        });

        black.setOnAction(event -> {
            root.setCenter(null);
            v.setColor("Black");
            root.setCenter(v.drawCircle());
        });

        lime.setOnAction(event -> {
            root.setCenter(null);
            v.setColor("Lime");
            root.setCenter(v.drawCircle());
        });

        pink.setOnAction(event -> {
            root.setCenter(null);
            v.setColor("Pink");
            root.setCenter(v.drawCircle());
        });
    }
}
