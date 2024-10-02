package apimonedas.apimonedas.presentacion;

import apimonedas.apimonedas.core.interfaces.servicios.IMonedaServicio;

public class MonedaControlador {

    private IMonedaServicio servicio;

    public MonedaControlador(IMonedaServicio servicio) {
        this.servicio = servicio;
    }

}
