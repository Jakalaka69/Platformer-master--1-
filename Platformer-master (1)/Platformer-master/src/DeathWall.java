import java.awt.*;

public class DeathWall {
    int x,y,width,height;

    Rectangle hitBox;

    public DeathWall(int x, int y, int width, int height){

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        hitBox = new Rectangle(x,y,width,height);
    }
    public void draw(Graphics2D gtd){


        gtd.setColor(Color.RED);
        gtd.fillRect(x,y,width,height);
    }
}
