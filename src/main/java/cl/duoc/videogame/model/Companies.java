package cl.duoc.videogame.model;

import java.util.Set;
import java.util.HashSet;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    //uno a muchos relacion
    @OneToMany(mappedBy = "companie")//indica el dueño de la relacion
    private Set<Console> consoles = new HashSet<>();//incluimos la coleccion a la relaccion

}
