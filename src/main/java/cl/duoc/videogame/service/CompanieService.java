package cl.duoc.videogame.service;

import org.springframework.stereotype.Service;
import cl.duoc.videogame.dto.CompanieDTO;
import cl.duoc.videogame.model.Companies;

import java.util.List;
import java.util.stream.Collectors;
import cl.duoc.videogame.repository.CompanieRepository;

@Service
public class CompanieService {
    private final CompanieRepository companieRepository;

    public CompanieService(CompanieRepository companieRepository){
        this.companieRepository = companieRepository;
    }

    public List<CompanieDTO> findAll(){
        return companieRepository.findAll()
                    .stream()
                    .map(c -> new CompanieDTO(c.getId(), c.getName(), c.getCountry()))
                    .collect(Collectors.toList()); 
    }

    public CompanieDTO create(CompanieDTO companieDTO){
        Companies companie = new Companies();
        companie.setName(companieDTO.getName());
        companie.setCountry(companieDTO.getCountry());
        companie = companieRepository.save(companie);
        companieDTO.setId(companie.getId());
        return companieDTO;
    }

    public CompanieDTO findById(Long id){
        Companies companie = companieRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Companie not found"));
        return new CompanieDTO(companie.getId(), companie.getName(), companie.getCountry());
    }

    public void delete(Long id){
        companieRepository.deleteById(id);
    }
}