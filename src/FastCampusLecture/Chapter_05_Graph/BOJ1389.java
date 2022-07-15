package FastCampusLecture.Chapter_05_Graph;

import java.io.*;
import java.util.*;

public class BOJ1389 {
    static FastReader reader = new FastReader();
    static int node,edge;
    static int[] kevinNum;
    static ArrayList<ArrayList<Integer>> nodeList = new ArrayList<>();

    static void input(){
        node = Integer.parseInt(reader.next());
        edge = Integer.parseInt(reader.next());
        kevinNum = new int[node + 1];
        for (int i = 0; i <= node; i++) nodeList.add(new ArrayList<>());

        for (int i = 0; i < edge; i++) {
            int inputF = Integer.parseInt(reader.next());
            int inputB = Integer.parseInt(reader.next());

            nodeList.get(inputF).add(inputB);
            nodeList.get(inputB).add(inputF);

        }

    }

    static void BFS(int start){
        boolean[] isVisited = new boolean[node + 1];
        int[] distance = new int[node + 1];
        int sum = 0;
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        isVisited[start] = true;
        distance[start] = 0;

        while(!queue.isEmpty()){

            int curr = queue.remove();
            ArrayList<Integer> nodes = nodeList.get(curr);

            for(Integer node:nodes){
                if(isVisited[node]) continue;
                isVisited[node] = true;
                queue.add(node);
                distance[node] = distance[curr] + 1;
            }
        }

        for (int i = 1; i <= node ; i++) {
            sum += distance[i];
        }

        kevinNum[start] = sum;

    }

    static void print(){
        int min = Integer.MAX_VALUE;
        int result = 0;

        input();

        for (int i = 1; i <= node ; i++) {

            BFS(i);

            if(min > kevinNum[i]){
                min = kevinNum[i];
                result = i;
            }

        }


        System.out.println(result);

    }

    public static void main(String[] args){
        print();
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
