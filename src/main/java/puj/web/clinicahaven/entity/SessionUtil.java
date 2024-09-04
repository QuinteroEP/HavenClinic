package puj.web.clinicahaven.entity;

import jakarta.servlet.http.HttpSession;
import puj.web.clinicahaven.entity.Cliente;

public class SessionUtil {

    private static final String LOGGED_IN_CLIENT = "loggedInClient";
    private static final String LOGGED_IN_VETERINARIAN = "loggedInVeterinarian";

    public static void setLoggedInClient(HttpSession session, Cliente cliente) {
        session.setAttribute(LOGGED_IN_CLIENT, cliente);
    }

    public static Cliente getLoggedInClient(HttpSession session) {
        return (Cliente) session.getAttribute(LOGGED_IN_CLIENT);
    }

    public static void removeLoggedInClient(HttpSession session) {
        session.removeAttribute(LOGGED_IN_CLIENT);
    }

    public static void setLoggedInVeterinarian(HttpSession session, Veterinario veterinario) {
        session.setAttribute(LOGGED_IN_VETERINARIAN, veterinario);
    }

    public static Veterinario getLoggedInVeterinarian(HttpSession session) {
        return (Veterinario) session.getAttribute(LOGGED_IN_VETERINARIAN);
    }

    public static void removeLoggedInVeterinarian(HttpSession session) {
        session.removeAttribute(LOGGED_IN_VETERINARIAN);
    }
}