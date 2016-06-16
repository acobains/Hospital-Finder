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


public class RSJaktim extends ListActivity {
    //Buat arrray 2 dimensi untuk data taksi yang terdiri dari nama dan nomor telepon
    private String[][] jaktim_data = {
            { "RS Harapan jayakarta", "02146822879" },
            { "RS Harum", "0218617212" },
            { "RSIA Hermina Jatinegara", "0218191223" },
            { "RSIA Yadika", "0218615754" },
            { "RS Islam Jakarta Pondok Kopi", "0218610471" },
            { "RSU Kartika", "0214703333" },
            { "RS POLRI", "0218093288" },
            { "RS Mediros", "0214704565" },
            { "RS Premier Jatinegara", "0211500908" },
            { "RS Pusdikkes", "0218092358" },
            { "RSPAU Dr. Esnawan Antariksa", "02180881911" },
            { "RSUD Pasar Rebo", "0218401127" },
            { "RSU UKI", "0218092317" },
            { "RSU Harapan Bunda", "0218400257" },
            { "RSU Pusat Persahabatan", "0214891708" },
            { "RSUD Budhi Asih", "0218090282 " },
            { "RS OMNI Medical Center Pulomas", "02129779999" },
            { "RS Dharma Nugraha", "0214707433" },
            { "RS MH Thamrin Pondok Gede", "0218004772" },
            { "RS Haji Jakarta", "0218000694" },
            { "RS Jantung Binawaluya", "02187781605" },
            { "RS Ketergantungan Obat", "02187711968" },
            { "RSIA Restu Kasih", "0218001177" },
            { "RS Duren Sawit", "0218615555" },
            { "RSIA SamMarie", "02186613145" },
            { "RSIA Bunda Aliyah", "02186602525" },
            { "RS Antam Medika", "02129378939" },
            { "RSIA Alvernia Agusta", "0214705266" },
            { "RSK Bedah Rawamangun", "02147881918" },
            { "RS Columbia Asia", "02129459999" },
            { "RSIA Dr. Euis", "02186905347" },
            { "RS Cijantung Kesdam Jaya", "0218400535" },
            { "RSIA Resti Mulya", "0214802192" } };
    //Buat arrray 1 dimensi untuk keperluan pembuatan menu list provider taxi
    private String[] jaktim_name = { "RS Harapan jayakarta", "RS Harum", "RSIA Hermina Jatinegara",
            "RSIA Yadika", "RS Islam Jakarta Pondok Kopi", "RSU Kartika", "RS POLRI", "RS Mediros",
            "RS Premier Jatinegara", "RS Pusdikkes", "RSPAU Dr. Esnawan Antariksa", "RSUD Pasar Rebo",
            "RSU UKI", "RSU Harapan Bunda", "RSU Pusat Persahabatan", "RSUD Budhi Asih", "RS OMNI Medical Center Pulomas",
            "RS Dharma Nugraha", "RS MH Thamrin Pondok Gede", "RS Haji Jakarta", "RS Jantung Binawaluya",
            "RS Ketergantungan Obat", "RSIA Restu Kasih", "RS Duren Sawit", "RSIA SamMarie", "RSIA Bunda Aliyah",
            "RS Antam Medika", "RSIA Alvernia Agusta", "RSK Bedah Rawamangun", "RS Columbia Asia", "RSIA Dr. Euis",
            "RS Cijantung Kesdam Jaya", "RSIA Resti Mulya", "Exit" };

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        // Create an ArrayAdapter, that will actually make the Strings above
        // appear in the ListView
        // Menset nilai array ke dalam list adapater sehingga data pada array
        // akan dimunculkan dalam list
        this.setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, jaktim_name));
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
     *
     */
    protected void callTaxi(String pilihan) {
        try {
            // Intent digunakan untuk sebagai pengenal suatu activity untuk
            // membuat panggilan telepon
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            String phonenumber = "";
            for (int i = 0; i < jaktim_data.length; i++) {
                if (pilihan.equals(jaktim_data[i][0])) {
                    phonenumber = jaktim_data[i][1];
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