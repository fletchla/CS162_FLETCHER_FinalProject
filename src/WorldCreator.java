import processing.core.PApplet;
import java.util.ArrayList;


public class WorldCreator extends PApplet {
    ArrayList<Zombie> zombies = new ArrayList<Zombie>();
    ArrayList<Human> humans = new ArrayList<Human>();

    public void settings() {
        size(500,500);
    }

    public void setup() {
        int humanCount = this.getInitialPopulation();
        int zombieCount = this.getInitialPopulation();

        for(int i = 0; i < humanCount; i++) {
            humans.add(new Human());
        }

        for(int i = 0; i < zombieCount; i++) {
            zombies.add(new Zombie());
        }
    }

    public void draw() {
        background(250);

        for(Human human: this.humans){
            human.draw(this);
        }

        for(Zombie zombie: this.zombies){
            zombie.draw(this);
        }

        drawCounters();

    }

    public int getInitialPopulation(){
        return (int) random(10, 50);
    }

    public void drawCounters(){
        textSize(30);
        fill(0);
        textAlign(TOP, CENTER);
        text("Zombies: " + this.zombies.size(), 250, 50);
        text("Humans: " + this.humans.size(), 250, 450);

    }
}
