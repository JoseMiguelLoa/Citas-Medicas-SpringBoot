package com.example.Citas.Medicas.mapper;

import com.example.Citas.Medicas.dtos.CitaDto;
import com.example.Citas.Medicas.models.CitaModel;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CitaMapper {

    //Método que realiza el cambio de Entidad a Dto de Cita
    @Mappings({
        @Mapping( source = "id", target = "id"),
        @Mapping(source = "paciente.id", target = "paciente_id"),
        @Mapping(source = "medico.id", target = "medico_id"),
    })
    CitaDto ModelToDTO(CitaModel citaModel);

    //Método que realiza el cambio de Dto a Entidad de Cita
    @InheritInverseConfiguration
    CitaModel DtoToModel(CitaDto citaDto);

    //Método que realiza el cambio de lista de Entidades a lista de Dto's de Cita
    List<CitaDto> ListaModelToListaDto (List<CitaModel> citaModelList);

    //Método que realiza el cambio de lista de Dto's a lista de Entidades de Cita
    List<CitaModel> ListaDtoToListaModel (List<CitaDto> citaDtoList);
    

}
