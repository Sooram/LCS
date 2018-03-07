import java.util.ArrayList;


public class Bin<T> extends ArrayList<T>
{
	private char name;
	
	public Bin(char c) {
		super();
		name = c;
	}
	
	public static int binIndex(int index) {		
		return (50 * index);
	}

	public void getLCS(Bin<T> other)
	{
		int i, j;
		int current, max = 0, maxIndex = 0;
		for(i=0; i<this.size(); i++) {
			LCS geneA = new LCS(this.get(i).toString());
			max = 0;
			Matrix<Integer> maxLen = null;
			for(j=0; j<other.size(); j++) { // get the longest common sequence
				LCS geneB = new LCS(other.get(j).toString());
				Matrix<Integer> len = geneA.lenMatrix(geneB);
				current = len.getLastVal();
				if(current > max) {
					max = current;
					maxIndex = j;
					maxLen = len;
				}
			}
			
			LCS geneB = new LCS(other.get(maxIndex).toString());
			Matrix<Character> dir = geneA.dirMatrix(geneB, maxLen);
			
			System.out.println(this.name + String.valueOf(binIndex(i)) + ',' + other.name + String.valueOf(binIndex(maxIndex)));
			geneA.printLCS(dir, geneB, maxLen);
			
		}
	}
	
	
	private static final long serialVersionUID = 1L;

	

}
