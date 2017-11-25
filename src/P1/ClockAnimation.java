package P1;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ClockAnimation extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		BorderPane pane = new BorderPane();
		
		ClockPane clock = new ClockPane();
		
//		TextField text = new TextField();
		Label label = new Label();
		EventHandler<ActionEvent> eventHandler = e -> {
			label.setText(clock.setCurrentTime());
		};
		
		Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000),eventHandler));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
		
		pane.setCenter(clock);
		pane.setBottom(label);
		BorderPane.setAlignment(label, Pos.TOP_CENTER);
		
		Scene scene = new Scene(pane,260,270);
		primaryStage.setTitle("ClockAnimation");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
