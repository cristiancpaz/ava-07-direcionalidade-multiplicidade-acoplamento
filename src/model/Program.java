package model;


public class Program {
    private String apelido;
    private final String lastname = null;
    private final String firstname = null;
    private final String fullname = null;

    // Program (String lastname, String fullname, String firstname){
    //     this.lastname = null;
    //     this.fullname = null;
    //     this.firstname = null;
    // }
     Program(String apelido){
        this.apelido = apelido;
    }
     Program(){
        this.apelido = null;
    }
    public String getApelido() {
        return apelido;
    }
    public String getFirstName() {
        return null;
    }
    public String getLastName() {
        return null;
    }
    public String getFullName() {
        return null;
    }
    public String getAlias() {
        return getApelido();
    }
@Override
public String toString() {

    return getApelido();
}
}
