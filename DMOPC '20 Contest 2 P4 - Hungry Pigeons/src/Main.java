import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt(), m = nextInt();
        int[] birds = new int[n];
        for(int i = 0 ; i < n; i++){
            birds[i] = nextInt();
        }
        Arrays.sort(birds);
        int[] satis = new int[n];
        int[] worms = new int[n];
        for(int i = 0 ; i < m; i++){

        }


        out.close();
    }

    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }


}
