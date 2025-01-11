package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;

public class Pear extends GraphicalObject {

    //Attribute
    private double speed;

    public Pear(double x, double y){
        this.x = x;
        this.y = y;
        speed = 150;
        width = 25;
        height = 35;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(0,255,0,255);
        drawTool.drawFilledRectangle(x,y,width,height);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawRectangle(x,y,width,height);
    }

    @Override
    public void update(double dt) {
        y = y + speed*dt;
        if (y>=Config.WINDOW_HEIGHT - height){
            jumpBack();
        }
    }

    public void jumpBack(){
        y = -height;
        x = Math.random()*(Config.WINDOW_WIDTH-75) + 50;
    }
}

