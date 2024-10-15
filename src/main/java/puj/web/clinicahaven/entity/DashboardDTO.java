package puj.web.clinicahaven.entity;

import java.util.List;
import java.util.Map;

public class DashboardDTO {
    private long totalTratamientos;
    private Map<String, Long> tratamientosPorMedicamento;
    private long veterinariosActivos;
    private long veterinariosInactivos;
    private long totalMascotas;
    private long mascotasActivas;
    private double ventasTotales;
    private double gananciasTotales;
    private List<Object[]> top3Tratamientos;

    // Getters and Setters

    public Map<String, Long> getTratamientosPorMedicamento() {
        return tratamientosPorMedicamento;
    }

    public void setTratamientosPorMedicamento(Map<String, Long> tratamientosPorMedicamento) {
        this.tratamientosPorMedicamento = tratamientosPorMedicamento;
    }

    public long getTotalTratamientos() {
        return totalTratamientos;
    }

    public void setTotalTratamientos(long totalTratamientos) {
        this.totalTratamientos = totalTratamientos;
    }

    public long getVeterinariosActivos() {
        return veterinariosActivos;
    }

    public void setVeterinariosActivos(long veterinariosActivos) {
        this.veterinariosActivos = veterinariosActivos;
    }

    public long getVeterinariosInactivos() {
        return veterinariosInactivos;
    }

    public void setVeterinariosInactivos(long veterinariosInactivos) {
        this.veterinariosInactivos = veterinariosInactivos;
    }

    public long getTotalMascotas() {
        return totalMascotas;
    }

    public void setTotalMascotas(long totalMascotas) {
        this.totalMascotas = totalMascotas;
    }

    public long getMascotasActivas() {
        return mascotasActivas;
    }

    public void setMascotasActivas(long mascotasActivas) {
        this.mascotasActivas = mascotasActivas;
    }

    public double getVentasTotales() {
        return ventasTotales;
    }

    public void setVentasTotales(double ventasTotales) {
        this.ventasTotales = ventasTotales;
    }

    public double getGananciasTotales() {
        return gananciasTotales;
    }

    public void setGananciasTotales(double gananciasTotales) {
        this.gananciasTotales = gananciasTotales;
    }

    public List<Object[]> getTop3Tratamientos() {
        return top3Tratamientos;
    }

    public void setTop3Tratamientos(List<Object[]> top3Tratamientos) {
        this.top3Tratamientos = top3Tratamientos;
    }
}