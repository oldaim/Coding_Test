package FastCampusLecture.Chapter_02_Sort;

import java.io.*;
import java.util.*;

public class BOJ11652 {
    static class CardWithNum implements Comparable<CardWithNum>{
        long cardNum;
        int  cardCount;

        @Override
        public int compareTo(CardWithNum o) {
            if(cardCount == o.cardCount && cardNum < o.cardNum) return -1;
            else if (cardCount == o.cardCount && cardNum > o.cardNum) {
                return 1;
            } else return o.cardCount - cardCount;
        }

        public CardWithNum(long cardNum, int cardCount) {
            this.cardNum = cardNum;
            this.cardCount = cardCount;
        }
    }

    static int N = 0;
    static List<CardWithNum> cardList = new ArrayList<>();
    static HashSet<Long> cardSet = new HashSet<>();

    static void input(){

        FastReader reader = new FastReader();
        N = reader.nextInt();

        for (int i = 0; i < N; i++) {

            long inputNumber = reader.nextLong();

            if(!cardSet.contains(inputNumber)) { // 집합에 포함되어 있지 않다면? 숫자를 추가하고 카운트를 올려준다!
                cardSet.add(inputNumber);
                cardList.add(new CardWithNum(inputNumber,1));
            }
            else {// 집합에 포함되어 있다면 ? 숫자를 추가 하지 않고 카운트를 올려준다!
                for (CardWithNum cardWithNum : cardList) {
                    if (cardWithNum.cardNum == inputNumber) {
                        cardWithNum.cardCount++;
                    }
                }
            }


        }

    }

    static void maxOfCard(){

        Collections.sort(cardList);

        System.out.println(cardList.get(0).cardNum);

    }

    public static void main(String[] args) {
        input();
        maxOfCard();
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
