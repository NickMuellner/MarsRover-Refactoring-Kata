package main.java.mars.rover;

public enum Direction {
    NORTH, EAST, SOUTH, WEST;

    public Direction rotateLeft(){
        int index = this.ordinal() == 0 ? 3 : this.ordinal() - 1;
        return Direction.values()[index];
    }

    public Direction rotateRight(){
        int index = this.ordinal() == 3 ?  0 : this.ordinal() + 1;
        return Direction.values()[index];
    }
}
