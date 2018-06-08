package dataStructures.bioinformatic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;

public class GenerateSequences {
    
    public static String chromosome(){
        Random rd = new Random();
        return "chr" + (rd.nextInt(23)+1);
       
        
    }
    
    public static String nucleotide(){
        Random rd = new Random();
        
        switch(rd.nextInt(4)){
            case 0: return "A";
            case 1: return "C";
            case 2: return "G";
            case 3: return "T";
            default:return "";
        }
    }
    
    public static String sequence(int length){
        if(length == 1)
            return nucleotide();
        else
            return nucleotide() + sequence(length - 1);
    }
    
    
    
    public static void main(String[] args){
    try{
        int data = 1000;
        FileWriter writer = new FileWriter("SECUENCIAS.txt");;
        BufferedWriter bw = new BufferedWriter(writer);
        Random rd = new Random();
        int length = rd.nextInt(50) + 1;
        int start = rd.nextInt(1000 + 1);
        
        for (int i = 0; i < data; i++) {
        
        writer.write(sequence(length) + "," + chromosome() + "," + start + "," + (start + length - 1) + "\n");        
        }

        writer.flush();
        writer.close(); 
    }
    catch(Exception e){
        e.printStackTrace();
        System.out.println(e);
    }
    }
    
    SequenceList sequencesList = new SequenceList();
    int max_occurrences = Integer.MIN_VALUE;
    String motif_winner = "";
    
    public void compareMotif(String motif_candidate){
        int counter = counterOccurrences(motif_candidate);
        if(counter > max_occurrences){
            max_occurrences = counter;
            motif_winner = motif_candidate;
        }
        
    }
    
    public int counterOccurrences(String motif_candidate){
        int counter = 0;
        String gen_sequence;
        Sequence temp = sequencesList.head;
        while(temp != null){
            gen_sequence = temp.sequence;
            for (int i = 0; i <= (gen_sequence.length() - motif_candidate.length()); i++) {
                if(gen_sequence.substring(i, i + motif_candidate.length()).equals(motif_candidate)){
                    counter += 1;
                    i += motif_candidate.length() - 1;
                }
            }
            temp=temp.next;
        }
        
        return counter;
    }
    
    public void generateCombinations(String subsequence, int size){
       if(size==1){
           compareMotif(subsequence + "A");
           compareMotif(subsequence + "C");
           compareMotif(subsequence + "G");
           compareMotif(subsequence + "T");
           
       }else{
           generateCombinations(subsequence + "A", size-1);
           generateCombinations(subsequence + "C", size-1);
           generateCombinations(subsequence + "G", size-1);
           generateCombinations(subsequence + "T", size-1);
       }
           
    }
}
