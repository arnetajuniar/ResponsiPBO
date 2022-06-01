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
    JLabel lhargasatuan = new JLabel("Harga");
    JLabel ldiskon = new JLabel("Diskon");
    //total harga gak usah, ditaruh tabel aja
    
    JButton btnTambah = new JButton("Tambah");
    JButton btnUpdate = new JButton("Update");
    JButton btnDelete= new JButton("Delete");
    JButton btnReset = new JButton("Clear");
    
    public JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object namaKolom[]={"ID Transaksi", "Nama Barang", "Nama Kasir", "Quantity", "Harga Satuan", "Diskon"};
    String ubah;
    
    public ViewTrans(){
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);
        
        setTitle("DATA TRANSAKSI");
        setDefaultCloseOperation(3);
        setSize(680, 440);
        setLayout(null);
        setResizable(false);
        
        add(scrollPane);
        scrollPane.setBounds(20, 20, 480, 300);
        
        add(lidtransaksi);
        lidtransaksi.setBounds(510, 20, 90, 20);
        add(fidtransaksi);
        fidtransaksi.setBounds(510, 40, 130, 20);
        
        add(lnamabarang);
        lnamabarang.setBounds(510, 60, 90, 20);
        add(fnamabarang);
        fnamabarang.setBounds(510, 80, 130, 20);
        
        add(lnamakasir);
        lnamakasir.setBounds(510, 100, 90, 20);
        add(fnamakasir);
        fnamakasir.setBounds(510, 120, 130, 20);
        
        add(lquantity);
        lquantity.setBounds(510, 140, 90, 20);
        add(fquantity);
        fquantity.setBounds(510, 160, 130, 20);
        
        add(lhargasatuan);
        lhargasatuan.setBounds(510, 180, 90, 20);
        add(fhargasatuan);
        fhargasatuan.setBounds(510, 200, 130, 20);
        
        add(ldiskon);
        ldiskon.setBounds(510, 220, 90, 20);
        add(fdiskon);
        fdiskon.setBounds(510, 240, 130, 20);
        
        add(btnTambah);
        btnTambah.setBounds(510, 270, 90, 20);
        
        add(btnUpdate);
        btnUpdate.setBounds(510, 300, 90, 20);
        
        add(btnDelete);
        btnDelete.setBounds(510, 330, 90, 20);
        
        add(btnReset);
        btnReset.setBounds(510, 360, 90, 20);
       
        setVisible(true);
        
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
    
    public static void main(String[] args){
        new ViewTrans();
    }
   
}
