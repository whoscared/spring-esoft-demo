package whoscared.esoftdemo.esoft.demo.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SearchWithLevenshteinDistance {
    @Autowired
    public SearchWithLevenshteinDistance() {
    }

    protected int levenshteinDistance(String s1, String s2) {
        int[][] matrix = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = levDiv(i, j, s1, s2, matrix);
            }
        }
        return matrix[s1.length()][s2.length()];
    }

    private int levDiv(int i, int j, String s1, String s2, int[][] matrix) {
        if (i == 0 && j == 0)
            return 0;
        if (i > 0 && j == 0)
            return i;
        if (j > 0 && i == 0)
            return j;
        int m = (s1.charAt(i - 1) == s2.charAt(j - 1)) ? 0 : 1;

        int min = matrix[i][j - 1] + 1;
        if (matrix[i - 1][j] + 1 < min)
            min = matrix[i - 1][j] + 1;
        if (matrix[i - 1][j - 1] + m < min)
            min = matrix[i - 1][j - 1] + m;
        return min;
    }

}
