package com.example.Citas.Medicas.mapper;

import com.example.Citas.Medicas.dtos.PacienteDto;
import com.example.Citas.Medicas.models.PacienteModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-18T13:39:12+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class PacienteMapperImpl implements PacienteMapper {

    @Override
    public PacienteDto ModelToDTO(PacienteModel pacienteModel) {
        if ( pacienteModel == null ) {
            return null;
        }

        PacienteDto.PacienteDtoBuilder pacienteDto = PacienteDto.builder();

        pacienteDto.id( pacienteModel.getId() );
        pacienteDto.NSS( pacienteModel.getNSS() );
        pacienteDto.numTarjeta( pacienteModel.getNumTarjeta() );
        pacienteDto.telefono( pacienteModel.getTelefono() );
        pacienteDto.direccion( pacienteModel.getDireccion() );

        return pacienteDto.build();
    }

    @Override
    public PacienteModel DtoToModel(PacienteDto pacienteDto) {
        if ( pacienteDto == null ) {
            return null;
        }

        PacienteModel.PacienteModelBuilder pacienteModel = PacienteModel.builder();

        pacienteModel.NSS( pacienteDto.getNSS() );
        pacienteModel.numTarjeta( pacienteDto.getNumTarjeta() );
        pacienteModel.telefono( pacienteDto.getTelefono() );
        pacienteModel.direccion( pacienteDto.getDireccion() );

        return pacienteModel.build();
    }

    @Override
    public List<PacienteDto> ListaModelToListaDto(List<PacienteModel> pacienteModelList) {
        if ( pacienteModelList == null ) {
            return null;
        }

        List<PacienteDto> list = new ArrayList<PacienteDto>( pacienteModelList.size() );
        for ( PacienteModel pacienteModel : pacienteModelList ) {
            list.add( ModelToDTO( pacienteModel ) );
        }

        return list;
    }

    @Override
    public List<PacienteModel> ListaDtoToListaModel(List<PacienteDto> pacienteDtoList) {
        if ( pacienteDtoList == null ) {
            return null;
        }

        List<PacienteModel> list = new ArrayList<PacienteModel>( pacienteDtoList.size() );
        for ( PacienteDto pacienteDto : pacienteDtoList ) {
            list.add( DtoToModel( pacienteDto ) );
        }

        return list;
    }
}
