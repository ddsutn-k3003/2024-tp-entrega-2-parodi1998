package ar.edu.utn.dds.k3003.facades.dtos;

public class RutaDTO {
  private Long Id;
  private Long colaboradorId;
  private Integer heladeraIdOrigen;
  private Integer heladeraIdDestino;

  public RutaDTO(Long colaboradorid, Integer heladeraOrigen, Integer heladeraDestino){
    this.colaboradorId = colaboradorid;
    this.heladeraIdOrigen = heladeraOrigen;
    this.heladeraIdDestino = heladeraDestino;
  }

  public Long getId() {
    return Id;
  }

  public void setId(Long id) {
    Id = id;
  }

  public long getColaboradorId() {
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
}