public class PeminjamanController {
    public void showFormPeminjaman(){
        Perpustakaan.formPeminjaman = new FormPeminjaman();
        Perpustakaan.formPeminjaman.tampil();
    }    

    public ArrayList<Buku> cariBuku(String judul){
        BukuProvider bukuProvider = new BukuProvider();
        bukuProvider.selectBuku(judul);
    }

    public  pinjam (String BukuDipinjam[]) {

    }
}