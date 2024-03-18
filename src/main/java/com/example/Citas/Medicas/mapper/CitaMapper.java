package com.example.Citas.Medicas.mapper;

import com.example.Citas.Medicas.dtos.CitaDto;
import com.example.Citas.Medicas.models.CitaModel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CitaMapper {

    //Metodo que realiza el cambio de Entidad a Dto de Cita
    @Mapping( source = "id", target = "id")
    CitaDto ModelToDTO(CitaModel citaModel);

    //Metodo que realiza el cambio de Dto a Entidad de Cita
    @InheritInverseConfiguration
    CitaModel DtoToModel(CitaDto citaDto);

    //Metodo que realiza el cambio de  lista de Entidades a  lista de Dto's de Cita
    List<CitaDto> ListaModelToListaDto (List<CitaModel> citaModelList);

    //Metodo que realiza el cambio de lista de Dto's  a lista de Entidades  de Cita
    List<CitaModel> ListaDtoToListaModel (List<CitaDto> citaDtoList);
    

}
