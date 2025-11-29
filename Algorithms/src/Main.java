
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {

        int[] array = {1, 2, 3, 2, 5,7,5,4,5,6,1,7,8,1};
        List<List<Integer>> subsequences = StrictlyIncreasing(array);

        for (List<Integer> subsequence : subsequences) {
            System.out.println(subsequence);
        }

    }

    public static List<List<Integer>> StrictlyIncreasing(int[] array) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentSubsequence = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (currentSubsequence.isEmpty() || array[i] > currentSubsequence.get(currentSubsequence.size() - 1)) {
                currentSubsequence.add(array[i]);
            } else {
                if (!currentSubsequence.isEmpty()) {
                    if (currentSubsequence.size()>1)
                          result.add(new ArrayList<>(currentSubsequence));
                    currentSubsequence.clear();
                }
                currentSubsequence.add(array[i]);
            }
        }
        if (!currentSubsequence.isEmpty()&&currentSubsequence.size()>1) {
            result.add(currentSubsequence);
        }

        return result;
    }










}
