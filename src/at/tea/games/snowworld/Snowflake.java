package at.tea.games.snowworld;

import org.newdawn.slick.Graphics;
import java.util.Random;

public class Snowflake implements Actor {

    // Enumeration zur Definition der möglichen Größen von Schneeflocken
    public enum SIZE {BIG, MEDIUM, SMALL}

    private float x, y; // Position der Schneeflocke auf dem Bildschirm
    private int size; // Größe der Schneeflocke
    private int speed; // Geschwindigkeit, mit der die Schneeflocke fällt
    private Random random; // Zufallsgenerator zur Bestimmung der Startposition

    public Snowflake(SIZE size) {
        this.random = new Random();
        if (size == SIZE.BIG) {
            this.size = 12;
            this.speed = 2;
        } else if (size == SIZE.MEDIUM) {
            this.size = 8;
            this.speed = 5;
        } else if (size == SIZE.SMALL) {
            this.size = 4;
            this.speed = 10;
        }
        setRandomPosition(); // Zufällige Startposition der Schneeflocke setzen
    }

    private void setRandomPosition() {
        this.x = this.random.nextInt(800); // Zufällige X-Position
        this.y = this.random.nextInt(600) - 600; // Zufällige Y-Position oberhalb des Bildschirms
    }

    // Methode zum Rendern (Zeichnen)
    @Override
    public void render(Graphics graphics) {
        graphics.fillOval(this.x, this.y, this.size, this.size); // Zeichnen der Schneeflocke als gefülltes Oval
    }

   // Methode zur zur Aktualisierung der Position der Schneeflocke
    @Override
    public void update(int delta) {
        this.y += (float) delta / this.speed; // Y-Position erhöhen
        if (this.y > 600) {  // Wenn die Schneeflocke den unteren Rand des Bildschirms erreicht
            setRandomPosition(); // Neue zufällige Position oberhalb des Bildschirms setzen
        }
    }
}
