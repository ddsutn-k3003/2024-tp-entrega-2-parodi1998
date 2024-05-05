package ar.edu.utn.dds.k3003.model;
import java.time.LocalDateTime;
public class Ruta {

  private Long id;
  private Long colaboradorId;
  private Integer heladeraIdOrigen;
  private Integer heladeraIdDestino;

  private LocalDateTime fechaCreacion;
  private Boolean activo;

  public Ruta(Long colaboradorId, Integer heladeraIdOrigen, Integer heladeraIdDestino) {
    this.colaboradorId = colaboradorId;
    this.heladeraIdOrigen = heladeraIdOrigen;
    this.heladeraIdDestino = heladeraIdDestino;
    this.fechaCreacion = LocalDateTime.now();
    this.activo = true;

  }
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getColaboradorId() {
    return colaboradorId;
  }

  public void setColaboradorId(Long colaboradorId) {
    this.colaboradorId = colaboradorId;
  }

  public Integer getHeladeraIdOrigen() {
    return heladeraIdOrigen;
  }

  public void setHeladeraIdOrigen(Integer heladeraIdOrigen) {
    this.heladeraIdOrigen = heladeraIdOrigen;
  }

  public Integer getHeladeraIdDestino() {
    return heladeraIdDestino;
  }

  public void setHeladeraIdDestino(Integer heladeraIdDestino) {
    this.heladeraIdDestino = heladeraIdDestino;
  }

  public LocalDateTime getFechaCreacion() {
    return fechaCreacion;
  }

  public void setFechaCreacion(LocalDateTime fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
  }

  public Boolean getActivo() {
    return activo;
  }

  public void setActivo(Boolean activo) {
    this.activo = activo;
  }


}