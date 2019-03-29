package springboot.demo_4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import springboot.demo_4.domain.Book;
import springboot.demo_4.domain.BookRepository;
import springboot.demo_4.service.BookService;
import java.util.List;


/**
 * @author Administrator
 * @version V1.0
 * @ClassName:BookServiceImpl
 * @Description:TODO Book 业务层实现
 * @date 2019/3/29
 */
@Service
@CacheConfig(cacheNames = "books")
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Cacheable(key = "#p0")
    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public Book add(Book book) {
        bookRepository.save(book);
        return book;
    }

    @CachePut(key = "#p0.id")
    @Override
    public Book update(Book book) {
        bookRepository.save(book);
        return book;
    }

    @CacheEvict(key = "#p0")
    @Override
    public Book delete(Long id) {
        Book book = bookRepository.findById(id).get();
        bookRepository.delete(book);
        return book;
    }
}
