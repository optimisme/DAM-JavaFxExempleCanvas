
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;

public class ObjDrawLinies {
    
    public static void draw (GraphicsContext gc) {

        // 0
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(2);
        gc.setLineCap(StrokeLineCap.ROUND);

        gc.strokeLine(50, 60, 100, 75);
       
        String codi = """
            gc.setStroke(Color.BLUE);
            gc.setLineWidth(2);
            gc.setLineCap(StrokeLineCap.ROUND);
    
            gc.strokeLine(50, 60, 100, 75);
                """;
        ObjExemples.drawCodi(gc, codi, 150, 50);

        // 1
        gc.setStroke(Color.GREEN);
        gc.setLineWidth(2);
        gc.setLineCap(StrokeLineCap.ROUND);

        gc.strokeLine(50, 260, 100, 275);
        gc.strokeLine(100, 275, 125, 300);
        gc.strokeLine(125, 300, 75, 300);
        gc.strokeLine(75, 300, 100, 325);
     
        codi = """
            gc.setStroke(Color.GREEN);
            gc.setLineWidth(2);
            gc.setLineCap(StrokeLineCap.ROUND);
    
            gc.strokeLine(50, 260, 100, 275);
            gc.strokeLine(100, 275, 125, 300);
            gc.strokeLine(125, 300, 75, 300);
            gc.strokeLine(75, 300, 100, 325);
                """;
        ObjExemples.drawCodi(gc, codi, 150, 250);

        // 2
        gc.setStroke(Color.RED);
        gc.setLineWidth(10);
        gc.setLineCap(StrokeLineCap.SQUARE);

        gc.strokeLine(400, 50, 430, 80);
       
        codi = """
            gc.setStroke(Color.RED);
            gc.setLineWidth(10);
            gc.setLineCap(StrokeLineCap.SQUARE);
            
            // Limits de linia quadrats
    
            gc.strokeLine(400, 50, 430, 80);
                """;
        ObjExemples.drawCodi(gc, codi, 450, 50);

        // 3
        gc.setStroke(Color.PURPLE);
        gc.setLineWidth(10);
        gc.setLineCap(StrokeLineCap.ROUND);

        gc.strokeLine(400, 250, 430, 280);
       
        codi = """
            gc.setStroke(Color.PURPLE);
            gc.setLineWidth(10);
            gc.setLineCap(StrokeLineCap.ROUND);

            // Limits de linia arrodonits
    
            gc.strokeLine(400, 250, 430, 280);
                """;
        ObjExemples.drawCodi(gc, codi, 450, 250);
    }
}
