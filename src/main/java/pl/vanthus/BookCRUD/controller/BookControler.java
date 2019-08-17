package pl.vanthus.BookCRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pl.vanthus.BookCRUD.model.Author;
import pl.vanthus.BookCRUD.model.Book;
import pl.vanthus.BookCRUD.repository.AuthorRepository;
import pl.vanthus.BookCRUD.repository.BookRepository;
import pl.vanthus.BookCRUD.service.AuthorService;
import pl.vanthus.BookCRUD.service.BookService;


@Controller
public class BookControler {

    AuthorRepository authorRepository;
    BookRepository bookRepository;
    AuthorService authorService;
    BookService bookService;

    @Autowired
    public BookControler(AuthorRepository authorRepository, BookRepository bookRepository,
                         AuthorService authorService, BookService bookService) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @GetMapping("/addBookAuthor")
    public String addAuthor(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("authorList", authorService.getAuthorList());
        model.addAttribute("author", new Author());
        return "addBookAuthor";
    }

    @PostMapping("/addBook")
    public String addBook(@ModelAttribute Book book){
        bookRepository.save(book);
        return "redirect:/books";
    }

    @GetMapping("/books")
    public String showBook(Model model){
        model.addAttribute("bookList", bookService.getBookList());
        return "books";
    }

    @DeleteMapping("/deleteBook/{bookId}")
    public String deleteAuthor(@PathVariable Long bookId){
        bookService.deleteBookById(bookId);
        return "redirect:/books";
    }

    @GetMapping("/editBook/{bookId}")
    public String updateBook(@PathVariable Long bookId, Model model){
        Book book = bookService.getBookById(bookId);
        model.addAttribute("book", book);
        model.addAttribute("authorList", authorService.getAuthorList());
        return "editBook";
    }

    @PutMapping("/editBook/{bookId}")
    public String updateBook(@PathVariable Long bookId, @ModelAttribute Book book){
        bookService.updateBook(bookId, book);
        return "redirect:/books";
    }
}
