import java.util.ArrayList;

public class Matrix<T> 
{
	private ArrayList<ArrayList<T>> matrix;
	private int row;
	private int col;
	
	public Matrix(int row, int col) 
	{ // constructor
		this.row = row;
		this.col = col;
		matrix = new ArrayList<ArrayList<T>>();
		
		for(int i=0; i<=col; i++) {
			ArrayList<T> rowArray = new ArrayList<>();	
			for(int j=0; j<=row; j++) {
				rowArray.add(null);
			}
			matrix.add(rowArray);
		}
	} // end constructor
	
	public void setVal(int row, int col, T value) 
	{
		matrix.get(col).set(row, value);
	}
	
	public T getVal(int row, int col)
	{
		return (matrix.get(col).get(row));	
	}
	
	public T getLastVal()
	{
		return (matrix.get(col).get(row));
	}
}
