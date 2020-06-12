package main.java.mars.rover;

public class MarsRover {
    int x;
    int y;
    Direction direction;
    World world;

    public MarsRover(int x, int y, Direction direction, World world) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.world = world;
    }

    void rotateLeft(){}

    void rotateRight(){}

    void move(){}

    void move(int distance){}

    void execute(String commands){}

    @Override
    public String toString() {
        return "MarsRover{" +
                "x=" + x +
                ", y=" + y +
                ", direction=" + direction +
                '}';
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    public World getWorld() {
        return world;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
