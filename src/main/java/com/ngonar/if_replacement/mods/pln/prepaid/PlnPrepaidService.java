/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ngonar.if_replacement.mods.pln.prepaid;

/**
 *
 * @author admin
 */

import com.ngonar.if_replacement.PelangiService;
import java.util.Map;


public class PlnPrepaidService extends PelangiService {
   
    public String process(String output, String trx_id, String prod_id, String trx_type, String format, Map mrx) {
        String result = "";
        
        System.out.println("-= PLN Prepaid Service =-");
        
        result = "PLN Prepaid Data has been processed";
        
        return result;
    }
}