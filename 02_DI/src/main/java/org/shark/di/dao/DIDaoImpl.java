package org.shark.di.dao;

import org.springframework.stereotype.Repository;

@Repository
public class DIDaoImpl implements DIDao{

    @Override
    public void daoMethod() {
        System.out.println("daoMethod()");
    }
}
