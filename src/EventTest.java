import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class EventTest extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane pane = new GridPane();
        pane.setStyle("-fx-background-color: LightBlue");
        Scene scene = new Scene(pane,600,600, Color.BLACK);

        pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("pane clicked");
            }
        });

        HBox hbox = new HBox();
        hbox.setPrefWidth(300);
        hbox.setStyle("-fx-background-color: Pink");
        hbox.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("hbox clicked");
            }
        });


        Label label = new Label("label text");
        label.setStyle("-fx-background-color: LightGreen");
        label.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("label clicked first 1");
                //event.consume();

            }
        });

        label.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("label clicked - setOnMouseClicked ");
                //event.consume();
            }
        });

        label.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("label clicked first 2");
                //event.consume();
            }
        });

        //add an eventfilter (Capturring phase)
        label.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
                    public void handle(MouseEvent event) {
                        System.out.println("label filter invoked");
                    };
                });




        pane.add(hbox, 0,1);
        hbox.getChildren().addAll(label);



        primaryStage.setTitle("Event test");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
