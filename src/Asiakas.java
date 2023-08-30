import java.lang.*;
import java.util.Scanner;
import java.util.LinkedList;

public class Asiakas {
    static int count = 1; //saadaan samalla pdiettyä kirjaa asiakkaiden kokonaismäärästä
    private int id;
    private String name;
    private long start;
    private long end;

    public Asiakas(String name) {
        this.name = name;
        this.id = count;
        this.start = System.nanoTime();
        this.start = System.nanoTime();
        count++;
    }
    public String getName() {
        return this.name;
    }
    public int getId() {
        return this.id;
    }
    public long getStart() {
        return this.start;
    }
    public long getEnd() {
        return this.end;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setStart(long time) {
        this.start = time;
    }
    public void setEnd(long time) {
        this.end = time;
    }
    public long getTime() {
        return this.end - this.start;
    }

    //hyvin tuntuu metodit toimivan
    public static void main(String[] args) {
        LinkedList<Asiakas> asiakkaat = new LinkedList<Asiakas>();
        boolean systemOn = true;
        Scanner reader = new Scanner(System.in);

        System.out.println("Tervetuloa asiakasrekisterin käyttöliittymään.");
        while(systemOn) {
            System.out.println("Järjestelmässä tällä hetkellä olevat asiakkaat:");
            for(Asiakas i : asiakkaat) {
                System.out.println("ID: " + i.getId() + " Nimi: " + i.getName() );
            }
            System.out.println("Valitse toiminto: lisää, poista tai lopeta");
            String komento = reader.nextLine();
            if (komento.equals("lopeta")) {
                systemOn = false;
                System.out.println("Lopetettu!");
            } else if (komento.equals("lisää")) {
                System.out.print("Anna nimi:");
                String nimi = reader.nextLine();
                Asiakas asiakas = new Asiakas(nimi);
                asiakkaat.addFirst(asiakas);
            } else if (komento.equals("poista")) {
                asiakkaat.getLast().setEnd(System.nanoTime());
                System.out.println("Asiakkaan " + asiakkaat.getLast().getId() + " jonossa viettämä aika: " + asiakkaat.getLast().getTime());
                asiakkaat.removeLast();
            }


        }
    }
}
