import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        //path to the sample
        String filename = "sample.txt";
        Map<String, List<String>> anagramGroups = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String word;

            while ((word = reader.readLine()) != null) {

                if (word.isEmpty()) {
                    continue;
                }

                char[] chars = word.toCharArray();
                Arrays.sort(chars);
                String sorted = new String(chars);

                anagramGroups.computeIfAbsent(sorted, k -> new ArrayList<>()).add(word);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        // print all anagram groups
        for (List<String> group : anagramGroups.values()) {
            System.out.println(String.join(" ", group));
        }
    }
}