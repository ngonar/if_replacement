/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ngonar.if_replacement;

/**
 *
 * @author admin
 */
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement(name="switch")
public class Switch {
    private List<Service> servicex;
    
    public List<Service> getServicex() {
        if( servicex == null ){
          servicex = new ArrayList<>();
        }
        return servicex;
    }
    
    @XmlElement(name="servicex")
    public void setServicex(List<Service> servicex) {
        this.servicex = servicex;
    }
}