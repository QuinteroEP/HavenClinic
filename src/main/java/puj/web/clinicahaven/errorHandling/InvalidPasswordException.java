package puj.web.clinicahaven.errorHandling;

public class InvalidPasswordException extends RuntimeException {
    private String email;

    public InvalidPasswordException(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}