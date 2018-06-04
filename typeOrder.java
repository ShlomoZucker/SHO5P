package Order;
import java.io.File;

/**
 * an Orderer that orders the files according to type (alphabetically).
 */
public class typeOrder extends Order{

    public typeOrder() {

        this.howTo = "type";

    }

    File[] runOrder(File[] files){
        String[] types = new String[files.length];      // make an array that contains all the file types
        for (File file : files){
            String extension = "";

            int i = file.getName().lastIndexOf('.');
            if (i > 0) {
                extension = file.getName().substring(i+1);
            }
            types[i] = extension;
        }

        orderer(types,files);

        return files;
    }

    /**
     * gets the files and the types arrays, and orders the files according to their type.
     * @param types the types of each file, in the same order as the files they represent.
     * @param files the files to be ordered by type.
     */
    private void orderer(String[] types, File[] files) {
        for (int i = 0; i < types.length - 1; i++) {
            boolean flag = true;
            if (types[i].compareTo(types[i + 1]) > 0) {        // this file type is smaller than the next

                String tempStr = types[i];                              // switch between them
                types[i] = types[i + 1];
                types[i + 1] = tempStr;

                File tempFile = files[i];
                files[i] = files[i + 1];
                files[i + 1] = tempFile;

                flag = false;
            }
            else {
                if (!flag){                                 // we're not done ordering, restart
                    i = -1;
                }
            }
        }
    }
}
