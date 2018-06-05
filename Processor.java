package processing;

import processing.Filters.Filter;
import processing.Orders.Order;

import java.io.File;

/**
 * this is a wrapper class for Filter and Order and allows us to have the both of them together under
 * one parent classe, which allows us to work on them and process them using the same bunch of code.
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
