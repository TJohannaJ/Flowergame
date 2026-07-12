package player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
//a Player osztalyban vannak leirva a player1 es a player2-hoz kapcsolodo fuggvenyek es valtozok
public class Player{
    //minden jatekosnak van egy koordinataja a tablan, ahol az adott pillanatban all (x;y)
    private int x,y;
    //a jatek vegen elert pontja a jatekosnak
    private long score = 0;
    //minden jatekosnak van egy neve
    private String name;
    //minden jatekos 10 viragot kap, amikor elkezdi a jatekot, ezeket kell a palyan "elultetni"
    private int flowers;
    //a jatekos ugy jelenik meg a kepernyon, mint a kep, amit ez a valtozo tarol
    private BufferedImage image;
    //a jatekos konstruktora, ez olvassa be a kepet, valamint adja oda a jatekosnak a 10 viragat
    public Player(String imagePath){
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        flowers = 10;
    }
    //A jatekos X koordinatajat allitja be
    public void setX( int num){
        x = num;
    }
    // a jatekos X koordinatajat adja vissza
    public int getX(){
        return x;
    }
    //A jatekos Y koordinatajat allitja be
    public void setY(int num){
        y = num;
    }
    // a jatekos Y koordinatajat adja vissza
    public int getY(){
        return y;
    }
    // Ha a jatekos lerak egy viragot, akkor levonja azt
    public void plant(){
        flowers -= 1;
    }
    //Ha a jatekos felveszi a viragot, akkor hozzaadja azt
    public void pickUp(){
        if(flowers < 10){
            flowers += 1;
        }
    }
    //Ezzel a fuggvennyel lehet beallitani egy jatekos score-jat
    public void setScore(long i){
        score = i;
    }
    //Ezzel a fuggvennyel lehet egy jatekosnak lekerdezni a score-jat
    public long getScore(){
        return score;
    }
    //Ezzel a fuggvennyel lehet beallitani a jatekosok nevet
    public void setName(String s){
        name = s;
    }
    // Ez a fuggveny visszaadja a jatekos nevet
    public String getName() {return name;}
    //Ezzel a fuggvennyel lehet lekerdezni, hogy hany viragja van meg hatra a jatekosnak
    public int getFlowers() {return flowers;}
    //Ez a fuggveny visszaadja a jatekos kepet
    public Image getImage(){
        return image;
    }
}
