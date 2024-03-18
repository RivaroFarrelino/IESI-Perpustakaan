import java.util.ArrayList;
import java.util.logging.Logger;


public class BukuProvider {
    private static final Logger logger = Logger.getLogger(BukuProvider.class.getName());

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
        bukuCollection.add(new Buku("Bumi Manusia"));
        bukuCollection.add(new Buku("Harry Potter"));
        bukuCollection.add(new Buku("Laskar Pelangi"));
        bukuCollection.add(new Buku("Atomic Habit"));
        bukuCollection.add(new Buku("Marmut Merah Jambu"));
        bukuCollection.add(new Buku("Pecahkan NYC"));
        bukuCollection.add(new Buku("Chasing the Last Laugh"));

    }

    public ArrayList<Buku> selectBuku(String judul) {
        ArrayList<Buku> foundBuku = new ArrayList<>();
        
        for (Buku buku : bukuCollection) {
            if (buku.getJudul().toLowerCase().contains(judul.toLowerCase())) {
                foundBuku.add(buku);
            }
        }
        logger.info("Jumlah buku ditemukan: " + foundBuku.size());
        return foundBuku;   
    }
}
