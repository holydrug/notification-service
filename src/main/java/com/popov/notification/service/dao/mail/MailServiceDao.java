package com.popov.notification.service.dao.mail;

import com.popov.notification.service.dao.Dao;

import java.util.List;
import java.util.Optional;

public interface MailServiceDao extends Dao {
    @Override
    Optional get(Long id);

    @Override
    List getAll();

    @Override
    void save(Object o);

    @Override
    void update(Object o);

    @Override
    void delete(Long id);
}
