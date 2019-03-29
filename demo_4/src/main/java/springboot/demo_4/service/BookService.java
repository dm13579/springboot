package springboot.demo_4.service;

import springboot.demo_4.domain.Book;

import java.util.List;

/**
 * @author Administrator
 * @version V1.0
 * @ClassName:BookService
 * @Description:TODO Book 业务层
 * @date 2019/3/29
 */
public interface BookService {

    /**
     * 查询所有书籍
     * @return
     */
    List<Book> findAll();

    /**
     * 通过id查询书籍
     * @param id
     * @return
     */
    Book findById(Long id);

    /**
     * 创建book
     * @param book
     * @return
     */
    Book add(Book book);

    /**
     * 更新book
     * @param book
     * @return
     */
    Book update(Book book);

    /**
     * 删除书籍
     * @param id
     * @return
     */
    Book delete(Long id);
}
