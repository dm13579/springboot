package springboor.demo2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboor.demo2.entity.User;

/**
 * @author dm
 * @version V1.0
 * @InterfaceName:UserRepository
 * @Description:TODO 用户持久层接口
 * @date 2019/3/28
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
