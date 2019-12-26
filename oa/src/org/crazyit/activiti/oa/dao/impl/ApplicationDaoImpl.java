package org.crazyit.activiti.oa.dao.impl;

import org.crazyit.activiti.oa.dao.ApplicationDao;
import org.crazyit.activiti.oa.entity.ExpenseAccount;
import org.crazyit.activiti.oa.entity.SalaryAdjust;
import org.crazyit.activiti.oa.entity.Vacation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

/**
 * @Author: xyy
 * @Date: 2019/12/25 11:14
 */
public class ApplicationDaoImpl implements ApplicationDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveVacation(Vacation vac) {
        Session session = sessionFactory.openSession();
        session.save(vac);
    }

    @Override
    public List<Vacation> listVacation(String userId) {
        Session session = sessionFactory.openSession();
        String hql = "from Vacation as vac where vac.userId=:userId";
        Query query = session.createQuery(hql);
        query.setParameter("userId", userId);
        return query.list();
    }

    @Override
    public void saveSalaryAdjust(SalaryAdjust salaryAdjust) {
        Session session = sessionFactory.openSession();
        session.save(salaryAdjust);
    }

    @Override
    public void saveExpenseAccount(ExpenseAccount expenseAccount) {
        Session session = sessionFactory.openSession();
        session.save(expenseAccount);
    }

    @Override
    public List<SalaryAdjust> listSalaryAdjust(String userId) {
        Session session = sessionFactory.openSession();
        String hql = "from SalaryAdjust sa where sa.userId=:userId";
        Query query = session.createQuery(hql);
        query.setParameter("userId", userId);
        return query.list();
    }

    @Override
    public List<ExpenseAccount> listExpenseAccount(String userId) {
        String hql = "from ExpenseAccount ea where ea.userId=:userId";
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        query.setParameter("userId", userId);
        return query.list();
    }
}
