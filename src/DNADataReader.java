// Class: DNADataReader
//
// Author: Pamela Cutter & Alyce Brady
//
// Created on May 23, 2006
// Modified November 15, 2006
// Modified November 19, 2006 to extend DNASeqReader

import java.io.IOException;
import java.util.ArrayList;

/**
 * This class contains code to read DNA sequence data in from
 * a file.  It must be put into a data structure as it is read.
 * The data structure should be chosen by the modifier of this
 * class.
 *
 * @author Pamela Cutter
 * @author Alyce Brady
 * @version Nov 19, 2006
 */
public class DNADataReader extends DNASeqReader
{
    private String filename;
    private int numLinesNucleoInfo;
    ArrayList<String> allsequences;
    ArrayList<DNASequence> data;
    DNASequence sequence;
    Database database;
    String QueryFile;
    int Threshold;


    /** Constructs an object that reads DNA sequence information
     *  from the given file.  The data is assumed to be in the
     *  following format:
     *      GenInfoIdentifier  A string describing the sequence
     *      a group of nucleotide blocks, spanning 1 or more lines
     *  where the number of lines of nucleotide blocks per sequence,
     *  is provided as a parameter. For example, if the parameter were
     *  1, the following would be a valid single sequence.
     *      94717691 Campo. sono. ichnovirus segment W, complete sequence
     *      ctccaccaaa ctttgagagt cactacaaaa acattcacga tcgcttcact
     */
    public DNADataReader(String filename, int numLinesNucleoInfo)
    {
        super(filename);
        this.filename = filename;
        this.numLinesNucleoInfo = numLinesNucleoInfo;
        this.allsequences = new ArrayList<>();
         data = new ArrayList<>();
         database = new Database(data, getAllsequences());
        QueryFile = ValidatedInputReader.getString("What is the file?","C:\\Users\\fdebi\\IdeaProjects\\PPBlast\\src\\Queries.txt");
        Threshold = ValidatedInputReader.getInteger("What is your desired range? ", 11, "Invalid value entered.");
    }

    /** Reads DNA sequence information from the given file, which must be
     *  in the format specified in the documentation for the DNADataReader
     *  constructor.
     *  Precondition: the file must have been successfully opened for
     *                reading.
     */
    public Database readData()    // *** Replace void with the data structure type ***
    {
        // *** Create a data structure here to hold the entire database ***
        // *** of sequence info ***


        try
        {
            // Read lines until hitting a null or blank line.
            // Read complete lines at a time, until end of file.
            String next;
            while ( (next = this.readLine()) != null)
            {
                //Debug.println(next);

                if ( ! next.equals("") )
                    data.add(readInfoForOneSequence(next));
                   //System.out.println(readInfoForOneSequence(next) + " " + "In Read Data");
            }
        }
        catch (IOException e)
        {
            System.err.println("Could not read file " + filename);
             /* *** null *** */
        }
        // Debugging: Print out the elements in your data structure.
        //Debug.println("No data structure created to print out (yet).");


        //database.ReturnAllSeq();
        QueryReader queryReader = new QueryReader(QueryFile);
        database.FindMatches(queryReader.readData());
        database.printTable();
        return database;
    }

    /** Reads in the sequence information for a single DNA sequence in the file.
     *      @param firstLine    the first line of info for this sequence
     *      @throws IOException
     */
    @SuppressWarnings("InfiniteLoopStatement")
    private DNASequence readInfoForOneSequence(String firstLine) throws IOException
    {
        // Put the space-separated items from the line into an array.
        String[] items = firstLine.split(" ");

        // The first line should contain the GenInfo identifier (GI)
        // and sequence description.
        String gi = items[0];     // GenInfo identifier
        String desc = "";         // Description
        for (int i = 1; i < items.length; i++)
            desc += items[i] + " ";

        Debug.println("Line " + this.getLineNumber() + ": " +
                gi + ", " + desc);

        // Then read in the lines with the sequence information.
        String seq = readSequenceString(numLinesNucleoInfo);
        Debug.println("Just read " + seq);

        // *** Create a DNA sequence object from gi, desc, and seq. ***

         sequence = new DNASequence(gi, desc, seq);


        allsequences.add(seq);
        // *** Add it to your data structure. ***
        data.add(sequence);
        Debug.println("Should be adding an element to the data structure");

        return sequence;
    }
    public ArrayList<String> getAllsequences(){
        // Read lines until hitting a null or blank line.
        /*try {
            String nextLine;
            while (!((nextLine = this.readLine()) == null))
            //&&    !nextLine.trim().equals(""))

            {

                String nucleotide = readSequenceString(numLinesNucleoInfo);
                //Using contains method to rule out the String information rather than the sequence itself
                //Alll the descriptions have a - so I rule out the strings that do contain that character
                String tester = ",";
                if(!readSequenceString(numLinesNucleoInfo).contains(tester)) {
                    //continue;


                    allsequences.add(nucleotide);
                    System.out.println("Getitng all the sequences.");
                    System.out.println(nucleotide);
                }
            }

        }

        catch(IOException e)
        {
            System.err.print("Exception");
        }
*/
        //System.out.println(allsequences);
        return allsequences;
    }
}
