package puj.web.clinicahaven.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class csvService{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public void uploadCsv(String csvPath) {
        String sql = "INSERT INTO DROGA (ID, NOMBRE, PRECIO_VENTA, PRECIO_COMPRA, UNIDADES_DISPONIBLES, UNIDADES_VENDIDAS) " +
                     "SELECT * FROM CSVREAD('" + csvPath + "')";
        jdbcTemplate.execute(sql);
    }
    
}
