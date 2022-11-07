package ba.unsa.etf.rpr;

import java.io.Serializable;
import java.util.Objects;

public class Laptop implements Serializable {
    private String brend, model, procesor, grafickaKartica;
    private double cijena, velicinaEkrana;
    private int ram, hdd, ssd;
    public Laptop () {}

    public Laptop(String brend, String model, String procesor, String grafickaKartica, double cijena, double velicinaEkrana, int ram, int hdd, int ssd) {
        this.brend = brend;
        this.model = model;
        this.procesor = procesor;
        this.grafickaKartica = grafickaKartica;
        this.cijena = cijena;
        this.velicinaEkrana = velicinaEkrana;
        this.ram = ram;
        this.hdd = hdd;
        this.ssd = ssd;
    }

    public void setBrend(String brend) {
        this.brend = brend;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setProcesor(String procesor) {
        this.procesor = procesor;
    }

    public void setGrafickaKartica(String grafickaKartica) {
        this.grafickaKartica = grafickaKartica;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
    }

    public void setVelicinaEkrana(double velicinaEkrana) {
        this.velicinaEkrana = velicinaEkrana;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public void setSsd(int ssd) {
        this.ssd = ssd;
    }

    public String getBrend() {
        return brend;
    }

    public String getModel() {
        return model;
    }

    public String getProcesor() {
        return procesor;
    }

    public String getGrafickaKartica() {
        return grafickaKartica;
    }

    public double getCijena() {
        return cijena;
    }

    public double getVelicinaEkrana() {
        return velicinaEkrana;
    }

    public int getRam() {
        return ram;
    }

    public int getHdd() {
        return hdd;
    }

    public int getSsd() {
        return ssd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Laptop)) return false;
        Laptop laptop = (Laptop) o;
        return Double.compare(laptop.getCijena(), getCijena()) == 0 && Double.compare(laptop.getVelicinaEkrana(), getVelicinaEkrana()) == 0 && getRam() == laptop.getRam() && getHdd() == laptop.getHdd() && getSsd() == laptop.getSsd() && getBrend().equals(laptop.getBrend()) && getModel().equals(laptop.getModel()) && getProcesor().equals(laptop.getProcesor()) && getGrafickaKartica().equals(laptop.getGrafickaKartica());
    }



    @Override
    public String toString() {
        return "Laptop{" +
                "brend='" + brend + '\'' +
                ", model='" + model + '\'' +
                ", procesor='" + procesor + '\'' +
                ", grafickaKartica='" + grafickaKartica + '\'' +
                ", cijena=" + cijena +
                ", velicinaEkrana=" + velicinaEkrana +
                ", ram=" + ram +
                ", hdd=" + hdd +
                ", ssd=" + ssd +
                '}';
    }
}
