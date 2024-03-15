public class Buku {
    private String judul;

    public Buku (String judul) {
        this.judul = judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getJudul() {
        return judul;
    }

    public String toString() {
        return "Judul: " + judul;
    }
}
