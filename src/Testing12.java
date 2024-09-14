import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class Testing12 {
    public static int hourglassSum(List<List<Integer>> arr) {
        int max = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        while (i < 4) {
            while (j < 4) {
                int ii = i;
                int jj = j;
                int sum = 0;
                while (ii < i+3) {
                    while (jj < j+3) {
                        if (ii == i+1 && jj != j+1) {
                            continue;
                        }
                       sum += arr.get(ii).get(jj);
                        jj++;
                    }
                    jj = j;
                    ii++;
                }
                max = Math.max(max, sum);
                j++;
            }
            j = 0;
            i++;
        }
       return max;    
    }
}


 class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Testing12.hourglassSum(arr);
        System.out.println(result);

        bufferedReader.close();
    }
}