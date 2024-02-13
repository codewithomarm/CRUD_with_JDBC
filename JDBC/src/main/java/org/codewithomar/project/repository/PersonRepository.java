package org.codewithomar.project.repository;

import org.codewithomar.project.model.Person;
import org.codewithomar.project.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonRepository implements Repository<Person>{
    private Connection getConnection() throws SQLException {
        return DatabaseConnection.getInstance();
    }

    @Override
    public List<Person> findAll() throws SQLException {
        List<Person> personList = new ArrayList<>();
        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM person")) {
            while (resultSet.next()) {
                personList.add(createPerson(resultSet));
            }
        }
        return personList;
    }

    @Override
    public Person getById(Integer id) throws SQLException {
        Person person = null;
        try (PreparedStatement preparedStatement = getConnection().prepareStatement("SELECT * FROM person WHERE id=?")) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    person = createPerson(resultSet);
                }
            }
        }
        return person;
    }

    @Override
    public void save(Person person) throws SQLException {
        String sqlQuery;
        if (person.getId() == null) {
            sqlQuery = "INSERT INTO person (first_name, middle_name, pa_surname, ma_surname, username) VALUES (?,?,?,?,?)";
        } else {
            sqlQuery = "UPDATE person SET first_name = ?, middle_name = ?, pa_surname = ?, ma_surname = ?, username = ? WHERE id = ?";
        }
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, person.getFirst_name());
            preparedStatement.setString(2, person.getMiddle_name());
            preparedStatement.setString(3, person.getPa_surname());
            preparedStatement.setString(4, person.getMa_surname());
            preparedStatement.setString(5, person.getUsername());
            if (person.getId() != null) {
                preparedStatement.setInt(6, person.getId());
            }
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        String sqlQuery = "DELETE FROM person WHERE id = ?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    private Person createPerson(ResultSet resultSet) throws SQLException {
        Person person = new Person();
        person.setId(resultSet.getInt("id"));
        person.setFirst_name(resultSet.getString("first_name"));
        person.setMiddle_name(resultSet.getString("middle_name"));
        person.setPa_surname(resultSet.getString("pa_surname"));
        person.setMa_surname(resultSet.getString("ma_surname"));
        person.setUsername(resultSet.getString("username"));
        return person;
    }
}
