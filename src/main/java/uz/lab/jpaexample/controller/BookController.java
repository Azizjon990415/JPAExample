package uz.lab.jpaexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uz.lab.jpaexample.DTO.BookDTO;
import uz.lab.jpaexample.service.BookService;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("api/book")
    public BookDTO saveNewBook(@RequestBody BookDTO bookDTO){
        return bookService.saveBook(bookDTO);
    }
}
