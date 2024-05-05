package ar.edu.utn.dds.k3003.facades;
import ar.edu.utn.dds.k3003.facades.dtos.RutaDTO;
import ar.edu.utn.dds.k3003.facades.dtos.TrasladoDTO;

import ar.edu.utn.dds.k3003.facades.exceptions.TrasladoNoAsignableException;
import ar.edu.utn.dds.k3003.model.Traslado;
import java.util.List;
public interface FachadaLogistica {

  public RutaDTO agregar(RutaDTO rutaDTO);

  public TrasladoDTO buscarXId(Long aLong);

  public TrasladoDTO asignarTraslado(TrasladoDTO trasladoDTO) throws TrasladoNoAsignableException;

  public List<Traslado> trasladosDeColaborador(Long aLong, Integer integer, Integer integer1);

  public void trasladoDepositado(Long aLong);

  public void trasladoRetirado(Long aLong);

  public void setHeladerasProxy(FachadaHeladeras fachadaHeladeras);

  public void setViandasProxy(FachadaViandas fachadaViandas);
}
