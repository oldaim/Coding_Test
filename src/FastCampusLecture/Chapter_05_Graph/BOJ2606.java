package FastCampusLecture.Chapter_05_Graph;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2606 {
    static FastReader reader = new FastReader();
    static int node, edge;
    static ArrayList<ArrayList<Integer>> nodeList = new ArrayList<>();
    static boolean[] isVisited;

    static void input(){
        node = reader.nextInt();
        edge = reader.nextInt();
        isVisited = new boolean[node + 1];

        for (int i = 0; i <= node; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            nodeList.add(tmp);
        }

        for (int i = 0; i < edge; i++) {
            int inputF = Integer.parseInt(reader.next());
            int inputB = Integer.parseInt(reader.next());

            nodeList.get(inputF).add(inputB);
            nodeList.get(inputB).add(inputF);
        }

    }

    static void BFS(){
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        isVisited[1] = true;

        while (!queue.isEmpty()){
            int curr = queue.remove();
            ArrayList<Integer> currNode = nodeList.get(curr);
            if(curr != 1) count++;

            for (Integer i :currNode){
                if(isVisited[i]) continue;
                isVisited[i] = true;
                queue.add(i);
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args){
        input();
        BFS();
    }

    static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public FastReader(String s) throws FileNotFoundException {
        br = new BufferedReader(new FileReader(new File(s)));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
    }


}
