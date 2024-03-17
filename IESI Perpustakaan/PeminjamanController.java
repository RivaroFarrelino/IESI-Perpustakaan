import java.util.ArrayList;

public class PeminjamanController {
    ArrayList<Buku> listBuku;

    public void showFormPeminjamn() {
        FormPeminjaman formPeminjaman = new FormPeminjaman();
        formPeminjaman.tampil();
    }

    public void cariBuku(String judul) {
        BukuProvider bukuProvider = new BukuProvider();
        ArrayList<Buku> hasilPencarian = bukuProvider.selectBuku(judul);

        if (hasilPencarian.isEmpty()) {
            DialogUI dialog = new DialogUI("Buku belum terdaftar!");
            dialog.pack();
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
        } else {
            FormPeminjaman formPeminjaman = new FormPeminjaman();
            formPeminjaman.display(hasilPencarian);
        }
    }

    public void pinjam(ArrayList<BukuDipinjam> bukuDipinjam) {
        PeminjamanManager peminjamanManager = new PeminjamanManager();
        boolean berhasil = peminjamanManager.simpan(bukuDipinjam);

        if (berhasil) {
            DialogUI dialog = new DialogUI("Berhasil meminjam buku");
            dialog.pack();
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
        }
    }
}