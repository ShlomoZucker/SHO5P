package processing;
import processing.Filters.Filter;
import processing.Filters.FilterFactory;
import processing.Orders.Order;
import processing.Orders.OrderFactory;

import java.io.File;

/**
* runs everything! parses the files, filters them, and orders them, all according to CMDfile.
*/
public class OverLord {
    private final static int FILE_DIRECTORY = 0;
    private final static int COMAND_FILE = 0;

    public static void main(String[] args) {
        File[] files = FilesParser.ParseFiles(args[FILE_DIRECTORY]);
        Order order = OrderFactory.createOrder("size");
        Filter filter = FilterFactory.createFilter("between#23#-80");
        File[] filesToPrint = order.runOrder(filter.runFilter(files));
        for (File file: filesToPrint){
            System.out.println(file.getName());
        }
    }
}
