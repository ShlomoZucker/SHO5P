package Order;

import java.io.File;

/**
 * an order abstraction, that can order the file names after being filtered.
 */
abstract class Order {

    // attributes -

    /**
     * the type of ordering to be done.
     */
    String howTo;


    // constructors -

    Order(){
    }


    // methods -

    /**
     * does the ordering!
     * @return the names of the files, after putting them in order.
     */
    private String[] runOrder(){
        return null;
    }
}
