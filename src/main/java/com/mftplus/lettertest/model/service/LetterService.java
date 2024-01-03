package com.mftplus.lettertest.model.service;

import com.mftplus.lettertest.model.entity.Letter;
import com.mftplus.lettertest.model.repository.CRUDRepository;
import com.mftplus.lettertest.model.utils.JpaProvider;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterService implements Service<Letter,Long> {
    private static final LetterService letterService = new LetterService();

    private LetterService() {
    }

    public static LetterService getUserService() {
        return letterService;
    }

    @Override
    public Letter save(Letter letter) throws Exception {
        try (CRUDRepository<Letter,Long> crudRepository = new CRUDRepository<>()){
            return crudRepository.save(letter);
        }
    }

    @Override
    public Letter edit(Letter letter) throws Exception {
        try (CRUDRepository<Letter,Long> crudRepository = new CRUDRepository<>()){
            return crudRepository.edit(letter);
        }
    }

    @Override
    public Letter remove(Long id) throws Exception {
        try (CRUDRepository<Letter,Long> crudRepository = new CRUDRepository<>()){
            return crudRepository.remove(Letter.class,id);
        }
    }

    @Override
    public Letter findById(Long id) throws Exception {
        try (CRUDRepository<Letter,Long> crudRepository = new CRUDRepository<>()){
            return crudRepository.findById(Letter.class,id);
        }
    }

    @Override
    public List<Letter> findAll() throws Exception {
        try (CRUDRepository<Letter,Long> crudRepository = new CRUDRepository<>()){
            return crudRepository.findAll(Letter.class);
        }
    }

    public Letter findByTitle(String title) throws Exception {
        try (CRUDRepository<Letter,Long> crudRepository = new CRUDRepository<>()){
            Map<String,Object> params = new HashMap<>();
            params.put("title",title);
            List<Letter> letterList = crudRepository.findBy("Letter.FindByTitle",params);
            return (letterList.isEmpty() ? null : letterList.get(0));
        }
    }

    public Letter findByContext(String context) throws Exception {
        try (CRUDRepository<Letter,Long> crudRepository = new CRUDRepository<>()){
            Map<String,Object> params = new HashMap<>();
            params.put("context",context);
            List<Letter> letterList = crudRepository.findBy("Letter.FindByContext",params);
            return (letterList.isEmpty() ? null : letterList.get(0));
        }
    }

    public Letter findByDate(String date) throws Exception {
        try (CRUDRepository<Letter,Long> crudRepository = new CRUDRepository<>()){
            Map<String,Object> params = new HashMap<>();
            params.put("date",date);
            List<Letter> letterList = crudRepository.findBy("Letter.FindByDate",params);
            return (letterList.isEmpty() ? null : letterList.get(0));
        }
    }

    //this has to be tested
    public void findByPartOfText(String text){
        FullTextEntityManager fullTextEntityManager
                = Search.getFullTextEntityManager(JpaProvider.getJpa().getEntityManager());

        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder()
                .forEntity(Letter.class)
                .get();
//
//        org.apache.lucene.search.Query query = queryBuilder
//                .keyword()
//                .onField("context")
//                .matching(text)
//                .createQuery();

        org.apache.lucene.search.Query phraseQuery = queryBuilder
                .phrase()
                .withSlop(1)
                .onField("context")
                .sentence(text)
                .createQuery();

        org.hibernate.search.jpa.FullTextQuery jpaQuery
                = fullTextEntityManager.createFullTextQuery(phraseQuery, Letter.class);

        List<Letter> results = jpaQuery.getResultList();
        for (Letter result : results) {
            System.out.println(result.getContext());
        }
    }
}
