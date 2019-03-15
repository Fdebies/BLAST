import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by fdebi on 4/16/2017.
 */
public class Indexer {
    private ArrayList<SubStringLocs> substrings = new ArrayList<SubStringLocs>();
    private String string;
    private int index;
    int arrayindex = 0;
    private DNADataReader seq;
    private Database data;
    public Indexer( String valid, DNADataReader dataReader)
    {
        string = valid;
        index = 11;
        seq = dataReader;
    }
    public void run()
    {
        try
        {
            Location loc = new Location (arrayindex, index);

            for(String reader : seq.getAllsequences())
            {

                for(int i = 0; i < reader.length() - index; i++)
                {
                    int j;
                    for (j = 0; j < substrings.size(); j++) {
                        SubStringLocs sub = substrings.get(j);
                        //System.out.println(sub);
                        if (sub.getSequence().equals(reader.substring(i, i + index))) {
                            substrings.get(j).addLocation(new Location(arrayindex, i));
                        }
                    }
                    if(j == substrings.size())
                    {
                        substrings.add(new SubStringLocs(reader.substring(i, i + index), loc));
                    }
                }

            }
            arrayindex++;
        }
        catch (IOException e)
        {
            System.err.print("Unknown error in adding the Substring locations");
        }
    }
    public void printall()
    {
        DNADataReader data = new DNADataReader(this.string, 1);
        data.readData();
        System.out.println("\n");
        System.out.println(substrings.size());
        for(SubStringLocs loc : substrings)
        {
                System.out.println("Locations: " + loc + ".");
        }
        for(String reader : data.getAllsequences())
        {
            System.out.println("Sequences: " + reader);
        }
    }
    public ArrayList<SubStringLocs> getSequence()
    {
        for (int i = 0; i < substrings.size(); i++)
        {
          substrings.get(i);
        }
        return substrings;
    }
    public Hashtable toHash()
    {
        Hashtable<String, ArrayList<Location>> table = new Hashtable<>();
        for (int i = 0; i < substrings.size(); i++)
        {
            table.put(substrings.get(i).getSequence(), substrings.get(i).printall());
        }
        System.out.println("Printing table");
        System.out.println(table);
        return table;
    }

}