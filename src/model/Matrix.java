package model;

import java.util.ArrayList;

public class Matrix {
private static Matrix matrix = new Matrix();
private ArrayList<Human> humanMatrix = new ArrayList<>();
private ArrayList<Human> foraMatrix = new ArrayList<>();
private ArrayList<Program> programa = new ArrayList<>();
private ArrayList<Agent> agente = new ArrayList<>();
//private final Program prog = new Program();
private boolean isPlugged = false;

    Matrix(){
      
    }
    public static Matrix get() {
        return  matrix;
    }
    public Human newHuman(String sobrenome, String nome) {
        Human h = new Human(sobrenome, nome);
        this.humanMatrix.add(h);
        this.isPlugged = true;
        return h;
    }
    public Human newHuman(String apelido) {
        Human h = new Human(apelido);
        this.humanMatrix.add(h);
        this.isPlugged = true;
        return h;
    }
    public Human newHuman(String sobrenome, String segundoNome, String nome) {
        Human h = new Human(sobrenome, segundoNome, nome);
        this.humanMatrix.add(h);
        this.isPlugged = true;
        return h;
    }
    public Program newProgram(String s) {
        Program p = new Program(s);
        this.programa.add(p);
        return p;
    }
    public Agent newAgent(String nome) {
        Agent a = new Agent(nome);
        this.agente.add(a);
        return a;
    }
    public boolean has(Human o) {
        if(humanMatrix.contains(o)){

            return true;
        }
        return false;
    }
    public boolean has(Program o) {
        if(programa.contains(o)){
            return true;
        }
        return false;
    }
    
    public void free(Human obj, String apelido) {
        if(humanMatrix.contains(obj)){
            humanMatrix.remove(obj);
           // foraMatrix.add(newHuman(apelido));
            foraMatrix.add(new Human(apelido));
            this.isPlugged = false;
        }
    }
    public void free(Agent smith, String apelido) {
        if(agente.contains(smith)){
            isPlugged = true;
        }
    }
    public boolean has(Agent o) {
        if(agente.contains(o)){
            return true;
        }
        return false;
    }
    public void enter(Human n) {
        if(!humanMatrix.contains(n)){
            humanMatrix.add(n);
            n.isPlugged();
            isPlugged = true;
        }
    }
    public void enter(Human t, Human m) {
        if(!humanMatrix.contains(t) && !humanMatrix.contains(m)){
            humanMatrix.add(t);
            humanMatrix.add(m);
        
            isPlugged = true;
        }
    }
    public void leave(Human m) {
        if(humanMatrix.contains(m)){
            humanMatrix.remove(m);
            if(m.getHumanForaMatrix().remove(m));
           // m.isPlugged();
        }
    }

    // public boolean isPlugged(Human h) {
    //     if(humanMatrix.contains(h)){

    //         return true;
    //     }
    //     return false;
    // }

}
