package model;


public class Agent {
    private final String lastname;
    private String alias;
    private boolean isPlugged = false;

    Agent(String lastname){
        this.lastname = lastname;
    }

    public String getLastName() {
        return lastname;
    }
    
    public String getFirstName() {
        return null;
    }
    public String getFullName() {
        return null;
    }
    public String getAlias() {
        return null;
    }
    @Override
    public String toString() {
        
        return "Agent "+getLastName();
    }

    public boolean isPlugged() {
        return true;
    }

    


}
