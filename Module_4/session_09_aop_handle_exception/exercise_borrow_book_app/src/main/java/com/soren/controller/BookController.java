package com.soren.controller;

import com.soren.model.Book;
import com.soren.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping({"", "/book"})
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("")
    public String getHome(Model model){
        model.addAttribute("listBook", this.bookService.findAll());
        return "index";
    }

    @GetMapping("/book_detail")
    public String getBookDetail(@RequestParam(name = "code") Integer code, Model model){
        model.addAttribute("book", this.bookService.findById(code));
        return "borrow";
    }

    @PostMapping("/borrow")
    public String borrowBook(Book book, RedirectAttributes redirect){
        this.bookService.decreasingBookQuantity(book);
        redirect.addFlashAttribute("message", "You've borrow the book "+book.getName()+". Your GIVEBACK code is : "+book.getCode());
        return "redirect:/book/";
    }

    @GetMapping("/giveback")
    public String showGivebackBookPage(){
        return "input_code";
    }

    @PostMapping("/giveback")
    public String givebackBook(@RequestParam(name = "inputCode") Integer code, Model model){
        if (this.bookService.checkingCodeBook(code)){
            this.bookService.increasingBookQuantity(this.bookService.findById(code));
            model.addAttribute("message", "Giveback Book successfully!");
            model.addAttribute("listBook", this.bookService.findAll());
            return "index";
        } else {
            model.addAttribute("inputCode", code);
            model.addAttribute("message", "Your book code is invalid!");
            return "input_code";
        }
    }
}
