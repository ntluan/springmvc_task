/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.pojo.Order;
import model.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author rin
 */
public class OrderDAO {
    //lay danh sach Order
    public static List<Order> getlist() {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        List<Order> lst = new ArrayList<Order>();

        try {
            s.beginTransaction();
            lst = s.createCriteria(Order.class).list();
            s.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lst;
    }
    //tao moi order
    public void create(Order e) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            s.beginTransaction();
            s.save(e);
            s.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            s.getTransaction().rollback();
        }
    }
    //xoa order
    public void remove(Order e) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            s.beginTransaction();
            s.delete(e);
            s.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            s.getTransaction().rollback();
        }
    }
    //sua order
    public void edit(Order e) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            s.beginTransaction();
            s.update(e);
            s.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            s.getTransaction().rollback();
        }
    }
    //lay object order tu orderId
    public Order getOrd(int orderId) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Order e = new Order();
        try {
            s.beginTransaction();
            e = (Order) s.get(Order.class, orderId);
            s.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            s.getTransaction().rollback();
        }
        return e;
    }
    //tim kiem tat ca cac truong
    public List<Order> findAll(String key) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        List<Order> lst = new ArrayList<Order>();
        try {
            s.getTransaction().begin();

            Criteria criteria = s.createCriteria(Order.class);
            Disjunction disCriteria = Restrictions.disjunction();
            disCriteria.add(Restrictions.like("amount", "%" + key + "%"));
            disCriteria.add(Restrictions.like("detail", "%" + key + "%"));
            criteria.add(disCriteria);
            lst = criteria.list();
            //xu ly truy van
            s.getTransaction().commit();
            return lst;
        } catch (Exception ex) {
            ex.printStackTrace();
            s.getTransaction().rollback();
            return null;
        }

    }

}
