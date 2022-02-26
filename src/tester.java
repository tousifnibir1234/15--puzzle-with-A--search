import java.util.HashMap;

public class tester {
    public static void main(String[] args) {
        int [][]mat = new int[][]{{1,2,3,4},{5,6,7,8},{9 ,10,11,12},{13,14,15,16}};
        int [][]mat2 = new int[][]{{1,2,12,4},{5,6,7,8},{9 ,10,11,12},{13,14,15,16}};
        int [][]mat3 = new int[][]{{1,2,7,4},{5,6,7,8},{9 ,10,11,12},{13,14,15,16}};

        node n1= new node(mat,4,null,1);
        node n2= new node(mat2,4,null,1);
        node n3= new node(mat3,4,null,1);


        HashMap<node, Integer> map = new HashMap<>();
        map.put(n1,n1.f_n);
        map.put(n2,n2.f_n);
        map.put(n3,n3.f_n);
        System.out.println(map.size());
    }
}
