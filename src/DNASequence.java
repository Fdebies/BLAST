/**
 * Created by fdebi on 4/7/2017.
 */
public class DNASequence {

    private String gi;
    private String desc;
    private String seq;
    public DNASequence( String stringgi, String stringdesc, String stringseq)
    {
        gi = stringgi;
        desc = stringdesc;
        seq = stringseq;
    }
    public String toString()
    {
        return gi + "\n" + desc + "\n" + seq + "End string";
    }
    public String sequence()
    {
        return seq;
    }
}
