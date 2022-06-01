
package responsi;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class ModelTrans {
    Connector connector = new Connector();
    public int getBanyakData(){
        int jmlData=0;
        try{
            String query = "SELECT * FROM transactions";
            connector.statement = connector.koneksi.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query);
            while(resultSet.next()){
                jmlData++;
            }
            connector.statement.close();
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("SQL Error");
        }
        return jmlData;
    }
    
    public String[][] DataTransaksi(){
        try{
            int jmlData=0;
            String data[][] = new String[getBanyakData()][7];
            
            String query = "SELECT * FROM transactions";
            connector.statement = connector.koneksi.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query);
            while(resultSet.next()){
                data[jmlData][0] = resultSet.getString("id_trans");
                data[jmlData][1] = resultSet.getString("nama_barang");
                data[jmlData][2] = resultSet.getString("nama_kasir");
                data[jmlData][3] = resultSet.getString("qty");
                data[jmlData][4] = resultSet.getString("price_per_qty");
                data[jmlData][5] = resultSet.getString("discount");
                data[jmlData][6] = resultSet.getString("price_total");
                jmlData++;
            }
            return data;
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public void tambahTrans(String idtransaksi, String namabarang, String namakasir, int quantity, int hargasatuan, int diskon, double totalharga){        
        try{
            String query = "INSERT INTO transactions VALUES('"+idtransaksi+"', '"+namabarang+"', '"+namakasir+"', '"+quantity+"', '"+hargasatuan+"', '"+diskon+"', '"+totalharga+"')";
            connector.statement = connector.koneksi.createStatement();
            connector.statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data berhasil ditambah.");
        } catch(SQLException ex){
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "ID transaksi sudah ada!");
        }
    }
    
    public void updateTrans(String idtransaksi, String namabarang, String namakasir, int quantity, int hargasatuan, int diskon, double totalharga, String ubah){
        try{
            String query = "UPDATE transactions set id_trans=?," + "nama_barang=?, nama_kasir=?, qty=?, price_per_qty=?, discount=?, price_total=? WHERE id_trans=?";
            PreparedStatement preparedStatement = connector.koneksi.prepareStatement(query);
            preparedStatement.setString(1, idtransaksi);
            preparedStatement.setString(2, namabarang);
            preparedStatement.setString(3, namakasir);
            preparedStatement.setInt(4, quantity);
            preparedStatement.setInt(5, hargasatuan);
            preparedStatement.setInt(6, diskon);
            preparedStatement.setDouble(7, totalharga);
            preparedStatement.setString(8, ubah);
            preparedStatement.execute();
            
            if(ubah.compareTo(idtransaksi)==0){
                JOptionPane.showMessageDialog(null,"Berhasil update data.");
            } else{
                JOptionPane.showMessageDialog(null,"Data transaksi tidak ditemukan.");
            }     
        } catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public void deleteTrans(String idtransaksi){
        try{
            String query = "DELETE * FROM transactions WHERE id_trans = '"+idtransaksi+"'";
            connector.statement = connector.koneksi.createStatement();
            connector.statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus.");
        } catch(SQLException sql){
            System.out.println(sql.getMessage());
        }
    }
}
