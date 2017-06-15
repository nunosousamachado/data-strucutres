package datastructures.bags;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public abstract class BagTests {

    protected Bag<String> bag;
    protected Bag<String> other;

    @Test(expected = IllegalArgumentException.class)
    public void add_Should_throw_exception_When_element_is_null() throws Exception {

        this.bag.add(null);
    }

    @Test
    public void add_Should_add_element_When_element_is_valid () throws Exception {

        this.bag.add("a");

        Assert.assertEquals(1, this.bag.size());
        Assert.assertFalse(this.bag.isEmpty());
        Assert.assertTrue(this.bag.contains("a"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addAll_Should_throw_am_exception_When_argument_is_null() throws Exception {
        this.bag.addAll(null);
    }

    @Test
    public void addAll_Should_throw_an_exception_and_add_no_element_When_some_element_is_null () throws Exception {
        List<String> elements = Arrays.asList("a", "b", "c", null);

        try {
            this.bag.addAll(elements);

            Assert.fail("didn't throw any exception!");
        }
        catch (IllegalArgumentException ex) {
            // everything ok here
        }
        catch (Exception ex) {
            Assert.fail("throw an exception but not the expected one!");
        }

        Assert.assertTrue(this.bag.isEmpty());
        Assert.assertEquals(0, this.bag.size());
        Assert.assertFalse(this.bag.contains("a"));
        Assert.assertFalse(this.bag.contains("b"));
        Assert.assertFalse(this.bag.contains("c"));
    }

    @Test
    public void addAll_Should_all_elements_to_the_bag_When_all_elements_are_valid () throws Exception {
        List<String> elements = Arrays.asList("a", "b", "c", "d");

        this.bag.addAll(elements);

        Assert.assertFalse(this.bag.isEmpty());
        Assert.assertEquals(4, this.bag.size());
        Assert.assertTrue(this.bag.contains("a"));
        Assert.assertTrue(this.bag.contains("b"));
        Assert.assertTrue(this.bag.contains("c"));
        Assert.assertTrue(this.bag.contains("d"));
    }

    @Test
    public void equals_Should_return_false_When_other_is_not_a_bag () throws Exception {

        boolean result = this.bag.equals(new Object());
        
        Assert.assertFalse(result);
    }

    @Test
    public void equals_Should_return_false_When_bags_have_different_sizes () throws Exception {
        this.bag.addAll(Arrays.asList("a", "b"));
        this.other.addAll(Arrays.asList("a","b","c"));

        boolean result = this.bag.equals(this.other);

        Assert.assertFalse(result);
        Assert.assertNotEquals(this.bag.hashCode(), this.other.hashCode());
    }

    @Test
    public void equals_Should_return_false_When_bags_have_same_size_but_different_elements () throws Exception {
        this.bag.addAll(Arrays.asList("a", "b"));
        this.other.addAll(Arrays.asList("a","c"));

        boolean result = this.bag.equals(this.other);

        Assert.assertFalse(result);
        Assert.assertNotEquals(this.bag.hashCode(), this.other.hashCode());
    }


    @Test
    public void equals_Should_return_true_When_bags_have_same_elements_in_same_order () throws Exception {
        this.bag.addAll(Arrays.asList("a","b"));
        this.other.addAll(Arrays.asList("a","b"));

        boolean result = this.bag.equals(this.other);

        Assert.assertTrue(result);
        Assert.assertEquals(this.bag.hashCode(), this.other.hashCode());
    }
}
