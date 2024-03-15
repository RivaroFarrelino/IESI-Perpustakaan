public class BukuDipinjam {
    private Buku buku;
    private int lamaPinjam; 

    public BukuDipinjam(Buku buku, int lamaPinjam) {
        this.buku = buku;
        this.lamaPinjam = lamaPinjam;
    }

    public Buku getBuku() {
        return buku;
    }

    public int getLamaPinjam() {
        return lamaPinjam;
    }
}
