package processing;

/**
* an error for bad formatting, e.g. FiLtEr instead of FILTER.
*/
class BAD_FORMAT_ERROR extends RuntimeException{
    // paramaters -
    
    private String missingPart;             // what's missing
    
    private int line;                       // where is it missing
    
    /**
    * default constructor.
    */
    BAD_FORMAT_ERROR(String part, int atLine){
        missingPart = part;
        line = atLine;
    }
    
    /** 
    * prints out the error.
    */
    public void printError(){
        System.out.print("Bad " + missingPart + " at line: " + line);
    }
}
