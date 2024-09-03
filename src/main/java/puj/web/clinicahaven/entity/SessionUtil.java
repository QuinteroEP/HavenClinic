package puj.web.clinicahaven.entity;

import jakarta.servlet.http.HttpSession;
import puj.web.clinicahaven.entity.Cliente;

public class SessionUtil {

    private static final String LOGGED_IN_CLIENT = "loggedInClient";

    public static void setLoggedInClient(HttpSession session, Cliente cliente) {
        session.setAttribute(LOGGED_IN_CLIENT, cliente);
    }

    public static Cliente getLoggedInClient(HttpSession session) {
        return (Cliente) session.getAttribute(LOGGED_IN_CLIENT);
    }

    public static void removeLoggedInClient(HttpSession session) {
        session.removeAttribute(LOGGED_IN_CLIENT);
    }
}