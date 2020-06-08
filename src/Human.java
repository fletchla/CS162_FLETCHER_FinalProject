import processing.core.PApplet;

public class Human extends Creature {


    public Human(WorldCreator w) {
        super(w);
        setupSpawnPoint(450, 490);
        setupColor(200, 255, 0, 150, 0, 150);

        int minRadius = 5;
        int maxRadius = 25;
        double r = w.random(minRadius, maxRadius);
        setRadius(r);


        float v = PApplet.map((float)r, minRadius, maxRadius, (float)-0.3, -2);
        setyVelocity(v);

    }

    public boolean attemptToKill(Creature target) {
        return true;
    }



}
