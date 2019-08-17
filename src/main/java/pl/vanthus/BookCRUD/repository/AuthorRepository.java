package pl.vanthus.BookCRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.vanthus.BookCRUD.model.Author;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
