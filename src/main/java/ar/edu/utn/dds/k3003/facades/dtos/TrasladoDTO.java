package ar.edu.utn.dds.k3003.facades.dtos;

import ar.edu.utn.dds.k3003.model.Ruta;
import java.time.LocalDateTime;

public class TrasladoDTO {

  private Long Id;
  private final String qrVianda;
  private EstadoTrasladoEnum estado;

  private LocalDateTime fechaTraslado;
  private final Integer heladeraOrigen;
  private final Integer heladeraDestino;
  private Long colaboradorID;

  public TrasladoDTO(String qrVianda,Integer heladeraOrien, Integer heladeraDestino) {
    this.qrVianda = qrVianda;
    this.heladeraOrigen = heladeraOrien;
    this.heladeraDestino = heladeraDestino;
  }

  public Long getId() {
    return Id;
  }

  public void setId(Long id) {
    Id = id;
  }

  public String getQrVianda() {
    return qrVianda;
  }

  public EstadoTrasladoEnum getStatus() {
    return estado;
  }

  public void setEstado(EstadoTrasladoEnum estado) {
    this.estado = estado;
  }

  public LocalDateTime getFechaTraslado() {
    return fechaTraslado;
  }

  public void setFechaTraslado(LocalDateTime fechaTraslado) {
    this.fechaTraslado = fechaTraslado;
  }

  public Integer getHeladeraOrigen() {
    return heladeraOrigen;
  }

  public Integer getHeladeraDestino() {
    return heladeraDestino;
  }

  public Long getColaboradorId() {
    return colaboradorID;
  }

  public void setColaboradorId(Long colaoradorID) {
    this.colaboradorID = colaoradorID;
  }
}