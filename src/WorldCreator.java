import processing.core.PApplet;
import java.util.ArrayList;

public class WorldCreator extends PApplet {
    Creature creature;
    ArrayList<Creature> creatures = new ArrayList<Creature>();

    public void settings() {
        size(500,500);
    }

    public void setup() {

        creatures.add(new Human(new SpawnPoint(250, 400), 50.0));
        creatures.add(new Zombie(new SpawnPoint(250, 100), 50.0));

    }

    public void draw() {
        //you'll need to draw all your shapes
        //this is your ShapeCreator object which is your sketch.
        //pass shape.draw the sketch so it can draw on it
        for(Creature shape: this.creatures){
            shape.draw(this);
        }

    }
}
