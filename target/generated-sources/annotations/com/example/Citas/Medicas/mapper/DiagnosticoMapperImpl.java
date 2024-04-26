package com.example.Citas.Medicas.mapper;

import com.example.Citas.Medicas.dtos.DiagnosticoDto;
import com.example.Citas.Medicas.models.CitaModel;
import com.example.Citas.Medicas.models.DiagnosticoModel;
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
public class DiagnosticoMapperImpl implements DiagnosticoMapper {

    @Override
    public DiagnosticoDto ModelToDTO(DiagnosticoModel diagnosticoModel) {
        if ( diagnosticoModel == null ) {
            return null;
        }

        DiagnosticoDto.DiagnosticoDtoBuilder diagnosticoDto = DiagnosticoDto.builder();

        diagnosticoDto.id( diagnosticoModel.getId() );
        diagnosticoDto.citaId( diagnosticoModelCitaId( diagnosticoModel ) );
        diagnosticoDto.valoracionEspecialista( diagnosticoModel.getValoracionEspecialista() );
        diagnosticoDto.enfermedad( diagnosticoModel.getEnfermedad() );

        return diagnosticoDto.build();
    }

    @Override
    public DiagnosticoModel DtoToModel(DiagnosticoDto diagnosticoDto) {
        if ( diagnosticoDto == null ) {
            return null;
        }

        DiagnosticoModel.DiagnosticoModelBuilder diagnosticoModel = DiagnosticoModel.builder();

        diagnosticoModel.cita( diagnosticoDtoToCitaModel( diagnosticoDto ) );
        diagnosticoModel.id( diagnosticoDto.getId() );
        diagnosticoModel.valoracionEspecialista( diagnosticoDto.getValoracionEspecialista() );
        diagnosticoModel.enfermedad( diagnosticoDto.getEnfermedad() );

        return diagnosticoModel.build();
    }

    @Override
    public List<DiagnosticoDto> ListaModelToListaDto(List<DiagnosticoModel> diagnosticoModelList) {
        if ( diagnosticoModelList == null ) {
            return null;
        }

        List<DiagnosticoDto> list = new ArrayList<DiagnosticoDto>( diagnosticoModelList.size() );
        for ( DiagnosticoModel diagnosticoModel : diagnosticoModelList ) {
            list.add( ModelToDTO( diagnosticoModel ) );
        }

        return list;
    }

    @Override
    public List<DiagnosticoModel> ListaDtoToListaModel(List<DiagnosticoDto> diagnosticoDtoList) {
        if ( diagnosticoDtoList == null ) {
            return null;
        }

        List<DiagnosticoModel> list = new ArrayList<DiagnosticoModel>( diagnosticoDtoList.size() );
        for ( DiagnosticoDto diagnosticoDto : diagnosticoDtoList ) {
            list.add( DtoToModel( diagnosticoDto ) );
        }

        return list;
    }

    private Long diagnosticoModelCitaId(DiagnosticoModel diagnosticoModel) {
        if ( diagnosticoModel == null ) {
            return null;
        }
        CitaModel cita = diagnosticoModel.getCita();
        if ( cita == null ) {
            return null;
        }
        Long id = cita.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected CitaModel diagnosticoDtoToCitaModel(DiagnosticoDto diagnosticoDto) {
        if ( diagnosticoDto == null ) {
            return null;
        }

        CitaModel.CitaModelBuilder citaModel = CitaModel.builder();

        citaModel.id( diagnosticoDto.getCitaId() );

        return citaModel.build();
    }
}
