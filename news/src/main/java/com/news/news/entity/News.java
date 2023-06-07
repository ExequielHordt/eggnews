package com.news.news.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author Exequiel Hordt
 * @version 17 Feb 2023
 */
@Entity(name = "news")
@Data
public class News implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String portrait;
    @Column(length = 8000)
    private String body;
}
