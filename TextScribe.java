import java.io.*;

public class TextScribe {
    public static void main(String[] args) {
        
        // TRY-WITH-RESOURCES (Tanda kurung setelah try)
        // fw = buka jalur ke file. true = Mode Append (nambah di bawah)
        // bw = buffer agar nulis teksnya ngebut
        try (FileWriter fw = new FileWriter("catatan_game.txt", true);
             BufferedWriter bw = new BufferedWriter(fw)) {
             
            // Menulis data ke file
            bw.write("[LOG] Player berhasil login.");
            bw.newLine(); // Pencet tombol Enter (pindah baris)
            
            System.out.println("Log berhasil dicatat ke file!");
            
            // KITA TIDAK PERLU NGETIK bw.close(); 
            // Java akan nutup otomatis saat kurung kurawal ini berakhir!
        } catch (IOException e) {
            System.out.println("Gagal nulis: " + e.getMessage());
        }

         System.out.println("\n--- ISI FILE CATATAN ---");
        
        // MEMBACA FILE DENGAN BUFFERED READER
        try (FileReader fr = new FileReader("catatan_game.txt");
             BufferedReader br = new BufferedReader(fr)) {
             
            String baris;
            // Selama hasil baca satu baris (readLine) BUKAN null (belum habis)
            while ((baris = br.readLine()) != null) {
                System.out.println(baris); // Print ke terminal
            }
            
        } catch (IOException e) {
            System.out.println("File nggak ketemu bos!");
        }
        
    }
}