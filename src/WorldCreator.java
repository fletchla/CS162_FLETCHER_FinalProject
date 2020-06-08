import processing.core.PApplet;
import java.util.ArrayList;


public class WorldCreator extends PApplet {
    ArrayList<Creature> zombies = new ArrayList<Creature>();
    ArrayList<Creature> humans = new ArrayList<Creature>();
    ArrayList<ParticleSystem> particles = new ArrayList<ParticleSystem>();

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
            zombie.detectCollision(this.humans);
        }

        for(ParticleSystem ps: this.particles){
            ps.draw();
            ps.update();
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

    public void addParticle(SpawnPoint p){
        ParticleSystem ps = new ParticleSystem(
                (int) p.getX(),
                (int) p.getY(),
                this
        );
        this.particles.add(ps);
    }



}
