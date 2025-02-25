package com.kafmongo.kafmongo.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.kafmongo.kafmongo.model.IndexRTModel;



public interface IndexRTRepo extends MongoRepository<IndexRTModel, String> {

}
