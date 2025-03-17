package com.berkayd.WordTandem.repository;

import com.berkayd.WordTandem.entity.Word;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordRepository extends MongoRepository<Word, String> {
}