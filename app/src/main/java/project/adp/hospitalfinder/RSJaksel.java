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


public class RSJaksel extends ListActivity {
    //Buat arrray 2 dimensi untuk data taksi yang terdiri dari nama dan nomor telepon
    private String[][] jaksel_data = {
            {"RS Agung", "0218282795" },
            {"RSIA Asih", "0212700609" },
            {"RSIA Budhi Jaya", "0218292672" },
            {"RSUP Fatmawati", "0217501524" },
            {"RS Gandaria", "0217203311" },
            {"RSB Kartini", "0217245646" },
            {"RS Jakarta", "0215732241" },
            {"RS Jakarta Medical Center", "0217985177" },
            {"RSIA Kemang Medical Care", "02127545454" },
            {"RSK THT Bedah Ciranjang", "0217243366" },
            {"RSK Mata Aini", "0215256228" },
            {"RS Medistra", "0215210200" },
            {"RS MMC", "0215203435" },
            {"RS Pondok Indah", "0217657525" },
            {"RS Prikasih", "0217504669" },
            {"RS Puri Cinere", "0217545488" },
            {"RS Pusat Pertamina", "0217219000" },
            {"RS Sanatorium Dharmawangsa", "0217394484" },
            {"RS Setia Mitra", "0217656000" },
            {"RS Tebet", "0218307540" },
            {"RS Tria Dipa", "0217974071" },
            {"RS Siaga Raya", "0217972750" },
            {"RS Zahirah", "02178888723" },
            {"RSIA Yadika", "0217291074" },
            {"RS Marinir Cilandak", "0217805296" },
            {"RSIA Muhammadiyah Taman Puring", "0217208358" },
            {"RS Asri Mampang", "02127837900" },
            {"RS Siloam TB Simatupang", "02129531900" },
            {"RS Mayapada", "02129217777" },
            {"RSIA Brawijaya", "0217211337" },
            {"RS Dr.Suyoto", "0217342012" },
            {"RSIA Avisena", "0215853916" },
            {"RSUD Pasar Minggu", "02129059999" },


    };
    //Buat arrray 1 dimensi untuk keperluan pembuatan menu list provider taxi
    private String[] jaksel_name = {"RS Agung", "RSIA Asih", "RSIA Budhi Jaya",
            "RSUP Fatmawati", "RS Gandaria", "RSB Kartini", "RS Jakarta", "RS Jakarta Medical Center",
            "RSIA Kemang Medical Care", "RSK THT Bedah Ciranjang", "RSK Mata Aini", "RS Medistra", "RS MMC",
            "RS Pondok Indah", "RS Prikasih", "RS Puri Cinere", "RS Pusat Pertamina", "RS Sanatorium Dharmawangsa",
            "RS Setia Mitra", "RS Tebet", "RS Tria Dipa", "RS Siaga Raya", "RS Zahirah", "RSIA Yadika",
            "RS Marinir Cilandak", "RSIA Muhammadiyah Taman Puring", "RS Asri Mampang", "RS Siloam TB Simatupang",
            "RS Mayapada", "RSIA Brawijaya", "RS Dr.Suyoto", "RSIA Avisena", "RSUD Pasar Minggu", "Exit"};

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        // Create an ArrayAdapter, that will actually make the Strings above
        // appear in the ListView
        // Menset nilai array ke dalam list adapater sehingga data pada array
        // akan dimunculkan dalam list
        this.setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, jaksel_name));
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
            for (int i = 0; i < jaksel_data.length; i++) {
                if (pilihan.equals(jaksel_data[i][0])) {
                    phonenumber = jaksel_data[i][1];
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