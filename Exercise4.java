public class Exercise4 {
    public static void main(String[] args) {
        int[][] grid= {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int r= grid.length;
        int c= grid[0].length;
        for(int i=0;i<r;i++)
        { int sumr=0;
            for(int j=0;j<c;j++)
            {
                sumr+= grid[i][j];
            }
            System.out.println("Sum of row No."+(i+1)+" is: "+sumr);
        }
        for(int i=0;i<c;i++)
        { int sumc=0;
            for(int j=0;j<r;j++)
            {
                sumc+= grid[j][i];
            }
            System.out.println("Sum of column No."+(i+1)+" is: "+sumc);
        }
    }
}
