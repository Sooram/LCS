import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;




public class Test {
	public static void main(String args[])
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		

			try
			{
				
				String input = br.readLine();
				
				String[] files = input.split("\\s");
				
				readFile(files);
				
				
				
			}
			catch (IOException e)
			{
				System.out.println("입력이 잘못되었습니다. 오류 : " + e.toString());
			}
		
	}

	private static void readFile(String[] files)
	{ // read file and insert all the substrings into the hash table
		String line;
		
		int lineNo = 0;
		ArrayList<String> a = new ArrayList<>();
		
		
			
		try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(files[0]);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
            	
                a.add(line.replaceAll(" ", ""));
                
            }   

            // close file
            bufferedReader.close();  
            
            
            FileReader fileReader2 = new FileReader(files[1]);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
            boolean matched = false;
            while((line = bufferedReader2.readLine()) != null) {
            	matched = true;
            	if(a.get(lineNo).length() == line.length()) {
            		for (int i = 0; i < line.length(); i ++) {
            			if(a.get(lineNo).charAt(i) != line.charAt(i)) {
            				matched = false;
            			
            			}
            		}
            	}
            	else matched = false; 
            	
            	if(matched == false) {
            		System.out.println("unmatched at " + lineNo);
        			System.out.println(a.get(lineNo));
        			System.out.println(line);
            	}
                ++lineNo;
            } 
            if(matched == true){
            	System.out.println("all matched");
            }
            
            bufferedReader2.close();  
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + files[0] + "'");                
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + files[0] + "'");                  
        }
		
        
	} // end readFile
}
