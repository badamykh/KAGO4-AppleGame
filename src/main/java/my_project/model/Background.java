package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;
import my_project.model.Player;

/**
 * Die Background-Klasse stellt die Umsetzung eines Objekts für den Hintergrund des Apple-Games dar.
 * Hier werden sogenannte Arrays (zu deutsch: Felder) verwendet, die im Unterricht noch nicht behandelt wurden.
 */

public class Background extends GraphicalObject {

    //Referenzen
    String chosenPhrase;
    String[] phrases = new String[]{"\"An apple a day keeps the doctor away!\" - Englisch",
            "\"Eat an apple on going to bed, and you’ll keep the doctor from earning his bread.\" - Walisische",
            "\"Ein Apfel am Tag, Arzt gespart!\" - Deutsch",
            "\"Una mela al giorno toglie il medico di torno.\" - Italienisch",
            "\"Jedna jabuka na dan, i doktor ti neće ući u stan.\" - Serbisch",
            "\"Günde bir elma Doktoru uzak tutar.\" - Türkisch",
            "\"Rojek sêvek doktor dûr dike\" - Kurdisch",
            "\"تفاحة على الريق تغنيك عن الطبيب\" - Arabisch"};

    private ProgramController program;
    private Player pl01;
    private Player pl02;

    public Background(ProgramController programController, Player player1, Player player2) {
        chosenPhrase = phrases[(int)(Math.random()*phrases.length)];
        program = programController;
        pl01 = player1;
        pl02 = player2;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(25, 100, 0, 255);
        drawTool.drawFilledRectangle(0, 0, 1600, 1024);
        drawTool.setCurrentColor(0, 0, 0, 255);
        drawTool.formatText("Arial", 1, 25);
        //drawTool.drawText(450,50,chosenPhrase);
        if (program.stand==1){
            drawTool.drawText(30, 100, "Spielstand:" + pl01.score);
            drawTool.drawText(800, 100, "Spielstand:" + pl02.score);
            if (program.pearCaught1) {
                drawTool.drawText(50, 50, "In der Not frisst der Teufel Birnen");
            }
            if (program.pearCaught2) {
                drawTool.drawText(560, 50, "In der Not frisst der Teufel Birnen");
            }

        } else if (program.stand==2){
            if (pl01.score>pl02.score){
                drawTool.drawText(350, 300, "Spieler 1 hat gewonnen!");
            } else if (pl01.score<pl02.score){
                drawTool.drawText(350, 300, "Spieler 2 hat gewonnen!");
            } else {
                drawTool.drawText(300, 300, "Die Freundschaft hat gewonnen!");
            }
        }


    }

    @Override
    public void update(double dt) {

    }

}