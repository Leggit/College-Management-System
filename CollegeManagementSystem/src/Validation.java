/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class containing static methods for many types of validation
 * @author leg16833648
 */
public class Validation {
    
    /**
     * Returns true if present, false if empty 
     * @param toCheck - the field you want to check
     * @return 
     */
    public static boolean isPresent(String toCheck){
        if(toCheck.equals("")){
            return false;
        }else{
            return true;
        }
    }
    
    /**
     * returns true if the number is within the specified range, false if it isn't
     * @param toCheck the number you want to check 
     * @param min the lowest it can be 
     * @param max the highest it can be 
     * @return 
     */
    public static boolean rangeCheck(int toCheck, int min, int max){
        if(toCheck < min || toCheck > max){
            return false;
        }else{
            return true;
        }
    }
    
    /**
     * length check
     * @param toCheck as a String
     * @param length as an integer 
     * @return false if not the specified length, true if it is
     */
    public static boolean lengthCheck(String toCheck, int length){
        if(toCheck.length() != length){
            return false;
        }else{
            return true;
        }
    }
    
    /**
     * type check to ensure the data within a field is an integer
     * @param toCheck as String
     * @return true if it is an integer, false if not
     */
    public static boolean isInt(String toCheck){
        try{
            Integer.parseInt(toCheck);
            return true;
        }catch(NumberFormatException e){
            return false;           
        }
    }
    
    /**
     * format check to ensure the date is in the form dd/mm/yyyy
     * @param toCheck The date to be checked is input as a String 
     * @return true if in correct format, false if not
     */
    public static boolean isDate(String toCheck){
        if(toCheck.matches("(([0-9]{2})/([0-9]{2})/([0-9]{4}))")){
            return true;
        }else{
            return false;
        }
    }
    
    
}
