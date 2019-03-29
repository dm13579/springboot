package springboot.demo_3.service.impl;

import org.springframework.stereotype.Service;
import springboot.demo_3.domain.Book;
import springboot.demo_3.service.BookService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @version V1.0
 * @ClassName:BookServiceImpl
 * @Description:TODO Book 业务层实现
 * @date 2019/3/29
 */
@Service
public class BookServiceImpl implements BookService{

    private static Map<Long,Book> BOOK_DB = new HashMap<>();

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(BOOK_DB.values());
    }

    @Override
    public Book findById(Long id) {
        return BOOK_DB.get(id);
    }

    @Override
    public Book add(Book book) {
        book.setId(BOOK_DB.size()+1L);
        BOOK_DB.put(book.getId(),book);
        return null;
    }

    @Override
    public Book update(Book book) {
        BOOK_DB.put(book.getId(),book);
        return book;
    }

    @Override
    public Book delete(Long id) {
        return BOOK_DB.remove(id);
    }
}
