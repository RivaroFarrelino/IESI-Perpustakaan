import java.util.ArrayList;

public class BukuProvider {

    private ArrayList<Buku> bukuCollection;

    public BukuProvider() {
        bukuCollection = new ArrayList<>();
        bukuCollection.add(new Buku("Sherlock Holmes"));
        bukuCollection.add(new Buku("Topeng Kaca"));
        bukuCollection.add(new Buku("Doraemon"));
        bukuCollection.add(new Buku("Petualangan Doraemon"));
        bukuCollection.add(new Buku("Thomas and Friends"));
        bukuCollection.add(new Buku("The Return of Sherlock Holmes"));
        bukuCollection.add(new Buku("The Adventure of Sherlock Holmes"));
    }

    public ArrayList<Buku> selectBuku(String judul) {
        ArrayList<Buku> foundBuku = new ArrayList<>();
        for (Buku buku : bukuCollection) {
            if (buku.getJudul().toLowerCase().contains(judul.toLowerCase())) {
                foundBuku.add(buku);
            }
        }
        return foundBuku;
        
    }
    

}
