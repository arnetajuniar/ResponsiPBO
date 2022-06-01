package responsi;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class ViewTrans extends JFrame{
    final JTextField fidtransaksi = new JTextField(10);
    final JTextField fnamabarang = new JTextField();
    final JTextField fnamakasir = new JTextField();
    final JTextField fquantity = new JTextField();
    final JTextField fhargasatuan = new JTextField();
    final JTextField fdiskon = new JTextField();
    
    JLabel lidtransaksi = new JLabel("ID Transaksi");
    JLabel lnamabarang = new JLabel ("Nama Barang");
    JLabel lnamakasir = new JLabel("Nama Kasir");
    JLabel lquantity = new JLabel("Quantity");
    JLabel lhargasatuan = new JLabel("Harga Satuan");
    JLabel ldiskon = new JLabel("Diskon (%)");
    //total harga gak usah, ditaruh tabel aja
    
    JButton btnTambah = new JButton("Tambah");
    JButton btnUpdate = new JButton("Update");
    JButton btnDelete= new JButton("Delete");
    JButton btnReset = new JButton("Clear");
    
    public JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    Object namaKolom[]={"ID Transaksi", "Nama Barang", "Nama Kasir", "Quantity", "Harga Satuan", "Diskon", "Total Harga"};
    String ubah;
    
    public ViewTrans(){
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);
        
        setTitle("DATA TRANSAKSI");
        setDefaultCloseOperation(3);
        setSize(780, 440);
        setLayout(null);
        setResizable(false);
        
        add(scrollPane);
        scrollPane.setBounds(20, 20, 480, 300);
        
        add(lidtransaksi);
        lidtransaksi.setBounds(600, 20, 90, 20);
        add(fidtransaksi);
        fidtransaksi.setBounds(600, 40, 130, 20);
        
        add(lnamabarang);
        lnamabarang.setBounds(600, 60, 90, 20);
        add(fnamabarang);
        fnamabarang.setBounds(600, 80, 130, 20);
        
        add(lnamakasir);
        lnamakasir.setBounds(600, 100, 90, 20);
        add(fnamakasir);
        fnamakasir.setBounds(600, 120, 130, 20);
        
        add(lquantity);
        lquantity.setBounds(600, 140, 90, 20);
        add(fquantity);
        fquantity.setBounds(600, 160, 130, 20);
        
        add(lhargasatuan);
        lhargasatuan.setBounds(600, 180, 90, 20);
        add(fhargasatuan);
        fhargasatuan.setBounds(600, 200, 130, 20);
        
        add(ldiskon);
        ldiskon.setBounds(600, 220, 90, 20);
        add(fdiskon);
        fdiskon.setBounds(600, 240, 130, 20);
        
        add(btnTambah);
        btnTambah.setBounds(600, 270, 90, 20);
        
        add(btnUpdate);
        btnUpdate.setBounds(600, 300, 90, 20);
        
        add(btnDelete);
        btnDelete.setBounds(600, 330, 90, 20);
        
        add(btnReset);
        btnReset.setBounds(600, 360, 90, 20);
       
        scrollPane.setBounds(20, 35, 570, 345);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        tabel.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent m){
                JTable pilih = (JTable) m.getSource();
                int baris = pilih.getSelectedRow(); //memilih baris
                ubah = tabel.getValueAt(baris, 0).toString();
                fidtransaksi.setText(tabel.getValueAt(baris, 0).toString());
                fnamabarang.setText(tabel.getValueAt(baris, 1).toString());
                fnamakasir.setText(tabel.getValueAt(baris, 2).toString());
                fquantity.setText(tabel.getValueAt(baris, 3).toString());
                fhargasatuan.setText(tabel.getValueAt(baris, 4).toString());
                fdiskon.setText(tabel.getValueAt(baris, 5).toString());
            }
        
        });
    }
    public JTextField getFidtransaksi(){
        return fidtransaksi;
    }
    
    public JTextField getFnamabarang(){
        return fnamabarang;
    }
    
    public JTextField getFnamakasir(){
        return fnamakasir;
    }
    
    public JTextField getFquantity(){
        return fquantity;
    }
    
    public JTextField getFhargasatuan(){
        return fhargasatuan;
    }
    
    public JTextField getFdiskon(){
        return fdiskon;
    }
    
//    public static void main(String[] args){
//        new ViewTrans();
//    }
   
}
