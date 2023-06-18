package hr.mlinx.personal_library.controller;

import hr.mlinx.personal_library.entity.Book;
import hr.mlinx.personal_library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "index";
    }

    @GetMapping("/new_book")
    public String newBook(Model model) {
        model.addAttribute("book", new Book());
        return "new_book";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") Book book) {
       bookService.saveBook(book);
       return "redirect:/";
    }

    @PostMapping("/save_comment/{id}")
    public String saveComment(@PathVariable(value ="id") String id, @RequestParam String comment) {
        bookService.saveComment(id, comment);
        return "redirect:/";
    }

    @GetMapping("/post_comment/{id}")
    public String postCommentForm(@PathVariable(value = "id") String id, Model model) {
        model.addAttribute("book", bookService.getById(id));
        model.addAttribute("comment", "");
        return "post_comment";
    }

    @GetMapping("/delete_book/{id}")
    public String deleteBook(@PathVariable(value = "id") String id) {
        bookService.deleteById(id);
        return "redirect:/";
    }

}
