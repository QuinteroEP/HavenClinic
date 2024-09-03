package puj.web.clinicahaven.errorHandling;

public class petNotFoundException extends RuntimeException{
    private Long petId;

    public petNotFoundException(Long petId) {
        this.petId = petId;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }
}
