import java.util.ArrayList;

public class PeminjamanManager {
    public boolean simpan (ArrayList<BukuDipinjam> bukuDipinjam) {
        try {
            new Peminjaman(bukuDipinjam);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}