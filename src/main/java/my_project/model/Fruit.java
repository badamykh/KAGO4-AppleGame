package my_project.model;

import KAGO_framework.model.GraphicalObject;
import my_project.Config;

public abstract class Fruit extends GraphicalObject {
    public double speed;
    public void update(double dt) {
        y = y + speed*dt;
        if (y>= Config.WINDOW_HEIGHT - radius){
            jumpBack();
        }
    }
    public abstract void jumpBack();
}
