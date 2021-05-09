package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "public.places")
public class Place {
    @Id
    Integer id;
    @Column(name = "\"name\"")
    String name;
    @Column(name = "\"row\"")
    Integer row;
    @Column(name = "place_num")
    Integer place_num;

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

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getPlace_num() {
        return place_num;
    }

    public void setPlace_num(Integer place_num) {
        this.place_num = place_num;
    }


}
