package pl.vanthus.BookCRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.vanthus.BookCRUD.model.Author;
import pl.vanthus.BookCRUD.model.Book;
import pl.vanthus.BookCRUD.repository.AuthorRepository;
import pl.vanthus.BookCRUD.repository.BookRepository;
import pl.vanthus.BookCRUD.service.AuthorService;


@Controller
public class BookControler {

    AuthorRepository authorRepository;
    BookRepository bookRepository;
    AuthorService authorService;

    @Autowired
    public BookControler(AuthorRepository authorRepository, BookRepository bookRepository, AuthorService authorService) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }


    @GetMapping("/addBookAuthor")
    public String addAuthor(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("authorList", authorService.getAuthorList());
        model.addAttribute("author", new Author());

        return "addBookAuthor";
    }

    @PostMapping("/addAuthor")
    public String addAuthor(@ModelAttribute Author author){
        authorRepository.save(author);
        return "redirect:/";
    }


    @PostMapping("/addBook")
    public String addBook(@ModelAttribute Book book){
        bookRepository.save(book);
        return "redirect:/";
    }

}
