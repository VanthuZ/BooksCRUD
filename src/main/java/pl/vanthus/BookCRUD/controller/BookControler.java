package pl.vanthus.BookCRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.vanthus.BookCRUD.model.Author;
import pl.vanthus.BookCRUD.repository.AuthorRepository;

@Controller
public class BookControler {

    AuthorRepository authorRepository;

    @Autowired
    public BookControler(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @PostMapping("/addBookAuthor")
    public String addAuthor(@ModelAttribute Author author){
        authorRepository.save(author);
        return "redirect:/";
    }

    @GetMapping("/addBookAuthor")
    public String addAuthor(Model model){
        model.addAttribute("author", new Author());
        return "addBookAuthor";
    }


}
