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


public class RSJakpus extends ListActivity {
    //Buat arrray 2 dimensi untuk data taksi yang terdiri dari nama dan nomor telepon
    private String[][] jakpus_data = {
            { "RS Abdi Waluyo", "0213144989" },
            { "RSIA Budi Kemuliaan", "0213842828" },
            { "RSIA Bunda", "02131922005" },
            { "RSIA Evasari", "0214202851" },
            { "RS Husada", "0216260108" },
            { "RS Islam Jakarta Cempaka Putih", "0214250451" },
            { "RS Jakarta Eye Center Menteng", "02129221000" },
            { "RSK THT-Bedah Proklamasi", "0213900002" },
            { "RSK Bedah Bina Estetika", "0213909393" },
            { "RSK THT Prof. Nizar", "0213843596" },
            { "RS Kramat 128", "0213918287" },
            { "RS MH Thamrin Salemba", "0213904422" },
            { "RS Mitra Kemayoran", "0216545555" },
            { "RS Mitra Menteng Mitra Afia", "0213154050" },
            { "RS MRCCC Siloam Semanggi", "02129962888" },
            { "RS PGI Cikini", "02138997777" },
            { "RSPAD Gatot Subroto", "0213441008" },
            { "RSU Cipto Mangunkusumo RSCM", "0211500135" },
            { "RS Sahid Sahirman Memorial", "02157853911" },
            { "RS Sint Carolus", "0213904441" },
            { "RSIA Tambak", "0212303444" },
            { "RS TK. II Moh. Ridwan Meuraksa", "0213150535" },
            { "RS TNI AL Dr. Mintoharjo", "0215703085" },
            { "RSUD Tarakan", "0213503150" },
            { "RS Pertamina Jaya", "0214211911" } };
    //Buat arrray 1 dimensi untuk keperluan pembuatan menu list provider taxi
    private String[] jakpus_name = { "RS Abdi Waluyo", "RSIA Budi Kemuliaan", "RSIA Bunda",
            "RSIA Evasari", "RS Husada", "RS Islam Jakarta Cempaka Putih", "RS Jakarta Eye Center Menteng", "RSK THT-Bedah Proklamasi",
            "RSK Bedah Bina Estetika", "RSK THT Prof. Nizar", "RS Kramat 128", "RS MH Thamrin Salemba",
            "RS Mitra Kemayoran", "RS Menteng Mitra Afia", "RS MRCCC Siloam Semanggi", "RS PGI Cikini", "RSPAD Gatot Subroto",
            "RSU Cipto Mangunkusumo RSCM", "RS Sahid Sahirman Memorial", "RS Sint Carolus", "RSIA Tambak",
            "RS TK. II Moh. Ridwan Meuraksa", "RS TNI AL Dr. Mintoharjo", "RSUD Tarakan", "RS Pertamina Jaya", "Exit" };

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        // Create an ArrayAdapter, that will actually make the Strings above
        // appear in the ListView
        // Menset nilai array ke dalam list adapater sehingga data pada array
        // akan dimunculkan dalam list
        this.setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, jakpus_name));
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
            for (int i = 0; i < jakpus_data.length; i++) {
                if (pilihan.equals(jakpus_data[i][0])) {
                    phonenumber = jakpus_data[i][1];
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
