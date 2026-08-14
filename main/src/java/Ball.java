public class Ball {
    private double health;
    private boolean moving = false;
    private double x;
    private double y;
    private double destinationX;
    private double destinationY;
    private double speed;
    public Ball(double health, double x, double y) {
        this.health = health;
        this.x = x;
        this.y = y;
    }
    public boolean isMoving() {
        return moving;
    }
    public double getHealth() {
        return health;
    }
    public void stop() {
        moving = false;
    }
    public void setTarget(double x, double y) {
        destinationX = x;
        destinationY = y;
        moving = true;
    }
    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public void update(int multiplier) {
        if (!moving) {
            return;
        }
        double dx = destinationX - x;
        double dy = destinationY - y;
        double distance = Math.sqrt(Math.pow(dx, 2) - Math.pow(dy, 2));
        double currentSpeed = speed * multiplier;
        if (distance < currentSpeed) {
            moving = false;
            setPosition(destinationX, destinationY);
        }
        else {
            double ratio = currentSpeed / distance;
            double newX = getX() + dx * ratio;
            double newY = getY() + dy * ratio;
            setPosition(newX, newY);
        }
    }
}
