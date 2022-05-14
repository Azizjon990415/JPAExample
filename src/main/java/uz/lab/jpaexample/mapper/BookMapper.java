package uz.lab.jpaexample.mapper;

import org.springframework.stereotype.Component;
import uz.lab.jpaexample.DTO.BookDTO;
import uz.lab.jpaexample.domain.Book;

@Component
public class BookMapper {
    public Book mapDTOtoDomain(BookDTO bookDTO){
        return new Book(bookDTO.getName(), bookDTO.getDescription(), bookDTO.getPictureLink(), bookDTO.getTitle(), bookDTO.getDate(), bookDTO.getWriter());
    }

    public BookDTO mapDomaintoDTO(Book book){
        return new BookDTO(book.getId(), book.getName(), book.getDescription(), book.getPictureLink(), book.getTitle(), book.getDate(), book.getWriter());
    }
}
