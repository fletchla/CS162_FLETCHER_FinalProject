import processing.core.PApplet;

public class Zombie extends Creature {
    public Zombie(WorldCreator w) {
        super(w);
        setupSpawnPoint(10, 50);
        setupColor(0, 150, 200, 255, 0, 150);

        int minRadius = 5;
        int maxRadius = 25;
        double r = w.random(minRadius, maxRadius);
        setRadius(r);


        float v = PApplet.map((float)r, minRadius, maxRadius, (float)5, (float)0.5 );
        setyVelocity(v);

    }

    public boolean attemptToKill(Creature target) {
        return true;
    }

}
