import java.io.Serializable;

// WAJIB IMPLEMENTS SERIALIZABLE! Kalau enggak, Java nolak nyimpen file-nya.
public class Player implements Serializable {
    
    public String name;
    public int level;
    
    // TRANSIENT: Keyword keamanan! 
    // Artinya atribut "uangHack" ini TIDAK BOLEH ikut tersimpan ke harddisk.
    // Saat diload ulang, nilainya akan otomatis hangus jadi 0.
    public transient int uangHack;

    public Player(String name, int level, int uang) {
        this.name = name;
        this.level = level;
        this.uangHack = uang;
    }
}