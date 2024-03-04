import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;




public class GamePanel extends javax.swing.JPanel implements ActionListener {

    Player player;
    ArrayList<Wall> walls = new ArrayList<>();
    ArrayList<DeathWall> deathWalls = new ArrayList<>();

    Timer gameTimer;

    double time = 0;
    public String timeString2;

    JLabel label = new JLabel("");

    public GamePanel(){
        GamePanel panelTemp = this;
        player = new Player(100,500,panelTemp);

        makeWalls();

        this.add(label);
        label.setSize(200,200);
        label.setFont(new Font("Arial", Font.PLAIN, 50));

        gameTimer = new Timer();
        gameTimer.schedule(new TimerTask(){

            @Override
            public void run() {
                time = time * 100;
                int time2 = (int)time;
                String timeString;
                timeString = Integer.toString(time2);
                StringBuilder timeString2 = new StringBuilder(timeString);
                if(time2 > 100 && time2 < 10000){
                    timeString2.insert(timeString2.length()-2,".");
                }
                else if(time2 > 10000){
                    timeString2.insert(timeString2.length()-4,".");
                }
                label.setText(timeString2.toString());
                time = time/100;
                time += 0.017;
                int result = player.set(timeString2);

                if(result == 1){


                    player.hitBox.y = 500;
                    player.hitBox.x = 100;
                    player.x = 100;
                    player.y = 500;
                    time = 0;
                    Platformer.restart();
                }
                else if(result == 2){
                    player.hitBox.y = 500;
                    player.hitBox.x = 100;
                    player.x = 100;
                    player.y = 500;


                }
                else if(result == 3){
                    time = 0;

                };
                repaint();


            }
        },0,17);

    }
public void makeWalls(){
        deathWalls.add(new DeathWall(300,400,50,50));

        for(int i = 50; i < 650; i+=50){
            walls.add(new Wall(i,600,50,50));
        }
        walls.add(new Wall(50,550,50,50));
        walls.add(new Wall(450,550,50,50));
        walls.add(new Wall(550,500,50,50));
        walls.add(new Wall(350,450,50,50));
        walls.add(new Wall(300,450,50,50));
        walls.add(new Wall(250,450,50,50));
        walls.add(new Wall(250,400,50,50));
        walls.add(new Wall(150,350,50,50));
        walls.add(new Wall(100,300,50,50));
}
    public void paint(Graphics g){

        super.paint(g);

        Graphics2D gtd = (Graphics2D) g;

        player.draw(gtd);
        for(Wall wall: walls) wall.draw(gtd);
        for(DeathWall deathWall: deathWalls) deathWall.draw(gtd);

    }






    void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'a'){ player.keyLeft = true;}
        if(e.getKeyChar() == ' ') {player.keyUp = true;}
        if(e.getKeyChar() == 's') {player.keyDown = true;}
        if(e.getKeyChar() == 'd') {player.keyRight = true;}
    }
    void keyReleased(KeyEvent e) {
        if(e.getKeyChar() == 'a') {player.keyLeft = false;}
        if(e.getKeyChar() == ' ') {player.keyUp = false;}
        if(e.getKeyChar() == 's') {player.keyDown = false;}
        if(e.getKeyChar() == 'd'){ player.keyRight = false;}
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
