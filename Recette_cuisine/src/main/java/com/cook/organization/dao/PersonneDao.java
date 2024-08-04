package com.cook.organization.dao;

import com.cook.organization.entity.Personne;

import java.sql.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PersonneDao implements IDao{


    @Override
    public Optional get(UUID id) {
        return Optional.empty();
    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public void save(Object o) {

    }


    @Override
    public void save(Personne person) {
        PreparedStatement psmt = null;
        try {

            Connection con = DatabaseConnexion.getConnection();
            psmt = con.prepareStatement("INSERT INTO PERSONNE (name,email) VALUES (?,?)");
            psmt.setString(1, person.getNom());
            psmt.setString(2, person.getEmail());
            if (psmt.execute() == true) {
                System.out.println("Connexion succeed !");
            } else {
                System.out.println("Connexion failed !");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                psmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }



    @Override
    public void update(Object o, String[] params) {

    }

    @Override
    public void delete(Object o) {

    }
}
