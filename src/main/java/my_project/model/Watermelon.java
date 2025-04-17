package my_project.model;

import KAGO_framework.view.DrawTool;
import my_project.Config;

public class Watermelon extends Fruit{

    public Watermelon(double x, double y){
        this.x = x;
        this.y = y;
        speed = 150;
        radius = 40;
    }

    public void draw(DrawTool drawTool){
        drawTool.setCurrentColor(56,185,28,255);
        drawTool.drawFilledArc(x-radius,y-radius,2*radius,0,-180,1);
        drawTool.setCurrentColor(255,102,102,255);
        drawTool.drawFilledArc(x-0.85*radius,y-0.85*radius,1.7*radius,0,-180,1);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawArc(x-radius,y-radius,2*radius,0,-180,1);

        drawTool.drawFilledCircle(x-0.6*radius,y+0.2*radius,radius*0.05);
        drawTool.drawFilledCircle(x-0.3*radius,y+0.2*radius,radius*0.05);
        drawTool.drawFilledCircle(x,y+0.23*radius,radius*0.05);
        drawTool.drawFilledCircle(x+0.3*radius,y+0.2*radius,radius*0.05);
        drawTool.drawFilledCircle(x+0.6*radius,y+0.2*radius,radius*0.05);

        drawTool.drawFilledCircle(x-0.45*radius,y+0.4*radius,radius*0.05);
        drawTool.drawFilledCircle(x-0.15*radius,y+0.4*radius,radius*0.05);
        drawTool.drawFilledCircle(x+0.15*radius,y+0.4*radius,radius*0.05);
        drawTool.drawFilledCircle(x+0.45*radius,y+0.4*radius,radius*0.05);

        drawTool.drawFilledCircle(x-0.3*radius,y+0.6*radius,radius*0.05);
        drawTool.drawFilledCircle(x,y+0.63*radius,radius*0.05);
        drawTool.drawFilledCircle(x+0.3*radius,y+0.6*radius,radius*0.05);

    }

    public void jumpBack(){
        y = -radius-10;
        x = Math.random()*(Config.WINDOW_WIDTH-80) + 70;
    }
}
