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

    //Metodo que realiza el cambio de Entidad a Dto de Medico
    @Mapping( source = "id", target = "id")
    MedicoDto ModelToDTO(MedicoModel medicoModel);

    //Metodo que realiza el cambio de Dto a Entidad de Medico
    @InheritInverseConfiguration
    MedicoModel DtoToModel(MedicoDto medicoDto);

    //Metodo que realiza el cambio de  lista de Entidades a  lista de Dto's de Medico
    List<MedicoDto> ListaModelToListaDto (List<MedicoModel> medicoModelList);

    //Metodo que realiza el cambio de lista de Dto's  a lista de Entidades  de Medico
    List<MedicoModel> ListaDtoToListaModel (List<MedicoDto> medicoDtoList);
}

