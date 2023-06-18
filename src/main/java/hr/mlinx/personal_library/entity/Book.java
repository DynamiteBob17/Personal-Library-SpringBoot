package hr.mlinx.personal_library.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "books")
public class Book {

    @Id
    @Getter
    private String id;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private List<String> comments;

    public Book() {
        comments = new ArrayList<>();
    }

}
