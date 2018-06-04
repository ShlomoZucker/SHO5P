package processing;

class BAD_FORMAT_ERROR extends RuntimeException{
    private String missingPart;
    private int line;
    BAD_FORMAT_ERROR(String part, int atLine){
        missingPart = part;
        line = atLine;
    }
    public void printError(){
        System.out.print("Bad " + missingPart + " at line: " + line);
    }
}
