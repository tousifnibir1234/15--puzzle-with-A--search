import java.util.ArrayList;

public class node {
    static functions func= new functions();
    static public int counter=0;
    node parent;
    public int[][] matrix;
    public int g_n,h_n,f_n,serial,n=main.n;

    int blank_x,blank_y;
    //int dx,dy;



    node(int[][] matrix , int n,node parent,int option)
    {
        this.matrix= matrix;
        counter++;
        this.serial =counter;


        this.parent = parent;
        if(parent!=null) this.g_n=parent.g_n+1;
        if(option ==1 )
             this.h_n=func.mandist(matrix);
        else this.h_n=func.hamdist(matrix);


        this.f_n= this.g_n+this.h_n;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==0)
                {
                    blank_x=i;
                    blank_y=j;
                }
            }
        }

    }

    public ArrayList<int[][]> generatechild()
    {
        ArrayList<int[][]> successor= new ArrayList<int[][]>();
        int []dx= new int[]{0,0,+1,-1};
        int []dy= new int[]{+1,-1,0,0};
        int x,y;
        for(int i=0;i<4;i++)
        {
            x=blank_x+dx[i];
            y=blank_y+dy[i];

            if(!(x<0 || x>=n || y<0 || y>=n))
            {
                int[][] child=new int[n][n];
                for(int k=0;k<n;k++){for(int j=0;j<n;j++ )child[k][j]=matrix[k][j];};
                child[x][y]= 0;
                child[blank_x][blank_y]=matrix[x][y];


                successor.add(child);

            }

        }
        return successor;

    }
    void printMatrix()
    {
        System.out.println("\n"+ "child  "+ "own number "+ this.serial);
        if(parent!= null) System.out.println("Parent is "+parent.serial);
        else System.out.println("Parent is  "+1);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(this.matrix[i][j]+" ");
            }
            System.out.println();
        }

    }
    public boolean equals(Object object) {
        node nd=null;
        if(object instanceof node)
        {
            nd=(node)object;

        }
        if(this==nd ) return  true;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(this.matrix[i][j]!=nd.matrix[i][j]) return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return java.util.Arrays.deepHashCode( this.matrix);
    }



}
