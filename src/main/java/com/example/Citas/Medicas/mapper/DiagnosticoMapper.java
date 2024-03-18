package com.example.Citas.Medicas.mapper;

import com.example.Citas.Medicas.dtos.DiagnosticoDto;
import com.example.Citas.Medicas.models.DiagnosticoModel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DiagnosticoMapper {

    //Metodo que realiza el cambio de Entidad a Dto de Diagnostico
    @Mapping( source = "id", target = "id")
    DiagnosticoDto ModelToDTO(DiagnosticoModel diagnosticoModel);

    //Metodo que realiza el cambio de Dto a Entidad de Diagnostico
    @InheritInverseConfiguration
    DiagnosticoModel DtoToModel(DiagnosticoDto diagnosticoDto);

    //Metodo que realiza el cambio de  lista de Entidades a  lista de Dto's de Diagnostico
    List<DiagnosticoDto> ListaModelToListaDto (List<DiagnosticoModel> diagnosticoModelList);

    //Metodo que realiza el cambio de lista de Dto's  a lista de Entidades  de Diagnostico
    List<DiagnosticoModel> ListaDtoToListaModel (List<DiagnosticoDto> diagnosticoDtoList);

}
