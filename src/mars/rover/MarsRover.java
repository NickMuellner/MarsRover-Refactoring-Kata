package mars.rover;

public class MarsRover {
    private int x;
    private int y;
    private Direction direction;
    private World world;

    public MarsRover(int x, int y, Direction direction, World world) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.world = world;

        if(!checkPosition(x, y)) {
            throw new IllegalArgumentException("Position out of World");
        }
    }

    public void rotateLeft(){
        direction = direction.rotateLeft();
    }

    public void rotateRight(){
        direction = direction.rotateRight();
    }

    public void move(){
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

    public void execute(String commands){
        if(commands == null) {
            throw new IllegalArgumentException("Position out of World");
        }
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

    private boolean checkPosition(int x, int y){
        return x > 0 && y > 0 && x < getWorld().getWidth() && y < getWorld().getHeight();
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
