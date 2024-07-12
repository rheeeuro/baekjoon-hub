import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main  {
    static int n, d, k, c;
    static int[] sushi;
    static int[] s;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] str = br.readLine().split(" ");

        n = Integer.parseInt(str[0]);
        d = Integer.parseInt(str[1]);
        k = Integer.parseInt(str[2]);
        c = Integer.parseInt(str[3]);

        sushi = new int[n*2];
        s = new int[d+1];

        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
            sushi[n+i] = sushi[i];
        }
        s[c] += 1;

        int count = 1;
        int ans = 0;
        for (int i = 0; i < k; i++) {
            if (s[sushi[i]]  == 0) count += 1;
            s[sushi[i]] += 1;
        }
        ans = Math.max(ans, count);

        int start = 0, end = k;

        for (int i = 1; i <= n; i++) {
            if (s[sushi[start]] == 1) count -= 1;
            s[sushi[start]] -= 1;
            start += 1;

            
            if (s[sushi[end]] == 0) count += 1;
            s[sushi[end]] += 1;
            end += 1;

            ans = Math.max(ans, count);
        }

        System.out.println(ans);
        

    }
}

