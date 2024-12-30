/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ngonar.if_replacement;

import java.util.Map;

/**
 *
 * @author admin
 */
public class If_replacement {

    public static void main(String[] args) {
        System.out.println("IF Replacement Alternative");
        
        Map mrx = Switching.serviceMapping();
        
        /*
        if the product is PLN_pre, just send the parameter
        for the processing class specific for the product parameter, 
        you can call the required class using Class.ForName and cast that to the 
        specified class ( inherited class would be easy to cast )
        */
        
        String result1 = Switching.processMessage("", "1234", "80", "2100", "JSON", mrx);
        System.out.println(result1);
        
        String result2 = Switching.processMessage("", "1234", "100", "2100", "JSON", mrx);
        System.out.println(result2);
        
        String result3 = Switching.processMessage("", "1234", "105", "2100", "JSON", mrx);
        System.out.println(result3);
    }
}
