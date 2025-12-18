
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class AdvancedArrayListOpsTest {

    @Test
    public void testAppendAndSearch() {
        AdvancedArrayListOps ops = new AdvancedArrayListOps();
        ops.append("Hello");
        ops.append("World");
        assertTrue(ops.search("Hello"));
        assertFalse(ops.search("Java"));
    }

    @Test
    public void testRemoveDuplicates() {
        AdvancedArrayListOps ops = new AdvancedArrayListOps();
        ops.append("apple");
        ops.append("banana");
        ops.append("apple");
        ops.removeDuplicates();
        ArrayList<String> result = ops.getStringList();
        assertEquals(2, result.size());
        assertTrue(result.contains("apple"));
    }

    @Test
    public void testRegexSearch() {
        AdvancedArrayListOps ops = new AdvancedArrayListOps();
        ops.append("cat");
        ops.append("catalog");
        ops.append("dog");
        ArrayList<String> matches = ops.regexSearch("^cat");
        assertEquals(2, matches.size());
    }
}
