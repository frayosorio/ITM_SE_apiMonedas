package apimonedas.apimonedas.core.interfaces.repositorios;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import apimonedas.apimonedas.dominio.CambioMoneda;

public interface ICambioMonedaRepositorio extends JpaRepository<CambioMoneda, Long>  {

    @Query("")
    List<CambioMoneda> listarPorPeriodo(long idMoneda, Date fecha1, Date fecha2);

}
