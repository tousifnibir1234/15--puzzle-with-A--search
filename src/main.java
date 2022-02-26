import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



//Input file bahir theke porbo file source folder e rakhbo na
//javafx library namay nite hobe . project structure e giye library add korar option theke library add korbo
class position{
    public int x,y;
    position(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
}
public class main {

    static int n=4;
    static int[][] goal ;
    static node goalNode;

    public   static void  main(String[] args) throws FileNotFoundException {
        int[][] primary;
        File file = new File("input.txt");

        int t;
        Scanner scanner = new Scanner(file);
        t = scanner.nextInt();

        System.out.println(n);
        primary = new int[n][n];
        goal = new int[n][n];

        //goal matrix input

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                goal[i][j] = ++count;
            }
        }
        goal[3][3] = 0;
        goalNode = new node(goal, n, null, 0);


        for(int q=0;q<t;q++)
        {
//primary matrix input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    primary[i][j] = scanner.nextInt();
                }
            }


// checking solvable or not
            functions f = new functions();
            if (f.solvable(primary, n)) {
                System.out.println("The puzzle  is solvable");
                System.out.println("The primary and goal are shown below " + "\n" + " ........ primary matrix. ......");
                //primary matrix output
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) System.out.print(primary[i][j] + " ");
                    System.out.println();
                }

                System.out.println("\n" + "goal matrix ");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) System.out.print(goal[i][j] + " ");
                    System.out.println();
                }
               // HammingDistance ham= new HammingDistance(primary);
               // ham.solve();

                manhattanDistance man = new manhattanDistance(primary);
                man.solve();
            } else {
                System.out.println("The puzzle is not solvable  ");
            }


//primary and goal matrix output



            // manhattanDistance man= new manhattanDistance( primary);
            //man.solve();


        }
    }
}
