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


public class RSJakbar extends ListActivity {
    //Buat arrray 2 dimensi untuk data taksi yang terdiri dari nama dan nomor telepon
    private String[][] jakbar_data = {
            {"RSAB Harapan Kita", "0215668284" },
            {"RS Kanker Dharmais", "0215681570" },
            {"RS Pelni Petamburan", "0215306901" },
            {"RS Siloam Kebon Jeruk", "02125677888" },
            {"RS Patria IKKT", "0215308981" },
            {"RS Medika Permata Hijau", "0215347411" },
            {"RS Hermina Daan Mogot", "0215408989" },
            {"RS Royal Taruma", "02156967788" },
            {"RS Bina Sehat Mandiri", "0215658870" },
            {"RS Puri Indah", "02125695200" },
            {"RSUD Cengkareng", "02154372874" },
            {"RS Grha Kedoya", "02129910999" },
            {"RS Jakarta Eye Center Kedoya", "02129221000" },
            {"RS Jantung Harapan Kita", "0215684093" },
            {"RSKB Cinta Kasih Tzu Chi", "02155963680" },
            {"RS Bhakti Mulia", "0215481625" },
            {"RSIA Aries", "0216496524" },
            {"RSJ Dr. Soeharto Heerjan", "0215682841" } };
    //Buat arrray 1 dimensi untuk keperluan pembuatan menu list provider taxi
    private String[] jakbar_name = {"RSAB Harapan Kita", "RS Kanker Dharmais", "RS Pelni Petamburan",
            "RS Siloam Kebon Jeruk", "RS Patria IKKT", "RS Medika Permata Hijau",
            "RS Hermina Daan Mogot", "RS Royal Taruma", "RS Bina Sehat Mandiri", "RS Puri Indah",
            "RSUD Cengkareng", "RS Grha Kedoya", "RS Jakarta Eye Center Kedoya", "RS Jantung Harapan Kita",
            "RSKB Cinta Kasih Tzu Chi", "RS Bhakti Mulia", "RSIA Aries", "RSJ Dr. Soeharto Heerjan", "Exit"};

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        // Create an ArrayAdapter, that will actually make the Strings above
        // appear in the ListView
        // Menset nilai array ke dalam list adapater sehingga data pada array
        // akan dimunculkan dalam list
        this.setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, jakbar_name));
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
            for (int i = 0; i < jakbar_data.length; i++) {
                if (pilihan.equals(jakbar_data[i][0])) {
                    phonenumber = jakbar_data[i][1];
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