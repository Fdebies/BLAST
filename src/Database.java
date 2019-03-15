/**
 * Created by fdebi on 5/30/2017.
 */
import java.io.IOException;
import java.util.*;

public class Database {
    ArrayList <DNASequence> seq = new ArrayList<>();
    ArrayList <Location> individualLocs;
    Hashtable<String, ArrayList<Location>> map;
    ArrayList<String> segments;
    public List<String> query;
    public int index;
    int Threshold = 11;
    MatchElement matchElement;

    public Database (ArrayList<DNASequence> sequences, ArrayList<String> lines)
    {
        seq = sequences;
        map = new Hashtable<>();
        individualLocs = new ArrayList<>();
        segments = lines;
        matchElement = new MatchElement();
        //index = ValidatedInputReader.getInteger("What is your desired Threshold? ", 11, "Invalid value entered.");
    }
    public void FindMatches(List<String> segQuery)
    {
        query = segQuery;
        System.out.println(query);
        for(String seg : query)
        {
            individualLocs = new ArrayList<>();
                    this.addSegments(seg);

            }
        }
    public ArrayList<DNASequence> ReturnAllSeq()
    {
        return seq;
    }
    public void addSegments (String string)
    {
        index = 0;
        int nextI = 0;
        int nextLength = 11;
        String current = string.substring(0, 11);
            for(String seq : segments)
            {
                index++;
                int i = 0;
                int length;
                 current = string.substring(0, 11);
                for(length = 11; length < seq.length();) {

                    if (current.equals(seq.substring(i, length))) {
                        //System.out.println("MATCH FOUND");
                        if (!map.containsKey(current)) {
                            Location locs = new Location(index, length);
                            individualLocs.add(locs);
                            map.put(current, individualLocs);
                        } else if (map.containsKey(current)) {
                            Location locs = new Location(index, length);
                            map.get(current).add(locs);
                        }
                        int j = nextLength;
                        int h = i;
                        int b = length;
                        int a = nextI;
                        if(j > string.length() || b > seq.length())
                        {
                            int extended = j - Threshold;
                            ExtendMatches(seq, extended);
                        }
                        else {
                            while (string.substring(a, j).equals(seq.substring(h, b))) {
                                if (b++ > seq.length() || j++ > string.length()) {
                                    int extended = j - Threshold;
                                    ExtendMatches(seq, extended);
                                    break;
                                }
                                j++;
                                b++;
                                if (string.substring(a, j).equals(seq.substring(h, b))) {
                                    if (j > Threshold && j < seq.length()) {
                                        Location threshold = new Location(index, j);
                                        ArrayList<Location> thresholdLocs = new ArrayList<>();
                                        thresholdLocs.add(threshold);
                                        matchElement.addToTable(current, thresholdLocs);
                                    } else {
                                        int extended = j - Threshold;
                                        ExtendMatches(seq, extended);
                                    }
                                }
                            }
                        }
                    }

                    else if (!map.containsKey(current)) {
                        map.put(current, individualLocs);
                    }
                    i++;
                    length++;
                    if(length>= seq.length())
                    {
                        if(nextLength > string.length())
                        {

                        }
                        else {
                            current = string.substring(nextI, nextLength);
                            i = 0;
                            length = 11;
                            nextI++;
                            nextLength++;
                        }
                    }
                }
            }
        //System.out.println("Added the segments");

        }


public void printTable()
{
    Set<String> key = map.keySet();
    for(String segment : key)
    {
        System.out.println(segment + "\n" +map.get(segment) );
    }
    matchElement.returnToTable();
}
    public void ExtendMatches(String seq, int max)
    {
        System.out.println("The longest match for this sequence: " + " " + seq + " " +"Is" + " " + max + " " +"Longer than the threshold");
    }

}
