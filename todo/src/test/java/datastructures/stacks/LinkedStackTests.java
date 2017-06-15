package datastructures.stacks;


import org.junit.Before;

public class LinkedStackTests extends StackTests {

    @Before
    public void setUp () throws Exception {
        this.stack = new LinkedStack<String>();
        this.other = new LinkedStack<String>();
    }
}
