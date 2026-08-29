/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dentalclinic.main;


import com.dentalclinic.util.DBConnection;
import java.sql.Connection;


public class ConnectionTest {

    public static void main(String[] args) {

        try {
            Connection connection = DBConnection.getConnection();

            System.out.println("Database Connected Successfully!");

            connection.close();

        } catch (Exception e) {

            System.out.println("Database Connection Failed!");
            e.printStackTrace();
        }
    }
}

