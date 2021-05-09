package models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "public.zoo")
public class Zoo {
    @Id
    Integer id;

    @Column(name = "\"name\"")
    String zoo_name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return zoo_name;
    }

    public void setName(String name) {
        this.zoo_name = name;
    }


}
