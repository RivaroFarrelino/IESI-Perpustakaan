public class Perpustakaan {
    public static HalamanUtamaUI halamanUtamaUI;
    public static PencarianController controllerPencarian;
    public static FormPencarian formPencarian;
    public static DialogUI dialogUI;
    public static BukuProvider bukuProvider;
    public static FormPeminjaman formPeminjaman;
    public static PeminjamanController peminjamanController;
    public static PeminjamanManager peminjamanManager;

    public static void main(String[] args) {
        
        bukuProvider = new BukuProvider();
        HalamanUtamaUI halamanUtamaUI = new HalamanUtamaUI();

        halamanUtamaUI.setLocationRelativeTo(null);
        halamanUtamaUI.setVisible(true);

        controllerPencarian = new PencarianController();
        peminjamanController = new PeminjamanController();
        
    }
}