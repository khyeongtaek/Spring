package org.shark.di.service;

import lombok.RequiredArgsConstructor;
import org.shark.di.dao.DIDao;
import org.shark.di.dao.DIDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DIServiceImpl implements DIService{

    private final DIDao diDao;

    @Override
    public void serviceMethod() {
        System.out.println("serviceMethod()");
        diDao.daoMethod();
    }
}
