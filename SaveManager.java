import java.io.*;

public class SaveManager {
    public static void main(String[] args) {
        
        Player p1 = new Player("Zilong", 99, 999999);

        System.out.println("Menyimpan game...");
        
        // PAKE BYTE STREAM: FileOutputStream (Jalur) + ObjectOutputStream (Mesin Pembeku)
        try (FileOutputStream fileOut = new FileOutputStream("save_slot1.dat");
             ObjectOutputStream objOut = new ObjectOutputStream(fileOut)) {
            
            // TULIS 1 OBJEK SECARA UTUH!
            objOut.writeObject(p1);
            System.out.println("Save sukses ke save_slot1.dat!");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Cek file save_slot1.dat di VS Code. Pasti isinya karakter aneh alien, 
        // karena itu Biner, bukan untuk dibaca manusia!
 System.out.println("\nLoading game...");
        
        // Karena baca objek bisa memicu 2 error (IOException dan ClassNotFoundException), 
        // kita harus siapkan Exception yang General
        try (FileInputStream fileIn = new FileInputStream("save_slot1.dat");
             ObjectInputStream objIn = new ObjectInputStream(fileIn)) {
            
            // READ & DOWNCAST! 
            // Hasil sedotan readObject() tipenya adalah Object umum, jadi harus dipaksa jadi (Player)
            Player loadedPlayer = (Player) objIn.readObject();
            
            System.out.println("Load Berhasil!");
            System.out.println("Nama  : " + loadedPlayer.name);
            System.out.println("Level : " + loadedPlayer.level);
            // Lihat ini! Karena 'uangHack' sifatnya transient, pas diload nilainya jadi 0 (musnah).
            System.out.println("Uang  : " + loadedPlayer.uangHack); 
            
        } catch (Exception e) {
            System.out.println("Save file corrupt / hilang!");
        }
    }
}