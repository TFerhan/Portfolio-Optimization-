package com.kafmongo.kafmongo.Service;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.kafmongo.kafmongo.Repo.BourseRepo;
import com.kafmongo.kafmongo.model.BourseModel;
import java.util.Date;


@Service
public class BourseService {
	
	@Autowired
	private BourseRepo bourseRepo;
	
	public BourseModel save(BourseModel bourseModel) {
		return bourseRepo.save(bourseModel);
	}
	
	
	
	
	

}
