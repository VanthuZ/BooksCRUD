package pl.vanthus.BookCRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.vanthus.BookCRUD.model.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
