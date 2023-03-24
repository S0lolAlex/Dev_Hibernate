package org.greenSnake.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class Planet {
    @Id
    @Column(name = "id",length = 50, nullable = false)
    private String id;
    @Column(name = "name", length = 500,nullable = false)
    private String name;
}
