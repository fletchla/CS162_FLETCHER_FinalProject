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
        //50% chance to kill human, 15% chance to convert
        double chance = w.random(0,100);
        //double probability = 45; //45% chance to kill
        //smaller zombie = lower probability = less chance to kill
        double probability = PApplet.map((float)getRadius(), 5, 25, 60, 20);

        if(chance < probability){
            if(w.random(0,100) < 25){
                //25% chance to create a zombie
                Creature z = new Zombie(this.w);
                z.setRadius(target.getRadius());
                z.setyVelocity(-1 * target.getyVelocity());
                z.setPosition(target.getPosition());
                w.zombies.add(z);
                return true;
            }
            return true;
        }

        return false;
    }

}
