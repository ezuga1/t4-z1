package ba.unsa.etf.rpr;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws Exception {
        Laptop l = new Laptop();
        l.setProcesor("Intel i5");
        l.setBrend("Lenovo");
        l.setCijena(1000);
        l.setHdd(256);
        l.setGrafickaKartica("NVIDIA");
        l.setModel("ideapad l340");
        l.setRam(8);
        l.setSsd(256);
        Laptop l2 = new Laptop();
        l2.setProcesor("AMD");
        l2.setBrend("HP");
        l2.setCijena(1000);
        l2.setHdd(256);
        l2.setGrafickaKartica("NVIDIA");
        l2.setModel("Probook");
        l2.setRam(16);
        l2.setSsd(256);
        LaptopDao dao = new LaptopDaoXMLFile(new File("laptop.xml"));
        dao.dodajLaptopUFile(l);
        dao.dodajLaptopUFile(l2);

        LaptopDao daojson = new LaptopDaoJSONFile(new File("laptop.json"));
        daojson.dodajLaptopUFile(l);
        daojson.dodajLaptopUFile(l2);


        LaptopDao ser = new LaptopDaoSerializableFile(new File("laptopi.txt"));
        ser.dodajLaptopUFile(l);
        ser.dodajLaptopUFile(l2);
        List<Laptop> laptopi = ser.vratiPodatkeIzDatoteke();
        System.out.println(laptopi);





    }
}
