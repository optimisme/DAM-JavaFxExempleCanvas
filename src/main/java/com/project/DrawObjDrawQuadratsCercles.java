package com.project;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.StrokeLineCap;

public class DrawObjDrawQuadratsCercles {
    
    public static void draw (GraphicsContext gc) {
        

        // 0
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(2);
        gc.setLineCap(StrokeLineCap.ROUND);

        gc.beginPath();
        gc.rect(50, 60, 40, 20); 
        gc.stroke();

        gc.beginPath();
        gc.strokeRoundRect(50, 110, 60, 30, 25, 25); 
        gc.stroke();
       
        String codi = """
            gc.setStroke(Color.BLUE);
            gc.setLineWidth(2);
            gc.setLineCap(StrokeLineCap.ROUND);
    
            gc.beginPath();
            gc.rect(50, 60, 40, 20); 
            // x, y, ample, alt
            gc.stroke();
    
            gc.beginPath();
            gc.strokeRoundRect(50, 110, 60, 30, 25, 25); 
            // x, y, ample, alt, curvaX, curvaY
            gc.stroke();
                """;
        ObjExemples.drawCodi(gc, codi, 150, 50);

        // 1
        gc.setFill(Color.ORANGE);
        gc.fillRect(50, 250, 40, 20); 
        gc.fill();

        gc.setFill(Color.PALEVIOLETRED);
        gc.fillRoundRect(50, 300, 30, 60, 25, 25); 
        gc.fill();
       
        codi = """
            gc.setFill(Color.ORANGE);
            gc.fillRect(50, 250, 40, 20); 
            gc.fill();
    
            gc.setFill(Color.PALEVIOLETRED);
            gc.fillRoundRect(50, 300, 30, 60, 25, 25); 
            gc.fill();
                """;
        ObjExemples.drawCodi(gc, codi, 150, 250);

        // 2
        gc.setStroke(Color.BLUE);
        gc.setFill(Color.MAGENTA);
        gc.setLineWidth(2);

        gc.beginPath();
        gc.fillOval(400, 60, 40, 20); 
        gc.strokeOval(400, 60, 40, 20);
        gc.stroke();
        gc.fill();

        codi = """
            gc.setStroke(Color.BLUE);
            gc.setFill(Color.MAGENTA);
            gc.setLineWidth(2);
    
            gc.beginPath();
            gc.fillOval(400, 60, 40, 20); 
            // x, y, ample, alt
            gc.strokeOval(400, 60, 40, 20);
            gc.stroke();
            gc.fill();
                """;
        ObjExemples.drawCodi(gc, codi, 450, 50);

        // 3
        gc.setStroke(Color.GREY);
        gc.setFill(Color.NAVY);
        gc.setLineWidth(5);

        gc.beginPath();
        gc.fillArc(370, 250, 60, 30, 0, 90, ArcType.ROUND);
        gc.strokeArc(370, 250, 60, 30, 0, 90, ArcType.ROUND);
        gc.stroke();
       
        codi = """
            gc.setStroke(Color.GREY);
            gc.setFill(Color.NAVY);
            gc.setLineWidth(5);
    
            gc.beginPath();
            gc.fillArc(370, 250, 60, 30, 0, 90, ArcType.ROUND);
            gc.strokeArc(370, 250, 60, 30, 0, 90, ArcType.ROUND);
            // x, y, w, h, startAngle, arcExtent, closure
            gc.stroke();
                """;
        ObjExemples.drawCodi(gc, codi, 450, 260);
    }
}