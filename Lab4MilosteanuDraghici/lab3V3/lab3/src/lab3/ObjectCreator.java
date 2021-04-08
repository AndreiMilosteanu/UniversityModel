package lab3;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ObjectCreator {


    public ObjectCreator() {
    }

    public Button CreateButton(int x, int y, String text){
        Button button = new Button(text);
        button.setPrefSize(65,30);
        button.setLayoutX(x);
        button.setLayoutY(y);

        return button;
    }

    public Label CreateLabel(int x, int y, String text, Font font, Color color){
        Label label = new Label();
        label.setLayoutX(x);
        label.setLayoutY(y);
        label.setText(text);
        label.setFont(font);
        label.setTextFill(color);

        return label;
    }

    public CheckBox CreateCheckBox(int x, int y, String text){
        CheckBox checkBox = new CheckBox();
        checkBox.setLayoutX(x);
        checkBox.setLayoutY(y);
        checkBox.setText(text);
        checkBox.setFont(Font.font("Verdana",12));
        checkBox.setTextFill(Color.BLACK);

        return checkBox;
    }

}
