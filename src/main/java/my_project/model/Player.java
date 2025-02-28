package my_project.model;

import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;

import java.awt.event.KeyEvent;

public class Player extends InteractiveGraphicalObject {


    //Attribute
    public double speed;

    //Tastennummern zur Steuerung
    private int keyToGoLeft;
    private int keyToGoRight;
    private int keyToGoUp;
    private int keyToGoDown;
    private int direction;

    public int score;
    private double min;
    private double max;

    public Player(double x, double y, double minima, double maxima, int iden){
        this.x = x;
        this.y = y;
        speed = 150;
        width = 80;
        height = 40;
        score = 0;
        min = minima;
        max = maxima;

        if (iden==1){
            this.keyToGoLeft    = KeyEvent.VK_A;
            this.keyToGoRight   = KeyEvent.VK_D;
            this.keyToGoUp    = KeyEvent.VK_W;
            this.keyToGoDown  = KeyEvent.VK_S;
        }
        if (iden==2){
            this.keyToGoLeft    = KeyEvent.VK_J;
            this.keyToGoRight   = KeyEvent.VK_L;
            this.keyToGoUp    = KeyEvent.VK_I;
            this.keyToGoDown  = KeyEvent.VK_K;
        }
        this.direction      = -1; //-1 keine Bewegung, 0 nach rechts, 2 nach links
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(157,152,3,255);
        drawTool.drawFilledRectangle(x,y,width,height);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawRectangle(x,y,width,height);
    }

    @Override
    public void update(double dt) {
        if(direction == 0){
            x = x + speed*dt;
            if (x>max){
                direction = -1;
                x = max;
            }
        }
        if(direction == 2){
            x = x - speed*dt;
            if (x<min){
                direction = -1;
                x = min;
            }
        }
        if(direction == 1){
            y = y - speed*dt;
            if (y<Config.WINDOW_HEIGHT-320){
                direction = -1;
                y = Config.WINDOW_HEIGHT-320;
            }
        }
        if(direction == 3){
            y = y + speed*dt;
            if (y>Config.WINDOW_HEIGHT){
                direction = -1;
                y = Config.WINDOW_HEIGHT;
            }
        }
    }

    @Override
    public void keyPressed(int key) {
        if(key == keyToGoLeft){
            direction = 2;
        }
        if(key == keyToGoRight){
            direction = 0;
        }
        if(key == keyToGoUp){
            direction = 1;
        }
        if(key == keyToGoDown){
            direction = 3;
        }
    }

    @Override
    public void keyReleased(int key) {
        if(key == keyToGoLeft){
            direction = -1;
        }
        if(key == keyToGoRight){
            direction = -1;
        }
        if(key == keyToGoUp){
            direction = -1;
        }
        if(key == keyToGoDown){
            direction = -1;
        }
    }
}
