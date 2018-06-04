package Order;
import java.io.File;
import java.util.Arrays;

/**
 * the basic Order, orders the files alphabetically.
 */
public class absOrder extends Order{

    public absOrder() {

        this.howTo = "abs";

    }

    File[] runOrder(File[] files){
        Arrays.sort(files);
        return files;
    }
}
