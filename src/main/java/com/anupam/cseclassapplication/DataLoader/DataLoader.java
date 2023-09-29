package com.anupam.cseclassapplication.DataLoader;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.anupam.cseclassapplication.entity.DatabaseEntity;
import com.anupam.cseclassapplication.repo.EntityRepo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component
public class DataLoader implements CommandLineRunner {
    long cnt;
    private final Logger logger = LoggerFactory.getLogger(DataLoader.class);

    @Autowired
    EntityRepo entityRepo;

    @Override
    public void run ( String... args ) throws Exception {
        loadSeedData();
    }
    @Transactional
    private void loadSeedData (){
        cnt = entityRepo.count();
        
        if(cnt == 0){

            DatabaseEntity databaseEntity1 = new DatabaseEntity("Sunday", "No Class", "CSE 401 at 10 AM","11:00-11:30","CSE 403 at 12 PM", "No Class", "1 PM to 2 PM", "No Class");

            DatabaseEntity databaseEntity2 = new DatabaseEntity("Monday", "Math 401 at 9 AM", "CSE 407 at 10 AM","11:00-11:30","CSE 408 at 11:30 AM", "No Class", "1 PM to 2 PM", "No Class");

            DatabaseEntity databaseEntity3 = new DatabaseEntity("Tuesday", "No Class", "CSE 401 at 10 AM","11:00-11:30","CSE 402 at 11:30 AM", "No Class", "1 PM to 2 PM", "No Class");

            DatabaseEntity databaseEntity4 = new DatabaseEntity("Wednesday", "No Class", "CSE 407 at 10 AM","11 to 12 PM","CSE 400 at 12 PM", "No Class", "1 PM to 2 PM", "No Class");

            DatabaseEntity databaseEntity5 = new DatabaseEntity("Thursday", "No Class", "Math 401 at 9:30 AM","10:30 to 11 AM","LAW 401 at 11 AM", "CSE 403 at 12 PM", "1 PM to 2 PM", "CSE 404 at 2 PM");
            
            entityRepo.save(databaseEntity1);
            entityRepo.save(databaseEntity2);
            entityRepo.save(databaseEntity3);
            entityRepo.save(databaseEntity4);
            entityRepo.save(databaseEntity5);

        }
        logger.info("Number of Items : {}", entityRepo.count());
    }

}
