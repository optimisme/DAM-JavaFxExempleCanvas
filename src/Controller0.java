import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class Controller0 implements Initializable {

    @FXML
    private AnchorPane anchor;

    @FXML
    private ChoiceBox<String> choiceBox = new ChoiceBox<>();
    private String choiceBoxValues[] = { "Linies", "Poligons", "Poligons emplenats", 
        "Quadrats i cercles", "Imatges", "Gradients lineals", "Gradients radials", 
        "Transformacions", "Texts", "Text multilinia" };

    @FXML
    private HBox hbox;

    @FXML
    private Canvas canvas;

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

        // Start drawing loop
        Main.drawing.start(canvas);
        updateCanvasSize();
    }

    public void updateCanvasSize () {
        // Start Canvas size
        canvas.setWidth(UtilsViews.parentContainer.getWidth());
        canvas.setHeight(UtilsViews.parentContainer.getHeight() - hbox.getHeight());
    }
}