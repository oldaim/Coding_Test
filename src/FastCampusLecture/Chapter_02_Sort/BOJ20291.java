package FastCampusLecture.Chapter_02_Sort;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ20291 {


    static int N = 0;
    static HashMap<String,Integer> extensionHashMap = new HashMap<>();
    static HashSet<String> extensionHashSet = new HashSet<>();

    static void input(){
        FastReader reader = new FastReader();
        N = reader.nextInt();


        for (int i = 0; i < N; i++) {

            String inputString = reader.nextLine();
            int startIndex = inputString.indexOf('.');
            String extensionText = inputString.substring(startIndex + 1);

            if(!extensionHashSet.contains(extensionText)){ // map을 사용해서 map 에도 데이터 추가
                extensionHashSet.add(extensionText);
                extensionHashMap.put(extensionText,1);
            }
            else{
              extensionHashMap.replace(extensionText,extensionHashMap.get(extensionText) + 1); // 키가 만약 있으면 +1로 대체
            }


        }
    }

    static void sortAndPrint(){

        Map<String, Integer> sortedMap = extensionHashMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> { throw new AssertionError(); },
                        LinkedHashMap::new
                ));

        for (String key : sortedMap.keySet()) {

            int value = sortedMap.get(key);

            System.out.println(key + " " + value);
        }


    }


    public static void main(String[] args) {
        input();
        sortAndPrint();
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
