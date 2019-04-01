package springboot.demo_4.service.impl;

import org.springframework.stereotype.Service;
import springboot.demo_4.domain.Book;
import springboot.demo_4.service.BookService;
import springboot.demo_4.util.RedisUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @version V1.0
 * @ClassName:BookServiceImpl
 * @Description:TODO Book 业务层实现
 * @date 2019/3/29
 */
@Service
public class BookServiceImpl implements BookService{

    @Resource(name = "redisUtil")
    private RedisUtil redisUtil;

    @Override
    public List<Book> findAll() {
        List<Book> bookList = new ArrayList<Book>();
        int i=1;
        while (redisUtil.hasKey("book_"+i)){
            Book book = (Book) redisUtil.get("book_"+i);
            bookList.add(book);
            i++;
        }
        return bookList;
    }

    @Override
    public Book findById(Long id) {
        Book book = (Book) redisUtil.get("book_"+id);
        return book;
    }

    @Override
    public Book add(Book book) {
        int i=1;
        while (redisUtil.hasKey("book_"+i)){
            i++;
        }
        book.setId(Long.parseLong(i+""));
        redisUtil.set("book_"+i,book);
        return book;
    }

    @Override
    public Book update(Book book) {
        redisUtil.set("book_"+book.getId(),book);
        return book;
    }

    @Override
    public Book delete(Long id) {
        Book book = (Book) redisUtil.get("book_"+id);
        redisUtil.del("book_"+id);
        return book;
    }
}
