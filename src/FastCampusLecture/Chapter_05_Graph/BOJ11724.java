package FastCampusLecture.Chapter_05_Graph;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11724 {
    static FastReader reader = new FastReader();
    static int N , M;
    static ArrayList<ArrayList<Integer>> nearNode =  new ArrayList<>();
    static int[] component;
    static boolean[] isVisited;

    static void input(){
        N = Integer.parseInt(reader.next());
        M = Integer.parseInt(reader.next());
        component = new int[N];
        isVisited = new boolean[N];

        for (int i = 0; i < N; i++) {
            nearNode.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int inputNodeF = Integer.parseInt(reader.next()) - 1;
            int inputNodeS = Integer.parseInt(reader.next()) - 1;

            nearNode.get(inputNodeF).add(inputNodeS);
            nearNode.get(inputNodeS).add(inputNodeF);
        }
    }

    static void numOfConnectionComponent(){
        int count = 0;

        for (int i = 0; i < N; i++) {
            if(!isVisited[i]) {
                BFS(i);
                count++;
            }
        }

        System.out.println(count);
    }

    static void BFS(int start){
        Queue<Integer> queue = new LinkedList<>();
        isVisited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()){
            int curr = queue.remove();

            ArrayList<Integer> nodeList = nearNode.get(curr);

            System.out.println();

            for(Integer i:nodeList){
                if(isVisited[i]) continue;
                queue.add(i);
                isVisited[i] = true;
            }
        }


    }

    public static void main(String[] args){
        input();
        numOfConnectionComponent();
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