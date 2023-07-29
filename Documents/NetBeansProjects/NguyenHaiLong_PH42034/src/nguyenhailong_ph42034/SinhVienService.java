/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nguyenhailong_ph42034;

import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author H.Long
 */
public class SinhVienService {

    ArrayList<SinhVien> list = new ArrayList<>();

    public ArrayList<SinhVien> getList() {
        return list;
    }

    public void setList(SinhVien sv) {
        this.list.add(sv);
    }

    public SinhVienService() {
    }
}
