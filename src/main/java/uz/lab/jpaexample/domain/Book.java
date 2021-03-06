package uz.lab.jpaexample.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String pictureLink;
    @Column
    private String title;
    @Column
    private String date;
    @Column
    private String writer;

    public Book(String name, String description, String pictureLink, String title, String date, String writer) {
        this.name = name;
        this.description = description;
        this.pictureLink = pictureLink;
        this.title = title;
        this.date = date;
        this.writer = writer;
    }
}
