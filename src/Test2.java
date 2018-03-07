import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


public class Test2 
{
	public static void main(String args[])
	{
		
		
		String input1 = null;
		for(int i = 0; i < 5; i ++) {
			input1 += "abcdefghijklmnopqrstuvwxyz";
		}
			Bin<String> binA = readInput(input1, 'A');
		//	Bin<String> binB = readInput(input2, 'B');
			
		//	binA.getLCS(binB);
		//	binB.getLCS(binA);
						
		
	
	}
	
	public static Bin<String> readInput(String gene, char binName) 
	{
	//	String line, gene = new String();
		Bin<String> bin = new Bin<>(binName);
		

	//		URL url = new URL(adr);

//			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		
//			in.readLine();	// exclude the first line
   //         while((line = in.readLine()) != null) {	// get the DNA sequence
  //          	gene += line;	  
 //           }
//            
            while(gene.length() >= 100){ 
            	// split the DNA sequence into subsequences each with 100 characters and add them to 'bin'
            	bin.add(gene.substring(0, 100));
            	gene = gene.substring(50);	
            }
            bin.add(gene);
            
            // close file
     //       in.close();       
   
		
		return bin;
	}
}