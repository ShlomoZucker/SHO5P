package processing;

import processing.Filters.Filter;
import processing.Filters.FilterFactory;
import processing.Orders.Order;
import processing.Orders.OrderFactory;
import java.io.*;

public class ParseCmdFile {
    private static final String FILTER_PARAGRAPH = "FILTER";
    private static final String ORDER_PARAGRAPH = "ORDER";
    private static final String NOT = "NOT";
    private static final String ALL = "all";

    public static Processor[] parse(File file) {
        String[] lines = FileToLines.getLines(file);
        Processor[] processors = new Processor[lines.length/3];
        int procIndex = 0;
        int lineIndex = 0;
        while (lineIndex < lines.length){
            Filter filter = null;
            Order order = null;
            if (!lines[lineIndex++].equals(FILTER_PARAGRAPH)){                      // no FILTER          
                throw new BAD_FORMAT_ERROR(FILTER_PARAGRAPH, lineIndex);
            }else{
                try {
                    filter = FilterFactory.createFilter(lines[lineIndex]);
                }catch (RuntimeException e){
                    System.err.print("Warning in line " + procIndex+ "\n");
                    filter = FilterFactory.createFilter(FilterFactory.ALL);
                }
                if (!lines[++lineIndex].equals(ORDER_PARAGRAPH)){                   // no ORDER
                    throw new BAD_FORMAT_ERROR(ORDER_PARAGRAPH, lineIndex);
                }else {
                    try{
                        if(lines[++lineIndex].equals(FILTER_PARAGRAPH)) {           
                            throw new RuntimeException();
                        }else
                            order = OrderFactory.createOrder(lines[lineIndex]);
                    }catch (NullPointerException e){
                        order = OrderFactory.createOrder("abs");                    // the default order
                    }catch (RuntimeException e){
                        System.err.print("Warning in line " + procIndex+ "\n");
                        order = OrderFactory.createOrder("abs");
                    }
                    lineIndex++;
                    processors[procIndex++] = new Processor(filter, order);
                }
            }
        }
        return processors;
    }
}


