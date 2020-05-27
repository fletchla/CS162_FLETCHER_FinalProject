public class SpawnPoint {

    private float x;
    private float y;

    public SpawnPoint(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }
    public void setXRelative(float x) {
        this.x += x;
    }

    public void setY(float y) {
        this.y = y;
    }
    public void setYRelative(float y) { this.y += y; }
}