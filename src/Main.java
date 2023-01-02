
import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
public class Main extends Application {

    private Drawing drawing = new Drawing();
    public static ArrayList<DrawingObj> drawingList = new ArrayList<>();

    public static String selectedDrawing = "Linies";
    public static ObjExemples dibuixExemples = new ObjExemples();

    public static void main(String[] args) {
 
        // Crear objectes
        drawingList.add(dibuixExemples);

        // Iniciar app JavaFX   
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {

        int windowHeight = 500;
        int windowWidth = 750;

        // Construir interficie
        VBox root = buildInterface(primaryStage);

        // Definir escena
        Scene  scene = new Scene(root);
        scene.addEventFilter(KeyEvent.ANY, keyEvent -> { keyEvent(keyEvent); });

        // Iniciar finestra d'app
        primaryStage.setTitle("Exemples Canvas");
        primaryStage.onCloseRequestProperty();
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(true);
        primaryStage.setHeight(windowHeight);
        primaryStage.setWidth(windowWidth);
        primaryStage.setMinHeight(windowHeight);
        primaryStage.setMinWidth(windowWidth);
        primaryStage.heightProperty().addListener((observable, oldValue, newvalue) -> {
            double titleHeight = primaryStage.getHeight() - scene.getHeight();
            double rootHeight = primaryStage.getHeight() - titleHeight;
            root.setPrefHeight(rootHeight);
        });

        // Definir icona d'app
        Image icon = new Image("file:./assets/icon.png");
        primaryStage.getIcons().add(icon);
    }

    @Override
    public void stop() {
        // Aturar el bucle de dibuix
        drawing.stop(); 
    }

    public VBox buildInterface(Stage primaryStage) {

        // Definir la divisió vertical
        VBox vbox = new VBox(0);
        vbox.setAlignment(Pos.TOP_CENTER);

            // Definir el selector superior
            HBox hbox = new HBox(0);
            hbox.setAlignment(Pos.CENTER);
            
                Label text = new Label("Dibuix: ");
                text.setMaxWidth(Double.MAX_VALUE);
                text.setAlignment(Pos.CENTER_RIGHT);

                ComboBox<String> comboBox = new ComboBox<String>();
                comboBox.getItems().add("Linies");
                comboBox.getItems().add("Poligons");
                comboBox.getItems().add("Poligons emplenats");
                comboBox.getItems().add("Quadrats i cercles");
                comboBox.getItems().add("Imatges");
                comboBox.getItems().add("Gradients lineals");
                comboBox.getItems().add("Gradients radials");
                comboBox.getItems().add("Transformacions");
                comboBox.getItems().add("Texts");
                comboBox.getItems().add("Text multilinia");
                comboBox.getSelectionModel().select(0);
                comboBox.setOnAction((event) -> {
                    Object selectedItem = comboBox.getSelectionModel().getSelectedItem();
                    selectedDrawing = (String) selectedItem;
                });

                hbox.getChildren().addAll(text, comboBox);
                HBox.setHgrow(text, Priority.ALWAYS);
                HBox.setHgrow(comboBox, Priority.NEVER);

            // Definir l'area de dibuix
            Canvas canvas = new Canvas(100, 100);
            drawing.start(canvas);
            canvas.widthProperty().bind(vbox.widthProperty());
            vbox.heightProperty().addListener((observable, oldValue, newvalue) -> {
                double canvasHeight = vbox.getHeight() - hbox.getHeight();
                canvas.setHeight(canvasHeight);
            });

            
        vbox.getChildren().addAll(hbox, canvas);
        VBox.setVgrow(hbox, Priority.NEVER);
        VBox.setVgrow(canvas, Priority.ALWAYS);

        return vbox;
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