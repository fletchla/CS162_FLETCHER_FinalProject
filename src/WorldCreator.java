import processing.core.PApplet;
import java.util.ArrayList;
import processing.sound.*;



public class WorldCreator extends PApplet {
    ArrayList<Creature> zombies = new ArrayList<Creature>();
    ArrayList<Creature> humans = new ArrayList<Creature>();
    ArrayList<ParticleSystem> particles = new ArrayList<ParticleSystem>();

    SoundFile[] zombieSlurpingSounds = new SoundFile[3]; //an array of sounds
    SoundFile[] zombieDeathSounds = new SoundFile[9];
    SoundFile conversionSound;

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


        String zombieEatingPath = dataPath("zombiesEating") + '/';
        //direct to sound file locations and set to array
        //if these are in the constructor, the path won't work for some reason
        zombieSlurpingSounds[0] = new SoundFile(this, sketchPath(zombieEatingPath + "eating_1.mp3"));
        zombieSlurpingSounds[1] = new SoundFile(this, sketchPath(zombieEatingPath + "eating_2.mp3"));
        zombieSlurpingSounds[2] = new SoundFile(this, sketchPath(zombieEatingPath + "eating_3.mp3"));

        String zombieDeathPath = dataPath("zombieDeath") + '/';
        //direct to sound file locations and set to array
        //if these are in the constructor, the path won't work for some reason
        for( int i = 0; i < 9; i++ ) {
            zombieDeathSounds[i] = new SoundFile(this, sketchPath(zombieDeathPath + "ZombieDeath_"+ (i+1) +".mp3"));
        }

        conversionSound = new SoundFile(this, "data/OMG-i-zombie.mp3");
    }

    public void draw() {
        background(250);

        for(Creature human: this.humans){
            human.draw(this);
            human.detectCollision(this.zombies);
        }

        for(int j = this.zombies.size() - 1; j >= 0; j--){
            Creature zombie = this.zombies.get(j);
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



    void playSlurpingSound() {
        //random from three
        int i = floor(random(0,3));
        zombieSlurpingSounds[i].play();
        println("slurp sound was played");
    }

    void playDeathSound() {
        //random from nine
        int i = floor(random(0,9));
        zombieDeathSounds[i].play();
        println("death sound was played");
    }

    void playConversionSound() {
        conversionSound.play();
    }





}
