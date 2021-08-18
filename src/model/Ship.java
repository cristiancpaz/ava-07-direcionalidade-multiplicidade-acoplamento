package model;
//import model.Human;
import java.util.ArrayList;

public class Ship {
    private final String nome;
    private int countHuman = 0;
    private String capitao;
    private final ArrayList<Human> humano = new ArrayList<>();
    private final ArrayList<Ship> ships = new ArrayList<>();

    public Ship(String nome) {
        this.nome = nome;
        ships.add(this);
    }

    public String getNome() {
        return this.nome;
    }
    boolean podeRecrutarHum(Human h){
        //!this.ships.contains(h);
        
        return ! this.humano.contains(h) && ! h.isCrewMemberOf(this); 
    }

    public void recruit(Human hum) {
        if(this.podeRecrutarHum(hum) && hum.podeAdicionarNave(this)){
            this.humano.add(hum);
            hum.getNaves().add(this);
            //this.adicionarHumNav(hum);
            countHuman++;   
              
        }
    }

    public int crewCount() { 
        return countHuman;
    }
    
    public Human getCaptain() {
        if( countHuman >= 1){
            return this.humano.get(0);
        }
            return null;
    }

     public ArrayList<Human> getHumano() {
         return humano;
     }

    public void removerHuman(Human h){
        this.humano.remove(h);
    }

    public void promoteToCaptain(Human n) {
        if(this.humano.contains(n)){
            this.removerHuman(this.humano.get(0));
            this.humano.add(1,this.humano.get(0));
            this.humano.add(0, n);
        }
    }

    /**
     * verifica qual nave o humano esta
     * @param h nome humano
     * @return nome da nave
     */
    public boolean HumanNaNave(Human h){
        if(humano.contains(h))
        for (Ship ship : ships) {
            ship.humano.contains(h);
                return true;
            
        }
        return false;
    }
    
    @Override
    public String toString() {
        
        return getNome();
    }

    public void dismiss(Human m) {
      if(humano.contains(m)){
          humano.remove(m);
          countHuman--;
      }
        
        
    }

}