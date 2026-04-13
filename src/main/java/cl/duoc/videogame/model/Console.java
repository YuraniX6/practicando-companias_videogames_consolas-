package cl.duoc.videogame.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name="consoles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Console {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String name;

    private Integer releaseYear;

    @ManyToOne
    @JoinColumn(name = "companie_id", nullable = false)
    private Companies companie;

}
