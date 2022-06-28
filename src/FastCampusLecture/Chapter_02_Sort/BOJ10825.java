package FastCampusLecture.Chapter_02_Sort;

import java.io.*;
import java.util.*;

public class BOJ10825 {
    static class Student implements Comparable<Student>{
        String name;
        int korean;
        int english;
        int math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }


        @Override
        public int compareTo(Student other) {
            if(korean != other.korean) return other.korean - korean; //내림차순
            if(english != other.english) return english - other.english; // 오름차순
            if(math != other.math) return  other.math - math;//내림차순
            if(!Objects.equals(name, other.name)) return name.compareTo(other.name);//오름차순
            return 0;
        }
    }
    static int N = 0;
    static List<Student> elemList = new ArrayList<>();

    static void input(){
        FastReader reader = new FastReader();
        N = reader.nextInt();

        for (int i = 0; i < N; i++) {
            String name = reader.next();
            int korean = Integer.parseInt(reader.next());
            int english = Integer.parseInt(reader.next());
            int math = Integer.parseInt(reader.next());

            elemList.add(new Student(name,korean,english,math));
        }


    }

    public static void main(String[] args) {
        input();
        Collections.sort(elemList);
        for (Student student : elemList) {
            System.out.println(student.name);
        }

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
