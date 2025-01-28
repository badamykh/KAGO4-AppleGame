package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.Config;
import my_project.model.Apple;
import my_project.model.PowerApple;
import my_project.model.Pear;
import my_project.model.Plum;
import my_project.model.Player;
import KAGO_framework.model.*;


/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern. Die updateProgram - Methode wird
 * mit jeder Frame im laufenden Programm aufgerufen.
 */
public class ProgramController {

    //Attribute


    // Referenzen
    private ViewController viewController;  // diese Referenz soll auf ein Objekt der Klasse viewController zeigen. Über dieses Objekt wird das Fenster gesteuert.

    private Apple apple01;
    private Apple apple02;
    private Apple apple03;

    private PowerApple pow01;

    private Pear pear01;
    private Pear pear02;
    private Pear pear03;
    private Pear pear04;

    private Plum plum01;
    private Player player01;

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
        pow01 = new PowerApple(xPos, yPos);
        viewController.draw(pow01);


        xPos = Math.random()*(Config.WINDOW_WIDTH-75) + 50;
        yPos = Math.random()*(Config.WINDOW_HEIGHT-85) + 50;
        pear01 = new Pear(xPos, yPos);
        viewController.draw(pear01);

        xPos = Math.random()*(Config.WINDOW_WIDTH-75) + 50;
        yPos = Math.random()*(Config.WINDOW_HEIGHT-85) + 50;
        pear02 = new Pear(xPos, yPos);
        viewController.draw(pear02);

        xPos = Math.random()*(Config.WINDOW_WIDTH-75) + 50;
        yPos = Math.random()*(Config.WINDOW_HEIGHT-85) + 50;
        pear03 = new Pear(xPos, yPos);
        viewController.draw(pear03);

        xPos = Math.random()*(Config.WINDOW_WIDTH-75) + 50;
        yPos = Math.random()*(Config.WINDOW_HEIGHT-85) + 50;
        pear04 = new Pear(xPos, yPos);
        viewController.draw(pear04);


        xPos = Math.random()*(Config.WINDOW_WIDTH-80) + 50;
        yPos = Math.random()*(Config.WINDOW_HEIGHT-80) + 50;
        plum01 = new Plum(xPos, yPos);
        viewController.draw(plum01);

        player01 = new Player(50, Config.WINDOW_HEIGHT-100);
        viewController.draw(player01);
        viewController.register(player01);
    }

    public void updateProgram(double dt){
        if (checkAndHandleCollision(apple01)){
            apple01.jumpBack();
        }
        if (checkAndHandleCollision(apple02)){
            apple02.jumpBack();
        }
        if (checkAndHandleCollision(apple03)){
            apple03.jumpBack();
        }
        if (checkAndHandleCollision(pow01)){
            pow01.jumpBack();
            player01.speed *= pow01.speedBuff;
            pow01.speedBuff = Math.random() + 1;
        }


        if (checkAndHandleCollision(pear01)){
            pear01.jumpBack();
        }
        if (checkAndHandleCollision(pear02)){
            pear02.jumpBack();
        }
        if (checkAndHandleCollision(pear03)){
            pear03.jumpBack();
        }
        if (checkAndHandleCollision(pear04)){
            pear04.jumpBack();
        }


        if (checkAndHandleCollision(plum01)){
            plum01.jumpBack();
        }
        //Weitere TODOs folgen und werden im Unterricht formuliert. Spätestens nach TODO 08 sollte der Aufbau des Projekts durchdacht werden.
    }

    public boolean checkAndHandleCollision(GraphicalObject gO){
        if (gO.collidesWith(player01)){
            return true;
        }else{
            return false;
        }
    }

}
