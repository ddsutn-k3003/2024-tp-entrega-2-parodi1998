package ar.edu.utn.dds.k3003.model;
import java.time.LocalDateTime;
import ar.edu.utn.dds.k3003.facades.dtos.EstadoTrasladoEnum;

public class Traslado {
  private Long id;
  private final String qrVianda;
  private final Ruta ruta;
  private EstadoTrasladoEnum estado;
  private final LocalDateTime fechaCreacion;
  private final LocalDateTime fechaTraslado;

  private Long colaboradorID;

  public Long getColaboradorID() {
    return colaboradorID;
  }

  public void setColaboradorID(Long colaboradorID) {
    this.colaboradorID = colaboradorID;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getQrVianda() {
    return qrVianda;
  }

  public Ruta getRuta() {
    return ruta;
  }

  public EstadoTrasladoEnum getEstado() {
    return estado;
  }

  public void setEstado(EstadoTrasladoEnum estado) {
    this.estado = estado;
  }

  public LocalDateTime getFechaCreacion() {
    return fechaCreacion;
  }

  public LocalDateTime getFechaTraslado() {
    return fechaTraslado;
  }

  public Traslado(String qrVianda, Ruta ruta, EstadoTrasladoEnum estado, LocalDateTime fechaTraslado) {
    this.qrVianda = qrVianda;
    this.ruta = ruta;
    this.estado = estado;
    this.fechaCreacion = LocalDateTime.now();
    this.fechaTraslado = fechaTraslado;
  }
}
