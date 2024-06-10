package at.tea.games.snowworld;

import at.tea.games.secgame.ObjectsGame;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class Snowworld extends BasicGame {
    private List<Actor> snowflakes; // Liste zur Speicherung von Schneeflocken-Objekten

    public Snowworld(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.snowflakes = new ArrayList<>();
        // Erzeugen von Schneeflocken in verschiedenen Größen und Hinzufügen zur Liste
        for (int i = 0; i < 100; i++) {
            this.snowflakes.add(new Snowflake(Snowflake.SIZE.BIG));
            this.snowflakes.add(new Snowflake(Snowflake.SIZE.MEDIUM));
            this.snowflakes.add(new Snowflake(Snowflake.SIZE.SMALL));
        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        // Aktualisieren der Position und des Zustands jeder Schneeflocke
        for (Actor actor : this.snowflakes) {
            actor.update(delta);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        // Zeichnen jeder Schneeflocke auf dem Bildschirm
        for (Actor actor : this.snowflakes) {
            actor.render(graphics);
        }
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Snowworld("Snowworld"));
            container.setDisplayMode(800, 600, false);  // Setzen der Bildschirmauflösung auf 800x600
            container.start();
        } catch (SlickException e) {
            e.printStackTrace(); // Fehlerbehandlung, falls ein SlickException auftritt
        }
    }
}