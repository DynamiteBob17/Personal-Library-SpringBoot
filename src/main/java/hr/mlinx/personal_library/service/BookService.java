package hr.mlinx.personal_library.service;

import hr.mlinx.personal_library.entity.Book;
import hr.mlinx.personal_library.exception.BookNotFoundException;
import hr.mlinx.personal_library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll(Sort.by(Sort.Direction.DESC, "title"));
    }

    public Book getById(String id) {
        return bookRepository
                .findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found by id:" + id));
    }

    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    public void saveComment(String id, String comment) {
        Book book = getById(id);
        book.getComments().add(comment);
        bookRepository.save(book);
    }

    public void deleteById(String id) {
        bookRepository.deleteById(id);
    }

}
