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
    @Builder.Default
    @OneToMany(mappedBy = "companies")//indica el dueño de la relacion
    private Set<Console> consoles = new HashSet<>();//incluimos la coleccion a la relaccion

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        
        if(!(o instanceof Companies)) return false;
        
        Companies other = (Companies) o;
        return id != null && id.equals(other.getId());
    }

    @Override
    public int hashCode(){
        return 31;
    }
}
