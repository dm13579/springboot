package springboot.demo_4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springboot.demo_4.domain.Book;
import springboot.demo_4.service.BookService;
import springboot.demo_4.util.pathKeys;

/**
 * @author Administrator
 * @version V1.0
 * @ClassName:BookController
 * @Description:TODO Book 控制层
 * @date 2019/3/29
 */
@Controller
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public String getBookList(ModelMap map){
        map.addAttribute("bookList",bookService.findAll());
        return pathKeys.BOOK_LIST_PATH_NAME;
    }

    @RequestMapping(value = "add",method = RequestMethod.GET)
    public String toAdd(ModelMap map){
        map.addAttribute("book",new Book());
        map.addAttribute("action","add");

        return pathKeys.BOOK_FORM_PATH_NAME;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(@ModelAttribute Book book){
        bookService.add(book);
        return pathKeys.REDIRECT_TO_BOOK_URL;
    }

    @RequestMapping(value = "update/{id}",method = RequestMethod.GET)
    public String toUpdate(@PathVariable Long id, ModelMap map){
        Book book = bookService.findById(id);
        map.addAttribute("book",book);
        map.addAttribute("action","update");
        return pathKeys.BOOK_FORM_PATH_NAME;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@ModelAttribute Book book){
        bookService.update(book);
        return pathKeys.REDIRECT_TO_BOOK_URL;
    }

    @RequestMapping(value = "delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable Long id){
        bookService.delete(id);
        return pathKeys.REDIRECT_TO_BOOK_URL;
    }
}
