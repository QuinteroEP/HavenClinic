package puj.web.clinicahaven.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import puj.web.clinicahaven.dto.DashboardDTO;
import puj.web.clinicahaven.repositorio.*;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

@Service
public class DashboardImplementation implements DashboardService {

    @Autowired
    private tratamientoRepository TratamientoRepository;
    @Autowired
    private VeterinarioRepository veterinarioRepository;
    @Autowired
    private petRepository PetRepository;
    @Autowired
    private drogaRepository DrogaRepository;

    @Override
    public DashboardDTO getKPIs() {
        DashboardDTO dto = new DashboardDTO();

        LocalDate now = LocalDate.now();
        LocalDate firstDayOfMonth = now.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate lastDayOfMonth = now.with(TemporalAdjusters.lastDayOfMonth());


        dto.setTotalTratamientos(TratamientoRepository.countByFechaBetween(firstDayOfMonth, lastDayOfMonth));
      //  dto.setTratamientosPorMedicamento(TratamientoRepository.countTratamientosPorMedicamento(firstDayOfMonth, lastDayOfMonth));
        dto.setVeterinariosActivos(veterinarioRepository.countByActivo(true));
        dto.setVeterinariosInactivos(veterinarioRepository.countByActivo(false));
        dto.setTotalMascotas(PetRepository.count());
        dto.setMascotasActivas(PetRepository.countByEnTratamiento(true));
        dto.setVentasTotales(TratamientoRepository.sumVentasTotales());
        dto.setGananciasTotales(TratamientoRepository.sumGananciasTotales());

        List<Object[]> top3Drogas = DrogaRepository.findTop3ByOrderByUnidadesVendidasDesc();
        dto.setTop3Tratamientos(top3Drogas.subList(0, Math.min(top3Drogas.size(), 3)));

        return dto;
    }
}