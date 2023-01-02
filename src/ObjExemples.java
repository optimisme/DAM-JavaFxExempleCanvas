
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.text.Font;

public class ObjExemples implements DrawingObj {

    // Animar
    public void run(Canvas cnv, double fps) {  }

    // Dibuixar el rellotge circular
    public void draw(GraphicsContext gc) {

        drawGrid(gc);

        switch (Main.selectedDrawing) {
            case "Linies":              ObjDrawLinies.draw(gc); break;
            case "Poligons":            ObjDrawPoligons.draw(gc); break;
            case "Poligons emplenats":   ObjDrawPoligonsEmplenats.draw(gc); break;
            case "Quadrats i cercles":  ObjDrawQuadratsCercles.draw(gc); break;
            case "Imatges":             ObjDrawImatges.draw(gc); break;
            case "Gradients lineals":   ObjDrawGradientsLineals.draw(gc); break;
            case "Gradients radials":   ObjDrawGradientsRadials.draw(gc); break;
            case "Transformacions":     ObjDrawTransformacions.draw(gc); break;
            case "Texts":               ObjDrawTexts.draw(gc); break;
            case "Text multilinia":     ObjDrawTextMultilinia.draw(gc); break;
        }
    }

    // Dibuixa una graella per saber la posición dels objectes
    private void drawGrid (GraphicsContext gc) {
        Canvas cnv = gc.getCanvas();
        double cnvHeight = cnv.heightProperty().doubleValue();
        double cnvWidth = cnv.widthProperty().doubleValue();

        gc.setFill(Color.BLACK);
        gc.save();
        gc.setFont(new Font("Arial", 12));
        gc.setLineCap(StrokeLineCap.BUTT);
        for (int x = 0; x < cnvWidth; x = x + 10) {
            if (x % 50 == 0) {
                gc.setStroke(Color.LIGHTGRAY);
                gc.setLineWidth(2);
                gc.strokeLine(x, 0, x, cnvHeight);
                gc.fillText("" + x, x, 10);
            } else {
                gc.setStroke(Color.LIGHTGRAY);
                gc.setLineWidth(1);
                gc.strokeLine(x, 0, x, cnvHeight);
            }
        }
        
        for (int y = 0; y < cnvHeight; y = y + 10) {
            if (y % 50 == 0) {
                gc.setStroke(Color.LIGHTGRAY);
                gc.setLineWidth(2);
                gc.strokeLine(0, y, cnvWidth, y);
                gc.fillText("" + y, 0, y + 10);
            } else {
                gc.setStroke(Color.LIGHTGRAY);
                gc.setLineWidth(1);
                gc.strokeLine(0, y, cnvWidth, y);
            }
        }
        gc.restore();
    }

    public static void drawCodi (GraphicsContext gc, String codi, double x, double y) {
        gc.save();
        gc.setFont(new Font("Arial", 12));
        gc.setFill(Color.BLACK);
        gc.fillText(codi, x, y);
        gc.restore();
    }
}
