import processing.core.PApplet;

import java.util.ArrayList;

abstract class Creature {
    WorldCreator w;

    private SpawnPoint position;
    private double radius;
    private int colour; //color reserved in Processing. who knows tf in here
    float xVelocity;
    float yVelocity;

    public Creature(WorldCreator w){
        this.w = w;
        this.position = new SpawnPoint(0, 0);
        this.colour = 0;
        this.radius = 10;
    }

    public SpawnPoint getPosition() {
        return position;
    }
    public void setPosition(SpawnPoint position) {
        this.position = position;
    }


    public void draw(WorldCreator w){
        w.fill(getColor());
        w.circle(
                this.getPosition().getX(),
                this.getPosition().getY(),
                (float) this.radius*2
        );
        move();
    }

    void move() {
        this.position.setXRelative(this.getxVelocity() +  getJitter());
        this.position.setYRelative(this.getyVelocity() +  getJitter());
    }

    public void setupSpawnPoint(float min, float max) {
        float x = w.random(0, 500);
        float y = w.random(min, max);
        this.position = new SpawnPoint(x,y);
    }

    public void setupColor(int rmin, int rmax, int gmin, int gmax, int bmin, int bmax) {
        int r = (int) w.random(rmin, rmax);
        int g = (int) w.random(gmin, gmax);
        int b = (int) w.random(bmin, bmax);

        setColor(r,g,b);
    }

    public void setColor(int r, int g, int b){
        this.colour = w.color(r, g, b, 255);
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

    public float getJitter(){
        return w.random((float)-1, (float)1);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void detectCollision(ArrayList<Creature> targets) {
        for(int i = targets.size() - 1; i >= 0; i--) {
            Creature target = targets.get(i);

            if (this.isCloseTo(target)) {
                //they collide and put shit here
                if(this.attemptToKill(target)) {
                    this.w.addParticle(target.getPosition());
                    targets.remove(i);
                }

                /*
                int chance = (int) w.random(0, 100);
                if (chance < 45) {
                    this.zombies.remove(i);
                } else if (chance < 60) {
                    SpawnPoint p = h.getPosition();
                    this.humans.remove(i);
                    Creature z2 = new Zombie(this);
                    this.zombies.add(z2);
                    z2.setPosition(p);
                    break;
                }
                System.out.println("They have collided"); //we talked about typewriters
                */

            }
        }
    }

    abstract boolean attemptToKill(Creature target);

    //checks if this creature is within range of a target
    public boolean isCloseTo(Creature target) {
        float distance = PApplet.dist(
                this.getPosition().getX(),
                this.getPosition().getY(),
                target.getPosition().getX(),
                target.getPosition().getY()
        );
        double sizes = (this.getRadius()) + (target.getRadius()); //combined radius of zombie and beaver
        return (distance <= sizes);
    }
}
