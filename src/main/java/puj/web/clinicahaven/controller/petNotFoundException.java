package puj.web.clinicahaven.controller;

public class petNotFoundException extends RuntimeException{
    private int petId;

    public petNotFoundException(int petId) {
        this.petId = petId;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }
}
