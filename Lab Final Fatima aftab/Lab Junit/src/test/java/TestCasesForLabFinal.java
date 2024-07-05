import org.example.LabFinal;
import org.example.Reverse;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertEquals;

public class TestCasesForLabFinal{
    @Test
    public void testSquare_TC_01() {
        LabFinal algo = new LabFinal();
        String result = algo.determineShape(3, 3, 3, 3);
        assertEquals("Given shape is Square.", result);
    }

    @Test
    public void testRectangle_TC_02() {
        LabFinal algo = new LabFinal();
        String result = algo.determineShape(3, 4, 3, 4);
        assertEquals("Given shape is Rectangle.", result);
    }

    @Test
    public void testInvalidSidesNegative_TC_03() {
        LabFinal algo = new LabFinal();
        String result = algo.determineShape(-3f, 4f, -3f, 4f);
        assertEquals("Invalid sides. Neither square nor rectangle.", result);
    }

    @Test
    public void testInvalidSidesSpecialValues_TC_04(){
        LabFinal algo=new LabFinal();
        String result = algo.determineShape("y", "y", -3f, 4f);
        assertEquals("Invalid input", result);
    }
    @Test
    public void testInvalidSidesZero_TC_05() {
        LabFinal algo = new LabFinal();
        String result = algo.determineShape(0f, 4f, 0f, 4f);
        assertEquals("Invalid sides. Neither square nor rectangle.", result);
    }
}
