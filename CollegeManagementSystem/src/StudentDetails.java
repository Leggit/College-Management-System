
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Class for creating objects to hold student details 
 * @author Oliver
 */
public class StudentDetails {
    public static String FILE_NAME = "StudentDetails.txt";//the file where all student details are stored
    
    //variables to hold each field in a record
    private String id;
    private String forename;
    private String surname;
    private String address1;
    private String address2;
    private String address3;
    private String postCode;
    private String phone;
    private String dob;
    
    /**
     * constructor method that takes all fields from a student record as parameters to create a new student object 
     * @param id
     * @param forename
     * @param surname
     * @param address1
     * @param address2
     * @param address3
     * @param postCode
     * @param phone
     * @param dob (date of birth)
     */
    public StudentDetails(String id, String forename, String surname, String address1, String address2, String address3, String postCode, String phone, String dob){
        this.id = id;
        this.forename = forename;
        this.surname = surname;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.postCode = postCode;
        this.phone = phone;
        this.dob = dob;
    }
    
    @Override
    /**
     * Returns a string containing all student details in a CSV format 
     * (no new line character is included)
     */
    public String toString(){
        String csvData;
        csvData = id + "," + forename + "," + surname + "," + address1 + "," + address2 + "," + address3 + "," + postCode + "," + 
                phone + "," + dob;
        
        return csvData;
    }
    
    /**
     * goes through student details file until the last record
     * returns the last ID + 1 to guarantee a unique identifier 
     * if there are no records in the file, the method returns the number 100
     * @return the new ID as an integer
     */
    public static int getNewId(){
        String line;
        String fields[];
        int newID = 100;
        
        try {
            FileReader fileReader = new FileReader(FILE_NAME);
            BufferedReader reader = new BufferedReader(fileReader);
            
            while((line = reader.readLine()) != null){
                fields = line.split(",");
                newID = Integer.parseInt(fields[0]) + 1;
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("couldnt find new ID");
            Logger.getLogger(StudentDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("couldnt find new ID");
            Logger.getLogger(StudentDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return newID;
        
    }
}
