package com.project;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

interface UtilsDrawingObj {
    public void run(Canvas cnv, double fps);
    public void draw(GraphicsContext gc);
}
