/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan7;                 // package yang digunakan untuk mengorganisir kelas-kelas dalam program
import java.awt.event.*;            // Mengimpor paket event dari Java AWT yang berisi kelas-kelas untuk mengelola peristiwa (events) GUI
import javax.swing.*;               // Mengimpor seluruh paket Swing untuk membuat komponen GUI 
import javax.swing.table.*;         // Mengimpor kelas-kelas yang terkait dengan tabel dalam Swing untuk menampilkan data dalam format tabel
import java.util.*;                 // Mengimpor paket util yang berisi banyak kelas yang membantu dalam pemrograman umum
import java.io.FileWriter;          // Mengimpor kelas FileWriter dari paket java.io untuk menulis data ke file teks
import java.io.File;                // Mengimpor kelas File dari paket java.io untuk merepresentasikan file dalam sistem berkas
import java.io.IOException;         // Mengimpor kelas IOException dari paket java.io untuk menangani pengecualian yang terkait dengan operasi masukan/keluaran
import javax.swing.JOptionPane;     // Mengimpor kelas JOptionPane dari paket javax.swing, yang digunakan untuk menampilkan dialog pesan dan kotak dialog dalam GUI.
/**
 *
 * @author lenovo
 */
public class Biodata extends JFrame{ //Mendeklarasikan kelas 'Biodata'
    private boolean checkBoxSelected; // Mendeklarasikan variabel boolean 'checkBoxSelected'
    
    private static final long serialVersionUID = 1L; // Konstanta serialVersionUID untuk identifikasi serialisasi
        
         // Metode untuk memeriksa apakah string mengandung karakter numerik
	private boolean isNumeric(String str) {
	    return str.matches("\\d+");
        }
    
    public Biodata() {
        this.checkBoxSelected = false; // Menginisilisasikan variabel checkBoxSelected dengan nilai false
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Method yang digunakan untuk menutup frame ketika tombol X ditekan
       
        // berfungsi untuk membuat objek JLabel dengan teks "Nama"
        // berfungsi untuk mengatur posisi dan ukuran dari labelNama
        JLabel labelNama = new JLabel("Nama: "); 
        labelNama.setBounds(15, 40, 365, 10); 

        // berfungsi untuk membuat objek kotak teks (text field)
        // berfungsi untuk mengatur posisi dan ukuran dari textField
        JTextField textFieldNama = new JTextField(); 
        textFieldNama.setBounds(15, 60, 365, 30); 

        // berfungsi untuk membuat objek JLabel dengan teks "Nomor HP"
        // berfungsi untuk mengatur posisi dan ukuran dari labelTelepon
        JLabel labelTelepon = new JLabel("Nomor HP: ");
        labelTelepon.setBounds(15, 100, 365, 10); 

        // berfungsi untuk membuat objek kotak teks (text field)
        // berfungsi untuk mengatur posisi dan ukuran dari textField
        JTextField textFieldTelepon = new JTextField(); 
        textFieldTelepon.setBounds(15, 120, 365, 30); 

        // berfungsi untuk membuat objek JLabel dengan teks "Jenis Kelamin" dengan nama labelRadio
        // berfungsi untuk mengatur posisi dan ukuran dari labelRadio
        JLabel labelRadio = new JLabel("Jenis Kelamin:");  
        labelRadio.setBounds(15, 160, 350, 10);
        
        // berfungsi untuk membuat sebuah objek JRadioButton (tombol radio) dengan teks "Laki-laki" 
        // berfungsi untuk mengatur posisi dan ukuran dari radioButton1
        JRadioButton radioButton1 = new JRadioButton("Laki-Laki", true); 
        radioButton1.setBounds(15, 180, 350, 30);

        // berfungsi untuk membuat sebuah objek JRadioButton (tombol radio) dengan teks "Perempuan" 
        // berfungsi untuk mengatur posisi dan ukuran dari radioButton2
        JRadioButton radioButton2 = new JRadioButton("Perempuan"); // membuat JRadioButton dengan nama button yang diberikan nilai "perempuan"
        radioButton2.setBounds(15, 205, 350, 30);// mengatur x,y panjang dan lebar

        // berfungsi untuk membuat sebuah objek ButtonGroup dengan nama bg. (untuk mengelompokkan radio button)
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);
        
        // berfungsi untuk membuat objek JLabel dengan teks "Alamat"
        // berfungsi untuk mengatur posisi dan ukuran dari labelAlamat
        JLabel labelAlamat = new JLabel ("Alamat : ");
        labelAlamat.setBounds(15, 230, 350, 30);
        
        // membuat JTextField dengan nama textFieldAlamat
        // mengatur x,y panjang dan lebar
        JTextArea textFieldAlamat = new JTextArea(); 
        textFieldAlamat.setBounds(15, 260, 365, 70); 
        
        // Instansiasi JButton dengan nama button yang diberikan nilai "Simpan"
        // mengatur x,y panjang dan lebar
        JButton button = new JButton("Simpan");
        button.setBounds(15, 340, 80, 40);
        
        // Instansiasi JButton dengan nama button yang diberikan nilai "Edit"
        JButton editButton = new JButton("Edit");
        editButton.setBounds(100, 340, 80, 40);

        // Instansiasi JButton dengan nama button yang diberikan nilai "Hapus"
        JButton deleteButton = new JButton("Hapus");
        deleteButton.setBounds(185, 340, 80, 40);

        // Instansiasi JButton dengan nama button yang diberikan nilai "Simpan ke File"
        JButton saveToFileButton = new JButton("Simpan ke File");
        saveToFileButton.setBounds(270, 340, 120, 40);
        
        
        // Instansiasi JTable dengan nama table
        JTable table = new JTable();
        // Instansiasi JScrollPane dengan nama scrollableTable yang diberikan ke objek table
        // mengatur x,y panjang dan lebar
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15, 390,365,200); 
 
        // Instansiasi LatihanMyTableModel dengan nama tableModel
        TableModel tableModel = new TableModel();
        // Atur model dari table dengan objek tableModel
        table.setModel(tableModel);

        
        // Menambahkan action listener ke button
        button.addActionListener(new ActionListener() {
            // Method untuk menerima event
            public void actionPerformed(ActionEvent e) {
                
                // menampilkan dialog konfirmasi (confirm dialog) ke user
                int confirmation = JOptionPane.showConfirmDialog(Biodata.this, 
                        "Apakah anda yakin ingin menyimpan data?", "konfirmasi", JOptionPane.YES_NO_OPTION);
                // Memeriksa apakah pengguna mengkonfirmasi dengan tombol Yes pada dialog
                if (confirmation == JOptionPane.YES_OPTION){
                    
                    // Variable jenisKelamin yang digunakan untuk menyimpan nilai radio button yang diklik (jenis kelamin)
                    String jenisKelamin = "";

                    // Jika radioButton1 diklik
                    if (radioButton1.isSelected()) {
                        // Maka jenisKelamin akan bernilai Laki-Laki
                        jenisKelamin = radioButton1.getText();
                        // Kembalikan radio button kembali ke kondisi semula
                        radioButton1.setSelected(false);
                    }
                    // Jika radioButton2 diklik
                    if (radioButton2.isSelected()) {
                        // Maka jenisKelamin akan bernilai Perempuan
                        jenisKelamin = radioButton2.getText();
                        // Kembalikan radio button kembali ke kondisi semula
                        radioButton2.setSelected(false);
                    } 
                    
                    String nama = textFieldNama.getText();       // Variable nama untuk menyimpan nilai dari objek textFieldNama (nama)
                    String telepon = textFieldTelepon.getText(); // Variable telepon untuk menyimpan nilai dari objek textFieldTelepon (telepon)
                    String alamat = textFieldAlamat.getText();   // Variable alamat untuk menyimpan nilai dari objek textFieldAlamat (alamat)
                    
                    // Memeriksa apakah nama kosong
                    if(nama.isEmpty()){ 
                        // Menampilkan pesan peringatan jika nama kosong
                        JOptionPane.showMessageDialog(Biodata.this, "Nama tidak Boleh kosong", "Peringatan",JOptionPane.WARNING_MESSAGE);
                    } else if(telepon.isEmpty()){
                        // Menampilkan pesan peringatan jika nomor hp kosong
                        JOptionPane.showMessageDialog(Biodata.this, "Nomor hp tidak Boleh kosong", "Peringatan",JOptionPane.WARNING_MESSAGE);
                    } else if(alamat.isEmpty()){
                         // Menampilkan pesan peringatan jika alamat kosong
                        JOptionPane.showMessageDialog(Biodata.this, "Alamat tidak Boleh kosong", "Peringatan",JOptionPane.WARNING_MESSAGE);
                    }else if (!isNumeric(telepon)) {
                          // Menampilkan pesan peringatan jika nomor hp tidak berisi angka
                        JOptionPane.showMessageDialog(null, "Nomor HP harus berisi angka.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                    }else {

                        // Jika semua validasi berhasil, Tambahkan variable nama, telepon, jenisKelamin, dan wna ke objek ArrayList dan dikirim lagi ke objek tableModel melalui method add
                        tableModel.add(new ArrayList<>(Arrays.asList(nama, telepon, jenisKelamin, alamat)));
                
                        textFieldNama.setText("");    // Kembalikan isi textFieldNama ke kondisi kosong
                        textFieldTelepon.setText(""); // Kembalikan isi textFieldTelepon ke kondisi kosong
                        textFieldAlamat.setText("");  // Kembalikan isi textFieldAlamat ke kondisi kosong
                        
                        // Menampilkan pesan sukses setelah data berhasil disimpan
                        JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "Info", JOptionPane.INFORMATION_MESSAGE);
                    }
                    
                    
                }
            }
        });
        
        // Menambahkan ActionListener ke tombol editButton untuk mengedit data
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Mendapatkan baris yang dipilih dalam tabel
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    String nama = (String) tableModel.getValueAt(selectedRow, 0);         // untuk mengambil data dari col 0 di tabel
                    String nomorHp = (String) tableModel.getValueAt(selectedRow, 1);      // untuk mengambil data dari col 1 di tabel
                    String jenisKelamin = (String) tableModel.getValueAt(selectedRow, 2); // untuk mengambil data dari col 2 di tabel
                    String alamat = (String) tableModel.getValueAt(selectedRow, 3);       // untuk mengambil data dari col 3 di tabel

                    textFieldNama.setText(nama);       // untuk mengisi textfield nama dengan data dari tabel
                    textFieldTelepon.setText(nomorHp); // untuk mengisi textfield nomorHp dengan data dari tabel
                    if (jenisKelamin.equals("Laki-Laki")) {
                        radioButton1.setSelected(true);
                    } else {
                        radioButton2.setSelected(true);
                    }
                    textFieldAlamat.setText(alamat); // untuk mengisi textfield alamat dengan data dari tabel

                    // Hapus data setelah memastikan data telah disalin
                    tableModel.remove(selectedRow);
                    
                    // Notifikasi ketika data berhasil disalin
                    JOptionPane.showMessageDialog(null, "Data berhasil disalin ke formulir. Klik Simpan jika sudah selesai mengedit.", "Info", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // Notifikasi jika tidak ada data yang dipilih
                    JOptionPane.showMessageDialog(null, "Pilih data yang ingin Anda edit terlebih dahulu.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        // Menambahkan ActionListener ke tombol deleteButton untuk menghapus data
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    tableModel.remove(selectedRow); // Notifikasi setelah data dihapus
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus", "Info", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // Notifikasi jika tidak ada data yang dipilih
                    JOptionPane.showMessageDialog(null, "Pilih data yang ingin Anda hapus terlebih dahulu.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        // Menambahkan ActionListener ke tombol deleteButton untuk menghapus data
        saveToFileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String filePath = "C:\\Users\\lenovo\\OneDrive\\Documents\\NetBeansProjects\\Hello World\\src\\pertemuan7\\file.txt"; // Lokasi file yang ditentukan
                    
                    File file = new File(filePath);

                    // Buat FileWriter untuk menulis data ke file
                    FileWriter writer = new FileWriter(file);

                    // Tulis data dari tabel ke file
                    for (int i = 0; i < tableModel.getRowCount(); i++) {
                        for (int j = 0; j < tableModel.getColumnCount(); j++) {
                            writer.write(tableModel.getValueAt(i, j).toString());
                            writer.write("\t"); // Tab sebagai pemisah data
                        }
                        writer.write("\n"); // Baris baru untuk setiap baris data
                    }

                    // Tutup FileWriter
                    writer.close();

                    // Notifikasi setelah data disimpan ke file
                    JOptionPane.showMessageDialog(null, "Data berhasil disimpan ke file", "Info", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    // Tangani kesalahan jika ada masalah dengan penulisan ke file
                    JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menyimpan ke file.", "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });
        
        // menambahkan WindowListener untuk menangani peristiwa penutupan jendela
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0); // Keluar dari aplikasi jika pengguna memilih "Ya"
                }
            }
        });
        
        // Mengatur perilaku tombol close window
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Tidak melakukan apa pun saat tombol close window ditekan
        

        
        this.add(labelNama);         // Untuk menambahkan objek labelNama ke frame
        this.add(textFieldNama);     // Untuk menambahkan objek textFieldNama ke frame
        this.add(labelTelepon);      // Untuk menambahkan objek labelTelepon ke frame
        this.add(textFieldTelepon);  // Untuk menambahkan objek textFieldTelepon ke frame
        this.add(labelRadio);        // Untuk menambahkan objek labelRadio ke frame
        this.add(radioButton1);      // Untuk menambahkan objek radioButton1 ke frame
        this.add(radioButton2);      // Untuk menambahkan objek radioButton2 ke frame
        this.add(labelAlamat);       // Untuk menambahkan objek labelAlamat ke frame
        this.add(textFieldAlamat);   // Untuk menambahkan objek textFieldAlamat ke frame
        this.add(button);            // Untuk menambahkan objek button ke frame
        this.add(scrollableTable);   // Untuk menambahkan objek scrollableTable ke frame
        this.add(editButton);        // Untuk menambahkan objek editbutton ke frame
        this.add(deleteButton);      // Untuk menambahkan objek deletebutton ke frame
        this.add(saveToFileButton);  // Untuk menambahkan objek saveToFileButton ke frame
        
        this.setSize(500, 700); // Mengatur ukuran frame menjadi 400 x 700
        this.setLayout(null);        // Mengatur layout frame menjadi null

    }
    
    // Main program
    public static void main(String[] args) {
        // Method invokeLater dari SwingUtilities untuk menjalankan objek Runnable yang berguna menangani event dan update UI
        SwingUtilities.invokeLater(new Runnable() {
            // Override method run dari Runnable
            public void run() {
                // Instansiasi Latihan4 dengan nama h
                Biodata h = new Biodata();
                // Tampilkan objek h dengan method setVisible dan parameternya true
                h.setVisible(true);
            }
        });
    }
}