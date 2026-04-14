package cl.duoc.videogame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.duoc.videogame.dto.CompanieDTO;
import java.util.List;
import java.util.stream.Collectors;
import cl.duoc.videogame.repository.CompanieRepository;

@Service
public class CompanieService {
    @Autowired

    public List<CompanieDTO> FindAll(){
        return CompanieRepository.findAll()
                    .stream()
                    .map(c -> new CompanieDTO(c.getId(), c.getName(), c.getCountry()))
                    .collect(Collectors.toList()); 
    }

}
