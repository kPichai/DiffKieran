/**
 * Plagiarism Checker
 * A tool for finding the longest shared substring between two documents.
 *
 * @author Zach Blick
 * @author Kieran Pichai
 */
public class PlagiarismChecker {

    /**
     * This method finds the longest sequence of characters that appear in both texts in the same order,
     * although not necessarily contiguously.
     * @param doc1 the first document
     * @param doc2 the second
     * @return The length of the longest shared substring.
     */

    // Tabulation focused approach to the longest shared substring problem, takes in two strings
    public static int longestSharedSubstring(String doc1, String doc2) {
        // Create a 2d array to store lengths of shared substrings
        int[][] subsequenceLength = new int[doc1.length()+1][doc2.length()+1];

        // Loop through each character of both strings
        for (int i = 1; i <= doc1.length(); i++) {
            for (int j = 1; j <= doc2.length(); j++) {
                if (doc1.charAt(i - 1) == doc2.charAt(j - 1)) {
                    // If characters match increment the count from the previous diagonal cell
                    subsequenceLength[i][j] = subsequenceLength[i-1][j-1] + 1;
                } else {
                    // Otherwise take the maximum value of the left or top cell
                    subsequenceLength[i][j] = Math.max(subsequenceLength[i-1][j], subsequenceLength[i][j-1]);
                }
            }
        }

        // Return bottom-right cell contains as it contains the length of the longest shared substring
        return subsequenceLength[doc1.length()][doc2.length()];
    }
}