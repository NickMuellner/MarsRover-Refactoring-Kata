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

    void rotateLeft(){
        direction = direction.rotateLeft();
    }

    void rotateRight(){
        direction = direction.rotateRight();
    }

    void move(){
        int newX = x;
        int newY = y;
        switch (direction) {
            case NORTH:
                newY++;
                break;
            case EAST:
                newX++;
                break;
            case SOUTH:
                newY--;
                break;
            case WEST:
                newX--;
                break;
        }

        if(checkPosition(newX, newY)) {
            x = newX;
            y = newY;
        }
    }

    void move(int distance){
        for (int i = 0; i < distance; i++) {
            move();
        }
    }

    void execute(String commands){
        for (char command :
                commands.toCharArray()) {
            switch (command) {
                case 'M':
                    move();
                    break;
                case 'R':
                    rotateRight();
                    break;
                case 'L':
                    rotateLeft();
                    break;
            }
        }
    }

    boolean checkPosition(int x, int y){
        return x > 0 && y > 0 && x < getWorld().width && getWorld().height < y;
    }

    @Override
    public String toString() {
        return x + " " + y + " " + direction.name().charAt(0);
    }

    public Direction getDirection() {
        return direction;
    }

    public World getWorld() {
        return world;
    }
}
