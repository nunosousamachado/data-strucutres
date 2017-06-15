package datastructures.bags;


import org.junit.Before;

public class LinkedBagTests extends BagTests {

    @Before
    public void setUp () throws Exception {
        this.bag = new LinkedBag<String>();
        this.other = new LinkedBag<String>();
    }
}
