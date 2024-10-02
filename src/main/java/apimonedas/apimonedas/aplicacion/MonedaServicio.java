package apimonedas.apimonedas.aplicacion;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import apimonedas.apimonedas.core.interfaces.repositorios.IMonedaRepositorio;
import apimonedas.apimonedas.core.interfaces.servicios.IMonedaServicio;
import apimonedas.apimonedas.dominio.CambioMoneda;
import apimonedas.apimonedas.dominio.Moneda;

@Service
public class MonedaServicio implements IMonedaServicio {

    private IMonedaRepositorio repositorio;

    public MonedaServicio(IMonedaRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Moneda> listar() {
        return repositorio.findAll();
    }

    @Override
    public Moneda obtener(Long id) {
        return repositorio.findById(id).isEmpty() ? repositorio.findById(id).get() : null;
    }

    @Override
    public List<Moneda> buscar(String nombre) {
        return repositorio.buscar(nombre);
    }

    @Override
    public Moneda buscarPorPais(String nombre) {
        return repositorio.buscarPorPais(nombre);
    }

    @Override
    public Moneda agregar(Moneda moneda) {
        moneda.setId(0);
        return repositorio.save(moneda);
    }

    @Override
    public Moneda modificar(Moneda moneda) {
        Optional<Moneda> monedaEncontrada = repositorio.findById(moneda.getId());
        if (monedaEncontrada.isPresent()) {
            return repositorio.save(moneda);
        } else {
            return null;
        }
    }

    @Override
    public boolean eliminar(Long id) {
        try {
            repositorio.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public List<CambioMoneda> listarPorPeriodo(long idMoneda, Date fecha1, Date fecha2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarPorPeriodo'");
    }

}
