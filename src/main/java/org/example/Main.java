package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;
import utils.Constants;
import utils.Utils;

public class Main {


    public static void main(String[] args) {



        int array [] = {1, 2, 3};
        try{
            System.out.println(array[4]);
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }catch (NullPointerException n){
            n.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("Kod se izvrsio do kraja!");
    }





}