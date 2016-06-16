package project.adp.hospitalfinder;


import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;



public class tampilRS extends ListActivity {
    Intent pindahClass;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        String[] daerahrs = new String[] {"Rumah Sakit Jakarta Timur","Rumah Sakit Jakarta Barat","Rumah Sakit Jakarta Selatan","Rumah Sakit Jakarta Utara","Rumah Sakit Jakarta Pusat"};
        this.setListAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, daerahrs));
    }

    public void onListItemClick (ListView l, View v, int position, long id) {
        //Intent i = new Intent (tampilRS.this, RSJaktim.class);
        //startActivity(i);

        super.onListItemClick(l, v, position, id);
        switch (position) {
            case 0:
                pindahClass = new Intent(this, RSJaktim.class);
                startActivity(pindahClass);
                break;
            case 1:
                pindahClass = new Intent(this, RSJakbar.class);
                startActivity(pindahClass);
                break;
            case 2:
                pindahClass = new Intent(this, RSJaksel.class);
                startActivity(pindahClass);
                break;
            case 3:
                pindahClass = new Intent(this, RSJakut.class);
                startActivity(pindahClass);
                break;
            case 4:
                pindahClass = new Intent(this, RSJakpus.class);
                startActivity(pindahClass);
                break;
            default:
                break;
        }
    }
}
