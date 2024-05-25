package ar.edu.utn.dds.k3003.app;

import ar.edu.utn.dds.k3003.facades.FachadaHeladeras;
import ar.edu.utn.dds.k3003.facades.FachadaViandas;
import ar.edu.utn.dds.k3003.facades.dtos.EstadoTrasladoEnum;
import ar.edu.utn.dds.k3003.facades.dtos.EstadoViandaEnum;
import ar.edu.utn.dds.k3003.facades.dtos.RetiroDTO;
import ar.edu.utn.dds.k3003.facades.dtos.RutaDTO;
import ar.edu.utn.dds.k3003.facades.dtos.TrasladoDTO;
import ar.edu.utn.dds.k3003.facades.dtos.ViandaDTO;
import ar.edu.utn.dds.k3003.model.Ruta;
import ar.edu.utn.dds.k3003.model.Traslado;
import ar.edu.utn.dds.k3003.repositories.RutaMapper;
import ar.edu.utn.dds.k3003.repositories.RutaRepository;
import ar.edu.utn.dds.k3003.repositories.TrasladoMapper;
import ar.edu.utn.dds.k3003.repositories.TrasladoRepository;
import ar.edu.utn.dds.k3003.facades.exceptions.TrasladoNoAsignableException;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
public class Fachada implements ar.edu.utn.dds.k3003.facades.FachadaLogistica {

  private final RutaRepository rutaRepository;
  private final RutaMapper rutaMapper;
  private final TrasladoRepository trasladoRepository;
  private final TrasladoMapper trasladoMapper;
  private FachadaViandas fachadaViandas;
  private FachadaHeladeras fachadaheladeras;

  public Fachada() {
    this.rutaRepository = new RutaRepository();
    this.rutaMapper = new RutaMapper();
    this.trasladoMapper = new TrasladoMapper();
    this.trasladoRepository = new TrasladoRepository();
  }

  @Override
  public RutaDTO agregar(RutaDTO rutaDTO) {
    Ruta ruta = new Ruta(rutaDTO.getColaboradorId(), rutaDTO.getHeladeraIdOrigen(), rutaDTO.getHeladeraIdDestino());
    ruta = this.rutaRepository.save(ruta);
    return rutaMapper.map(ruta);
  }
  @Override
  public TrasladoDTO buscarXId(Long Id) throws NoSuchElementException {

    Traslado traslado = trasladoRepository.findById(Id);
    return trasladoMapper.map(traslado);
  }

  @Override
  public TrasladoDTO asignarTraslado(TrasladoDTO trasladoDTO) throws  TrasladoNoAsignableException {

    ViandaDTO viandaDTO = fachadaViandas.buscarXQR(trasladoDTO.getQrVianda());

    List<Ruta> rutasPosibles = this.rutaRepository.findByHeladeras(trasladoDTO.getHeladeraOrigen(),
        trasladoDTO.getHeladeraDestino());

    Collections.shuffle(rutasPosibles);
    Ruta ruta = rutasPosibles.get(0);

    Traslado traslado = trasladoRepository.save(new Traslado(viandaDTO.getCodigoQR(), ruta,
        EstadoTrasladoEnum.ASIGNADO, trasladoDTO.getFechaTraslado()));


    return this.trasladoMapper.map(traslado);
  }

  @Override
  public List<Traslado> trasladosDeColaborador(Long Id, Integer mes, Integer anio) {
    LocalDateTime date = LocalDateTime.of(mes,anio,1,0,0);

    return trasladoRepository.findCyColaboradorIdandDate(Id,date);
  }

  @Override
  public void setHeladerasProxy(FachadaHeladeras fachadaHeladeras) {
    this.fachadaheladeras = fachadaHeladeras;

  }

  @Override
  public void setViandasProxy(FachadaViandas fachadaViandas) {
    this.fachadaViandas = fachadaViandas;
  }

  @Override
  public void trasladoRetirado(Long trasladoId) {
    TrasladoDTO trasladoDTO = buscarXId(trasladoId);
    Ruta rutaDeTraslado = new Ruta(trasladoDTO.getColaboradorId(),trasladoDTO.getHeladeraOrigen(),trasladoDTO.getHeladeraDestino());
    RetiroDTO retiroDTO = new RetiroDTO(trasladoDTO.getQrVianda(),"",trasladoDTO.getFechaTraslado(),trasladoDTO.getHeladeraOrigen());
    fachadaheladeras.retirar(retiroDTO);
    fachadaViandas.modificarEstado(trasladoDTO.getQrVianda(), EstadoViandaEnum.EN_TRASLADO);
    trasladoRepository.save(new Traslado(trasladoDTO.getQrVianda(),rutaDeTraslado,EstadoTrasladoEnum.EN_VIAJE,trasladoDTO.getFechaTraslado()));

  }

  @Override
  public void trasladoDepositado(Long trasladoId) {

    TrasladoDTO trasladoDTO = buscarXId(trasladoId);
    Ruta rutaDeTraslado = new Ruta(trasladoDTO.getColaboradorId(),trasladoDTO.getHeladeraOrigen(),trasladoDTO.getHeladeraDestino());
    fachadaheladeras.depositar(trasladoDTO.getHeladeraDestino(),trasladoDTO.getQrVianda());
    fachadaViandas.modificarHeladera(trasladoDTO.getQrVianda(),trasladoDTO.getHeladeraDestino());
    fachadaViandas.modificarEstado(trasladoDTO.getQrVianda(), EstadoViandaEnum.DEPOSITADA);
    trasladoRepository.save(new Traslado(trasladoDTO.getQrVianda(),rutaDeTraslado,EstadoTrasladoEnum.ENTREGADO,trasladoDTO.getFechaTraslado()));

  }
}
