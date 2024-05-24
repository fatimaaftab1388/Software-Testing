import org.example.Reverse;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestCasesReverseAnArray {
    @Test
    public void reverse_array_with_multiple_elements_in_array(){
        Reverse obj=new Reverse();
        int[] array = {1, 2, 3, 4, 5};
        int [] actual=obj.reverseArray(array);
        int[] expected = {5,4,3,2,1};
        Assertions.assertArrayEquals(actual,expected);
    }
    @Test
    public void reverse_array_with_single_element_in_array(){
        Reverse obj=new Reverse();
        int[] array = {1};
        int [] actual=obj.reverseArray(array);
        int[] expected = {1};
        Assertions.assertArrayEquals(actual,expected);
    }
}
