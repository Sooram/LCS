import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


public class FindLCS 
{
	public static void main(String args[])
	{
		
		String input1 = "http://epigenomics.snu.ac.kr/teaching/2016/algorithm/HW3/geneA.fasta";
		String input2 = "http://epigenomics.snu.ac.kr/teaching/2016/algorithm/HW3/geneB.fasta";
		
		Bin<String> binA = readInput(input1, 'A');
		Bin<String> binB = readInput(input2, 'B');
		
		binA.getLCS(binB);
		binB.getLCS(binA);

	}
	
	public static Bin<String> readInput(String adr, char binName) 
	{ // read the DNA sequence and store it into a bin
		String line, gene = new String();
		Bin<String> bin = new Bin<>(binName);
		
		try {
			URL url = new URL(adr);

			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		
			in.readLine();	// exclude the first line
            while((line = in.readLine()) != null) {	// get the DNA sequence
            	gene += line;	  
            }
            
            while(gene.length() >= 100){ 
            	// split the DNA sequence into subsequences each with 100 characters and add them to 'bin'
            	bin.add(gene.substring(0, 100));
            	gene = gene.substring(50);	
            }
            bin.add(gene);
            
            // close file
            in.close();       
        }
		catch( MalformedURLException ex) {
			System.out.println("Wrong URL");
		}
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + adr + "'");                
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + adr + "'");                  
        }
		
		return bin;
	}

}
