package org.codewithomar.project.main;

import org.codewithomar.project.model.Person;
import org.codewithomar.project.repository.PersonRepository;
import org.codewithomar.project.repository.Repository;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Repository<Person> repository = new PersonRepository();

        Crud crud = new Crud();

        crud.personCrud(repository);
    }
}