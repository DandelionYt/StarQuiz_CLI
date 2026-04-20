import java.io.*;
import java.util.*;

public class FileManager {

    private static final String FILE_NAME = "history.txt";

    public static void saveScore(String username, int score) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
            fw.write(username + "," + score + "\n");
        } catch (IOException e) {
            System.out.println("Error saving score.");
        }
    }

    public static List<ScoreRecord> loadScores() {
        List<ScoreRecord> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                list.add(new ScoreRecord(parts[0], Integer.parseInt(parts[1])));
            }

        } catch (IOException e) {
            // file may not exist yet
        }

        return list;
    }

    public static void showLeaderboard() {
        List<ScoreRecord> scores = loadScores();

        scores.sort((a, b) -> b.score - a.score);

        System.out.println("\n=== LEADERBOARD ===");

        for (int i = 0; i < Math.min(5, scores.size()); i++) {
            System.out.println((i + 1) + ". " +
                    scores.get(i).username + " - " + scores.get(i).score);
        }
    }
}
