package com.kafmongo.kafmongo.Repo;
import com.kafmongo.kafmongo.model.BourseModel;
import java.util.List;
import java.util.Map;
import java.util.Date;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BourseRepo extends MongoRepository<BourseModel, String> {

	//List<BourseModel> findByDate(Date date);
	
	
	//BourseModel findByTicker(String ticker);
	
	

}
