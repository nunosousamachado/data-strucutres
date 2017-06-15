package datastructures.queues;


import org.junit.Before;

public class DynamicArrayQueueTests extends QueueTests {
    @Before
    public void setUp () throws Exception {
        this.queue = new DynamicArrayQueue<String>();
        this.other = new DynamicArrayQueue<String>();
    }
}
