package com.kucher.la56.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kucher.la56.domain.Objectc;
import com.kucher.la56.exception.ObjectcNotFoundxception;
import com.kucher.la56.service.ObjectService;
import com.kucher.la56.repository.ObjectRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ObjectServiceImpl implements ObjectService {

    @Autowired
    private final ObjectRepository objectRepository;

    public ObjectServiceImpl(ObjectRepository objectRepository) {
        this.objectRepository = objectRepository;
    }

    @Override
    public List<Objectc> findAll() {
        return objectRepository.findAll();
    }

    @Override
    public Objectc findById(Integer idobject) {
        return objectRepository.findById(idobject)
                .orElseThrow(() -> new ObjectcNotFoundxception(idobject));
    }

    @Override
    public Objectc create(Objectc objectc) {
        objectRepository.save(objectc);
        return objectc;
    }

    @Override
    @Transactional
    public void update(Integer idobject, Objectc uObjectc) {
        Objectc objectc = objectRepository.findById(idobject)
                .orElseThrow(() -> new ObjectcNotFoundxception(idobject));
        objectc.setName(uObjectc.getName());
        objectc.setAdress(uObjectc.getAdress());
        objectRepository.save(objectc);
    }

    @Override
    @Transactional
    public void delete(Integer idobject) {
        Objectc objectc = objectRepository.findById(idobject)
                .orElseThrow(() -> new ObjectcNotFoundxception(idobject));
        if (!objectc.getAdress().isEmpty()) throw new ObjectcNotFoundxception(idobject);
        objectRepository.delete(objectc);
    }
}
