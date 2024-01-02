package com.mftplus.lettertest.model.service;
import com.mftplus.lettertest.model.repository.CRUDRepository;
import com.mftplus.lettertest.model.utils.GeneratedSequence;

import java.util.List;

public class GeneratedSequenceService implements Service<GeneratedSequence,Long> {
    private static final GeneratedSequenceService generatedSequenceService = new GeneratedSequenceService();

    private GeneratedSequenceService() {
    }

    public static GeneratedSequenceService generatedSequenceService() {
        return generatedSequenceService;
    }
    @Override
    public GeneratedSequence save(GeneratedSequence generatedSequence) throws Exception {
        try (CRUDRepository<GeneratedSequence,String> crudRepository = new CRUDRepository<>()){
            return crudRepository.save(generatedSequence);
        }
    }

    @Override
    public GeneratedSequence edit(GeneratedSequence generatedSequence) throws Exception {
        return null;
    }

    @Override
    public GeneratedSequence remove(Long id) throws Exception {
        return null;
    }

    @Override
    public GeneratedSequence findById(Long id) throws Exception {
        return null;
    }

    @Override
    public List<GeneratedSequence> findAll() throws Exception {
        return null;
    }
}
