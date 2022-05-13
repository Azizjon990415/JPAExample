package uz.lab.jpaexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.lab.jpaexample.domain.Book;

public interface BookRepository extends JpaRepository<Book,Long> {
}
