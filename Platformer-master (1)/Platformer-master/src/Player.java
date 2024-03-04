import java.awt.*;

public class Player {

    GamePanel panel;
    int x,y,width,height;

    double xspeed,yspeed;

    Rectangle hitBox;

    boolean keyLeft,keyRight,keyUp,keyDown;

    boolean started = false;
    public Player(int x, int y, GamePanel panel){

        this.panel = panel;
        this.x = x;
        this.y = y;

        width = 50;
        height = 100;
        hitBox = new Rectangle(x,y,width,height);
    }

    public int set(StringBuilder currentTime){
        if(keyLeft || keyRight || keyUp){
            started = true;
        }
        if(!started){
            return 3;
        }
        if(keyLeft && keyRight || !keyLeft && !keyRight){xspeed *= 0.8;}
        else if(keyLeft && !keyRight){ xspeed --;}
        else if (keyRight && !keyLeft){ xspeed ++;}



        if(xspeed > 0 && xspeed < 0.75){xspeed =0;}
        if(xspeed < 0 && xspeed > -0.75){xspeed =0;}

        if(xspeed > 7){xspeed = 7;}
        if(xspeed < -7){ xspeed =-7;}

        if(keyUp){

            hitBox.y ++;
            for(Wall wall: panel.walls){

                if(wall.hitBox.intersects(hitBox)){yspeed = -6;}
            }
            hitBox.y --;


        }


        if(hitBox.y < 200){
            System.out.println(currentTime + "" +  hitBox.y);
            started = false;
            return 1;
        }

        yspeed += 0.3;

        hitBox.x += xspeed;
        for(Wall wall: panel.walls){

            if(hitBox.intersects(wall.hitBox)){
                hitBox.x -= xspeed;
                while(!wall.hitBox.intersects(hitBox)){hitBox.x  += Math.signum(xspeed);}
                hitBox.x -= Math.signum(xspeed);
                xspeed = 0;
                x = hitBox.x;
            }
        }
        hitBox.y += yspeed;
        for(Wall wall: panel.walls){

            if(hitBox.intersects(wall.hitBox)){
                hitBox.y -= yspeed;
                while(!wall.hitBox.intersects(hitBox)){hitBox.y  += Math.signum(yspeed);}
                hitBox.y -= Math.signum(yspeed);
                yspeed = 0;
                y = hitBox.y;
            }
        }

        hitBox.x += xspeed;
        for(DeathWall deathWall: panel.deathWalls){

            if(hitBox.intersects(deathWall.hitBox)){
                hitBox.x -= xspeed;
                while(!deathWall.hitBox.intersects(hitBox)){hitBox.x  += Math.signum(xspeed);}
                hitBox.x -= Math.signum(xspeed);
                xspeed = 0;
                x = hitBox.x;
                started = false;
                return 2;
            }
        }

        x += xspeed;
        y += yspeed;

        hitBox.x = x;
        hitBox.y = y;

        if(y > 580){panel.player = new Player(100,500,panel);};
        return 0;
    }

    public void draw(Graphics2D gtd){
        gtd.setColor(Color.WHITE);
        gtd.drawRect(x,y,width,height);
        gtd.setColor(Color.black);
        gtd.fillRect(x+1,y+1,width-2,height-2);


    }

}
