import java.util.ArrayList;

public class functions {
    int dx=0,dy=0;
    int hamdist(int[][] matrix)
    {
        int n= main.n;
        int dist=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==0) continue;
                else if(matrix[i][j]!=main.goal[i][j])
                {
                    dist++;
                }
            }
        }
        return dist;
    }
    int mandist(int[][] matrix)
    {
        int n= main.n;
        int dist=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                int flag=0;
                if( matrix [i][j]==0 )continue;
                //searching in goal matrix
                else
                {
                    search(matrix[i][j]);
                    dist= dist+  Math.abs(i-dx)+Math.abs(j-dy);

                }



            }
        }
        return dist;


    }
    void search(int p)
    {
        for(int k=0;k<main.n;k++)
        {
            for(int l=0;l<main.n;l++)
            {
                if(main.goal[k][l]== p)
                {
                    dx=k;
                    dy=l;

                }
            }
        }
    }


    public Boolean solvable(int[][] matrix,int n)
    {
        int blank_row_no=0;
        int inversion_count=0;
        ArrayList<Integer> list= new ArrayList<Integer>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==0 ){
                    blank_row_no=n-i;
                    continue;
                }
                list.add(matrix[i][j]);
            }
        }



        for(int i=0;i<n*n-1;i++)
        {
            for(int j=i+1;j<n*n-1;j++)
            {
                if(list.get(i)>list.get(j)) inversion_count++;
            }
        }
        //System.out.println("Inversion count is : "+ inversion_count);

        if((n%2==1) && (inversion_count%2==0)) return true;
        else if( n%2==0)
        {
            if (( inversion_count%2==0) && (blank_row_no%2==1)) return true;
            else if((inversion_count%2==1) && (blank_row_no %2==0)) return true;
        }
        return false;



    }
}
