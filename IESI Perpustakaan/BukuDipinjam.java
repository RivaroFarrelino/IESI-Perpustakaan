public class BukuDipinjam {
    private int lama;
    private Buku buku;

    public BukuDipinjam(Buku buku, int lama) {
        this.lama = lama;
        this.buku = buku;
    }

    public int getLamaPinjam() {
        return lama;
    }

    public Buku getBuku() {
        return buku;
    }
}
