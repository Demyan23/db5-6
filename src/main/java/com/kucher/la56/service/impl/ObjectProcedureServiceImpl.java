package com.kucher.la56.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kucher.la56.repository.ObjectRepository;
import com.kucher.la56.service.ObjectProcedureService;

@Service
public class ObjectProcedureServiceImpl implements ObjectProcedureService{

    @Autowired
    ObjectRepository objectRepository;
    @Override
    public void addBaseObject(int objectId, int userId) {
        objectRepository.addBaseObject(objectId, userId);
    }
}
