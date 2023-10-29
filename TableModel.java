/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan7;
import javax.swing.table.*; // Mengimpor semua kelas dari paket javax.swing.table
import java.util.ArrayList; // Mengimpor kelas ArrayList dari paket java.util
import java.util.List; // Mengimpor kelas List dari paket java.util
/**
 *
 * @author lenovo
 */
public class TableModel extends AbstractTableModel{ // Mendefinisikan kelas TableModel yang menggantikan kelas AbstractTableModel
    private String[] columnNames = {"Nama", "Nomor HP", "Jenis Kelamin","Alamat"}; // Mendefinisikan array columnNames yang berisi nama kolom-kolom tabel
    private ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>(); // Mendefinisikan ArrayList data untuk menyimpan data tabel
    
    // Implementasi metode untuk mengembalikan jumlah kolom
    public int getColumnCount(){
        return columnNames.length; // Mengembalikan panjang (jumlah elemen) dari array columnNames sebagai jumlah kolom
    }
    
     public int getRowCount() { // Implementasi metode untuk mengembalikan jumlah baris (data) dalam tabel
        return data.size(); // Mengembalikan jumlah elemen dalam ArrayList data sebagai jumlah baris
    }
     
    public String getColumnName(int col) { // Implementasi metode untuk mendapatkan nama kolom pada indeks tertentu
         return columnNames[col]; // Mengembalikan nama kolom pada indeks 'col' dari array 'columnNames'
    }
    
    public Object getValueAt(int row, int col) { // Metode ini digunakan untuk mendapatkan nilai pada sel tabel tertentu
        List<String> rowItem = data.get(row); // Mengambil baris data pada indeks 'row' dari ArrayList 'data'
        return rowItem.get(col); // Mengembalikan nilai pada kolom 'col' dari baris data yang diambil
    }
    
    public boolean isCellEditable(int row, int col) { // Implementasi metode untuk menentukan apakah sel dalam tabel dapat diedit
        return false; // Sel dalam tabel tidak dapat diedit (kembalikan nilai false)
    }
    
     public void add(ArrayList<String> value) { // Metode untuk menambahkan data ke tabel
        data.add(value); // Menambahkan data ke ArrayList data 
        fireTableRowsInserted(data.size() -1, data.size() -1); // Memanggil metode fireTableRowsInserted untuk memberitahu tabel bahwa baris telah ditambahkan
    }
    
    // Menghapus baris pada indeks tertentu
    public void remove(int rowIndex) {
        data.remove(rowIndex);
        // Memberi tahu tabel bahwa baris telah dihapus
        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    // Mengambil data pada baris tertentu
    public ArrayList<String> getDataAt(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < data.size()) {
            return data.get(rowIndex);
        }
        return null;
    }

    // Memperbarui data pada baris tertentu
    public void update(int rowIndex, ArrayList<String> updatedData) {
        if (rowIndex >= 0 && rowIndex < data.size()) {
            data.set(rowIndex, updatedData);
            // Memberi tahu tabel bahwa baris telah diperbarui
            fireTableRowsUpdated(rowIndex, rowIndex);
        }
    }

    // Menghapus semua data dalam model tabel
    public void clearData() {
        int size = data.size();
        data.clear();
        // Memberi tahu tabel bahwa semua baris telah dihapus
        fireTableRowsDeleted(0, size - 1);
    }

}
