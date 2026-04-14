package cl.duoc.videogame.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VideogameDTO {
    private long id;
    private String title;
    private Integer releaseYear;
    private String genre;
    private String developer;
    private List<ConsoleDTO> consoles;

}
