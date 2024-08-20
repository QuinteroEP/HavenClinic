package puj.web.clinicahaven.controller;

public class NotFoundException extends RuntimeException {
    
    private int id;
    private int petId;
    
    public NotFoundException(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
