package springboor.demo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springboor.demo2.Repository.UserRepository;
import springboor.demo2.entity.User;
import springboor.demo2.service.UserSevice;

import javax.validation.Valid;
import java.awt.print.Book;

/**
 * @author Administrator
 * @version V1.0
 * @InterfaceName:UserSevice
 * @Description:TODO 用户控制层
 * @date 2019/3/28
 */
@Controller
@RequestMapping("/users")
public class UserController {


    @Autowired
    UserSevice userSevice; // User业务层接口

    /**
     * 获取用户列表
     * @param map
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getUserList(ModelMap map){
        map.addAttribute("userList",userSevice.findAll());
        return "userList";
    }

    /**
     *
     * 跳转创建用户
     * @param map
     * @return
     */
    @RequestMapping(value="/create", method=RequestMethod.GET)
    public String toAdd(ModelMap map) {
       map.addAttribute("user",new User());
       map.addAttribute("action","creayte");
       return "userForm";
    }

    /**
     * 创建用户
     * @param map
     * @param user
     * @param bindingResult
     * @return
     */
    @RequestMapping(value="/craete", method = RequestMethod.POST)
    public String add(ModelMap map, @ModelAttribute @Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            map.addAttribute("action","create");
            return "userForm";
        }
        userSevice.add(user);
        return "redirect:/users/";
    }

    /**
     * 跳转更新用户
     * @param id
     * @param map
     * @return
     */
    @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
    public String getUser(@PathVariable Long id,ModelMap map){
        map.addAttribute("user", userSevice.findById(id));
        map.addAttribute("action","update");
        return "userForm";
    }

    /**
     * 更新用户
     * @param map
     * @param user
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public String update(ModelMap map,@ModelAttribute @Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            map.addAttribute("action","update");
            return "userForm";
        }
        userSevice.update(user);
        return "redirect:/users/";
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @RequestMapping(value = "delete/{id}",method = RequestMethod.GET)
    public  String delete(@PathVariable Long id){
        userSevice.delete(id);
        return "redirect:/users/";
    }
}
