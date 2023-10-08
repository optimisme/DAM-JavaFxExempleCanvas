package com.project;

import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


public class DrawObjDrawTextMultilinia {

    public static WritableImage image = null;
    
    public static void draw (GraphicsContext gc) {

        String str = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";

        if (image == null) {

            double width = 600;

            Stop[] stops1 = new Stop[] { new Stop(0.2, Color.ORANGE), new Stop(0.5, Color.GREEN), new Stop(0.8, Color.BLUE)};
            LinearGradient lg1 = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops1);
            
            Text txt = new Text(str);
            txt.setFont(new Font("Verdana", 20));
            txt.setTextAlignment(TextAlignment.JUSTIFY);
            txt.setWrappingWidth(width);
            txt.setTextOrigin(VPos.TOP);
            txt.setFill(lg1);

            Group root = new Group();
            root.getChildren().add(txt);
                
            Scene scene = new Scene(root, width, txt.getLayoutBounds().getHeight());
            scene.setFill(Color.TRANSPARENT);

            image = scene.snapshot(null);
        }
        
        gc.drawImage(image, 50, 25, image.getWidth(), image.getHeight());

        String codi = """
            // Crea un node \"Text\" amb un ample màxim i mira l'alçada final 'height'
            // Dibuixa el text en una imatge que finalment pinta al canvas
            
            String str = \"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\";
            if (image == null) {
    
                double width = 600;
                Stop[] stops1 = new Stop[] { new Stop(0.2, Color.ORANGE), new Stop(0.5, Color.GREEN), new Stop(0.8, Color.BLUE)};
                LinearGradient lg1 = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops1);
                Text txt = new Text(str);
                txt.setFont(new Font(\"Verdana\", 20));
                txt.setTextAlignment(TextAlignment.JUSTIFY);
                txt.setWrappingWidth(width);
                txt.setTextOrigin(VPos.TOP);
                txt.setFill(lg1);
    
                Group root = new Group();
                root.getChildren().add(txt);
                Scene scene = new Scene(root, width, txt.getLayoutBounds().getHeight());
                scene.setFill(Color.TRANSPARENT);
                image = scene.snapshot(null);
            }
            
            gc.drawImage(image, 50, 25, image.getWidth(), image.getHeight());
                """;
                
        ObjExemples.drawCodi(gc, codi, 50, 125);
    }
}
