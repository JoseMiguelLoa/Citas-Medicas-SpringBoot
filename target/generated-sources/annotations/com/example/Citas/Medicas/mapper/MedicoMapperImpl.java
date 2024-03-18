package com.example.Citas.Medicas.mapper;

import com.example.Citas.Medicas.dtos.MedicoDto;
import com.example.Citas.Medicas.models.MedicoModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-18T13:39:11+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class MedicoMapperImpl implements MedicoMapper {

    @Override
    public MedicoDto ModelToDTO(MedicoModel medicoModel) {
        if ( medicoModel == null ) {
            return null;
        }

        MedicoDto.MedicoDtoBuilder medicoDto = MedicoDto.builder();

        medicoDto.id( medicoModel.getId() );
        medicoDto.numColegiado( medicoModel.getNumColegiado() );

        return medicoDto.build();
    }

    @Override
    public MedicoModel DtoToModel(MedicoDto medicoDto) {
        if ( medicoDto == null ) {
            return null;
        }

        MedicoModel.MedicoModelBuilder medicoModel = MedicoModel.builder();

        medicoModel.numColegiado( medicoDto.getNumColegiado() );

        return medicoModel.build();
    }

    @Override
    public List<MedicoDto> ListaModelToListaDto(List<MedicoModel> medicoModelList) {
        if ( medicoModelList == null ) {
            return null;
        }

        List<MedicoDto> list = new ArrayList<MedicoDto>( medicoModelList.size() );
        for ( MedicoModel medicoModel : medicoModelList ) {
            list.add( ModelToDTO( medicoModel ) );
        }

        return list;
    }

    @Override
    public List<MedicoModel> ListaDtoToListaModel(List<MedicoDto> medicoDtoList) {
        if ( medicoDtoList == null ) {
            return null;
        }

        List<MedicoModel> list = new ArrayList<MedicoModel>( medicoDtoList.size() );
        for ( MedicoDto medicoDto : medicoDtoList ) {
            list.add( DtoToModel( medicoDto ) );
        }

        return list;
    }
}
