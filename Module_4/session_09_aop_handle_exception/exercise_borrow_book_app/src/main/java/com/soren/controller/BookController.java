package com.soren.controller;

import com.soren.model.Book;
import com.soren.service.BookService;
import com.soren.service.exception.QuantityEqualsZeroException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping({"", "/book"})
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("")
    public String getHome(Model model, @CookieValue(value = "view", defaultValue = "0") Long count,
                          HttpServletRequest request, HttpServletResponse response){
        count++;
        request.getSession().setAttribute("count", count);
        Cookie cookie = new Cookie("view", count.toString());
        cookie.setMaxAge(60*60);
        response.addCookie(cookie);
        model.addAttribute("times", cookie.getValue());
        model.addAttribute("listBook", this.bookService.findAll());
        return "index";
    }

    @GetMapping("/book_detail")
    public String getBookDetail(@RequestParam(name = "code") Integer code, Model model){
        model.addAttribute("book", this.bookService.findById(code));
        return "borrow";
    }

    @PostMapping("/borrow")
    public String borrowBook(Book book, Model model){
        try {
            this.bookService.decreasingBookQuantity(book);
            model.addAttribute("message", "You've borrow the book "+book.getName()+". Your GIVEBACK code is : "+book.getCode());
            model.addAttribute("listBook", this.bookService.findAll());
            return "index";
        } catch (QuantityEqualsZeroException e){
            return "error";
        }

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
