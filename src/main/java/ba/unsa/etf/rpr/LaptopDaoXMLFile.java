package ba.unsa.etf.rpr;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

class LaptopDaoXMLFile implements LaptopDao{
    private File file;

    public LaptopDaoXMLFile(File file) {
        this.file =file;
    }

    private ArrayList<Laptop> laptopi = new ArrayList<Laptop>();

    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) throws IOException {
    laptopi.add(laptop);
        ObjectMapper map = new XmlMapper();
        FileOutputStream out = new FileOutputStream(file);
        String s = map.writeValueAsString(laptopi);
        out.write(s.getBytes());
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
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() {

        ArrayList<Laptop> vrati = null;
        ObjectMapper map = new XmlMapper();
        try{
            vrati = map.readValue(file, new TypeReference<ArrayList<Laptop>>() {
            });
        }
        catch (IOException e){
            System.out.println(e);
        }
        return vrati;
    }
}
