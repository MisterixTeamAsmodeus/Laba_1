import org.example.data.AbstractArray;
import org.example.data.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayListTest {

    @Before
    public void setUp() {
        testArray = new ArrayList<>();

        testArray.add(1);
        testArray.add(2);
        testArray.add(3);
        testArray.add(4);
        testArray.add(5);
        testArray.add(6);
        testArray.add(7);
        testArray.add(8);
        testArray.add(9);
        testArray.add(10);
    }

    @Test
    public void get() {
        Assert.assertEquals(testArray.get(2), new Integer(3));
    }

    @Test
    public void add() {
        testArray.add(15);
        testArray.add(20, 1);
        Assert.assertArrayEquals(testArray.toArray(), new Integer[]{1, 20, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15});
    }

    @Test
    public void set() {
        testArray.set(5, 15);
        Assert.assertArrayEquals(testArray.toArray(), new Integer[]{1, 2, 3, 4, 5, 15, 7, 8, 9, 10});
    }

    @Test
    public void remove() {
        testArray.remove(6);
        testArray.remove(7);
        testArray.remove(10);
        Assert.assertArrayEquals(testArray.toArray(), new Integer[]{1, 2, 3, 4, 5, 8, 9});

    }

    @Test
    public void removeAt() {
        testArray.removeAt(0);
        testArray.removeAt(testArray.size() - 1);
        testArray.removeAt(2);
        Assert.assertArrayEquals(testArray.toArray(), new Integer[]{2, 3, 5, 6, 7, 8, 9});
    }

    @Test
    public void size() {
        Assert.assertEquals(testArray.size(), 10);
        testArray.clear();
        Assert.assertEquals(testArray.size(), 0);
    }

    @Test
    public void isEmpty() {
        Assert.assertFalse(testArray.isEmpty());
        testArray.clear();
        Assert.assertTrue(testArray.isEmpty());
    }

    @Test
    public void contains() {
        Assert.assertFalse(testArray.contains(20));
        Assert.assertTrue(testArray.contains(7));
    }

    @Test
    public void indexOf() {
        Assert.assertEquals(testArray.indexOf(7), 6);
        Assert.assertEquals(testArray.indexOf(15), -1);
    }

    @Test
    public void lastIndexOf() {
        testArray.add(7, 1);
        Assert.assertEquals(testArray.lastIndexOf(7), 7);
    }

    private AbstractArray<Integer> testArray;

}
