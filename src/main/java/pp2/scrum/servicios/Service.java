package pp2.scrum.servicios;

public abstract class Service {
    private String name;
    
    public Service(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}
