package DataStructures.CustomDataStructures.DynamicArray;

import DataStructures.CustomDataStructures.DynamicArrays.DynamicArray;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DynamicArrayTest {

    private DynamicArray fullDynamicArray;
    private DynamicArray regularDynamicArray;
    private DynamicArray emptyDynamicArray;

    @BeforeEach
    void setUp() {
        fullDynamicArray = new DynamicArray();
        fullDynamicArray.append(1);
        fullDynamicArray.append(2);
        fullDynamicArray.append(3);
        fullDynamicArray.append(4);

        regularDynamicArray = new DynamicArray();
        regularDynamicArray.append(1);
        regularDynamicArray.append(2);

        emptyDynamicArray = new DynamicArray();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testIsEmptyOnEmptyDynamicArray() {
        Assert.assertTrue(emptyDynamicArray.isEmpty());
    }

    @Test
    void testIsEmptyOnNonEmptyDynamicArray() {
        Assert.assertFalse(fullDynamicArray.isEmpty());
    }

    @Test
    void testAppendWithoutArrayExpansion() {
        regularDynamicArray.append(3);
        Assert.assertEquals("1 2 3 Size: 3\n", regularDynamicArray.toString());
        Assert.assertEquals(4, regularDynamicArray.getCapacity());
    }

    @Test
    void testAppendWithArrayExpansion() {
        emptyDynamicArray.append(1);
        Assert.assertEquals("1 Size: 1\n", emptyDynamicArray.toString());
        Assert.assertEquals(1, emptyDynamicArray.getCapacity());

        emptyDynamicArray.append(2);
        Assert.assertEquals("1 2 Size: 2\n", emptyDynamicArray.toString());
        Assert.assertEquals(2, emptyDynamicArray.getCapacity());

        emptyDynamicArray.append(3);
        Assert.assertEquals("1 2 3 Size: 3\n", emptyDynamicArray.toString());
        Assert.assertEquals(4, emptyDynamicArray.getCapacity());

        emptyDynamicArray.append(4);
        Assert.assertEquals("1 2 3 4 Size: 4\n", emptyDynamicArray.toString());
        Assert.assertEquals(4, emptyDynamicArray.getCapacity());
    }

    @Test
    void testDeleteWithoutArrayContraction() {
        fullDynamicArray.delete();
        Assert.assertEquals("1 2 3 Size: 3\n", fullDynamicArray.toString());
        Assert.assertEquals(4, fullDynamicArray.getCapacity());
    }

    @Test
    void testDeleteWithArrayContraction() {
        fullDynamicArray.delete();
        Assert.assertEquals("1 2 3 Size: 3\n", fullDynamicArray.toString());
        Assert.assertEquals(4, fullDynamicArray.getCapacity());

        fullDynamicArray.delete();
        Assert.assertEquals("1 2 Size: 2\n", fullDynamicArray.toString());
        Assert.assertEquals(4, fullDynamicArray.getCapacity());

        fullDynamicArray.delete();
        Assert.assertEquals("1 Size: 1\n", fullDynamicArray.toString());
        Assert.assertEquals(4, fullDynamicArray.getCapacity());

        fullDynamicArray.delete();
        Assert.assertEquals("Size: 0\n", fullDynamicArray.toString());
        Assert.assertEquals(1, fullDynamicArray.getCapacity());
    }

    @Test
    void testDeleteFromEmptyDynamicArray() {
        Assertions.assertThrows(IllegalStateException.class, () -> emptyDynamicArray.delete());
    }
}
