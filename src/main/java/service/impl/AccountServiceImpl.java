package service.impl;

import dao.IAccountDao;
import dao.impl.AccountDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import service.IAccountService;

import javax.annotation.Resource;

/**
 * 账户的业务层实现类
 *
 * 曾经的xml配置：
 *  <bean id="accountService" class="service.impl.AccountServiceImpl"
 *    scope=“ ” init-method=“ ”  destroy-method=“ ”>
 *    <property name="" ref=""></property>
 *    </bean>
 *
 *  用于创建对象的注解
 *      与xml配置文件中编写一个<bean>标签实现的功能是一样的
 *      @Component：用于把当前类对象存入Spring容器中
 *          属性： value; 用于指定bean对象的id，当我们不写value时，它的默认值是当前类名，并且首字母改为小写
 *      @Controller：一般用在表现层
 *      @Servie：一般用于业务层
 *      @Repository：一般用于持久层
 *    以上三个注解的作用和属性和Component一样，时spring提供明确的三层使用的注解，使我们的三层对象更加清晰
 *
 *  用于注入数据的注解
 *      与xml配置文件中的<bean>标签中写一个<property>标签的作用是一样的
 *      @Autowired:
 *         作用：自动按照类型注入，只要容器中有唯一一个bean对象类型和要注入的变量类型匹配，就可以注入成功
 *              如果ioc容器中没有任何bean的类型和要注入的变量类型匹配，则报错
 *              如果ioc容器中有多个类型匹配时：
 *                 首先先按照类型圈定出来匹配的对象，然后使用变量名称作为id从圈定出来的对象中继续查找
 *                 如果有一样，也可以注入成功，如果没有，则报错
 *         出现位置：可以是变量上，也可以是方法上  使用注解时，set方法就不是必须的
 *      @Qualifier：在按照类中注入的基础之上再按照名称注入，它在给类成员注入时不能单独使用。
 *         value：用于指定注入bean的id
 *      @Resource:直接按照bean的id注入，可以独立使用
 *    以上三个注入都只能注入其他bean类型的数据，而基本类型和String类型无法使用上述注解实现
 *
 *       Value：用于注入基本类型和String类型的数据
 *         属性：
 *           value：用于指定数据的值。可以使用spEL 写法：${达式}
 *
 *
 *  勇于改变作用范围的注解
 *      与xml配置文件中的<bean>标签中使用<scope>标签的作用是一样的
 *     Scope：用于指定bean的作用范围
 *       value：指定范围的取值  singleton（单例 默认）  prototype（多例）
 *
 *
 *  和生命周期相关的注解
 *      与xml配置文件中的<bean>标签中使用init-method和destroy-method标签的作用是一样的
 *      PreDestroy 用于指定销毁方法
 *      PreConstruct 用于指定初始化方法
 *
 */
@Component
public class AccountServiceImpl implements IAccountService {
   @Autowired
   @Qualifier("accountDao1")
    private IAccountDao accountDao;

    public AccountServiceImpl(){
        System.out.println("对象创建");
    }
    public void saveAccount() {

        accountDao.saveAccount();
    }
}
