package pl.vanthus.BookCRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.vanthus.BookCRUD.model.Author;
import pl.vanthus.BookCRUD.repository.AuthorRepository;
import pl.vanthus.BookCRUD.service.AuthorService;



@Controller
public class AuthorController {


    AuthorService authorService;
    AuthorRepository authorRepository;


    @Autowired
    public AuthorController(AuthorService authorService, AuthorRepository authorRepository) {
        this.authorService = authorService;
        this.authorRepository = authorRepository;
    }

    @GetMapping("/authors")
    public String showAuthors(Model model){
        model.addAttribute("authorList", authorService.getAuthorList());
        return "authors";
    }

    @PostMapping("/addAuthor")
    public String addAuthor(@ModelAttribute Author author){
        authorRepository.save(author);
        return "redirect:/";
    }

    @DeleteMapping("/deleteAuthor/{authorId}")
    public String deleteAuthor(@PathVariable Long authorId){
        authorService.deleteAuthorById(authorId);
        return "redirect:/authors";
    }



}
