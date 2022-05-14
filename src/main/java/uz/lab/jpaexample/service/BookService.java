package uz.lab.jpaexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.lab.jpaexample.DTO.BookDTO;
import uz.lab.jpaexample.domain.Book;
import uz.lab.jpaexample.mapper.BookMapper;
import uz.lab.jpaexample.repository.BookRepository;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookMapper bookMapper;

    public BookDTO saveBook(BookDTO bookDTO){
        Book savedBook = bookRepository.save(bookMapper.mapDTOtoDomain(bookDTO));
        BookDTO savedBookDTO = bookMapper.mapDomaintoDTO(savedBook);
        return savedBookDTO;
    }
}
