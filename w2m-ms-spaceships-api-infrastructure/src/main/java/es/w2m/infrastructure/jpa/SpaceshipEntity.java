package es.w2m.infrastructure.jpa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SPACESHIPS")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SpaceshipEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SPACESHIPS_SEQ")
    @SequenceGenerator(name = "SPACESHIPS_SEQ", sequenceName = "SPACESHIPS_SEQ", initialValue = 23, allocationSize = 1)
    Long id;

    @Column(nullable = false)
    String name;
}
