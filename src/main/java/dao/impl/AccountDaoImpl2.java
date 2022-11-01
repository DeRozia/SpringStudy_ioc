package dao.impl;

import dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * 账户的业务层实现类
 * <bean id="accountDao" class="dao.impl.AccountDaoImpl"></bean>
 */
@Repository("accountDao2")
public class AccountDaoImpl2 implements IAccountDao {

    public void saveAccount() {
        System.out.println("保存了账户22222222222");
    }
}
