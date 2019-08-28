/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.itta.springbootmvc.config;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import net.itta.springbootmvc.model.Personne;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfig {

    @Bean
    List<Personne> getPeople() {
        List<Personne> people = new ArrayList();
        people.add(new Personne(1, "albert", "duschmoll", new Date()));
        people.add(new Personne(2, "al", "einstein", new Date()));
        people.add(new Personne(3, "albert", "jean", new Date()));
        people.add(new Personne(4, "albert", "dupont", new Date()));
        return people;
    }

}
