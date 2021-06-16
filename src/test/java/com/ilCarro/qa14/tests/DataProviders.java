package com.ilCarro.qa14.tests;

import com.ilCarro.qa14.models.Car;
import com.ilCarro.qa14.models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> validUser(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"fName", "sName", "fName@gm.com", "53656rsr!A"});
        list.add(new Object[]{"fName1", "sName1", "fName11@gm.com", "53656rsr!A1"});
        list.add(new Object[]{"fName2", "sName2", "fName22@gm.com", "53656rsr!A2"});

        return list.iterator();
    }

    @DataProvider
    public  Iterator<Object[]> validUserFromCSV() throws IOException {
        return userParser("src/test/resources/valid_user_data.csv").iterator();
    }
    @DataProvider
    public  Iterator<Object[]> wrongPassUserFromCSV() throws IOException {
       return userParser("src/test/resources/wrong_pass_user_data.csv").iterator();
    }

    private List<Object[]> userParser(String src)  throws IOException{
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File(src)));
        String line = reader.readLine();
        String[] dataArr = line.split(",");
        while ((line != null)) {
            list.add(new Object[]{new User().withFirstName(dataArr[0])
                    .withSecondName(dataArr[1])
                    .withEmail(dataArr[2])
                    .withPassword(dataArr[3])});
            line = reader.readLine();
        }
        return list;
    }

    @DataProvider
    public  Iterator<Object[]> validCarFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/tes_new_car.csv")));
        String line = reader.readLine();
        String[] dataArr = line.split(",");
        while ((line != null)) {
            list.add(new Object[]{new Car().withCountry(dataArr[0])
                    .withAddress(dataArr[1])
                    .withDistance(dataArr[2])});
            line = reader.readLine();
        }
        return list.iterator();
    }
}
