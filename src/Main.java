import processing.core.PApplet;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    private final static String[] OPTIONS= new String[] {"--present","WorldCreator"};
    public static void main(String[] args){
        PApplet.main(OPTIONS);
        ArrayList<Creature> creatures = new ArrayList<Creature>();
        add(creatures);
        display(creatures);
        System.out.println(String.format("The total number of shapes created are: %d", Creature.getNumShapes()));
    }

    private static void add(ArrayList<Creature> shapes) {
        shapes.add(new Human(new SpawnPoint(200.0, 200.0), 50.0));

        shapes.add(new Zombie(new SpawnPoint(50.0, 50.0), 10.0));

    }

    private static void display(ArrayList<Creature> creatures) {
        for(Creature creature: creatures){
            System.out.println(creature);
        }
        System.out.println("Before ^ After v");
        //Collections.sort(creatures);
        for(Creature creature: creatures){
            System.out.println(creature);
        }
    }

}
