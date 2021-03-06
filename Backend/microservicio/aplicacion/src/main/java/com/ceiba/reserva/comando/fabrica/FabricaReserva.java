package com.ceiba.reserva.comando.fabrica;


import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.modelo.entidad.Reserva;
import org.springframework.stereotype.Component;

@Component
public class FabricaReserva {

    public Reserva crear(ComandoReserva comandoReserva){
        return new Reserva(
                comandoReserva.getId(),
                comandoReserva.getCedula(),
                comandoReserva.getNombre(),
                comandoReserva.getFechaEntrada(),
                comandoReserva.getIdGlamping(),
                comandoReserva.getCantPersonas(),
                comandoReserva.getTelefono(),
                comandoReserva.getFechaSalida(),
                comandoReserva.getCostoTotal(),
                comandoReserva.getFechaRegistro()



        );
    }
}
