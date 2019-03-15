import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by fdebi on 5/30/2017.
 */
public class MatchElement {
    Hashtable<String, ArrayList<Location>> matchElements;
    public MatchElement()
    {
        matchElements = new Hashtable<>();
    }
    public void addToTable(String seq, ArrayList<Location> locations)
    {
        matchElements.put(seq, locations);
    }
    public Hashtable<String, ArrayList<Location>> returnToTable()
    {
        System.out.println(matchElements);
        return matchElements;
    }
}
