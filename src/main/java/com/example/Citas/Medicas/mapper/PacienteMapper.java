package com.example.Citas.Medicas.mapper;


import com.example.Citas.Medicas.dtos.PacienteDto;
import com.example.Citas.Medicas.models.PacienteModel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING )
public interface PacienteMapper {

    //Metodo que realiza el cambio de Entidad a Dto de Paciente
    @Mapping( source = "id", target = "id")
    PacienteDto ModelToDTO(PacienteModel pacienteModel);

    //Metodo que realiza el cambio de Dto a Entidad de Paciente
    @InheritInverseConfiguration
    PacienteModel DtoToModel(PacienteDto pacienteDto);

    //Metodo que realiza el cambio de  lista de Entidades a  lista de Dto's de Paciente
    List<PacienteDto> ListaModelToListaDto (List<PacienteModel> pacienteModelList);

    //Metodo que realiza el cambio de lista de Dto's  a lista de Entidades  de Paciente
    List<PacienteModel> ListaDtoToListaModel (List<PacienteDto> pacienteDtoList);

}
