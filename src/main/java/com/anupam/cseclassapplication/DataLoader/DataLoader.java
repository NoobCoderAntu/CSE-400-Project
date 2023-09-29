package com.anupam.cseclassapplication.DataLoader;

import org.springframework.stereotype.Component;

import com.anupam.cseclassapplication.entity.DatabaseEntity;
import com.anupam.cseclassapplication.repo.EntityRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component
public class DataLoader implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(DataLoader.class);

    @Autowired
    EntityRepo entityRepo;

    @Override
    public void run ( String... args ) throws Exception {
        loadSeedData();
    }
    private void loadSeedData (){
        if(entityRepo.count() == 0){
            DatabaseEntity databaseEntity1 = new DatabaseEntity("Sunday", "No Class", "CSE 401 at 10 AM","11:00-11:30","CSE 403 at 12 PM", "No Class", "1 PM to 2 PM", "No Class");
            entityRepo.save(databaseEntity1);
        }
        logger.info("Number of Items : {}", entityRepo.count());
    }

}
