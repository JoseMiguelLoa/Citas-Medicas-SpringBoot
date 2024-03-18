package com.example.Citas.Medicas.mapper;

import com.example.Citas.Medicas.dtos.UsuarioDto;
import com.example.Citas.Medicas.models.UsuarioModel;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UsuarioMapper {

    //Metodo que realiza el cambio de Entidad a Dto de usuario
    @Mapping( source = "id", target = "id")
    UsuarioDto ModelToDTO( UsuarioModel usuarioModel);

    //Metodo que realiza el cambio de Dto a Entidad de usuario
    @InheritInverseConfiguration
    UsuarioModel DtoToModel(UsuarioDto usuarioDto);

    //Metodo que realiza el cambio de  lista de Entidades a  lista de Dto's de usuario
    List<UsuarioDto> ListaModelToListaDto (List<UsuarioModel> usuarioModelList);

    //Metodo que realiza el cambio de lista de Dto's  a lista de Entidades  de usuario
    List<UsuarioModel> ListaDtoToListaModel (List<UsuarioDto> usuarioDtoList);
}
