package responsi;

import responsi.Main.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.JOptionPane;

public class ControllerTrans {
    ModelTrans modelTrans;
    ViewTrans viewTrans;
    
    public ControllerTrans(ModelTrans modelTrans, ViewTrans viewTrans){
        this.modelTrans = modelTrans;
        this.viewTrans = viewTrans;

        if(modelTrans.getBanyakData()!=0){
            String dataTrans[][] = modelTrans.DataTransaksi();
            viewTrans.tabel.setModel((new JTable(dataTrans, viewTrans.namaKolom)).getModel());
        } else{
            JOptionPane.showMessageDialog(null, "Data tidak ditemukan.");
        }

        viewTrans.btnTambah.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String idtransaksi = viewTrans.getFidtransaksi().getText();
                String namabarang = viewTrans.getFnamabarang().getText();
                String namakasir = viewTrans.getFnamabarang().getText();
                int quantity = Integer.parseInt(viewTrans.getFquantity().getText());
                int hargasatuan = Integer.parseInt(viewTrans.getFhargasatuan().getText());
                int diskon = Integer.parseInt(viewTrans.getFdiskon().getText());
                double totalharga = (quantity*hargasatuan)-(quantity*hargasatuan*(diskon*0.01));
                
                if(idtransaksi.equals("") || namabarang.equals("")||namakasir.equals("")|| quantity==0 || hargasatuan==0 || diskon==0){
                    JOptionPane.showMessageDialog(viewTrans, "Isi kolom yang kosong!");
                } else{
                    modelTrans.updateTrans(idtransaksi, namabarang, namakasir, quantity, hargasatuan, diskon, totalharga, namakasir);
                    viewTrans.dispose();
                    Main main = new Main();
                    main.main();
                }
            }
        });

        viewTrans.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idtransaksi = viewTrans.getFidtransaksi().getText();
                String namabarang = viewTrans.getFnamabarang().getText();
                String namakasir = viewTrans.getFnamabarang().getText();
                int quantity = Integer.parseInt(viewTrans.getFquantity().getText());
                int hargasatuan = Integer.parseInt(viewTrans.getFhargasatuan().getText());
                int diskon = Integer.parseInt(viewTrans.getFdiskon().getText());
                double totalharga = (quantity*hargasatuan)-(quantity*hargasatuan*(diskon*0.01));
                String ubah = viewTrans.ubah;
                
                if(idtransaksi.equals("") || namabarang.equals("")||namakasir.equals("")|| quantity==0 || hargasatuan==0 || diskon==0){
                    JOptionPane.showMessageDialog(viewTrans, "Isi kolom yang kosong!");
                } else{
                    modelTrans.updateTrans(idtransaksi, namabarang, namakasir, quantity, hargasatuan, diskon, totalharga, namakasir);
                    viewTrans.dispose();
                    Main main = new Main();
                    main.main();
                }
            }
        });

        viewTrans.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idtransaksi = viewTrans.getFidtransaksi().getText();
     
                if(idtransaksi.equals("")){
                   JOptionPane.showConfirmDialog(null, "Hapus data transaksi?", "Pilih Opsi", JOptionPane.YES_NO_OPTION);
                } else{
                    JOptionPane.showMessageDialog(null, "Data batal dihapus");
                    modelTrans.deleteTrans(idtransaksi);
                    viewTrans.dispose();
                    Main main = new Main();
                    main.main();
                }
            }
        });
        
        viewTrans.btnReset.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                viewTrans.fidtransaksi.setText("");
                viewTrans.fnamabarang.setText("");
                viewTrans.fnamakasir.setText("");
                viewTrans.fquantity.setText("");
                viewTrans.fhargasatuan.setText("");
                viewTrans.fdiskon.setText("");
            }
        });
    }
}