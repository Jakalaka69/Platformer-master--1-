import java.awt.*;

public class Wall {

    int x,y,width,height;
    Rectangle hitBox;

    public Wall(int x, int y, int width, int height){

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        hitBox = new Rectangle(x,y, width,height);


    }
    public void draw(Graphics2D gtd){


        gtd.setColor(Color.BLACK   );
        gtd.fillRect(x, y,width, height);
    }
}
