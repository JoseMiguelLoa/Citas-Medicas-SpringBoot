package com.example.Citas.Medicas.mapper;

import com.example.Citas.Medicas.dtos.CitaDto;
import com.example.Citas.Medicas.models.CitaModel;
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
public class CitaMapperImpl implements CitaMapper {

    @Override
    public CitaDto ModelToDTO(CitaModel citaModel) {
        if ( citaModel == null ) {
            return null;
        }

        CitaDto.CitaDtoBuilder citaDto = CitaDto.builder();

        citaDto.id( citaModel.getId() );
        citaDto.fechaHora( citaModel.getFechaHora() );
        citaDto.motivoCita( citaModel.getMotivoCita() );
        citaDto.attribute11( citaModel.getAttribute11() );
        citaDto.paciente( citaModel.getPaciente() );
        citaDto.medico( citaModel.getMedico() );
        citaDto.diagnostico( citaModel.getDiagnostico() );

        return citaDto.build();
    }

    @Override
    public CitaModel DtoToModel(CitaDto citaDto) {
        if ( citaDto == null ) {
            return null;
        }

        CitaModel.CitaModelBuilder citaModel = CitaModel.builder();

        citaModel.id( citaDto.getId() );
        citaModel.fechaHora( citaDto.getFechaHora() );
        citaModel.motivoCita( citaDto.getMotivoCita() );
        citaModel.attribute11( citaDto.getAttribute11() );
        citaModel.paciente( citaDto.getPaciente() );
        citaModel.medico( citaDto.getMedico() );
        citaModel.diagnostico( citaDto.getDiagnostico() );

        return citaModel.build();
    }

    @Override
    public List<CitaDto> ListaModelToListaDto(List<CitaModel> citaModelList) {
        if ( citaModelList == null ) {
            return null;
        }

        List<CitaDto> list = new ArrayList<CitaDto>( citaModelList.size() );
        for ( CitaModel citaModel : citaModelList ) {
            list.add( ModelToDTO( citaModel ) );
        }

        return list;
    }

    @Override
    public List<CitaModel> ListaDtoToListaModel(List<CitaDto> citaDtoList) {
        if ( citaDtoList == null ) {
            return null;
        }

        List<CitaModel> list = new ArrayList<CitaModel>( citaDtoList.size() );
        for ( CitaDto citaDto : citaDtoList ) {
            list.add( DtoToModel( citaDto ) );
        }

        return list;
    }
}
