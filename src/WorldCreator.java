import processing.core.PApplet;
import java.util.ArrayList;


public class WorldCreator extends PApplet {
    ArrayList<Creature> zombies = new ArrayList<Creature>();
    ArrayList<Creature> humans = new ArrayList<Creature>();

    public void settings() {
        size(500,500);
    }

    public void setup() {
        int humanCount = this.getInitialPopulation();
        int zombieCount = this.getInitialPopulation();

        for(int i = 0; i < humanCount; i++) {
            humans.add(new Human(this));
        }

        for(int i = 0; i < zombieCount; i++) {
            zombies.add(new Zombie(this));
        }
    }

    public void draw() {
        background(250);

        for(Creature human: this.humans){
            human.draw(this);
            human.detectCollision(this.zombies);
        }

        for(Creature zombie: this.zombies){
            zombie.draw(this);
        }

        //detectCollisions();
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

    public void detectCollisions() {

        //if (this.zombies.size() > 0) {
            for (int i = this.humans.size() - 1; i >= 0; i--) {
                for (int j = this.zombies.size() - 1; j >= 0; j--) {
                    Creature h = this.humans.get(i);
                    Creature z = this.zombies.get(i);

                    if (this.isClose(h,z) == true) {
                        //they collide and put shit here
                        int chance = (int)random(0,100);
                        if (chance < 45) {
                            this.zombies.remove(i);
                        }
                        else if (chance < 60) {
                            SpawnPoint p = h.getPosition();
                            this.humans.remove(i);
                            Creature z2 = new Zombie(this);
                            this.zombies.add(z2);
                            z2.setPosition(p);
                            break;
                        }
                        System.out.println("They have collided"); //we talked about typewriters
                    }
                }
            }
        //}

    }

    public boolean isClose(Creature h, Creature z) {
        float distance = dist(
                h.getPosition().getX(),
                h.getPosition().getY(),
                z.getPosition().getX(),
                z.getPosition().getY()
        );
        double sizes = (h.getRadius()) + (z.getRadius()); //combined radius of zombie and beaver
        if (distance <= sizes) {
            return true;
        }
        else {
            return false;
        }
    }

}
