package com.example.ok.percobaan1;

import java.util.List;

public class Repository {

    PadiDao padiDao;
    List<Padi> list;

    public Repository(){
        DaoSession daoSession =  MyApp.getInstance().getDaoSession();
        padiDao=daoSession.getPadiDao();
    }



    public List<Padi> getAllData() {
        list=padiDao.loadAll();

        return list;
    }

    public void updateData( Padi padi) {
        padiDao.update(padi);
    }


    public void deleteData( Long id) {
        padiDao.deleteByKey(id);
    }


    public void addData( Padi padi) {
        padiDao.insert(padi);
    }

}