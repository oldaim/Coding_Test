package FastCampusLecture.Chapter_05_Graph;

import java.io.*;
import java.util.*;

public class BOJ11725 {
    /*
     * 트리의 부모를 구하는 문제
     * 처음에는 BFS 로 인접노드를 돌려서 루트인 1을 만나게 되면 부모이다! 라고 생각했는데 시간초과 발생 -> 아마 2~3중 반복문때문에 그런듯
     * 해결책으로 1로부터 떨어져있는 차수를 구해서 차수가 낮은쪽이 부모다 라고 생각 -> 정답
     * */

    static FastReader reader = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] distance;
    static ArrayList<ArrayList<Integer>> nodeList = new ArrayList<>();

    static void input(){
        N = reader.nextInt();
        distance = new int[N + 1];

        for (int i = 0; i <= N ; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            nodeList.add(tmp);
        }

        for (int i = 0; i < N - 1; i++) {
            int inputF = Integer.parseInt(reader.next());
            int inputB = Integer.parseInt(reader.next());

            nodeList.get(inputF).add(inputB);
            nodeList.get(inputB).add(inputF);
        }
    }


    private static void BFS() {
        int curr = 1 , dis = 1;
        boolean[] isVisited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(curr);
        isVisited[curr] = true;
        distance[curr] = dis;

        while (!queue.isEmpty()){
            int node = queue.remove();
            ArrayList<Integer> nodes = nodeList.get(node);

            for (Integer i:nodes){
                if(isVisited[i]) continue;
                isVisited[i] = true;
                queue.add(i);
                distance[i] = distance[node] + 1;

            }

        }

    }

    static void findParent(){
       BFS();
        for (int i = 2; i <= N ; i++) {
            ArrayList<Integer> list = nodeList.get(i);
            for (Integer nodes: list) {
                if(distance[i] > distance[nodes]) sb.append(nodes).append('\n');
            }
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args){
        input();
        findParent();
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
