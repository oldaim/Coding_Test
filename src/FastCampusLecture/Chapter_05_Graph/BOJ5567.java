package FastCampusLecture.Chapter_05_Graph;

import java.io.*;
import java.util.*;

public class BOJ5567 {
    static FastReader reader = new FastReader();
    static int node,edge;
    static int[] distance;
    static ArrayList<ArrayList<Integer>> nodeList = new ArrayList<>();
    static void input(){
        node = reader.nextInt();
        edge = reader.nextInt();
        distance = new int[node + 1];
        for (int i = 0; i <= node; i++) nodeList.add(new ArrayList<>());

        for (int i = 0; i < edge; i++) {
            int inputF = Integer.parseInt(reader.next());
            int inputB = Integer.parseInt(reader.next());

            nodeList.get(inputF).add(inputB);
            nodeList.get(inputB).add(inputF);
        }

        for (int i = 0; i <= node; i++) {
            distance[i] = - 1;
        }

    }

    static void BFS(){
        boolean[] isVisited = new boolean[node + 1];
        Queue<Integer> queue = new LinkedList<>();
        isVisited[1]  = true;
        queue.add(1);
        distance[1] = 0;

        while (!queue.isEmpty()){
            int curr = queue.remove();
            ArrayList<Integer> nearNode = nodeList.get(curr);

            for (Integer n:nearNode){
                if(isVisited[n]) continue;
                isVisited[n] = true;
                queue.add(n);
                distance[n] = distance[curr] + 1;
            }


        }

    }

    static void findInvite(){
        int count = 0;

        input();

        BFS();

        for (int i = 2; i <= node ; i++) {
            if(distance[i] != -1 && distance[i] <= 2) count++;
        }

        System.out.println(count);

    }

    public static void main(String[] args){
        findInvite();
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
