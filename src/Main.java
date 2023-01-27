import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {launch(args); }
    @Override
    public void start(Stage stage) {
        stage.setTitle("Modulo Visualization");

        BorderPane root = new BorderPane();
        VBox gui = new VBox(10);
        Button startBtn = new Button("Start");
        Button pauseBtn = new Button("Pause");
        Slider speedSlider = new Slider(0, 5, 1);
        Label speedLabel = new Label("Speed");
        Label TimesTableLabel= new Label("Enter the times table number from 1 to 360");
        TextField setTimesTable = new TextField();
        Label NumPointsLabel= new Label("Enter the number of points from 1 to 360");
        TextField setNumPoints = new TextField();

        MenuButton color = new MenuButton("Color");
        color.getItems().addAll(
                new MenuItem("Red"),
                new MenuItem("Orange"),
                new MenuItem("Yellow"),
                new MenuItem("Green"),
                new MenuItem("Blue"),
                new MenuItem("Indigo"),
                new MenuItem("Violet"),
                new MenuItem("Black"),
                new MenuItem("Lime"),
                new MenuItem("Pink")
        );

        speedSlider.setShowTickMarks(true);
        speedSlider.setShowTickLabels(true);
        speedSlider.setMajorTickUnit(1);

        gui.getChildren().addAll(speedLabel, speedSlider,TimesTableLabel, setTimesTable,
                NumPointsLabel, setNumPoints, color, startBtn, pauseBtn);

        root.setLeft(gui);

        stage.setScene(new Scene(root,600,400));
        stage.show();
    }
}
