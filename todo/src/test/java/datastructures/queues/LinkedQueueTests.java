package datastructures.queues;


import org.junit.Before;

public class LinkedQueueTests extends QueueTests {
    @Before
    public void setUp () throws Exception {
        this.queue = new LinkedQueue<String>();
        this.other = new LinkedQueue<String>();
    }
}
