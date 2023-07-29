/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nguyenhailong_ph42034;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author H.Long
 */
public class GhiDoc {

    public static void ghiFile(File file, ArrayList<SinhVien> list) throws IOException {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(list);
            oos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GhiDoc.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static ArrayList<SinhVien> DocFile(File file) {
        try {
            try ( ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                ArrayList<SinhVien> list = (ArrayList<SinhVien>) ois.readObject();
                ois.close();
                return list;
            }
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
}
