
public class LCS 
{
	private String a;
	
	public LCS(String str)
	{
		a = str;
	}
	
	public int length()
	{
		return a.length();
	}
	
	public char charAt(int index)
	{
		if(index == 0) {
			return '0';
		}
		else {
			return a.charAt(index-1);
		}
	}
	
	public String toString()
	{
		String str = a;
		
		return str;
	}

	public Matrix<Integer> lenMatrix(LCS other)
	{ // matrix of length
		int m = this.length();
		int n = other.length();
		
		Matrix<Integer> table = new Matrix<>(m, n);
		
		int i, j;
		for(i=0; i<=m; i++) {
			table.setVal(i, 0, 0);
		}
		for(j=0; j<=n; j++) {
			table.setVal(0, j, 0);
		}
		
		for(i=1; i<=m; i++){
			for(j=1; j<=n; j++) {
				if(this.charAt(i) == other.charAt(j)) {
					table.setVal(i, j, table.getVal(i-1, j-1) + 1);
				}
				else if(table.getVal(i-1, j) >= table.getVal(i, j-1)) {
					table.setVal(i, j, table.getVal(i-1, j));
				}
				else {
					table.setVal(i, j, table.getVal(i, j-1));
				}
			}
		}
		
		return table;
	}
	
	public Matrix<Character> dirMatrix(LCS other, Matrix<Integer> lenMatrix)
	{ // matrix of direction
		
		int m = this.length();
		int n = other.length();
		
		Matrix<Character> table = new Matrix<>(m, n);
		
		int i, j;
		for(i=0; i<=m; i++) {
			table.setVal(i, 0, '0');
		}
		for(j=0; j<=n; j++) {
			table.setVal(0, j, '0');
		}
		
		for(i=1; i<=m; i++){
			for(j=1; j<=n; j++) {
				if(this.charAt(i) == other.charAt(j)) {
					table.setVal(i, j, 'd');
				}
				else if(lenMatrix.getVal(i-1, j) >= lenMatrix.getVal(i, j-1)) {
					table.setVal(i, j, 'u');
				}
				else {
					table.setVal(i, j, 'l');
				}
			}
		}	
		
		return table;
	}
	
	public void printLCS(Matrix<Character> dirMatrix, LCS other, Matrix<Integer> lenMatrix)
	{
		String lcsA, lcsB;
		lcsA = this.printThis(dirMatrix, this.length(), other.length(), lenMatrix);
		System.out.println(lcsA);
		lcsB = other.printOther(lcsA);
		System.out.println(lcsB);
	}

	public String printThis(Matrix<Character> dir, int row, int col, Matrix<Integer> len)
	{ // print the lcs result for the first input
		String lcs = new String();
		
		if (row == 0 || col == 0) {
			while(row != 0){
				lcs += '_';
				row--;
			}
			return lcs;
		}
		
		if(dir.getVal(row, col) == 'd') {
			if(len.getVal(row-1, col) == len.getVal(row, col)) { // for left most aligned value
				lcs = this.printThis(dir, row-1, col, len);
				lcs += '_';
			}
			else {
				lcs = this.printThis(dir, row-1, col-1, len);
				lcs += this.charAt(row);
			}
		}
		else if(dir.getVal(row, col) == 'u') {
			lcs = this.printThis(dir, row-1, col, len);
			lcs += '_';
		}
		else {
				lcs = this.printThis(dir, row, col-1, len);
		}
		
		return lcs;
	}
	
	public String printOther(String a)
	{ // print the lcs result for the second input
      // compare each character of the second input with the lcs result of the first input
		String thisStr = this.toString();
		String b = new String();
		int j = 0;
	
			for(int i=0; (i<a.length() && j < 100); i++) {
				if (a.charAt(i) == '_') {
					continue;
				}
				while(a.charAt(i) != thisStr.charAt(j)) {
					b += '_';
					j++;
				}
				b += thisStr.charAt(j);
				j++;
			}
			while(j < this.length()) {
				b += '_';
				j++;
			}
		
		return b;
		
	}

}
