package uz.lab.jpaexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.lab.jpaexample.DTO.BookDTO;
import uz.lab.jpaexample.service.BookService;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("api/book")
    public List<BookDTO> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("api/book/{id}")
    public BookDTO getBook(@PathVariable Long id){
        return bookService.getBook(id);
    }

    @PostMapping("api/book")
    public BookDTO saveNewBook(@RequestBody BookDTO bookDTO){
        return bookService.saveBook(bookDTO);
    }

    @PutMapping("api/book/{id}")
    public BookDTO editBook(@PathVariable Long id,@RequestBody BookDTO bookDTO){
        return bookService.editBook(id,bookDTO);
    }

    @DeleteMapping("api/book/{id}")
    public String deleteBook(@PathVariable Long id){
        return bookService.deleteBook(id);
    }
}


