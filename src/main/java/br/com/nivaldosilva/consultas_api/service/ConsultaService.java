package br.com.nivaldosilva.consultas_api.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import br.com.nivaldosilva.consultas_api.dto.ConsultaDTO;
import br.com.nivaldosilva.consultas_api.model.ConsultaEntity;
import br.com.nivaldosilva.consultas_api.repository.ConsultaRepository;
import lombok.RequiredArgsConstructor;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ConsultaService {

    private final ConsultaRepository repository;
    private final ModelMapper mapper;


    public Optional<ConsultaDTO> create(ConsultaDTO request){
       ConsultaEntity consultaEntity = mapper.map(request, ConsultaEntity.class);
       repository.saveAndFlush(consultaEntity);
       return Optional.of(mapper.map(consultaEntity, ConsultaDTO.class));
    }


    public List<ConsultaDTO> getAll(){
        
        List<ConsultaEntity> consultas = repository.findAll();
        List<ConsultaDTO> responses = new ArrayList<>();

        for(ConsultaEntity consultaEntity: consultas){
            ConsultaDTO response = mapper.map(consultaEntity,ConsultaDTO.class);
            responses.add(response);
        }
        return responses;
    }



    public Optional<ConsultaDTO> getById(Long id){
   
    Optional<ConsultaEntity> consultas = repository.findById(id);

      if (consultas.isPresent()) {
        return Optional.of(mapper.map(consultas.get(),ConsultaDTO.class));
      }
      return Optional.empty();
    }


    public Optional<ConsultaDTO> update(Long id, ConsultaDTO request){
      
     Optional<ConsultaEntity> consultas = repository.findById(id);

     if (consultas.isPresent()) {
        consultas.get().setDataConsulta(request.getDataConsulta());
        consultas.get().setHoraConsulta(request.getHoraConsulta());
        repository.save(consultas.get());
        return Optional.of(mapper.map(consultas, ConsultaDTO.class));
     }
       return Optional.empty();
    }


    public boolean inactive(Long id){
       
        Optional<ConsultaEntity> consultas = repository.findById(id);
        if (consultas.isPresent()) {
            repository.save(consultas.get());
            return true;
        }
        return false;
    }

}
