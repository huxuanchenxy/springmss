package mss.service.user.entity;


import lombok.Data;
import javax.persistence.*;


@Data
@Entity(name = "user")//绑定映射的实体并指定数据库名称
public class User {

    @Id //表示该字段作为主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //主键生成策略，自增
    private int id;


    @Column(name="acc_name") //用来标识实体类中属性与数据表中字段的对应关系
    private String accName;

    @Column(name="user_name")
    private String userName;

}
