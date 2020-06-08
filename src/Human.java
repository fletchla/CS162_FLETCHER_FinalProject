public class Human extends Creature {


    public Human(WorldCreator w) {
        super(w);
        setupSpawnPoint(450, 490);
        setupColor(200, 255, 0, 150, 0, 150);
        setyVelocity(-1);

    }

    public boolean attemptToKill(Creature target) {
        return true;
    }



}
