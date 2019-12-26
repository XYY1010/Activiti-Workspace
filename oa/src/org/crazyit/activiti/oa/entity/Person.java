package org.crazyit.activiti.oa.entity;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

/**
 * @Author: xyy
 * @Date: 2019/12/24 12:45
 */
@Entity
@Table(name = "CRA_PERSON")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

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
}
