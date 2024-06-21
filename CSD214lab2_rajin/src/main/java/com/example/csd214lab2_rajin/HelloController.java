package com.example.csd214lab2_rajin;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.sql.*;

public class HelloController implements Initializable {
    public TableView<deliverydetails> detailstable;
    public TableColumn <deliverydetails,String>address;
    public TableColumn <deliverydetails,String>zipcode;
    public TableColumn <deliverydetails,String>fname;
    public TableColumn <deliverydetails,Integer>sn;
    public TextField szipcode;
    public TextField saddress;

    public TextField ssn;
    public TextField sfname;
    public Label welcomeText;



    ObservableList<deliverydetails> list = FXCollections.observableArrayList();

    @FXML

    protected void onHelloButtonClick() {
        Fetchdata();
    }

    private void Fetchdata() {
        list.clear();

        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214lab_2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM deliverydetails";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int sn = resultSet.getInt("sn");
                String fname = resultSet.getString("fname");
                String address = resultSet.getString("address");
                String zipcode = resultSet.getString("zipcode");
                detailstable.getItems().add(new deliverydetails(sn, fname, address, zipcode));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        sn.setCellValueFactory(new PropertyValueFactory<deliverydetails,Integer>("sn"));
        fname.setCellValueFactory(new PropertyValueFactory<deliverydetails,String>("fname"));
        address.setCellValueFactory(new PropertyValueFactory<deliverydetails,String>("address"));
        zipcode.setCellValueFactory(new PropertyValueFactory<deliverydetails,String>("zipcode"));
        detailstable.setItems(list);


    }


    public void InsertData(ActionEvent actionEvent) {



        String fname = sfname.getText();
        String address = saddress.getText();
        String zipcode = szipcode.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214lab_2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "INSERT INTO `deliverydetails`( `fname`, `address`, `zipcode`) VALUES ('"+fname+"','"+address+"','"+zipcode+"')";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void UpdateData(ActionEvent actionEvent) {
        String sn = ssn.getText();
        String fname = sfname.getText();
        String address = saddress.getText();
        String zipcode = szipcode.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214lab_2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "UPDATE `deliverydetails` SET `fname`='"+fname+"',`address`='"+address+"',`zipcode`='"+zipcode+"' WHERE sn='"+sn+"' ";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void DeleteData(ActionEvent actionEvent) {

        String sn = ssn.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214lab_2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "DELETE FROM `deliverydetails` WHERE sn='"+sn+"'";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void LoadData(ActionEvent actionEvent) {

        String sn = ssn.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214lab_2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM deliverydetails WHERE sn='"+sn+"'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {

                String fname = resultSet.getString("fname");
                String address = resultSet.getString("address");
                String zipcode = resultSet.getString("zipcode");

                sfname.setText(fname);
                saddress.setText(address);
                szipcode.setText(zipcode);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}