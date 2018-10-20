
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Class containing methods for finding specific records, 
 * The records can be returned, edited or deleted using the methods in this class
 * @author Oliver
 */
public class Search {

    /**
     * Searches a particular field in each record to see if it matches the
     * search input
     *
     * @param fileName the name of the file the be searched
     * @param toFind the input value to be found in the file
     * @param fieldNum identifies the specific field to be searched through
     * (starts from 0)
     * @return the record containing the matching field as a String array
     */
    static String[] findRecord(String fileName, String toFind, int fieldNum) {
        String line;
        String fields[];

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fileReader);

            while ((line = reader.readLine()) != null) {
                //System.out.println(line);
                fields = line.split(",");

                if (fields[fieldNum].equals(toFind)) {
                    return fields;
                }
            }

            //JOptionPane.showMessageDialog(null, "No match found");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "An error occurred");
            return null;
        } catch (IOException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "An error occurred");
            return null;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "An error occurred");
            return null;
        }

        return null;
    }

    /**
     * deletes the record in the specified file that matches the key input
     * @param fileName the file containing the record to be deleted
     * @param key the primary key of the record to be deleted
     */
    static void findAndDelete(String fileName, String key) {
        String toKeep[] = new String[99999];//stores the records to be kept 
        String line;
        String fields[];
        int counter = 0;

        //read in every record apart from the one to be deleted
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fileReader);

            while ((line = reader.readLine()) != null) {
                fields = line.split(",");
                if (!fields[0].equals(key)) {//if the record is not the one to be deleted, copy it in
                    toKeep[counter] = line;
                    counter++;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        }

        //copy accross all the records to be kept 
        try {
            FileWriter writer = new FileWriter(fileName);

            for (int i = 0; i < counter; i++) {
                writer.write(toKeep[i]);
            }

            writer.flush();
            writer.close();

        } catch (IOException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        }

        JOptionPane.showMessageDialog(null, "Succesfully Deleted");//let the user know
    }

    /**
     * method that finds a file to be edited, deleted the original and adds in the edited record in its place
     * @param fileName - the name of the file containing the record to be edited
     * @param key - the primary key of the record to be edited
     * @param editedRecord - the updated record
     */
    static void findAndEdit(String fileName, String key, String editedRecord) {
        String toKeep[] = new String[99999];//stores all the records to be copied accross
        String line;
        String fields[];
        int counter = 0;

        //read in every record apart from the one to be edited
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fileReader);

            while ((line = reader.readLine()) != null) {
                fields = line.split(",");
                if (!fields[0].equals(key)) {
                    toKeep[counter] = line;
                    counter++;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        }

        //write in all records except the edited one, add the updated record to the end 
        try {
            FileWriter writer = new FileWriter(fileName);

            for (int i = 0; i < counter; i++) {
                writer.write(toKeep[i]);
            }

            writer.write(editedRecord);//add in the new record

            writer.flush();
            writer.close();

        } catch (IOException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        }

        JOptionPane.showMessageDialog(null, "Succesfully Edited");
    }

}
