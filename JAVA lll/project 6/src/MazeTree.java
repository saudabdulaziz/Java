/*
 * Saud Aljandal
 * lab6
 * 12/7/2017
 */
public class MazeTree{  
	//Create a private TreeNode class inside the MazeTree class described below.
	private class TreeNode
	{
		private int row, column;
	    private TreeNode north, south, east, west;
	    
	    
	   /*
	    * The TreeNode constructor sets the row, and column fields to the values passed to it;
	    *  the four child pointers are set to null.
	    */
	   private TreeNode(int row, int column) {

		   this.row = row;
		   this.column = column;
		   this.north=null;
		   this.west=null;
		   this.south=null;
		   this.east=null;
	   }
	   //The toString() method returns the row and column as a formatted string
	   public String toString() {
		   return "("+"+row+ :" + this.row + " +column+ :" + this.column+")"+"\n";
	   }
	}
	private TreeNode root;
	private int finalDestRow, finalDestCol;

	//Traversing a maze: Current location in the array is [n-1,n-1]
	public  MazeTree(int[][] grid) {
		
		// create a tree from a grid
		//Instantiate the root
		root = new TreeNode(finalDestRow, finalDestCol);// which is (0,0);
		finalDestRow = grid[0].length-1;//last row
		finalDestCol = grid.length-1;//last col
		make(grid,root);
	}
	
	
	private void make(int[][] grid, TreeNode parent) {
		grid[parent.column][parent.row] = -1;//base
		
		//up north
		if (parent.column != 0) {
			int north =  grid[parent.column -1][parent.row];
			if (north == 1) {
				parent.north = new TreeNode(parent.row, parent.column-1);
				make(grid, parent.north);//new from new location
			}
		}

		//left west
		if (parent.row != 0) {
			int west = grid[parent.column][parent.row - 1];
			if ( west == 1) {
				parent.west = new TreeNode(parent.row - 1, parent.column);
				make(grid, parent.west);//new from new location
			}
		}
		//down south
		if (parent.column != finalDestCol) {
			int south = grid[parent.column + 1][parent.row]; 
			if (south == 1) {
				parent.south = new TreeNode(parent.row, parent.column+1);
				make(grid, parent.south);//new from new location
			}
		}
		//right east
		if (parent.row != finalDestRow) {
			int east = grid[parent.column][parent.row + 1]; 
			if (east == 1) {
				parent.east = new TreeNode(parent.row + 1, parent.column);
				make(grid, parent.east);//new from new location
			}
		}
	}
	
	private String depthFirstSearch(TreeNode thisNode) {
		String nodeStr = thisNode.toString();
		if (thisNode.column == finalDestCol && thisNode.row == finalDestRow) {
			return nodeStr;
		}
		else {
			if (thisNode.north != null) {
				String path = depthFirstSearch(thisNode.north);
				if (path != "") {
					return nodeStr + path;
					}
				}
			if (thisNode.west != null) {
				String path = depthFirstSearch(thisNode.west);
				if (path != "") {
					return nodeStr + path;
					}
				}
			if (thisNode.south != null) {
				String path = depthFirstSearch(thisNode.south);
				if (path != "") {
					return nodeStr + path;
					}
				}
			if (thisNode.east != null) {
				String path = depthFirstSearch(thisNode.east);
				if (path != "") {
					return nodeStr + path;
					}
				}
			//if no solution found:
			return "";
			}
		}
	
	/*
	 * public depthFirstSearch() method traverses the tree to find the
	 *  solution and is called by the main() method. 
	 * It calls the private depthFirstSearch(Treenode node) method.
	 */
	public String depthFirstSearch() {
		return depthFirstSearch(this.root);
	}
	/*
	 * main() declares and initializes the grid, then 
	 * instantiates a MazeTree object passing the grid to the MazeTree constructor,
	 *  then calls the depth first search method. 
	 * Print “no solution found” if depthFirstSearch() returned “”. 
	 * Otherwise, print the path returned.
	 */
	public static void main(String[] args) {
		
		int[][] grid = { 
				{1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0},
                {1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1} };
		
		MazeTree mazeT = new MazeTree(grid);
		
		//Print “no solution found” if depthFirstSearch() returned “”.
		if(mazeT.depthFirstSearch().isEmpty()) {
			System.out.println("no solution found");
		}
		System.out.println(mazeT.depthFirstSearch(mazeT.root));
	}
}








