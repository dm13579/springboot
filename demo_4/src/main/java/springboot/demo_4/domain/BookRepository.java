package springboot.demo_4.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Administrator
 * @version V1.0
 * @InterfaceName:BookRepository
 * @Description:TODO 数据持久层接口
 * @date 2019/3/29
 */
public interface BookRepository extends JpaRepository<Book,Long>{

}
