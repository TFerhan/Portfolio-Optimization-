package com.kafmongo.kafmongo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.kafmongo.kafmongo.Repo.DailyPriceRepo;
import com.kafmongo.kafmongo.model.DailyPrice;
import com.kafmongo.kafmongo.model.DailyPriceId;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


