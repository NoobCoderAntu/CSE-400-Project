package com.anupam.cseclassapplication.DataLoader;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.anupam.cseclassapplication.entity.DatabaseEntity;
import com.anupam.cseclassapplication.repo.EntityRepo;

//import java.sql.Time;

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
    public void run(String... args) throws Exception {
        loadSeedData();
    }

    @Transactional
    private void loadSeedData() {
        cnt = entityRepo.count();

        if (cnt == 0) {
            String tbTime1 = String.valueOf("11:00");
            String tbTime2 = String.valueOf("11:00");
            String tbTime3 = String.valueOf("11:00");
            String tbTime4 = String.valueOf("11:00");
            String tbTime5 = String.valueOf("11:00");

            String lbTime1 = String.valueOf("13:15");
            String lbTime2 = String.valueOf("13:15");
            String lbTime3 = String.valueOf("13:15");
            String lbTime4 = String.valueOf("13:15");
            String lbTime5 = String.valueOf("13:15");

            String p1T1 = String.valueOf("09:00"); // Sunday Period 1
            String p1T2 = String.valueOf("09:00"); // Monday Period 1
            String p1T3 = String.valueOf("09:00");
            String p1T4 = String.valueOf("09:00");
            String p1T5 = String.valueOf("09:00");

            String p2T1 = String.valueOf("10:00"); // Sunday Period 2
            String p2T2 = String.valueOf("10:00"); // Monday Period 2
            String p2T3 = String.valueOf("10:00");
            String p2T4 = String.valueOf("10:00");
            String p2T5 = String.valueOf("10:00");
            
            String p3T1 = String.valueOf("11:30"); // Sunday Period 3
            String p3T2 = String.valueOf("11:30"); // Monday Period 3
            String p3T3 = String.valueOf("11:30");
            String p3T4 = String.valueOf("11:30");
            String p3T5 = String.valueOf("11:30");

            String p4T1 = String.valueOf("12:30"); // Sunday Period 4
            String p4T2 = String.valueOf("12:30"); // Monday Period 4
            String p4T3 = String.valueOf("12:30");
            String p4T4 = String.valueOf("12:30");
            String p4T5 = String.valueOf("12:30");

            String p5T1 = String.valueOf("14:00"); // Sunday Period 5
            String p5T2 = String.valueOf("14:00"); // Monday Period 5
            String p5T3 = String.valueOf("14:00");
            String p5T4 = String.valueOf("14:00");
            String p5T5 = String.valueOf("14:00");


            DatabaseEntity databaseEntity1 = new DatabaseEntity("Sunday", "No Class",p1T1, "CSE 401",p2T1, tbTime1, "CSE 403",p3T1, "No Class",p4T1, lbTime1, "No Class", p5T1);
            DatabaseEntity databaseEntity2 = new DatabaseEntity("Monday", "Math 401",p1T2, "CSE 407",p2T2, tbTime2, "CSE 408",p3T2, "No Class",p4T2, lbTime2, "No Class", p5T2);
            DatabaseEntity databaseEntity3 = new DatabaseEntity("Tuesday", "No Class",p1T3, "CSE 401",p2T3, tbTime3, "CSE 402",p3T3, "No Class",p4T3, lbTime3, "No Class", p5T3);
            DatabaseEntity databaseEntity4 = new DatabaseEntity("Wednesday", "No Class",p1T4, "CSE 407",p2T4, tbTime4, "CSE 400",p3T4, "No Class",p4T4, lbTime4, "No Class", p5T4);
            DatabaseEntity databaseEntity5 = new DatabaseEntity("Thursday", "No Class",p1T5, "Math 401",p2T5, tbTime5, "LAW 401",p3T5, "CSE 403",p4T5, lbTime5, "CSE 404", p5T5);

            entityRepo.save(databaseEntity1);
            entityRepo.save(databaseEntity2);
            entityRepo.save(databaseEntity3);
            entityRepo.save(databaseEntity4);
            entityRepo.save(databaseEntity5);
            
        }

        logger.info("Number of Items: {}", entityRepo.count());
    }
}

