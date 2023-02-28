package proj4;
/**
 * The Client class creates a new Converter for a file and tells it to convert().
 * 
 * @author Claudia Porto
 * @version 11/1/2022
 */

public class Client
{
    public static void main(String[] args)
    {
        Converter converter = new Converter("src/proj4/proj4_input.txt");
        converter.convert();
    }
}
