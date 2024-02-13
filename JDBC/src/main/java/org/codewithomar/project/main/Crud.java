package org.codewithomar.project.main;

import org.codewithomar.project.model.Person;
import org.codewithomar.project.repository.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

public class Crud {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);

    public void personCrud(Repository<Person> repository) {
        System.out.println("\tTHIS IS A CRUD PROJECT IMPLEMENTING JDBC");
        System.out.println("\tARCHITECTURE: CLIENT-SERVER");
        System.out.println("\tDEPENDENCIES: MAVEN");
        System.out.println("\tSGBD: MySQL");
        System.out.println("\tDB: schedules");
        System.out.println("\tTABLE NAME: person\n");

        boolean exit = false;
        do {
            System.out.println("\tAvailable Options: ");
            System.out.println("\t1. List all records");
            System.out.println("\t2. List one record using person's ID");
            System.out.println("\t3. Add a new record");
            System.out.println("\t4. Update a record");
            System.out.println("\t5. Delete a record");
            System.out.println("\t6. Close program");
            System.out.print("\tSelect your answer using the option's number: ");
            try {
                int option = Integer.parseInt(br.readLine());

                switch (option) {
                    case 1 -> this.listAllPerson(repository);
                    case 2 -> this.listOnePerson(repository);
                    case 3 -> this.addPerson(repository);
                    case 4 -> this.updatePerson(repository);
                    case 5 -> this.deletePerson(repository);
                    case 6 -> exit = true;
                    default -> {
                        System.out.println("\tNo option available for input provided.");
                        System.out.println("\tPlease try again.");
                    }
                }
            } catch (IOException e){
                System.out.println("\tInput/Output Error.");
                System.out.println("\tPlease try again.\n");
            } catch (NumberFormatException e){
                System.out.println("\tInput provided is not valid.");
                System.out.println("\tPlease try again.\n");
            }
        } while (!exit);
    }

    public void listAllPerson(Repository<Person> repository) {
        try {
            List<Person> listPerson = repository.findAll();

            System.out.println("\n\tList all records:");
            for (Person person : listPerson) {
                System.out.println(person.toString());
            }
            System.out.println();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void listOnePerson(Repository<Person> repository){
        boolean exit = false;
        do {
            System.out.println("\n\tList one record using person's ID:");
            System.out.print("\tProvide person's ID you want to list: ");
            try {
                Integer id = Integer.parseInt(br.readLine());

                if (repository.getById(id) == null) {
                    System.out.println("\n\tThe ID provided doesn't match with any person on the database.");
                    System.out.println("\tPlease try again");
                } else {
                    Person person = repository.getById(id);
                    System.out.println("\n"+person.toString()+"\n");
                    exit = true;
                }

            } catch (IOException e){
                System.out.println("\tInput/Output Error.");
                System.out.println("\tPlease try again.\n");
            } catch (NumberFormatException e){
                System.out.println("\tInput provided is not valid.");
                System.out.println("\tPlease try again.\n");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("\tSQL Error.");
                System.out.println("\tPlease try again.");
            }

        } while (!exit);
    }

    public void addPerson(Repository<Person> repository) {
        boolean exit = false;
        do {
            try {
                System.out.println("\n\tAdd a new person:");
                System.out.print("\tProvide person's First Name: ");
                String first_name = br.readLine();
                System.out.print("\tProvide person's Middle Name: ");
                String middle_name = br.readLine();
                System.out.print("\tProvide person's Paternal Surname: ");
                String pa_surname = br.readLine();
                System.out.print("\tProvide person's Maternal Surname: ");
                String ma_surname = br.readLine();
                System.out.print("\tProvide person's Username: ");
                String username = br.readLine();

                Person person = new Person();
                person.setFirst_name(first_name);
                person.setMiddle_name(middle_name);
                person.setPa_surname(pa_surname);
                person.setMa_surname(ma_surname);
                person.setUsername(username);

                repository.save(person);

                System.out.println("\n\tPerson has been added successfully!\n");

                exit = true;

            } catch (IOException e){
                System.out.println("\tInput/Output Error.");
                System.out.println("\tPlease try again.\n");
            } catch (NumberFormatException e){
                System.out.println("\tInput provided is not valid.");
                System.out.println("\tPlease try again.\n");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("\tSQL Error.");
                System.out.println("\tPlease try again.");
            }
        } while (!exit);
    }

    public void updatePerson(Repository<Person> repository) {
        boolean exit = false;
        do {
            try {
                System.out.println("\n\tUpdate person:");
                System.out.print("\tProvide the person´s ID you want to update: ");
                Integer id = Integer.parseInt(br.readLine());
                System.out.print("\tProvide person's First Name: ");
                String first_name = br.readLine();
                System.out.print("\tProvide person's Middle Name: ");
                String middle_name = br.readLine();
                System.out.print("\tProvide person's Paternal Surname: ");
                String pa_surname = br.readLine();
                System.out.print("\tProvide person's Maternal Surname: ");
                String ma_surname = br.readLine();
                System.out.print("\tProvide person's Username: ");
                String username = br.readLine();

                Person person = new Person();
                person.setFirst_name(first_name);
                person.setMiddle_name(middle_name);
                person.setPa_surname(pa_surname);
                person.setMa_surname(ma_surname);
                person.setUsername(username);
                person.setId(id);

                if (repository.getById(person.getId()) != null) {
                    repository.save(person);
                    System.out.println("\n\tPerson has been updated successfully!\n");
                    exit = true;
                } else {
                    System.out.println("\n\tThe ID provided doesn't match with any person on the database.");
                    System.out.println("\tPlease try again");
                }

            } catch (IOException e){
                System.out.println("\tInput/Output Error.");
                System.out.println("\tPlease try again.\n");
            } catch (NumberFormatException e){
                System.out.println("\tInput provided is not valid.");
                System.out.println("\tPlease try again.\n");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("\tSQL Error.");
                System.out.println("\tPlease try again.");
            }
        } while (!exit);
    }

    public void deletePerson(Repository<Person> repository){
        System.out.println("\n\tDelete one record:");
        System.out.print("\tProvide person's ID you want to delete: ");
        try {
            Integer id = Integer.parseInt(br.readLine());

            if (repository.getById(id) == null) {
                System.out.println("\n\tThe ID provided doesn't match with any person on the database.");
                System.out.println("\tPlease try again\n");
            } else {
                repository.delete(id);
                System.out.println("\n\tRecord deleted successfully!\n");
            }

        } catch (IOException e){
            System.out.println("\tInput/Output Error.");
            System.out.println("\tPlease try again.\n");
        } catch (NumberFormatException e){
            System.out.println("\tInput provided is not valid.");
            System.out.println("\tPlease try again.\n");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("\tSQL Error.");
            System.out.println("\tPlease try again.");
        }
    }
}
