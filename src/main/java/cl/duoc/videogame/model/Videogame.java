package cl.duoc.videogame.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="videogames")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Videogame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    private Integer releaseYear;

    private String genre;

    private String developer;

    @Builder.Default
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})

    @JoinTable(
        name="videogame_console",
        joinColumns = @JoinColumn(name="videogame_id"),
        inverseJoinColumns = @JoinColumn(name="console_id")
    )
    private Set<Console> consoles = new HashSet<>();

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Videogame)) return false;
        Videogame other = (Videogame) o;
        return id != null && id.equals(other.getId());
    }

    @Override
    public int hashCode(){
        return 31;
    }
    

}
