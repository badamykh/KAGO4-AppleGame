package my_project.model;

import KAGO_framework.view.DrawTool;
import my_project.Config;

public class Pear extends Fruit {
    private double a;
    private double b;
    private double c;
    public Pear(double xpos, double y, double a, double b){
        c = xpos;
        this.y = y;
        speed = 150;
        width = 25;
        height = 35;
        this.a = a;
        this.b = b;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(255,191,0,255);
        drawTool.drawFilledRectangle(x,y,width,height);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawRectangle(x,y,width,height);
    }

    @Override
    public void jumpBack(){
        y = -height;
        c = Math.random()*(Config.WINDOW_HEIGHT-75) + 50;
        a = Math.random()*0.01;
        b = Math.random()*500;
    }

    public void update(double dt){
        super.update(dt);
        x = Math.sin(a*y)*b + c;
    }
}

