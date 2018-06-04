package processing;

import processing.Filters.Filter;
import processing.Orders.Order;

import java.io.File;

/**
 * this is a wrapper class for Filter and Order and allows us to have two of them together and thus avoid
 * problems.
 */
public class Processor {
    private Filter filter;
    private  Order order;

    Processor(Filter givenfilter, Order givenorder){
        filter = givenfilter;
        order = givenorder;
    }
    public File[] proccess(File[] files){
        return order.runOrder(filter.runFilter(files));
    }
}
