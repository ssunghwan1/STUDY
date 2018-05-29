import java.io.BufferedReader;
import java.io.InputStreamReader;
 

 
public class Solution {
	
	static class Node {
	     
	    int left;
	    int right;
	     
	    Node() {
	         
	        this.left = 0;
	        this.right = 0;
	    }
	     
	    Node(int left, int right) {
	         
	        this.left = left;
	        this.right = right;
	    }
	}
 
    static Node[] tree;
    static int[] parents;
    static int[] Depth;
    static int[] size;
     
    static int Answer;
    static int V;
    static int E;
     
    static int P;
    static int Q;
 
    public static void main(String args[]) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("input.txt"));
         
        String[] temp = null;
 
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
 
            System.out.print("#" + (test_case + 1) + " ");
             
            temp = br.readLine().split(" ");
             
            V = Integer.parseInt(temp[0]);
            E = Integer.parseInt(temp[1]);
             
            P = Integer.parseInt(temp[2]);
            Q = Integer.parseInt(temp[3]);
             
            tree = new Node[V + 1];
            for(int i = 0; i <= V; i++)
                tree[i] = new Node();
             
            parents = new int[V + 1];
            Depth = new int[V + 1];
            size = new int[V + 1];
             
            temp = br.readLine().split(" ");
            for(int i = 2; i <= E * 2; i += 2) {
                 
                int p = Integer.parseInt(temp[i - 2]);
                int q = Integer.parseInt(temp[i - 1]);
                 
                if(tree[p].left == 0)
                    tree[p].left = q;
                else
                    tree[p].right = q;
                 
                parents[q] = p;
            }
            travel(1, 0);
            Answer = LCA(P, Q);
             
            System.out.println(Answer + " " + size[Answer]);
        }
 
        br.close();
    }
     
    static int travel(int node, int depth) {
         
        int count = 0;
         
        if(node != 0) {
             
            count++;
            count += travel(tree[node].left, depth + 1);
            count += travel(tree[node].right, depth + 1);
        }
         
        Depth[node] = depth;
        size[node] = count;
         
        return count;
    }
     
    static int LCA(int p, int q) {
         
        int u = Depth[p] > Depth[q] ? p : q;
        int v = Depth[p] > Depth[q] ? q : p;
         
        int len = Depth[u] - Depth[v];
        for(int i = 0; i < len; i++)
            u = parents[u];
         
        while(u != v) {
             
            u = parents[u];
            v = parents[v];
        }
         
        return u;
    }
}