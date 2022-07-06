package FastCampusLecture.Chapter_03_BinarySearch;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ10816 { // map 과 set으로 구현하긴했는데 이분탐색을 활용한 lower_bound upper_bound 구현을 시도해보는 것이 좋을듯?
    static int N = 0 , M = 0;
    static HashSet<Integer> cardSet = new HashSet<>();
    static HashMap<Integer,Integer> cardMap = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    static FastReader reader = new FastReader();

    static void input(){
        N = reader.nextInt();

        for (int i = 0; i < N; i++) {
            int inputNumber = Integer.parseInt(reader.next());
            if(!cardSet.contains(inputNumber)){
                cardSet.add(inputNumber);
                cardMap.put(inputNumber,1);
            }
            else{
                cardMap.replace(inputNumber,cardMap.get(inputNumber) + 1);
            }
        }

        M = reader.nextInt();

        for (int i = 0; i < M; i++) {
            int inputNumber = Integer.parseInt(reader.next());
            if(cardMap.containsKey(inputNumber)) sb.append(cardMap.get(inputNumber)).append(' ');
            else sb.append(0).append(' ');
        }


    }

    public static void main(String[] args){
        input();
        System.out.println(sb);
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
