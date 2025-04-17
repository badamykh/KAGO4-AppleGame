package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;

import java.awt.event.KeyEvent;

public class ScoreNerf extends InteractiveGraphicalObject {

    private Player pl;

    public double speed = 300;
    private int richtung;
    public boolean InBounds = true;
    private int index;

    public ScoreNerf(double x, double y, int num){
        this.x = x;
        this.y = y;
        radius = 15;
        index = num;
        if(index == 1){
            richtung = 1;
        }
        if(index == 2){
            richtung = -1;
        }
    }

    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(255,255,255,255);
        drawTool.drawFilledCircle(x,y,radius);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawCircle(x,y,radius);
    }

    public void update(double dt) {
        if(pl != null){
            this.x = pl.getX();
            this.y = pl.getY();
        } else {
            this.x += richtung * speed * dt;
            if (index == 1 && x > Config.WINDOW_WIDTH) {
                speed = 0;
                this.x = -100;
            }
            if (index == 2 && x < 0) {
                speed = 0;
                x = -100;
            }
        }

    }

    public void setPlayer(Player p) {
        this.pl = p;
    }

    public void detach() {
        this.pl = null;
    }



}
