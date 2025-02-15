package my_project.model;

import KAGO_framework.view.DrawTool;

import java.awt.*;

public class PowerApple extends Apple {

    public double speedBuff = Math.random() + 1;

    public PowerApple(double x, double y){
        super(x,y);
        radius = 15;
    }

    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(76,187,23,255);
        drawTool.drawFilledCircle(x,y,radius);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawCircle(x,y,radius);
        drawTool.setCurrentColor(88,57,39,255);
        drawTool.drawFilledRectangle(x-0.125*radius,y-1.5*radius,0.25*radius,radius);
    }
}
