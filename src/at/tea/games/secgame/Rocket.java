package at.tea.games.secgame;

import org.newdawn.slick.*;

public class Rocket implements Actor {

    private Image rocketImage;  // Bild der Rakete
    private float x, y; // Position der Rakete auf dem Bildschirm


    public Rocket() throws SlickException {
        Image tmp = new Image("testdata/rocket.png");
        // Lade das Bild der Rakete und skaliere es auf 130x130 Pixel
        this.rocketImage = tmp.getScaledCopy(130, 130);
        // Initialisiere die Startposition der Rakete
        this.x = 100;
        this.y = 100;

    }

    @Override
    public void render(Graphics graphics) {
        // Zeichne das Bild der Rakete an der aktuellen Position
        rocketImage.draw(this.x, this.y);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        if (gameContainer.getInput().isKeyDown(Input.KEY_RIGHT)) {
            // Erhöhe die x-Position der Rakete um 1
            this.x++;
        }
        if (gameContainer.getInput().isKeyDown(Input.KEY_LEFT)) {
            this.x--;
        }
        if (gameContainer.getInput().isKeyDown(Input.KEY_UP)) {
            this.y--;
        }
        if (gameContainer.getInput().isKeyDown(Input.KEY_DOWN)) {
            this.y++;
        }
    }

    public float getX() {
        return x + 57;
    }

    public float getY() {
        return y - 10;
    }
}
