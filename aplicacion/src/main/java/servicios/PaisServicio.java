package monedas.api.aplicacion.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import monedas.api.dominio.DTOs.*;
import monedas.api.dominio.entidades.*;
import monedas.api.core.servicios.*;
import monedas.api.infraestructura.repositorios.*;
import monedas.api.infraestructura.integracion.*;

@Service
public class PaisServicio implements IPaisServicio {

    @Autowired
    private IPaisRepositorio repositorio;

    @Autowired
    private PaisCliente integracion;

    @Override
    public List<Pais> listar() {
        return repositorio.findAll();
    }

    @Override
    public Pais obtener(Long id) {
        var pais = repositorio.findById(id);
        return pais.isEmpty() ? null : pais.get();
    }

    @Override
    public List<Pais> buscar(String nombre) {
        return repositorio.buscar(nombre);
    }

    @Override
    public Pais agregar(Pais pais) {
        pais.setId(0);
        return repositorio.save(pais);
    }

    @Override
    public Pais modificar(Pais pais) {
        Optional<Pais> paisEncontrado = repositorio.findById(pais.getId());
        if (!paisEncontrado.isEmpty()) {
            return repositorio.save(pais);
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
    public CapitalDto obtenerCapital(String nombre) {
        return integracion.obtenerCapital(nombre);
    }

}
