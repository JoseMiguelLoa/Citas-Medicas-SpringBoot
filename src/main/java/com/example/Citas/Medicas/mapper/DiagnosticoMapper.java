package com.example.Citas.Medicas.mapper;

import com.example.Citas.Medicas.dtos.DiagnosticoDto;
import com.example.Citas.Medicas.models.DiagnosticoModel;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DiagnosticoMapper {

    //Método que realiza el cambio de Entidad a Dto de Diagnóstico
    @Mappings({
            @Mapping( source = "id", target = "id"),
            @Mapping(source = "cita.id", target = "citaId"),
    })
    DiagnosticoDto ModelToDTO(DiagnosticoModel diagnosticoModel);

    //Método que realiza el cambio de Dto a Entidad de Diagnóstico
    @InheritInverseConfiguration
    DiagnosticoModel DtoToModel(DiagnosticoDto diagnosticoDto);

    //Método que realiza el cambio de lista de Entidades a lista de Dto's de Diagnóstico
    List<DiagnosticoDto> ListaModelToListaDto (List<DiagnosticoModel> diagnosticoModelList);

    //Método que realiza el cambio de lista de Dto's a lista de Entidades de Diagnóstico
    List<DiagnosticoModel> ListaDtoToListaModel (List<DiagnosticoDto> diagnosticoDtoList);

}
