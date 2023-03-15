
import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ctrl0Canvas {

    long[] frameTimes = new long[120];
  
    private Canvas cnv;
    private GraphicsContext gc;
    private AnimationTimer animationTimer;

    public static ArrayList<UtilsDrawingObj> drawingList = new ArrayList<>();
    public static ObjExemples dibuixExemples = new ObjExemples();

    public Ctrl0Canvas () { }

    // Iniciar el context i bucle de dibuix
    public void start (Canvas canvas) {

        cnv = canvas;

        // Definir contexte de dibuix
        gc = canvas.getGraphicsContext2D();

        // Init drawing bucle
        animationTimer = new UtilsFps(this::run, this::draw);
        animationTimer.start();

        // Crear objectes
        drawingList.add(dibuixExemples);

        // Iniciar el bucle de dibuix
        animationTimer.start();

    }

    // Aturar el bucle de dibuix
    public void stop () {
        animationTimer.stop();
    }

    // Animar
    private void run(double fps) {

        // Animar elements
        for (UtilsDrawingObj obj : drawingList) {
            obj.run(cnv, fps);
        }
    }

    // Dibuixar
    private void draw() {
        // Netejar l'area de dibuix
        gc.clearRect(0, 0, cnv.getWidth(), cnv.getHeight());

        // Dibuixar elements
        for (UtilsDrawingObj obj : drawingList) {
            obj.draw(gc);
        }

        // Dibuixar un marc a l'area de dibuix
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);
        gc.strokeRect(0, 0, cnv.getWidth(), cnv.getHeight());
    }
}