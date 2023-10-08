package com.project;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;

public class DrawObjDrawPoligonsEmplenats {
    
    public static void draw (GraphicsContext gc) {
        

        // 0
        gc.setStroke(Color.ORANGE);
        gc.setFill(Color.GREEN);
        gc.setLineWidth(8);
        gc.setLineCap(StrokeLineCap.ROUND);

        gc.beginPath();
        gc.moveTo(50, 60);
        gc.lineTo(100, 75);
        gc.lineTo(75, 100);
        gc.lineTo(50, 75);
        gc.fill();
        gc.stroke();
       
        String codi = """
            gc.setStroke(Color.ORANGE);
            gc.setFill(Color.GREEN);
            gc.setLineWidth(8);
            gc.setLineCap(StrokeLineCap.ROUND);
    
            gc.beginPath();
            gc.moveTo(50, 60);
            gc.lineTo(100, 75);
            gc.lineTo(75, 100);
            gc.lineTo(50, 75);
            gc.fill();
            gc.stroke();
            // El relleu (stroke) queda per sobre de l'emplenat (fill)
                """;
        ObjExemples.drawCodi(gc, codi, 150, 50);

        // 1
        gc.setStroke(Color.GREEN);
        gc.setFill(Color.ORANGE);
        gc.setLineWidth(8);
        gc.setLineCap(StrokeLineCap.ROUND);

        gc.beginPath();
        gc.moveTo(50, 260);
        gc.lineTo(100, 275);
        gc.lineTo(100, 300);
        gc.lineTo(50, 275);
        gc.stroke();
        gc.fill();
       
        codi = """
            gc.setStroke(Color.GREEN);
            gc.setFill(Color.ORANGE);
            gc.setLineWidth(8);
            gc.setLineCap(StrokeLineCap.ROUND);
    
            gc.beginPath();
            gc.moveTo(50, 260);
            gc.lineTo(100, 275);
            gc.lineTo(100, 300);
            gc.lineTo(50, 275);
            gc.stroke();
            gc.fill();
            // L'emplenat (fill) queda per sobre del relleu (stroke)
                """;
        ObjExemples.drawCodi(gc, codi, 150, 250);

        // 2
        gc.setFill(Color.RED);

        gc.beginPath();
        gc.moveTo(400, 60);
        gc.lineTo(440, 70);
        gc.lineTo(420, 100);
        gc.lineTo(410, 90);
        gc.fill();


       
        codi = """
            gc.setFill(Color.RED);

            gc.beginPath();
            gc.moveTo(400, 60);
            gc.lineTo(440, 70);
            gc.lineTo(420, 100);
            gc.lineTo(410, 90);
            gc.fill();
                """;
        ObjExemples.drawCodi(gc, codi, 450, 50);

        // 3
        gc.setFill(Color.RED);
        gc.beginPath();
        gc.moveTo(400, 250);
        gc.lineTo(440, 290);
        gc.lineTo(390, 280);
        gc.fill();

        gc.setFill(new Color(0.5, 1, 0.5, 0.5));
        // Red, Green, Blue, Opacity (alpha)
        gc.beginPath();
        gc.moveTo(400, 260);
        gc.lineTo(440, 300);
        gc.lineTo(390, 290);
        gc.fill();
       
        codi = """
            gc.setFill(Color.BURLYWOOD);
            gc.beginPath();
            gc.moveTo(400, 250);
            gc.lineTo(440, 290);
            gc.lineTo(390, 280);
            gc.fill();
    
            gc.setFill(new Color(128, 256, 128, 0.5));
            gc.beginPath();
            gc.moveTo(400, 270);
            gc.lineTo(440, 300);
            gc.lineTo(390, 300);
            gc.fill();

            // El 'fill' queda per sota del relleu
                """;
        ObjExemples.drawCodi(gc, codi, 450, 250);
    }
}