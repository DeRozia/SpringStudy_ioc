package dao.impl;

import dao.IAccountDao;
import org.springframework.stereotype.Repository;
import service.IAccountService;

/**
 * 账户的业务层实现类
 * <bean id="accountDao" class="dao.impl.AccountDaoImpl"></bean>
 */
@Repository("accountDao1")
public class AccountDaoImpl implements IAccountDao {

    public void saveAccount() {
        System.out.println("保存了账户111111111");
    }
}
