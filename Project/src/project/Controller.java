/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Asus
 */
public class Controller {
    ModelAdmin modelAdmin;
    ViewAdmin viewAdmin ;
    ModelTamu modelTamu;
    ViewTamu viewTamu;

    Controller(ViewAdmin viewAdmin, ModelAdmin modelAdmin) {
    this.modelAdmin = modelAdmin;
    this.viewAdmin = viewAdmin;
    
    //mengecek data yang ada dari database dan memasukkan ke dalam tabel
    if(modelAdmin.getBanyakData() != 0){
            String data[][] = modelAdmin.readData();
            viewAdmin.tabel.setModel((new JTable(data, viewAdmin.namaKolom)).getModel());
        } else{
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
    
    //aksi ketika menekan tombol tambah
    viewAdmin.btnTambah.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { 
        String judul = viewAdmin.getFjudul().getText();
        String pengarang = viewAdmin.getFpengarang().getText();
        String penerbit = viewAdmin.getFpenerbit().getText();
        String tahun = viewAdmin.getFtahun().getText();
        String lokasi = viewAdmin.getFlokasi().getText();
        if (judul.equals("") || pengarang.equals("")||penerbit.equals("")||tahun.equals("")||lokasi.equals("")) {
            JOptionPane.showMessageDialog(viewAdmin, "Isi Kolom Kosong Terlebih Dahulu !");
        }else {
            modelAdmin.tambahData(judul,pengarang,penerbit,tahun,lokasi);
            viewAdmin.dispose();
            MVC mvc = new MVC();
            mvc.Admin();
        }
        }
    });
    
    //aksi ketika menekan tombol update
    viewAdmin.btnUpdate.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { 
        String nama = viewAdmin.nama;
        String judul = viewAdmin.getFjudul().getText();
        String pengarang = viewAdmin.getFpengarang().getText();
        String penerbit = viewAdmin.getFpenerbit().getText();
        String tahun = viewAdmin.getFtahun().getText();
        String lokasi = viewAdmin.getFlokasi().getText();
        if (judul.equals("") || pengarang.equals("")||penerbit.equals("")||tahun.equals("")||lokasi.equals("")) {
            JOptionPane.showMessageDialog(viewAdmin, "Isi Kolom Kosong Terlebih Dahulu !");
        }else {
            modelAdmin.updateData(nama,judul,pengarang,penerbit,tahun,lokasi);
            viewAdmin.dispose();
            MVC mvc = new MVC();
            mvc.Admin();
        }
        }
    });
    
    //aksi ketika menekan tombol delete
    viewAdmin.btnDelete.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { 
        String judul = viewAdmin.getFjudul().getText();

        if (judul.equals("")) {
            JOptionPane.showMessageDialog(viewAdmin, "Isi Judul Buku Yang Akan Dihapus");
        }else {
            modelAdmin.deleteData(judul);
            viewAdmin.dispose();
            MVC mvc = new MVC();
            mvc.Admin();
        }
        }
    });
    
    //aksi ketika menekan tombol clear
     viewAdmin.btnClear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                viewAdmin.fjudul.setText("");
                viewAdmin.fpengarang.setText("");
                viewAdmin.fpenerbit.setText("");
                viewAdmin.ftahun.setText("");
                viewAdmin.flokasi.setText("");
            }
        });
     
     //aksi ketika menekan tombol Menu Utama
     viewAdmin.btnBack.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                viewAdmin.dispose();
                Home home = new Home();
            }
        });
    
    }
    
    Controller(ViewTamu viewTamu, ModelTamu modelTamu) {
    this.modelTamu = modelTamu;
    this.viewTamu = viewTamu;
    
    //mengecek data yang ada dari database dan memasukkan ke dalam tabel
    if(modelTamu.getBanyakData() != 0){
            String data[][] = modelTamu.readData();
            viewTamu.tabel.setModel((new JTable(data, viewTamu.namaKolom)).getModel());
        } else{
            JOptionPane.showMessageDialog(null, "Data Kosong!!\nMinta Admin Untuk Menginput Data!!");
        }
    
    //aksi ketika menekan tombol Menu Utama
    viewTamu.btnBack.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                viewTamu.dispose();
                Home home = new Home();
            }
        });
    
    }
    
}
