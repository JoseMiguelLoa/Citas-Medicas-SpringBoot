package com.example.Citas.Medicas.mapper;

import com.example.Citas.Medicas.dtos.DiagnosticoDto;
import com.example.Citas.Medicas.models.DiagnosticoModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-18T10:40:30+0100",
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
}
