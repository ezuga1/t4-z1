package ba.unsa.etf.rpr;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LaptopDaoSerializableFile implements LaptopDao{
    private ArrayList<Laptop> laptopi = new ArrayList<Laptop>();
    File file;

    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
    }

    public LaptopDaoSerializableFile( File file) {

        this.file = file;
    }


    @Override
    public void dodajLaptopUFile(Laptop laptop) throws IOException {
            laptopi.add(laptop);
        FileOutputStream out = new FileOutputStream(file);
        ObjectOutputStream outo = new ObjectOutputStream(out);
        outo.writeObject(laptopi);
        outo.close();
        out.close();
    }

    @Override
    public Laptop getLaptop(String procesor) {
        for(Laptop l : laptopi){
            if(l.getProcesor().equals(procesor))
                return l;
        }
        throw new NeodgovarajuciProcesorError("Laptop nije u listi");
    }

    @Override
    public void napuniListu(ArrayList<Laptop> laptopi) {
        this.laptopi=laptopi;
    }

    @Override
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() throws IOException {
        ArrayList<Laptop> vrati;
        FileInputStream in = new FileInputStream(file);
        ObjectInputStream ino = new ObjectInputStream(in);
        try{
            vrati = (ArrayList)ino.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return vrati;
    }
}
