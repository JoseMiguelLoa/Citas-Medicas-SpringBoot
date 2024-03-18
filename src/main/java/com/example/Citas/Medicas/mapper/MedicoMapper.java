package com.example.Citas.Medicas.mapper;


import com.example.Citas.Medicas.dtos.MedicoDto;
import com.example.Citas.Medicas.models.MedicoModel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING )
public interface MedicoMapper {

    //Método que realiza el cambio de Entidad a Dto de Médico
    @Mapping( source = "id", target = "id")
    MedicoDto ModelToDTO(MedicoModel medicoModel);

    //Método que realiza el cambio de Dto a Entidad de Médico
    @InheritInverseConfiguration
    MedicoModel DtoToModel(MedicoDto medicoDto);

    //Método que realiza el cambio de lista de Entidades a lista de Dto's de Médico
    List<MedicoDto> ListaModelToListaDto (List<MedicoModel> medicoModelList);

    //Método que realiza el cambio de lista de Dto's a lista de Entidades de Médico
    List<MedicoModel> ListaDtoToListaModel (List<MedicoDto> medicoDtoList);
}

