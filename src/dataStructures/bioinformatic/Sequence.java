package dataStructures.bioinformatic;

public class Sequence {
    
    public String sequence;
    public String chromosome;
    public int start;
    public int end;
    
    public Sequence next = null;//Apuntador
    
    
    public Sequence() {
    }

    public Sequence(String sequence, String chromosome, int start, int end) {
        this.sequence = sequence;
        this.chromosome = chromosome;
        this.start = start;
        this.end = end;
    }
    
    public String toString()
    {
        return("Sequence: "+this.sequence+"Chromosome: "+this.chromosome);
    }
    
    public Sequence clone()
  {
      Sequence temp = new Sequence(this.sequence, this.chromosome,this.start,this.end);
      return temp;
  }
    
}

