package processing;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileToLines {
    public static String[] getLines(File file){
        List<String> lines = new ArrayList<>();
        String[] commands = new String[0];
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (bufferedReader.readLine() != null)
                lines.add(bufferedReader.readLine());
            bufferedReader.close();
            fileReader.close();
            commands = new String[lines.size()];
            int index = 0;
            for (String line: lines)
                commands[index++] = line;
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + file + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + file + "'");
        }
        return commands;
    }
}
