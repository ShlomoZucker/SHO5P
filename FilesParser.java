package processing;

import java.io.File;

public class FilesParser {

    public static File[] ParseFiles(String sourcedir){
        File folder = new File(sourcedir);
        return folder.listFiles();
    }
}
