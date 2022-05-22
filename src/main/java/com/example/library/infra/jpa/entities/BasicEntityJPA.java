package com.example.library.infra.jpa.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.util.StringUtils;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
@Setter
@Getter
public class BasicEntityJPA {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", unique = true, length = 36)
    private String id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BasicEntityJPA)) return false;
        BasicEntityJPA that = (BasicEntityJPA) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        if(id == null || id.equals("")){
            return super.hashCode();
        }
        return Objects.hash(id);
    }
}
