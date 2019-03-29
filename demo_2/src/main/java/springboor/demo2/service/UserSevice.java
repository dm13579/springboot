package springboor.demo2.service;

import springboor.demo2.entity.User;

import java.util.List;

/**
 * @author Administrator
 * @version V1.0
 * @InterfaceName:UserSevice
 * @Description:TODO User业务层接口
 * @date 2019/3/28
 */
public interface UserSevice {

    /*
     * 查询所有用户
     */
    List<User> findAll();

    /*
     * Id查询用户
     */
    User findById(Long id);

    /*
     * 创建用户
     */
    User add(User user);

    /*
     * 删除用户
     */
    User delete(Long id);

    /*
     * 更新用户
     */
    User update(User user);
}
