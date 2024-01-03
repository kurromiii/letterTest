package com.mftplus.lettertest.model.service;

import com.mftplus.lettertest.model.entity.Letter;
import com.mftplus.lettertest.model.entity.LetterRef;
import com.mftplus.lettertest.model.repository.CRUDRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterRefService implements Service<LetterRef,Long> {
    private static final LetterRefService letterRefService = new LetterRefService();

    private LetterRefService() {
    }

    public static LetterRefService getLetterRefService() {
        return letterRefService;
    }

    @Override
    public LetterRef save(LetterRef letterRef) throws Exception {
        try (CRUDRepository<LetterRef,Long> crudRepository = new CRUDRepository<>()){
            return crudRepository.save(letterRef);
        }
    }

    @Override
    public LetterRef edit(LetterRef letterRef) throws Exception {
        try (CRUDRepository<LetterRef,String> crudRepository = new CRUDRepository<>()){
            return crudRepository.edit(letterRef);
        }
    }

    @Override
    public LetterRef remove(Long id) throws Exception {
        try (CRUDRepository<LetterRef,Long> crudRepository = new CRUDRepository<>()){
            return crudRepository.remove(LetterRef.class,id);
        }
    }

    @Override
    public LetterRef findById(Long id) throws Exception {
        try (CRUDRepository<LetterRef,Long> crudRepository = new CRUDRepository<>()){
            return crudRepository.findById(LetterRef.class,id);
        }
    }

    @Override
    public List<LetterRef> findAll() throws Exception {
        try (CRUDRepository<LetterRef,Long> crudRepository = new CRUDRepository<>()){
            return crudRepository.findAll(LetterRef.class);
        }
    }

    public LetterRef findByLetter(Letter letterId) throws Exception {
        try (CRUDRepository<LetterRef,Long> crudRepository = new CRUDRepository<>()){
            Map<String,Object> params = new HashMap<>();
            params.put("letterId",letterId);
            List<LetterRef> letterRefList = crudRepository.findBy("LetterRef.FindByLetter",params);
            System.out.println("list : " + letterRefList);
            return (letterRefList.isEmpty() ? null : letterRefList.get(0));
        }
    }
}
