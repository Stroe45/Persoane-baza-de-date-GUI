import java.util.ArrayList;
import java.util.List;

public class ListaPersoane {
    List<Persoana> allPersoane=new ArrayList<>();

    Persoana p1=new Persoana("Vasile",34);
    Persoana p2=new Persoana("Ionel",40);
    Persoana p3=new Persoana("Marcel",22);
    Persoana p4=new Persoana("Manea",18);
    Persoana p5=new Persoana("Maria",33);

    public ListaPersoane(){
        allPersoane.add(p1);
        allPersoane.add(p2);
        allPersoane.add(p3);
        allPersoane.add(p4);
        allPersoane.add(p5);
    }

    public void adaugare(Persoana p){
        allPersoane.add(p);
    }

    public void stergere(Persoana p){
        allPersoane.remove(p);
    }

    public void golire(){
        allPersoane.clear();
    }

    public List<Persoana> getAllPersoane(){
        return allPersoane;
    }
}
