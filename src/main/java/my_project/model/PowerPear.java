package my_project.model;

import KAGO_framework.view.DrawTool;

import java.awt.*;

public class PowerPear extends Pear {

    public double speedDeBuff = Math.random();

    public PowerPear(double xpos, double y, double a, double b){
        super(xpos, y, a, b);
    }

    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(137,181,89,255);
        drawTool.drawFilledRectangle(x,y,width,height);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawRectangle(x,y,width,height);
        drawTool.setCurrentColor(88,57,39,255);
        drawTool.drawFilledRectangle(x+0.375*width,y-0.25*height,0.25*width,0.5*height);
    }
}
