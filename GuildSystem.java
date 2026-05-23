import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GuildSystem {

    public static void main(String[] args) {

        // =========================
        // IMPLEMENTASI SET
        // Mencegah ID dobel
        // =========================
        HashSet<String> registeredID = new HashSet<>();

        registeredID.add("A01");
        registeredID.add("A02");
        registeredID.add("A01"); // data dobel

        // =========================
        // IMPLEMENTASI LIST
        // Menyimpan history login
        // =========================
        ArrayList<String> loginHistory = new ArrayList<>();

        loginHistory.add("A01 logged in");
        loginHistory.add("A02 logged in");

        // =========================
        // IMPLEMENTASI MAP
        // Database Job Member
        // =========================
        HashMap<String, String> memberJob = new HashMap<>();

        memberJob.put("A01", "Sniper");
        memberJob.put("A02", "Healer");

        // =========================
        // OUTPUT
        // =========================

        System.out.println("Jumlah ID unik: " + registeredID.size());

        System.out.println("\nLogin History:");
        for (String history : loginHistory) {
            System.out.println(history);
        }

        System.out.println("\nJob dari ID A02:");
        System.out.println(memberJob.get("A02"));
    }
}