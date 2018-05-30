package pl.vrum.bookProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.vrum.bookProject.model.Author;
import pl.vrum.bookProject.repositories.AuthorRepository;



@CrossOrigin
@RestController
@RequestMapping("/authors")
public class AuthorController {


    @Autowired
    AuthorRepository authorRepository;

    @GetMapping
    public Iterable<Author> allAuthors() {
        Iterable<Author> list = authorRepository.findAll();
        return list;
    }

    @GetMapping("/{param1}")
    public Author author(@PathVariable long param1) {
        return authorRepository.findById(param1);
    }

    @PostMapping
    public Author authorAdd(@ModelAttribute("author") Author author) {
        authorRepository.save(author);
        return author;
    }

    @PutMapping(value="/{id}")
    public Author update(@RequestBody Author author, @PathVariable Long id) {
        author.setId(id);
        authorRepository.save(author);
        return author;
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id)
    {
        authorRepository.deleteById(id);
    }

}
