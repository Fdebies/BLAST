import java.util.ArrayList;

/**
 * Created by fdebi on 5/30/2017.
 */
public class Simulation {
    public Simulation()
    {

    }
    public void run()
    {
        String filename = ValidatedInputReader.getString("What is the file?","C:\\Users\\fdebi\\IdeaProjects\\PPBlast\\src\\Viruses.txt");

        int index = ValidatedInputReader.getInteger("What is your desired range? ", 1, "Invalid value entered.");
        DNADataReader dataReader = new DNADataReader(filename, index);
        dataReader.readData();


    }
}
