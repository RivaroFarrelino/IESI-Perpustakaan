public class Perpustakaan {
    public static HalamanUtamaUI halamanUtamaUI;
    public static PencarianController controllerPencarian;
    public static FormPencarian formPencarian;
    public static DialogUI dialogUI;
    public static BukuProvider bukuProvider;

    public static void main(String[] args) {
        
        HalamanUtamaUI halamanUtamaUI = new HalamanUtamaUI();

        halamanUtamaUI.pack();
        halamanUtamaUI.setLocationRelativeTo(null);
        halamanUtamaUI.setVisible(true);

        controllerPencarian = new PencarianController();
        
    }
}