import processing.core.PApplet;

abstract class Creature extends PApplet {

    private SpawnPoint position;
    private static int numShapes;
    private double radius;
    private int colour; //color reserved in Processing. who knows tf in here
    float xVelocity;
    float yVelocity;

    public Creature(){
        this.position = new SpawnPoint(0, 0);
        this.colour = 0;
        this.radius = 50;
        ++numShapes;
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


    public void draw(PApplet p){
        p.fill(getColor());
        p.circle(
                this.getPosition().getX(),
                this.getPosition().getY(),
                (float) this.radius
        );
        move();
    }

    void move() {
        this.position.setXRelative(this.xVelocity);
        this.position.setYRelative(this.yVelocity);
    }

    public void setupSpawnPoint(float min, float max) {
        float x = random(0, 500);
        float y = random(min, max);
        this.position = new SpawnPoint(x,y);
    }

    public void setupColor(int rmin, int rmax, int gmin, int gmax, int bmin, int bmax) {
        int r = (int) random(rmin, rmax);
        int g = (int) random(gmin, gmax);
        int b = (int) random(bmin, bmax);

        setColor(r,g,b);
    }

    public void setColor(int r, int g, int b){
        this.colour = color(r, g, b, 255);
    }

    public int getColor(){
        return this.colour;
    }

    public float getxVelocity() {
        return xVelocity;
    }

    public float getyVelocity() {
        return yVelocity;
    }

    public void setxVelocity(float xVelocity) {
        this.xVelocity = xVelocity;
    }

    public void setyVelocity(float yVelocity) {
        this.yVelocity = yVelocity;
    }
}
