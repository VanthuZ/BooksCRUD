package pl.vanthus.BookCRUD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.vanthus.BookCRUD.model.Author;
import pl.vanthus.BookCRUD.repository.AuthorRepository;
import java.util.List;


@Service
public class AuthorService {

    AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAuthorList(){
        return authorRepository.findAll();
    }

    public void deleteAuthorById(Long id){
        authorRepository.deleteById(id);
    }

    public Author getAuthorById(Long id){
        return authorRepository.getOne(id);
    }

    public void updateAurhor(Long id, Author updatedAuthor){
        Author author = authorRepository.getOne(id);

        author.setName(updatedAuthor.getName());
        author.setLastName(updatedAuthor.getLastName());

        authorRepository.save(author);
    }
}
