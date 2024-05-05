package at.tea.games.firstgame;

import org.newdawn.slick.*;

public class Rectangles extends BasicGame {

    // Enum für die Richtungen der Formen
    public enum DIRECTION {RIGHT, DOWN, LEFT, UP}

    // Rechteck
    private float xRect;
    private float yRect;
    private DIRECTION rectDirection = DIRECTION.RIGHT; // Die Richtung, in die das Rechteck sich bewegt
    private float speedRect; // Geschwindigkeit des Rechtecks

    // Oval
    private float xOv;
    private float yOv;
    private DIRECTION ovDirection = DIRECTION.RIGHT; // Die Richtung, in die das Oval sich bewegt
    private float speedOv; // Geschwindigkeit des Ovals

    //Kreis
    private float xCir;
    private float yCir;
    private DIRECTION cirDirection = DIRECTION.DOWN; // Die Richtung, in die der Kreis sich bewegt
    private float speedCir; // Geschwindigkeit des Kreises


    public Rectangles(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        // Startposition und Geschwindigkeit für jedes Objekt festlegen
        this.xRect = 150;
        this.yRect = 150;
        this.speedRect = 3.0f;

        this.xOv = 100;
        this.yOv = 100;
        this.speedOv = 3.0f;

        this.xCir = 50;
        this.yCir = 100;
        this.speedCir = 3.0f;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        // Bewegung des Rechtecks

        if (rectDirection == DIRECTION.RIGHT) {
            this.xRect += (float) delta / speedRect;
        /*Überprüft, ob die Form die Grenze (oben, unten, links, rechts)
        des Bildschirms überschreitet. Wenn ja, ändert die Bewegungsrichtung der Form
        entsprechend,um sie in die entgegengesetzte Richtung zu bewegen.*/
            if (this.xRect > 550) {
                this.rectDirection = DIRECTION.DOWN;
            }
        } else if (rectDirection == DIRECTION.DOWN) {
            this.yRect += (float) delta / speedRect;
            if (this.yRect > 400) {
                this.rectDirection = DIRECTION.LEFT;
            }
        } else if (rectDirection == DIRECTION.LEFT) {
            this.xRect -= (float) delta / speedRect;
            if (this.xRect < 120) {
                this.rectDirection = DIRECTION.UP;
            }
        } else if (rectDirection == DIRECTION.UP) {
            this.yRect -= (float) delta / speedRect;
            if (this.yRect < 150) {
                this.rectDirection = DIRECTION.RIGHT;
            }
        }

        // Bewegung des Ovals
        if (ovDirection == DIRECTION.RIGHT) {
            this.xOv += (float) delta / speedOv;
            if (this.xOv > 650) {
                this.ovDirection = DIRECTION.LEFT;
            }
        } else if (ovDirection == DIRECTION.LEFT) {
            this.xOv -= (float) delta / speedOv;
            if (this.xOv < 50) {
                this.ovDirection = DIRECTION.RIGHT;
            }
        }

        // Bewegung des Kreises
        if (cirDirection == DIRECTION.DOWN) {
            this.yCir += (float) delta / speedCir;
            if (this.yCir > 520) {
                this.cirDirection = DIRECTION.UP;
            }
        } else if (cirDirection == DIRECTION.UP) {
            this.yCir -= (float) delta / speedCir;
            if (this.yCir < 100) {
                this.cirDirection = DIRECTION.DOWN;
            }
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawRect(this.xRect, this.yRect, 100, 100); // Rechteck zeichnen
        graphics.drawOval(this.xOv, this.yOv, 50, 25); // Oval zeichnen
        graphics.drawOval(this.xCir, this.yCir, 25, 25); // Kreis zeichnen
        graphics.drawString("Hello World!", 50, 50); // Text "Hello World!" zeichnen
    }

    // Main-Methode zum Starten des Spiels
    public static void main(String[] argv) {
        try {
            // Spielcontainer erstellen und Spiel starten
            AppGameContainer container = new AppGameContainer(new Rectangles("Rectangles"));
            container.setDisplayMode(800, 600, false); // Fenstergröße festlegen
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}