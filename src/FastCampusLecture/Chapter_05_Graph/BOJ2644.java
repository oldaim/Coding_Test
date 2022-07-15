package FastCampusLecture.Chapter_05_Graph;

import java.io.*;
import java.util.*;

public class BOJ2644 {
    static FastReader reader = new FastReader();
    static int N, firstPerson, secondPerson, edge;
    static int[] distance;
    static boolean[] isVisited;
    static ArrayList<ArrayList<Integer>> nodeList = new ArrayList<>();

    static void input(){
        N = reader.nextInt();
        distance = new int[N + 1];
        isVisited = new boolean[N + 1];

        for (int i = 0; i <= N ; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            nodeList.add(tmp);
        }

        firstPerson = Integer.parseInt(reader.next());
        secondPerson = Integer.parseInt(reader.next());
        edge = reader.nextInt();

        for (int i = 0; i < edge; i++) {
            int inputF = Integer.parseInt(reader.next());
            int inputB = Integer.parseInt(reader.next());

            nodeList.get(inputF).add(inputB);
            nodeList.get(inputB).add(inputF);
        }
    }

    static int BFS(int start, int goal){
        Queue<Integer> queue = new LinkedList<>();
        boolean isFamily = false;
        isVisited[start] = true;
        queue.add(start);
        distance[start] = 0;

        while (!queue.isEmpty()){
            int curr = queue.remove();
            ArrayList<Integer> nodes = nodeList.get(curr);
            if(curr == goal) isFamily = true;

            for (Integer node:nodes){
                if(isVisited[node]) continue;
                isVisited[node] = true;
                distance[node] = distance[curr] + 1;
                queue.add(node);
            }
        }

        if(isFamily) return distance[goal];
        else return -1;

    }

    static void print(){
        input();

        System.out.println(Math.max(BFS(firstPerson,secondPerson),BFS(secondPerson,firstPerson)));
        
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
