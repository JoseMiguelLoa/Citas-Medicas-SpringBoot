package com.example.Citas.Medicas.mapper;

import com.example.Citas.Medicas.dtos.CitaDto;
import com.example.Citas.Medicas.models.CitaModel;
import com.example.Citas.Medicas.models.DiagnosticoModel;
import com.example.Citas.Medicas.models.MedicoModel;
import com.example.Citas.Medicas.models.PacienteModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-18T13:46:01+0100",
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
        citaDto.paciente_id( citaModelPacienteId( citaModel ) );
        citaDto.medico_id( citaModelMedicoId( citaModel ) );
        citaDto.diagnostico_id( citaModelDiagnosticoId( citaModel ) );
        citaDto.fechaHora( citaModel.getFechaHora() );
        citaDto.motivoCita( citaModel.getMotivoCita() );
        citaDto.attribute11( citaModel.getAttribute11() );

        return citaDto.build();
    }

    @Override
    public CitaModel DtoToModel(CitaDto citaDto) {
        if ( citaDto == null ) {
            return null;
        }

        CitaModel.CitaModelBuilder citaModel = CitaModel.builder();

        citaModel.paciente( citaDtoToPacienteModel( citaDto ) );
        citaModel.medico( citaDtoToMedicoModel( citaDto ) );
        citaModel.diagnostico( citaDtoToDiagnosticoModel( citaDto ) );
        citaModel.id( citaDto.getId() );
        citaModel.fechaHora( citaDto.getFechaHora() );
        citaModel.motivoCita( citaDto.getMotivoCita() );
        citaModel.attribute11( citaDto.getAttribute11() );

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

    private Long citaModelPacienteId(CitaModel citaModel) {
        if ( citaModel == null ) {
            return null;
        }
        PacienteModel paciente = citaModel.getPaciente();
        if ( paciente == null ) {
            return null;
        }
        Long id = paciente.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long citaModelMedicoId(CitaModel citaModel) {
        if ( citaModel == null ) {
            return null;
        }
        MedicoModel medico = citaModel.getMedico();
        if ( medico == null ) {
            return null;
        }
        Long id = medico.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long citaModelDiagnosticoId(CitaModel citaModel) {
        if ( citaModel == null ) {
            return null;
        }
        DiagnosticoModel diagnostico = citaModel.getDiagnostico();
        if ( diagnostico == null ) {
            return null;
        }
        Long id = diagnostico.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected PacienteModel citaDtoToPacienteModel(CitaDto citaDto) {
        if ( citaDto == null ) {
            return null;
        }

        PacienteModel.PacienteModelBuilder pacienteModel = PacienteModel.builder();

        return pacienteModel.build();
    }

    protected MedicoModel citaDtoToMedicoModel(CitaDto citaDto) {
        if ( citaDto == null ) {
            return null;
        }

        MedicoModel.MedicoModelBuilder medicoModel = MedicoModel.builder();

        return medicoModel.build();
    }

    protected DiagnosticoModel citaDtoToDiagnosticoModel(CitaDto citaDto) {
        if ( citaDto == null ) {
            return null;
        }

        DiagnosticoModel.DiagnosticoModelBuilder diagnosticoModel = DiagnosticoModel.builder();

        diagnosticoModel.id( citaDto.getDiagnostico_id() );

        return diagnosticoModel.build();
    }
}
