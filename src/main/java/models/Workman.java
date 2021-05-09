package models;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "public.workman")
public class Workman {
    @Id
    Integer id;
    @Column(name = "\"name\"")
    String name;
    @Column(name = "age")
    Integer age;
    @Column(name = "\"position\"")
    Integer position;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }


}
