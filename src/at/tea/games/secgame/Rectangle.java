package at.tea.games.secgame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Rectangle implements Actor {
    private enum DIRECTION {RIGHT, LEFT}

    ;
    private float x;
    private float y;
    private float speed;
    private DIRECTION direction;


    public Rectangle(float x, float y, float speed, boolean leftToRight) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.direction = leftToRight ? DIRECTION.RIGHT : DIRECTION.LEFT;
        //Wenn "leftToRight" wahr ist, wird "DIRECTION.RIGHT" zugewiesen, sonst "DIRECTION.LEFT"
    }

    public void render(Graphics graphics) {
        graphics.drawRect(this.x, this.y, 10, 10);
    }

    public void update(int delta) {
        if (this.direction == DIRECTION.RIGHT) {
            this.x += (float) delta / this.speed;
            if (this.x > 800) {
                this.x = 0;
            }
        } else {
            this.x -= (float) delta / this.speed;
            if (this.x < 0) {
                this.x = 800;
            }
        }
    }
}