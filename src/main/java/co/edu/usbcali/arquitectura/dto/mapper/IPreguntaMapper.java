package co.edu.usbcali.arquitectura.dto.mapper;

import co.edu.usbcali.arquitectura.modelo.Pregunta;
import co.edu.usbcali.arquitectura.modelo.dto.PreguntaDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IPreguntaMapper {
    public PreguntaDTO preguntaToPreguntaDTO(Pregunta pregunta)
        throws Exception;

    public Pregunta preguntaDTOToPregunta(PreguntaDTO preguntaDTO)
        throws Exception;

    public List<PreguntaDTO> listPreguntaToListPreguntaDTO(
        List<Pregunta> preguntas) throws Exception;

    public List<Pregunta> listPreguntaDTOToListPregunta(
        List<PreguntaDTO> preguntaDTOs) throws Exception;
}
