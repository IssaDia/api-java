package com.example.api;

import com.example.api.models.Candidat;
import com.example.api.repositories.CandidatRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class LoadData {
    private static final Logger Log = LoggerFactory.getLogger(LoadData.class);

    @Bean
    CommandLineRunner initDatabase(CandidatRepository repository) throws ParseException {
        Log.info("Launch Preloading");
        if(repository.count() == 0) {
            SimpleDateFormat formatter = new SimpleDateFormat( "dd/mm/yyyy");
            Date dateNaissance = formatter.parse("05/06/1974");

            Candidat candidat = new Candidat("Dia","Issa", dateNaissance,"12 rue paix",
                    "Lyon","69008");

            return args-> {
                Log.info("Preloading " + repository.save(candidat));
            };

        }

        else {
            return args-> {
                Log.info("Already initialized");
            };
        }

    }

}
