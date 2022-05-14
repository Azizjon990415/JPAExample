package uz.lab.jpaexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.lab.jpaexample.DTO.BookDTO;
import uz.lab.jpaexample.domain.Book;
import uz.lab.jpaexample.mapper.BookMapper;
import uz.lab.jpaexample.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookMapper bookMapper;

    public List<BookDTO> getAllBooks() {
        List<Book> allBooks = bookRepository.findAll();
        List<BookDTO> bookDTOList = new ArrayList<>();
        allBooks.forEach(book -> {
            bookDTOList.add(bookMapper.mapDomaintoDTO(book));
        });
        return bookDTOList;
    }

    public BookDTO getBook(Long id) {
        Optional<Book> byId = bookRepository.findById(id);
        if (byId.isPresent()){
            BookDTO bookDTO = bookMapper.mapDomaintoDTO(byId.get());
            return bookDTO;
        } else {
            throw new NullPointerException("Book not found!");
        }
    }

    public BookDTO saveBook(BookDTO bookDTO){
        Book savedBook = bookRepository.save(bookMapper.mapDTOtoDomain(bookDTO));
        BookDTO savedBookDTO = bookMapper.mapDomaintoDTO(savedBook);
        return savedBookDTO;
    }


    public BookDTO editBook(Long id, BookDTO bookDTO) {
        Book book = bookMapper.mapDTOtoDomain(bookDTO);
        book.setId(id);
        Book savedBook = bookRepository.save(book);
        BookDTO savedBookDTO = bookMapper.mapDomaintoDTO(savedBook);
        return savedBookDTO;
    }

    public String deleteBook(Long id) {
        bookRepository.deleteById(id);
        return "Book deleted";
    }
}
