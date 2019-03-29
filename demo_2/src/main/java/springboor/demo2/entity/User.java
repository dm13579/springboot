package springboor.demo2.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author dm
 * @version V1.0
 * @Classname:User
 * @Description:TODO 用户实体类
 * @date 2019/3/28
 */
@Entity
public class User implements Serializable {

    /**
     * 编号
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 名称
     */
    @NotEmpty(message = "姓名不能为空")
    @Size(min = 2,max = 4,message = "姓名长度在2到4之间")
    private String name;

    /**
     * 年龄
     */
    @NotNull(message = "年龄不能为空")
    @Min(value = 0,message = "年龄大于0")
    @Max(value = 200,message = "年龄不大于200")
    private Integer age;

    /**
     * 出生时间
     */
    @NotEmpty(message = "出生时间不能为空")
    private String birthday;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

}
