package pl.vanthus.BookCRUD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.vanthus.BookCRUD.model.Book;
import pl.vanthus.BookCRUD.repository.BookRepository;

import java.util.List;


@Service
public class BookService {

    BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book>getBookList(){
        return bookRepository.findAll();
    }

    public void deleteBookById(Long id){
        bookRepository.deleteById(id);
    }
}
