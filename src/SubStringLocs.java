
import javax.xml.stream.*;
import java.io.IOException;
import java.lang.Object;
import java.util.ArrayList;
import java.util.ListIterator;

/* * Created by fdebi on 4/9/2017.*/
public class SubStringLocs {
    ArrayList<Location> locations;
    //ArrayList<String> substrings = new ArrayList<String>();
    //String reading = null;
    String sequence;

    public SubStringLocs(String seq, Location location) throws IOException {
        sequence = seq;
        this.locations = new ArrayList<Location>();
        this.locations.add(location);
    }

    public void addLocation(Location loc) {
                locations.add(loc);
    }
    public ArrayList<Location> printall()
    {
        return locations;
    }
    public String getSequence()
    {
        return sequence;
    }

    public String toString(){
            return "For the SubString sequence: " + sequence + " " + locations.toString() + ".";
        }
    }

