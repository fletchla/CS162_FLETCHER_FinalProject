import processing.core.PApplet;

abstract class Creature {

    private SpawnPoint position;
    private static int numShapes;
    private int id;

    public Creature(SpawnPoint position){
        this.position=position;
        ++numShapes;
        setId(numShapes);
    }

    public SpawnPoint getPosition() {
        return position;
    }
    public void setPosition(SpawnPoint position) {
        this.position = position;
    }
    public static int getNumShapes(){
        return numShapes;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    abstract public double computeArea();
    abstract public double getPerimeter();

    public String toString(){
        return String.format("Shape type: %s, ID: %d, Area: %f, Perimeter: %f", getClass().getName(),id, computeArea(),getPerimeter());
    }

    //@Override
    public int compareTo(final Creature o) {
        double x = Double.compare(this.computeArea(), o.computeArea());
        if (x == 0) {
            x = Double.compare(this.getPerimeter(), o.getPerimeter());
        }
        return (int) x;
    }

    abstract public void draw(PApplet p);
}
