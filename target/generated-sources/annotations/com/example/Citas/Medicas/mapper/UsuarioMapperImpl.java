package com.example.Citas.Medicas.mapper;

import com.example.Citas.Medicas.dtos.UsuarioDto;
import com.example.Citas.Medicas.models.UsuarioModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-26T12:45:42+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuarioDto ModelToDTO(UsuarioModel usuarioModel) {
        if ( usuarioModel == null ) {
            return null;
        }

        UsuarioDto.UsuarioDtoBuilder usuarioDto = UsuarioDto.builder();

        usuarioDto.id( usuarioModel.getId() );
        usuarioDto.nombre( usuarioModel.getNombre() );
        usuarioDto.apellidos( usuarioModel.getApellidos() );
        usuarioDto.usuario( usuarioModel.getUsuario() );

        return usuarioDto.build();
    }

    @Override
    public UsuarioModel DtoToModel(UsuarioDto usuarioDto) {
        if ( usuarioDto == null ) {
            return null;
        }

        UsuarioModel usuarioModel = new UsuarioModel();

        usuarioModel.setId( usuarioDto.getId() );
        usuarioModel.setNombre( usuarioDto.getNombre() );
        usuarioModel.setApellidos( usuarioDto.getApellidos() );
        usuarioModel.setUsuario( usuarioDto.getUsuario() );

        return usuarioModel;
    }

    @Override
    public List<UsuarioDto> ListaModelToListaDto(List<UsuarioModel> usuarioModelList) {
        if ( usuarioModelList == null ) {
            return null;
        }

        List<UsuarioDto> list = new ArrayList<UsuarioDto>( usuarioModelList.size() );
        for ( UsuarioModel usuarioModel : usuarioModelList ) {
            list.add( ModelToDTO( usuarioModel ) );
        }

        return list;
    }

    @Override
    public List<UsuarioModel> ListaDtoToListaModel(List<UsuarioDto> usuarioDtoList) {
        if ( usuarioDtoList == null ) {
            return null;
        }

        List<UsuarioModel> list = new ArrayList<UsuarioModel>( usuarioDtoList.size() );
        for ( UsuarioDto usuarioDto : usuarioDtoList ) {
            list.add( DtoToModel( usuarioDto ) );
        }

        return list;
    }
}
