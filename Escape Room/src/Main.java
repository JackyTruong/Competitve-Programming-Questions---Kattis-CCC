import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static int rows, col;
    static int[][] room;
    static boolean[][] beenTo;
    static boolean end;

    private static void escape(int spotRow, int spotCol, boolean[][] been){
        if(end){
            return;
        }
        been[spotRow][spotCol] = true;
        if(spotRow == rows-1 && spotCol == col-1){
            end = true;
        }
        else{
            ArrayList<Integer> divs = divisors(room[spotRow][spotCol]);
            for(int i = 0; i < divs.size(); i++){
                int a = divs.get(i);
                int b = room[spotRow][spotCol]/a;
                a--;
                b--;
                if(a < rows && b < col && !been[a][b]){
                    escape(a, b, been);
                }
                if(a < col && b < rows && !been[b][a]){
                    escape(b, a, been);
                }
            }
        }
        /*
        for(int i = 0 ; i < rows; i++){
            for(int o = 0 ; o < col; o++){
                System.out.println(been[i][o]);
            }
        }
        System.out.println("dif");

         */
    }

    private static ArrayList<Integer> divisors(int num){
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 1 ; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                temp.add(i);
            }
        }
        return temp;
    }

    private static boolean toEnd(int num){
        if(num/rows == col){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        rows = nextInt();
        col = nextInt();
        room = new int[rows][col];
        beenTo = new boolean[rows][col];
        end = false;
        boolean possible = false;
        for(int i = 0 ; i < rows; i++){
            for(int o = 0 ; o < col; o++){
                room[i][o] = nextInt();
                beenTo[i][o] = false;
                if(toEnd(room[i][o])){
                    possible = true;
                }
            }
        }
        if (possible) {
            escape(0,0, beenTo);
        }
        /*
        for(int i = 0 ; i < rows; i++){
            System.out.println(Arrays.toString(room[i]));
        }

         */
        if(end){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }

        out.close();
    }

    private static String next()throws IOException{
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }
}
