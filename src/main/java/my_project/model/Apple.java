package my_project.model;

import KAGO_framework.view.DrawTool;
import my_project.Config;

public class Apple extends Fruit {

    public Apple(double x, double y){
        this.x = x;
        this.y = y;
        speed = 150;
        radius = 30;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(255,0,0,255);
        drawTool.drawFilledCircle(x,y,radius);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawCircle(x,y,radius);
    }

    @Override
    public void jumpBack(){
        y = -radius;
        x = Math.random()*(Config.WINDOW_WIDTH-80) + 50;
    }
}
