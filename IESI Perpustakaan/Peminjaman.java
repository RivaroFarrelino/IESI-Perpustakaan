import java.util.ArrayList;

public class Peminjaman {
    private ArrayList<BukuDipinjam> daftarBuku = new ArrayList<BukuDipinjam>();

    public Peminjaman(ArrayList<BukuDipinjam> bukuDipinjam) throws Exception {
        for (BukuDipinjam buku : bukuDipinjam) {
            daftarBuku.add(buku);
        }
    }
}
