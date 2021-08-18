package model;

import java.util.ArrayList;
import model.Matrix;

public class Human {
    private  String sobrenome;
    private  String segundoNome;
    private  String nome;
    private  String apelido;
    private boolean isPlugged = false;
    private boolean isAlive = false;
    private ArrayList<Human> humanForaMatrix = new ArrayList<>();
    private ArrayList<Human>naMatrix = new ArrayList<>();
    private ArrayList<Ship>naves = new ArrayList<>();

    public Human(String sobrenome, String segundoNome, String nome){
        this.sobrenome = sobrenome;
        this.segundoNome = segundoNome;
        this.nome = nome;
        isPlugged = false;
        humanForaMatrix.add(this);
    }
    public Human(String sobrenome, String nome){
        this.sobrenome = sobrenome;
        this.nome = nome;
        isPlugged = false;
       humanForaMatrix.add(this);
    }
    public Human(String apelido){
        this.apelido = apelido;
        isPlugged = false;
        humanForaMatrix.add(this);
    }
    
    public String getSobrenome() {
        return this.sobrenome;
    }
    public String getSegundoNome() {
        return this.segundoNome;
    }
    public String getNome() {
        return this.nome;
    }
    public String getFirstName() {
        // if(! isPlugged){
        //     return apelido;
        // }
        return this.getNome();
    }
    public String getLastName() {
        return this.getSobrenome();
    }

    public String getFullName() {
        
        return this.nome + " "+this.segundoNome + " " + this.sobrenome;
    }

    public String getAlias() {
        return apelido;
    }
    public String getMiddleName() {
        return this.segundoNome;
    }
    public boolean isPlugged() {
        if(!this.humanForaMatrix.contains(this)){
            isPlugged = false;
        return false;
        }else{
            isPlugged = true;
        }
        return true;
    }


    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public ArrayList<Human> getHumanos(){
        return humanForaMatrix;
    }

    public boolean isCaptainOf(Ship n) {
        if(this.apelido == n.getCaptain().getAlias()){
            
            return true;
        }
        return false;
    }

    public void promoteToCaptainOf(Ship logos) {
        if(this.getHumanos().contains(this)){
            logos.promoteToCaptain(this);
        }  
    }


    public boolean isCrewMemberOf(Ship nve) {
        if(nve.HumanNaNave(this)){

            return true;
        }
        return false;
    }
    /**
     * deixar de ser tripulação
     */
    public void resign() {
       removerHuman(this);
    //this.removerHuman(this);
    }

    void removerHuman(Human h){
        
        if(this.humanForaMatrix.contains(h)){
            humanForaMatrix.remove(h);
            //naMatrix.remove(h);
        }
    }
    public ArrayList<Ship> getNaves() {
        return naves;
    }
    public ArrayList<Human> getHumanForaMatrix() {
        return humanForaMatrix;
    }
    public ArrayList<Human> getNaMatrix() {
        return naMatrix;
    }
    
    boolean podeAdicionarNave(Ship sp){
        return ! this.naves.contains(sp);
    }

    void adicionarHumNav(Ship s){
        if(this.podeAdicionarNave(s) && s.podeRecrutarHum(this)){
            this.naves.add(s);
            s.getHumano().add(this);
        }
    
    }
    public void join(Ship nv) {
        if(this.podeAdicionarNave(nv) && nv.podeRecrutarHum(this)){
            this.naves.add(nv);
            nv.getHumano().add(this);
        }
    }
    public void plug() {
        humanForaMatrix.add(this);
        isPlugged = true;
        isPlugged();
    }
    
    public void unplug() {
        humanForaMatrix.remove(this);
        isPlugged = false;
        isPlugged();
    }
    public void unplug(Human a) {
        if(humanForaMatrix.contains(a)){
            humanForaMatrix.remove(a);
           // if(a.isPlugged){
                a.isPlugged = false;
                isPlugged();
                isAlive = false;
           // }
            //isPlugged();
        }
    }
    
    public boolean isAlive() {
        return true;
    }
    @Override
    public String toString() {
        
        return "Mr. "+ this.sobrenome;
    }
}


