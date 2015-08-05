package leetcodeOJ;

public class _240Search_a_2D_Matrix_II {
    public boolean searchMatrix(int[][] matrix, int target) {
        int height=matrix.length;
        int length=matrix[0].length;
        int right=length;
        for(int i=0;i<height;i++){
        	for(int j=0;j<right;j++){
        		if(matrix[i][j]==target){
        			return true;
        		}
        		if(matrix[i][j]>target){
        			right=j;
        			break;
        		}
        	}
        }
        return false;
    }
    
    public static void main(String[] args){
    	_240Search_a_2D_Matrix_II o=new _240Search_a_2D_Matrix_II();
    	int[][] matrix={{1,4,7,11,15},
		 			  {2,5,8,12,19},
		 			  {3,6,9,16,22},
		 			  {10,13,14,17,24},
		 			  {18,21,23,26,30}};
    	System.out.println(o.searchMatrix(matrix, 30));
    }
}