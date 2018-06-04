package Order;
import java.io.File;

/**
 * an Orderer that orders the files according to type (alphabetically).
 */
public class sizeOrder extends Order{

    public sizeOrder() {

        this.howTo = "size";

    }

    File[] runOrder(File[] files){
        double[] sizes = new double[files.length];      // make an array that contains all the file sizes
        for (int i=0; i<sizes.length; i++){
            sizes[i] = files[i].length();
        }

        orderer(sizes,files);

        return files;
    }

    /**
     * gets the files and the types sizes, and orders the files according to their size.
     * @param sizes the size of each file, in the same order as the files they represent.
     * @param files the files to be ordered by size.
     */
    private void orderer(double[] sizes, File[] files) {
        for (int i = 0; i < sizes.length - 1; i++) {
            boolean flag = true;
            if(i < sizes.length -1) {
                if (sizes[i] > sizes[i + 1]) {        // this file size is bigger than the next

                    double tempInt = sizes[i];  // switch between them
                    sizes[i] = sizes[i + 1];
                    sizes[i + 1] = tempInt;

                    File tempFile = files[i];
                    files[i] = files[i + 1];
                    files[i + 1] = tempFile;

                    flag = false;           // there was a switch made, make sure we go over it all again
                }
            }
            else {
                if (!flag){                                 // we're not done ordering, restart
                    i = -1;
                }
            }
        }
    }
}
