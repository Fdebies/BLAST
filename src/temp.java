/*
import java.io.IOException;
import java.util.ArrayList;

*/
/**
 * Created by fdebi on 4/16/2017.
 *//*

public class temp {
    private ArrayList<SubStringLocs> substrings = new ArrayList<SubStringLocs>();
    private ArrayList<String> subs = new ArrayList<String>();
    private String string;
    private int index;
    int arrayindex = 0;
    private DNADataReader seq;
    public Indexer()
    {
        string = ValidatedInputReader.getString("What is the desired file:", "C:\\Users\\fdebi\\IdeaProjects\\Indexing\\src\\TestData.txt");
        index = ValidatedInputReader.getInteger("What is your desired range? ", 4, "Invalid value entered.");
        seq = new DNADataReader(string);
    }
    public void run()
    {
        try
        {
            Location loc = new Location (arrayindex, index);
            for(String reader : seq.getAllsequences())
            {

                int length = 4;
                for(int i = 0; i < reader.length(); i++)
                {
                    int h = 0;
                    int j;
                    length = i + length;
                    if(length > reader.length()) {
                        length = reader.length();
                    }
                    if (index > reader.length()) {
                        index = reader.length();
                    }
                        String smallseq = (reader.substring(h, index));

                    for(j = 0; j < substrings.size(); j++) {
                        //System.out.println(subs.get(j));
                        SubStringLocs sub = substrings.get(j);
                        //System.out.println(sub);
                        if(smallseq.equals(sub))
                        {
                            sub.addLocation(new Location(h, index));
                        }
                        else
                        {
                            substrings.add(new SubStringLocs(smallseq, new Location(h, index)));
                        }
                    }
                }

            }
        }
        catch (IOException e)
        {
            System.err.print("Unknown error in adding the Substring locations");
        }
    }
    public void printall()
    {
        DNADataReader data = new DNADataReader(this.string);
        data.readData();
        System.out.println("\n");
        System.out.println(substrings.size());
        for(SubStringLocs loc : substrings)
        {
            for(String substring : subs) {
                System.out.println("The substring: " + substring +  " " + "Locations: " + loc + ".");
            }
        }
        for(String reader : data.getAllsequences())
        {
            System.out.println("Sequences: " + reader);
        }

    }
}*/
