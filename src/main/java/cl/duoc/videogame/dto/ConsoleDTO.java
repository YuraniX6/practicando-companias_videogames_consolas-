package cl.duoc.videogame.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsoleDTO {
    private long id;
    private String name;
    private Integer releaseYear;
    private CompanieDTO companie;

}
