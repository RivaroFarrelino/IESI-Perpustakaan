public class Perpustakaan {
    public static HalamanUtamaUI halamanUtamaUI;
    public static PencarianController controllerPencarian;
    public static FormPencarian formPencarian;
    public static DialogUI dialogUI;
    public static BukuProvider bukuProvider;

    public static void main(String[] args) {
        
        Perpustakaan.halamanUtamaUI = new HalamanUtamaUI();

        Perpustakaan.halamanUtamaUI.pack();
        Perpustakaan.halamanUtamaUI.setLocationRelativeTo(null);

        Perpustakaan.halamanUtamaUI.setVisible(true);

    }
}