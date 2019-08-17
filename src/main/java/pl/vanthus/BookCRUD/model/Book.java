package pl.vanthus.BookCRUD.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @ManyToMany(
                cascade = CascadeType.ALL,
                fetch = FetchType.EAGER)
    @JoinTable(
                name = "book_author",
                joinColumns = @JoinColumn(name = "book_id"),
                inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors;
    private int pages;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publicationDate;

}
