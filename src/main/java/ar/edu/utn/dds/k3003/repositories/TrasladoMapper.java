package ar.edu.utn.dds.k3003.repositories;

import ar.edu.utn.dds.k3003.model.Traslado;
import ar.edu.utn.dds.k3003.facades.dtos.TrasladoDTO;

public class TrasladoMapper {

  public TrasladoDTO map(Traslado traslado) {
    TrasladoDTO trasladoDTO = new TrasladoDTO(traslado.getQrVianda(),traslado.getRuta().getHeladeraIdOrigen(),
        traslado.getRuta().getHeladeraIdDestino());

    trasladoDTO.setEstado(traslado.getEstado());
    trasladoDTO.setId(traslado.getId());
    trasladoDTO.setColaboradorId(traslado.getRuta().getColaboradorId());


    return trasladoDTO;
  }
}
