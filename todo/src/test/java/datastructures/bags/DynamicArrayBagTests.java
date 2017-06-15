package datastructures.bags;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DynamicArrayBagTests extends BagTests {

    @Before
    public void setUp () throws Exception {
        this.bag = new DynamicArrayBag<String>();
        this.other = new DynamicArrayBag<String>();
    }

    @Test
    public void add_Should_add_element_and_grow_array_When_bag_is_full() {

        this.bag.add("a");
        this.bag.add("b");
        this.bag.add("c");
        this.bag.add("d");
        this.bag.add("e");

        Assert.assertFalse(this.bag.isEmpty());
        Assert.assertEquals(5, this.bag.size());
        Assert.assertTrue(this.bag.contains("a"));
        Assert.assertTrue(this.bag.contains("b"));
        Assert.assertTrue(this.bag.contains("c"));
        Assert.assertTrue(this.bag.contains("d"));
        Assert.assertTrue(this.bag.contains("e"));
    }
}
