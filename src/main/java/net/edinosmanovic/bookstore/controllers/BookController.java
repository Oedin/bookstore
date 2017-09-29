package net.edinosmanovic.bookstore.controllers;

import net.edinosmanovic.bookstore.models.Book;
import net.edinosmanovic.bookstore.models.BookGenre;
import net.edinosmanovic.bookstore.models.data.BookDao;
import net.edinosmanovic.bookstore.models.data.BookGenreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;



/**
 * Created by eo on 6/3/17.
 */
@Controller
@RequestMapping("books")
public class BookController {

    @Autowired
    private BookDao bookDao;

    @Autowired
    BookGenreDao bookGenreDao;

    //request path: /books
    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("books", bookDao.findAll());
        model.addAttribute("title", "My Books");
        return "books/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayBookForm(Model model) {
        model.addAttribute("title", "Add book");
        model.addAttribute(new Book());
        model.addAttribute("bookGenres", bookGenreDao.findAll());

        return "books/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddBookForm(@ModelAttribute @Valid Book newBook, Errors errors, Model model) {

        /*
        * ---Model Binding by using @ModelAttribute
        * Book newBook = newBook();
        * newBook.setTitleName(Request.getParameter("titleName"));
        * newBook.setAuthorName(Request.getParameter("authorName));
        */

        if(errors.hasErrors()){
            model.addAttribute("title", "Add book");
            model.addAttribute("genres", bookGenreDao.findAll());
            return "books/add";
        }

        BookGenre enre = bookGenreDao.findOne(genr)
        bookDao.save(newBook);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveBookForm(Model model) {
        model.addAttribute("books", bookDao.findAll());
        model.addAttribute("title", "Remove Book");
        return "books/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String proecessRemoveBookForm(@RequestParam int[] bookIds) {
        for (int bookId : bookIds) {
            bookDao.delete(bookId);
        }

        return "redirect:";
    }

//    @RequestMapping(value = "edit/{bookId}", method = RequestMethod.GET)
//    public String displayEditBookForm(Model model, @PathVariable int bookId) {
//        Book a = bookDao.getById(bookId);
//        model.addAttribute("title", a.getTitleName());
//        model.addAttribute("bookGenres", BookGenre.values());
//        model.addAttribute(a);
//        return "books/edit";
//    }
//    @RequestMapping(value = "edit", method = RequestMethod.POST)
//    public String processEditBookForm(@ModelAttribute @Valid Book newBook,  Errors errors, Model model){
//        if(errors.hasErrors()){
//            model.addAttribute("Edit Book "+newBook.getTitleName());
//            model.addAttribute("book", newBook);
//            model.addAttribute("bookGenres", BookGenre.values());
//
//            return "books/edit";
//        }
//
//        Book c = BookData.getById(newBook.getBookId());
//        c.setTitleName(newBook.getTitleName());
//        c.setAuthorName(newBook.getAuthorName());
//        c.setGenre(newBook.getGenre());
//
//        return "redirect:";
//    }



}
