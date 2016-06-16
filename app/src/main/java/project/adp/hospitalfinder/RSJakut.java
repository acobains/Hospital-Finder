package project.adp.hospitalfinder;

/**
 * Created by JELO ANGELO on 4/30/2016.
 */
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class RSJakut extends ListActivity {
    //Buat arrray 2 dimensi untuk data taksi yang terdiri dari nama dan nomor telepon
    private String[][] jakut_data = {
            {"RS Atma Jaya", "0216606127" },
            {"RSIA Family", "0216695066" },
            {"RS Gading Pluit", "0214521001" },
            {"RSIA Hermina Podomoro", "0216404910" },
            {"RS Infeksi Prof. Dr. Sulianti Saroso", "0216506559" },
            {"RS Islam Jakarta Sukapura", "0214400778" },
            {"RSUD Koja", "02143938478" },
            {"RS Mitra Keluarga Kelapa Gading", "02145852700" },
            {"RS Oilia Medical Centre", "02143900564" },
            {"RS Pelabuhan", "0214403026" },
            {"RS Puri Medika", "02143903355" },
            {"RS Royal Progress", "0216400261" },
            {"RS Sukmul Sisma Medika", "0214301269" },
            {"RS Satya Negara", "02165836583" },
            {"RS Pluit", "02129228000" },
            {"RS Pantai Indah Kapuk", "0215880911" },
            {"RS Port Medical Centre", "02143902350" } };
    //Buat arrray 1 dimensi untuk keperluan pembuatan menu list provider taxi
    private String[] jakut_name = {"RS Atma Jaya", "RSIA Family", "RS Gading Pluit", "RSIA Hermina Podomoro",
            "RS Infeksi Prof. Dr. Sulianti Saroso", "RS Islam Jakarta Sukapura", "RSUD Koja",
            "RS Mitra Keluarga Kelapa Gading", "RS Oilia Medical Centre", "RS Pelabuhan", "RS Puri Medika",
            "RS Royal Progress", "RS Sukmul Sisma Medika", "RS Satya Negara", "RS Pluit",
            "RS Pantai Indah Kapuk", "RS Port Medical Centre", "Exit"};

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        // Create an ArrayAdapter, that will actually make the Strings above
        // appear in the ListView
        // Menset nilai array ke dalam list adapater sehingga data pada array
        // akan dimunculkan dalam list
        this.setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, jakut_name));
    }


    @Override
    /**method ini akan mengoveride method onListItemClick yang ada pada class List Activity
     * method ini akan dipanggil apabilai ada salah satu item dari list menu yang dipilih
     */
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        // Get the item that was clicked
        // Menangkap nilai text yang dklik
//        Object o = this.getListAdapter().getItem(position);
//        String pilihan = o.toString();
        String pilihan = this.getListAdapter().getItem(position).toString();
        // Mencek pilihan, apabila pilihan = Exit maka akan keluar dari aplikasi
        if (pilihan.equals("Exit")) {
            finish();
        } else {// pilihan != exit maka akan memanggil method callTaxi
            callTaxi(pilihan);
        }
    }

    /**
     * Launches the activity to make phone call to taxi provider based on
     * selected taxi
     */
    protected void callTaxi(String pilihan) {
        try {
            // Intent digunakan untuk sebagai pengenal suatu activity untuk
            // membuat panggilan telepon
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            String phonenumber = "";
            for (int i = 0; i < jakut_data.length; i++) {
                if (pilihan.equals(jakut_data[i][0])) {
                    phonenumber = jakut_data[i][1];
                }
            }
            if (phonenumber.equals("")) {
                Toast.makeText(this, "Pilih RS",
                        Toast.LENGTH_LONG).show();
                return;
            }
            callIntent.setData(Uri.parse("tel:" + phonenumber));
            startActivity(callIntent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}