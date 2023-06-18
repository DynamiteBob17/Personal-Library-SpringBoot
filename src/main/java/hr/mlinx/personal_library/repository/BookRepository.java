package hr.mlinx.personal_library.repository;

import hr.mlinx.personal_library.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {

}
