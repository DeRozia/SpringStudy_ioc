package ui;

import dao.IAccountDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import service.IAccountService;
import service.impl.AccountServiceImpl;

import java.sql.SQLOutput;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {
    /**
     * 获取spring的ioc核心容器，并根据ID获取对象
     *
     *ApplicationContext的三个常用实现类：
     *      ClassPathXmlApplicationContext:加载类路径下的配置文件，要求配置文件必须在类路径下，否则加载不了（更常用）
     *      FileSystemXmlApplicationContext:加载磁盘上任意路径下的配置文件（必须有访问权限）
     *      AnnotationConfigApplicationContext:读取注释创建的容器
     *
     *      核心容器两个接口引发出的问题:
     *        ApplicationContext： （单例对象适用）
     *          它在构建核心容器的时候，创建对象采取的策略是立即加载的方式，即一读取完配置文件马上就创建配置文件中配置的对象
     *        BeanFactory         （多例对象适用）
     *          它在构建核心容器的时候，创建对象采取的策略是延时加载的方式，即获取ID对象后才真正创建了对象
     *
     */
    public static void main(String[] args) {
        //火球核心容器对象
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext applicationContext01=new FileSystemXmlApplicationContext("任意路径");
        //根据ID获取bean对象
        IAccountService as=(IAccountService)applicationContext.getBean("accountServiceImpl");

//        IAccountDao accountDao=applicationContext.getBean("accountDao",IAccountDao.class);
//
//        System.out.println(as);
//        System.out.println(accountDao);


       as.saveAccount();
    }
}
