package springboor.demo2.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboor.demo2.Repository.UserRepository;
import springboor.demo2.entity.User;
import springboor.demo2.service.UserSevice;

import java.util.List;

/**
 * @author Administrator
 * @version V1.0
 * @Classname:UserServiceImpl
 * @Description:TODO User业务层实现
 * @date 2019/3/28
 */
@Service
public class UserServiceImpl implements UserSevice {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        LOGGER.info("查询用户 id" + id);
        return userRepository.findById(id).get();
    }

    @Override
    public User add(User user) {
        LOGGER.info("新增用户：" + user.toString());
        return userRepository.save(user);
    }

    @Override
    public User delete(Long id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
        LOGGER.info("删除用户：" + user.toString());
        return user;
    }

    @Override
    public User update(User user) {
        LOGGER.info("更新用户：" + user.toString());
        return userRepository.save(user);
    }
}
