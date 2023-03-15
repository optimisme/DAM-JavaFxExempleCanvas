import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class Ctrl0 implements Initializable {

    @FXML
    private AnchorPane anchor;

    @FXML
    private ChoiceBox<String> choiceBox = new ChoiceBox<>();
    private String choiceBoxValues[] = { "Linies", "Poligons", "Poligons emplenats", 
        "Quadrats i cercles", "Imatges", "Gradients lineals", "Gradients radials", 
        "Transformacions", "Texts", "Text multilinia" };

    @FXML
    private Canvas canvas;

    @FXML
    private HBox hbox;

    public static Ctrl0Canvas drawing = new Ctrl0Canvas();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Initialize choiceBox values and action
        choiceBox.getItems().addAll(choiceBoxValues);
        choiceBox.setValue("Linies");
        choiceBox.setOnAction((event) -> {
            Object selectedItem = choiceBox.getSelectionModel().getSelectedItem();
            Main.selectedDrawing = (String) selectedItem;
        });

        // Initialize canvas responsive size
        UtilsViews.stage.heightProperty().addListener((observable, oldValue, newvalue) -> {
            updateCanvasSize();
        });
        UtilsViews.stage.widthProperty().addListener((observable, oldValue, newvalue) -> {
            updateCanvasSize();
        });
    }

    public void updateCanvasSize () {
        // Start Canvas size
        canvas.setWidth(UtilsViews.parentContainer.getWidth());
        canvas.setHeight(UtilsViews.parentContainer.getHeight() - hbox.getHeight());
    }

    public void drawingStart () {
        drawing.start(canvas);
    }

    public void drawingStop () {
        drawing.start(canvas);
    }

    public void keyEvent (KeyEvent evt) {

        // Quan apretem una tecla
        if (evt.getEventType() == KeyEvent.KEY_PRESSED) {
            if (evt.getCode() == KeyCode.UP) {
            }
        }

        // Quan deixem anar la tecla
        if (evt.getEventType() == KeyEvent.KEY_RELEASED) {

        }
    }
}