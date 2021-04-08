package lab3;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.CheckBox;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.awt.*;

public class Main extends Application implements EventHandler<ActionEvent> {

    Button studentButton;
    Button teacherButton;

    Label studentLabel;
    Label teacherLabel;

    ObjectCreator objectCreator = new ObjectCreator();
    Font fontMare = Font.font("Verdana", 20);

    Pane layout = new Pane();
    Pane layoutStud = new Pane();
    Pane layoutTeacher = new Pane();

    javafx.scene.control.TextField TFStud;
    javafx.scene.control.TextField TFTeacher;

    @Override
    public void start(Stage primaryStage) throws Exception{
        studentButton =objectCreator.CreateButton(300,270,"Check");
        studentButton.setOnAction(this);

        teacherButton = objectCreator.CreateButton(300,470,"Check");
        teacherButton.setOnAction(this);

        studentLabel = objectCreator.CreateLabel(200,200,"Student Login",fontMare,Color.BLACK);
        teacherLabel = objectCreator.CreateLabel(200,400,"Teacher Login",fontMare,Color.BLACK);
        TFTeacher = new javafx.scene.control.TextField();
        TFStud = new javafx.scene.control.TextField();

        TFStud.setLayoutX(400);
        TFStud.setLayoutY(200);

        TFTeacher.setLayoutX(400);
        TFTeacher.setLayoutY(400);

        layout.getChildren().add(studentButton);
        layout.getChildren().add(teacherButton);
        layout.getChildren().add(TFTeacher);
        layout.getChildren().add(TFStud);
        layout.getChildren().add(teacherLabel);
        layout.getChildren().add(studentLabel);

        Scene scene = new Scene(layout,900,600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
            if(actionEvent.getSource() == studentButton){
                Pane layoutStud = new Pane();
                TextField tf1 = new TextField();
            }
    }
}
