package com.oops.OvertureOfPromachina.application.repository.Account;

import com.oops.OvertureOfPromachina.application.entity.account.Account;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.Querydsl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import static com.oops.OvertureOfPromachina.application.entity.account.QAccount.account;
import java.util.List;

@Repository
@Transactional
public class DbAccountRepository implements AccountRepository {

    private final EntityManager em;
    private final JPAQueryFactory query;


    public DbAccountRepository(EntityManager em) {

        this.em = em;
        this.query = new JPAQueryFactory(em);
    }


    @Override
    public Long save(Account account_save) {

        em.persist(account_save);
        return account_save.getAccount_id();
    }


    @Override
    public List<Account> findAccount(long user_id) {

        return query.select(account)
                .from(account)
                .where(account.user_id.id.eq(user_id))
                .fetch();
    }
}
