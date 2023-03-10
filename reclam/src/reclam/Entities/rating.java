/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reclam.Entities;

/**
 *
 * @author houssem
 */
public class rating {
      private int  value  ;
 
      
       public rating( int value) {
      
        this.value = value;
       }
       public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
