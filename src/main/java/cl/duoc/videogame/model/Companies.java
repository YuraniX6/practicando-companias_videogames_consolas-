package cl.duoc.videogame.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="companies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Companies {

    @Id //indica que es pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //incremento automatico
    private long id;//campo

    @NotBlank   //validar que no sea nulo ni vacio
    private String name;

    private String country;

}
