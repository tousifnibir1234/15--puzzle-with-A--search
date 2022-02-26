import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class HammingDistance {
    node primary,goal;
    int n=main.n;

    HammingDistance( int[][] primary  )
    {
        this.primary=new node(primary,n,null,0);

    }

    public boolean solve()
    {
        Comparator<node> fValue= new Comparator<node>() {
            @Override
            public int compare(node o1, node o2) {
                if(o1.f_n>o2.f_n) return 1;
                else if(o1.f_n<o2.f_n) return -1;
                return 0;
            }
        };

        // System.out.println("the total manhattan distance is" + primary.h_n);

        PriorityQueue<node> pq= new PriorityQueue<node>(15,fValue);
        HashMap<node,Integer > explore = new HashMap<node,Integer>();
        HashMap<node,Integer> closed = new HashMap<>();
        pq.add(primary);
        int expanded=0;
        // explore.put(primary,primary.f_n);
        while(!pq.isEmpty())
        {
            node  mini = pq.poll();
            expanded++;
            if (mini.equals(main.goalNode))
            {
                int count=0;
                System.out.println("..........\n Hamming  :  Found goal state..........\nFrom goal to primary path");
                while(mini.parent!=null)
                {
                    mini.printMatrix();
                    System.out.println("\n");
                    mini=mini.parent;
                    count++;
                }
                mini.printMatrix();
                System.out.println("Move is  "+count+"\n  Expanded Node count "+expanded);
                pq.clear();
                explore.clear();
                return true;

            }
            explore.put(mini,mini.f_n);
          //  closed.put(mini,mini.f_n);

            ArrayList<int[][]> list=mini.generatechild();
            for(int i=0;i<list.size();i++)
            {
                node n1= new node(list.get(i),main.n,mini,0);


                if(!explore.containsKey(n1))
                {
                    pq.add(n1);
                    explore.put(n1,n1.f_n);
                }
                else if(explore.containsKey(n1) && explore.get(n1)>n1.f_n)
                {
                    //explore.remove(n1);
                    explore.put(n1,n1.f_n);
                    //pq.remove(n1);
                    pq.add(n1);
                }


            }

        }
        return false;

    }

}
