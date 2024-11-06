package es.w2m.infrastructure.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SPACESHIPS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SpaceshipEntity {

    @Id
    Long id;

    @Column(nullable = false)
    String name;
}
