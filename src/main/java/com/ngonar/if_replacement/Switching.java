/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ngonar.if_replacement;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public class Switching {
    
    public static Map mpx = new HashMap();
    
    public Switching(){
        
    }
    
    public  File getConfigFile() {
        try {
            URL resource = getClass().getClassLoader().getResource("switch.xml");
            if (resource == null) {
                throw new IllegalArgumentException("file not found!");
            } else {
                return new File(resource.toURI());
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            
        }
        throw new IllegalArgumentException("file not found!");
    }
    
    public static Map serviceMapping() {
        
        try {
            Switching switching = new Switching();
            File file = switching.getConfigFile();
        
            JAXBContext jaxbContext = JAXBContext.newInstance(Switch.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Switch switchx = (Switch) jaxbUnmarshaller.unmarshal(file);

            List <Service> serviceMap = switchx.getServicex();
            Iterator<Service> iterator = serviceMap.iterator();

            while (iterator.hasNext()) {
                Service serv = iterator.next();
//                System.out.println(serv.getProcessor());
//                System.out.println(serv.getName());
//                System.out.println(serv.getProduct());
//                System.out.println(serv.getFormat());
//                System.out.println("================");
                
                //put into map
                mpx.put(serv.getProduct()+"_class", serv.getProcessor());
                mpx.put(serv.getProduct()+"_format", serv.getFormat());
                
            }
//            System.out.println();
//            System.out.println(" Map Elements");
//            System.out.print("\t" + mpx);
            
            return mpx;
            
        }
        catch(Exception e) {
            e.printStackTrace();
            return new HashMap();
        }
    }
    
    public static String getInternalMessageFormat(String[] reqParams, Map mrx, int user_id) {
        String result = "";
        
        ClassLoader classLoader = If_replacement.class.getClassLoader();

        try {
            String prod_id = reqParams[3];
            System.out.println("prod_id = " + prod_id);
            
            Class ngeload = classLoader.loadClass(mrx.get(prod_id+"_format").toString());
            System.out.println("the format = " + ngeload.getName());
            
            Constructor constructor = ngeload.getConstructor();
	    Object obj = constructor.newInstance();
            
            Class x = Class.forName(mrx.get(prod_id+"_format").toString());
            InternalMessageFormat ps = (InternalMessageFormat)x.newInstance();
            
            result = ps.getFormat(reqParams,mrx, user_id);
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
        
        return result;
    }
    
    public static String processMessage(String output, String trx_id, String prod_id, String trx_type, String format, Map mrx){
        String result = "";
        
        ClassLoader classLoader = If_replacement.class.getClassLoader();

        try {
            Class ngeload = classLoader.loadClass(mrx.get(prod_id+"_class").toString());
            System.out.println("the class name = " + ngeload.getName());
            
            Constructor constructor = ngeload.getConstructor();
	    Object obj = constructor.newInstance();
            
            Class x = Class.forName(mrx.get(prod_id+"_class").toString());
            PelangiService ps = (PelangiService)x.newInstance();
            
            result = ps.process(output, trx_id, prod_id, trx_type, format,mrx);
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
        
             
        
        return result;
    }
    
}