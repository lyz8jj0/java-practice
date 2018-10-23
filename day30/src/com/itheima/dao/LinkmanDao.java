package com.itheima.dao;

import com.itheima.domain.Linkman;
import com.itheima.utils.HibernateUtils;
import org.hibernate.Session;

public class LinkmanDao {
    /**
     * 保存联系人
     *
     * @param man
     */
    public void save(Linkman man) {
        Session session = HibernateUtils.getCurrentSession();
        session.save(man);
    }
}
