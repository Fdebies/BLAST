// Import statements go here.  For example,
// import java.awt.Color;
// import java.util.ArrayList;
// import java.util.Random;

import java.io.IOException;
import java.util.ArrayList;

/**
 *  Lab (or Programming Project) X Name of Lab or PP<br>
 *
 *  The <code>MainClassTemplate</code> class provides a main method
 *  for a program that does X.
 *
 *  A more detailed description goes here, if necessary.
 *  <br> <br>
 *  Created <br>
 *     [the date], [your name(s)]<br>
 *     With assistance from  [people who helped (including instructor/TAs)]<br>
 *  Modifications <br>
 *     [the date], [your name(s)], [the reason]<br>
 *
 *  @author [your name]   [with assistance from... or working alongside ...]
 *  @author [your partner's name]   [with assistance from or working alongside]
 *  @version [date]
 */
public class Main
{
    /*
     *  The main function initiates execution of this program.
     *    @param    String[] args not used in this program
    */
    public static void main(String[] args) throws IOException
    {

        Debug.turnOn();
        //Debug.print("Test");
        //Creates an indexer class which would be used to prompt user about the DNA sequences.
       Simulation sim = new Simulation();
       sim.run();
        System.out.println ("Program done.");

    }//end main

}//end class