package cl.duoc.videogame.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanieDTO {
    private Long id;
    private String name;
    private String country;
}
