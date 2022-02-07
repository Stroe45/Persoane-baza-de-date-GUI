public class Persoana {
    private String nume;
    private int varsta;

    public Persoana(String nume, int varsta) {
        if(nume==null||nume.length()<3) throw new ExceptieNume();
        if(varsta<0) throw new ExceptieVarsta();
        this.nume = nume;
        this.varsta = varsta;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }


    public boolean hasFaramaTextuala(String s){
        if(nume.startsWith(s)){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return nume +", "+ varsta+" ani";
    }
}


