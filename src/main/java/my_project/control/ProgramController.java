package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.Config;
import my_project.model.*;
import KAGO_framework.model.*;


/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern. Die updateProgram - Methode wird
 * mit jeder Frame im laufenden Programm aufgerufen.
 */
public class ProgramController {

    //Attribute


    // Referenzen
    private ViewController viewController;  // diese Referenz soll auf ein Objekt der Klasse viewController zeigen. Über dieses Objekt wird das Fenster gesteuert.

    private Background background;

    private Apple apple01;
    private Apple apple02;
    private Apple apple03;

    private PowerApple powa01;

    private Pear pear01;
    private Pear pear02;
    private Pear pear03;

    private PowerPear powp01;

    private Plum plum01;
    private Player player01;
    private boolean collided1;
    private Player player02;
    private boolean collided2;

    private int number;

    public boolean pearCaught1;
    public boolean pearCaught2;

    public int stand = 1;
    private double time = 0;

    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse viewController. Diese wird als Parameter übergeben.
     * @param viewController das viewController-Objekt des Programms
     */
    public ProgramController(ViewController viewController){
        this.viewController = viewController;
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen.
     * Sie erstellt die leeren Datenstrukturen, zu Beginn nur eine Queue
     */
    public void startProgram() {
        player01 = new Player(50, Config.WINDOW_HEIGHT-320,0, 0.5*(Config.WINDOW_WIDTH-18)-80, 1);

        player02 = new Player(0.5*(Config.WINDOW_WIDTH-18)+50, Config.WINDOW_HEIGHT-320, 0.5*(Config.WINDOW_WIDTH-18), Config.WINDOW_WIDTH-98, 2);

        background = new Background(this, player01, player02);
        viewController.draw(background);

        viewController.draw(player01);
        viewController.register(player01);

        viewController.draw(player02);
        viewController.register(player02);

        double xPos = Math.random()*(Config.WINDOW_WIDTH-80) + 50;
        double yPos = Math.random()*(Config.WINDOW_HEIGHT-80) + 50;
        apple01 = new Apple(xPos, yPos);
        viewController.draw(apple01);

        xPos = Math.random()*(Config.WINDOW_WIDTH-80) + 50;
        yPos = Math.random()*(Config.WINDOW_HEIGHT-80) + 50;
        apple02 = new Apple(xPos, yPos);
        viewController.draw(apple02);

        xPos = Math.random()*(Config.WINDOW_WIDTH-80) + 50;
        yPos = Math.random()*(Config.WINDOW_HEIGHT-80) + 50;
        apple03 = new Apple(xPos, yPos);
        viewController.draw(apple03);

        xPos = Math.random()*(Config.WINDOW_WIDTH-80) + 50;
        yPos = Math.random()*(Config.WINDOW_HEIGHT-80) + 50;
        powa01 = new PowerApple(xPos, yPos);
        viewController.draw(powa01);


        xPos = Math.random()*(Config.WINDOW_WIDTH-75) + 50;
        yPos = Math.random()*(Config.WINDOW_HEIGHT-85) + 50;
        double periode = Math.random()*0.01;
        double ampl = Math.random()*(Config.WINDOW_HEIGHT-xPos);
        pear01 = new Pear(xPos, yPos, periode, ampl);
        viewController.draw(pear01);

        xPos = Math.random()*(Config.WINDOW_WIDTH-75) + 50;
        yPos = Math.random()*(Config.WINDOW_HEIGHT-85) + 50;
        periode = Math.random()*0.01;
        ampl = Math.random()*(Config.WINDOW_HEIGHT-xPos);
        pear02 = new Pear(xPos, yPos, periode, ampl);
        viewController.draw(pear02);

        xPos = Math.random()*(Config.WINDOW_WIDTH-75) + 50;
        yPos = Math.random()*(Config.WINDOW_HEIGHT-85) + 50;
        periode = Math.random()*0.01;
        ampl = Math.random()*(Config.WINDOW_HEIGHT-xPos);
        pear03 = new Pear(xPos, yPos, periode, ampl);
        viewController.draw(pear03);

        xPos = Math.random()*(Config.WINDOW_WIDTH-75) + 50;
        yPos = Math.random()*(Config.WINDOW_HEIGHT-85) + 50;
        periode = Math.random()*0.01;
        ampl = Math.random()*(Config.WINDOW_HEIGHT-xPos);
        powp01 = new PowerPear(xPos, yPos, periode, ampl);
        viewController.draw(powp01);


        xPos = Math.random()*(Config.WINDOW_WIDTH-80) + 50;
        yPos = Math.random()*(Config.WINDOW_HEIGHT-80) + 50;
        plum01 = new Plum(xPos, yPos);
        viewController.draw(plum01);


    }

    public void updateProgram(double dt){
        time = time + dt;
        if (time<30){
            stand = 1;
        } else {
            stand = 2;
            apple01.speed = 0;
            apple02.speed = 0;
            apple03.speed = 0;
            pear01.speed = 0;
            pear02.speed = 0;
            pear03.speed = 0;
            powa01.speed = 0;
            powp01.speed = 0;
            plum01.speed = 0;
            player01.speed = 0;
            player02.speed = 0;

        }

        if (checkAndHandleCollision(apple01)){
            apple01.jumpBack();
        }
        if (checkAndHandleCollision(apple02)){
            apple02.jumpBack();
        }
        if (checkAndHandleCollision(apple03)){
            apple03.jumpBack();
        }
        if (checkAndHandleCollision(powa01)){
            powa01.jumpBack();
            if (number == 1){
                player01.speed *= powa01.speedBuff;
            }
            if (number == 2){
                player02.speed *= powa01.speedBuff;
            }
            powa01.speedBuff = Math.random() + 1;
        }


        if (checkAndHandleCollision(pear01)){
            pear01.jumpBack();
            if (number == 1){
                pearCaught1 = true;
            }
            if (number == 2){
                pearCaught2 = true;
            }
        }
        if (checkAndHandleCollision(pear02)){
            pear02.jumpBack();
            if (number == 1){
                pearCaught1 = true;
            }
            if (number == 2){
                pearCaught2 = true;
            }
        }
        if (checkAndHandleCollision(pear03)){
            pear03.jumpBack();
            if (number == 1){
                pearCaught1 = true;
            }
            if (number == 2){
                pearCaught2 = true;
            }
        }
        if (checkAndHandleCollision(powp01)){
            powp01.jumpBack();
            if (number == 1){
                player01.speed *= powp01.speedDeBuff;
                pearCaught1 = true;
            }
            if (number == 2){
                player02.speed *= powp01.speedDeBuff;
                pearCaught2 = true;
            }
            powp01.speedDeBuff = Math.random();
        }


        if (checkAndHandleCollision(plum01)){
            plum01.jumpBack();
        }
        //Weitere TODOs folgen und werden im Unterricht formuliert. Spätestens nach TODO 08 sollte der Aufbau des Projekts durchdacht werden.
    }

    public boolean checkAndHandleCollision(GraphicalObject gO){
        collided1 = false;
        collided2 = false;
        if (gO.collidesWith(player01)) {
            number = 1;
            player01.score += 1;
            collided1 = true;
            if (gO != pear01 && gO != pear02 && gO != pear03 && gO != powp01){
                pearCaught1 = false;
            }
        }

        if (gO.collidesWith(player02)){
            number = 2;
            player02.score += 1;
            collided2 = true;
            if (gO != pear01 && gO != pear02 && gO != pear03 && gO != powp01){
                pearCaught2 = false;
            }
        }
        return collided1 || collided2;
    }

}
