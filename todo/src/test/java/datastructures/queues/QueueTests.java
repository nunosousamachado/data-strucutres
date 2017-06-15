package datastructures.queues;


import org.junit.Assert;
import org.junit.Test;

public abstract class QueueTests {

    protected Queue<String> queue;
    protected Queue<String> other;

    @Test(expected = IllegalArgumentException.class)
    public void enqueue_Should_throw_an_exception_When_element_is_null () throws Exception {
        this.queue.enqueue(null);
    }

    @Test
    public void enqueue_Should_add_new_element_When_elements_is_valid () throws Exception {
        this.queue.enqueue("Item");

        Assert.assertEquals(1, this.queue.size());
        Assert.assertFalse(this.queue.isEmpty());
        Assert.assertTrue(this.queue.contains("Item"));

    }

    @Test
    public void enqueue_Should_add_several_elements () throws Exception {
        this.queue.enqueue("Item1");
        this.queue.enqueue("Item2");
        this.queue.enqueue("Item3");
        this.queue.enqueue("Item4");
        this.queue.enqueue("Item5");

        Assert.assertEquals(5, this.queue.size());
        Assert.assertFalse(this.queue.isEmpty());
        Assert.assertTrue(this.queue.contains("Item1"));
        Assert.assertTrue(this.queue.contains("Item2"));
        Assert.assertTrue(this.queue.contains("Item3"));
        Assert.assertTrue(this.queue.contains("Item4"));
        Assert.assertTrue(this.queue.contains("Item5"));

    }

    @Test(expected = IllegalStateException.class)
    public void peek_Should_throw_an_exception_When_queue_is_empty () throws Exception {
        this.queue.peek();
    }

    @Test
    public void peek_Should_return_first_element_When_queue_has_elements () throws Exception {
        this.queue.enqueue("Item1");
        this.queue.enqueue("Item2");

        String element = this.queue.peek();

        Assert.assertEquals(2, this.queue.size());
        Assert.assertEquals("Item1", element);

    }

    @Test(expected = IllegalStateException.class)
    public void dequeue_Should_throw_an_exception_When_queue_is_empty () throws Exception {
        this.queue.dequeue();
    }

    @Test
    public void dequeue_Should_return_first_element_and_remove_it_When_queue_has_elements () throws Exception {
        this.queue.enqueue("Item1");
        this.queue.enqueue("Item2");

        String element = this.queue.dequeue();

        Assert.assertEquals(1, this.queue.size());
        Assert.assertEquals("Item1", element);

    }

    @Test
    public void equals_Should_return_false_When_other_is_not_a_queue () throws Exception {

        boolean result = this.queue.equals(new Object());

        Assert.assertFalse(result);
    }

    @Test
    public void equals_Should_return_false_When_queues_have_different_sizes () throws Exception {
        this.queue.enqueue("a");

        boolean result = this.queue.equals(this.other);

        Assert.assertFalse(result);
        Assert.assertNotEquals(this.queue.hashCode(), this.other.hashCode());

    }

    @Test
    public void equals_Should_return_false_When_queues_have_same_size_but_different_elements () throws Exception {
        this.queue.enqueue("a");
        this.other.enqueue("b");

        boolean result = this.queue.equals(this.other);

        Assert.assertFalse(result);
        Assert.assertNotEquals(this.queue.hashCode(), this.other.hashCode());

    }

    @Test
    public void equals_Should_return_false_When_queues_have_same_elements_but_in_different_order () throws Exception {
        this.queue.enqueue("a");
        this.queue.enqueue("b");
        this.other.enqueue("b");
        this.other.enqueue("a");

        boolean result = this.queue.equals(this.other);

        Assert.assertFalse(result);
        Assert.assertNotEquals(this.queue.hashCode(), this.other.hashCode());

    }

    @Test
    public void equals_Should_return_true_When_queues_have_same_elements_in_same_order () throws Exception {
        this.queue.enqueue("a");
        this.queue.enqueue("b");
        this.other.enqueue("a");
        this.other.enqueue("b");

        boolean result = this.queue.equals(this.other);

        Assert.assertTrue(result);
        Assert.assertEquals(this.queue.hashCode(), this.other.hashCode());

    }
}
