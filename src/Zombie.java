public class Zombie extends Creature {
    public Zombie() {
        super();
        setupSpawnPoint(10, 50);
        setupColor(0, 150, 200, 255, 0, 150);
        setyVelocity((float)0.5);

    }

}
