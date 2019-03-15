/**
 * Created by fdebi on 4/11/2017.
 */
public class Location {
    int SubstringLoc;
    int String;

    public Location (int x, int y)
    {
        this.SubstringLoc = x;
        this.String = y;
    }
    public String toString ()
    {
        return "(" + SubstringLoc + "," + String + ")";
    }
}
