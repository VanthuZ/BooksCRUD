package pl.vanthus.BookCRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.vanthus.BookCRUD.service.AuthorService;



@Controller
public class AuthorController {


    AuthorService authorService;


    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public String showAuthors(Model model){
        model.addAttribute("authorList", authorService.getAuthorList());
        return "authors";
    }

}
