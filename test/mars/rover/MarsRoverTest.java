package mars.rover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static mars.rover.Direction.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MarsRoverTest {

    private World world;
    private MarsRover rover;

    @BeforeEach
    public void setUp(){
        world = new World(10, 10);
        rover = new MarsRover(1, 1, NORTH, world);
    }

    @Test
    public void rover_toString() {
        assertEquals("1 1 N", rover.toString());
    }

    @Test
    public void rover_null_command() {
        assertThrows(IllegalArgumentException.class, () -> rover.execute(null));
    }
    @Test
    public void rover_illegal_command() {
        executeAndCheck("Y", "1 1 N");
    }

    @Test
    public void rover_no_commands() {
        executeAndCheck("", "1 1 N");
    }

    @Test
    public void rover_x_out_of_world() {
        assertThrows(IllegalArgumentException.class, () -> new MarsRover(11, 1, NORTH, world));
    }

    @Test
    public void rover_y_out_of_world() {
        assertThrows(IllegalArgumentException.class, () -> new MarsRover(1, 11, NORTH, world));
    }

    public void rover_move_x_out_of_world() {
        executeAndCheck("LM", rover.toString());
    }

    public void rover_move_y_out_of_world() {
        executeAndCheck("LLM", "1 1 S");
    }

    @Test
    public void rover_rotation_left() {
        executeAndCheck("L", "1 1 W");

        executeAndCheck("L", "1 1 S");

        executeAndCheck("L", "1 1 E");

        executeAndCheck("L", "1 1 N");
    }

    @Test
    public void rover_rotation_right() {
        executeAndCheck("R", "1 1 E");

        executeAndCheck("R", "1 1 S");

        executeAndCheck("R", "1 1 W");

        executeAndCheck("R", "1 1 N");
    }

    @Test
    public void rover_rotation_mixed() {
        executeAndCheck("LR", "1 1 N");
    }

    @Test
    public void rover_move_x() {
        executeAndCheck("M", "1 2 N");
    }

    @Test
    public void rover_move_y() {
        executeAndCheck("RM", "2 1 E");
    }

    @Test
    public void rover_complex_command(){
        executeAndCheck("MLMRRMMRM", "3 1 S");
    }

    private void executeAndCheck(String commands, String result){
        rover.execute(commands);
        assertEquals(result, rover.toString());
    }
}