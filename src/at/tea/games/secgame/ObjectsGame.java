package at.tea.games.secgame;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ObjectsGame extends BasicGame {
    private List<Actor> actors; // Liste der Actors im Spiel

    public ObjectsGame(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actors = new ArrayList<>();

        Random random = new Random();
        // Erstelle und füge 10 Rechtecke hinzu
        for (int i = 0; i < 10; i++) {
            Rectangle rectangle = new Rectangle(random.nextInt(800), random.nextInt(600), random.nextInt(50), random.nextBoolean());
            this.actors.add(rectangle);
        }
        // Erstelle und füge 10 Kreise hinzu
        for (int i = 0; i < 10; i++) {
            Circle circle = new Circle();
            this.actors.add(circle);
        }
        // Erstelle und füge 10 Ellipsen und 10 Raketen hinzu
        for (int i = 0; i < 10; i++) {
            Ellipse ellipse = new Ellipse(random.nextInt(800), random.nextInt(600));
            this.actors.add(ellipse);

            Rocket rocket = new Rocket();
            this.actors.add(rocket);
        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        // Aktualisiere jeden Actor in der Liste
        for (Actor actor : this.actors) {
            actor.update(delta);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        // Zeichne jeden Actor in der Liste
        for (Actor actor : this.actors) {
            actor.render(graphics);
        }
    }

    public static void main(String[] argv) {
        try {
            // Erstelle den Spielcontainer und starte das Spiel
            AppGameContainer container = new AppGameContainer(new ObjectsGame("ObjectsGame"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}

