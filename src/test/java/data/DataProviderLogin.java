package data;

import dto.UserDtoLombok;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderLogin {

    @DataProvider
    public Iterator<Object[]> positiveDataLogin() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{
                UserDtoLombok.builder()
                        .username("testqa20@gmail.com")
                        .password("123456Aa$")
                        .build()
        });
        list.add(new Object[]{
                UserDtoLombok.builder()
                        .username("testqa20@gmail.com")
                        .password("123456Aa$")
                        .build()
        });
         return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> negativePasswordDataLogin() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{
                UserDtoLombok.builder()
                        .username("testqa20@gmail.com")
                        .password("123456A88")
                        .build()
        });
        list.add(new Object[]{
                UserDtoLombok.builder()
                        .username("testqa20@gmail.com")
                        .password("123456Aaa")
                        .build()
        });
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginCSV() {
        List<Object[]> list = new ArrayList<>();
        String path = "src/test/resources/datalogin.csv";
        try(BufferedReader reader = new BufferedReader(new FileReader(new File(path)))) {
            String line = reader.readLine();
            while(line != null) {
                String[] split = line.split(",");
                list.add(new Object[]{
                        UserDtoLombok.builder()
                                .username(split[0])
                                .password(split[1])
                                .build()
                });
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list.iterator();
    }
}
