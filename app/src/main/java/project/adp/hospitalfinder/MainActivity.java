package project.adp.hospitalfinder;

        import android.os.Bundle;
        import android.app.Activity;
        import android.app.AlertDialog;
        import android.view.Gravity;
        import android.view.View;
        import android.view.animation.AlphaAnimation;
        import android.view.animation.Animation;
        import android.widget.Button;
        import android.content.Intent;
        import android.content.DialogInterface;
        import android.view.KeyEvent;
        import android.widget.TextView;

public class MainActivity extends Activity {

    DialogInterface.OnClickListener listener;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //jika tombol BACK ditekan
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Keluar();
        }
        return super.onKeyDown(keyCode,event );
    }

    //method untuk keluar aplikasi menggunakan dialog terlebih dahulu
    private void Keluar() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Konfirmasi");
        builder.setMessage("Apakah anda yakin ingin keluar?");
        builder.setCancelable(false);//tombol BACK tidak bisa tekan

        //Membuat listener untuk tombol DIALOG
        listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which==DialogInterface.BUTTON_POSITIVE){
                    finish(); //keluar aplikasi
                }else if(which==DialogInterface.BUTTON_NEGATIVE){
                    dialog.cancel(); //batal keluar
                }
            }
        };

        //menerapkan listener pada tombol ya dan tidak
        builder.setPositiveButton("Ya", listener);
        builder.setNegativeButton("Tidak", listener);
        builder.show(); //menampilkan dialog
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btnPanggil = (Button) findViewById(R.id.btnPanggil);
        final Button btnBantuan = (Button) findViewById(R.id.btnBantuan);
        final Button btnInfo = (Button) findViewById(R.id.btnInfo);
        final Button btnPeta = (Button) findViewById(R.id.btnPeta);

        btnPanggil.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent (getBaseContext(),tampilRS.class);
                startActivity(intent);
                Animation animation = new AlphaAnimation(1.0f, 0.0f);
                animation.setDuration(5);
                btnPanggil.startAnimation(animation);
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Info();

                Animation animation = new AlphaAnimation(1.0f, 0.0f);
                animation.setDuration(5);
                btnInfo.startAnimation(animation);
            }
        });

        btnBantuan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Bantuan();
                Animation animation = new AlphaAnimation(1.0f, 0.0f);
                animation.setDuration(5);
                btnBantuan.startAnimation(animation);
            }
        });

        btnPeta.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View V) {
                // TODO Auto-generated method stub
                Intent intent = new Intent (getBaseContext(),Peta.class);
                startActivity(intent);
                Animation animation = new AlphaAnimation(1.0f, 0.0f);
                animation.setDuration(5);
                btnPeta.startAnimation(animation);
            }
        });
    }

    public void Bantuan(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Bantuan");
        builder.setIcon(R.drawable.bantuan_adp);
        builder.setMessage("»»» MENGGUNAKAN PETA ««« \n\n"+
                "1. Tap tombol Peta\n\n"+
                "2. Konfirmasi pengaktifan GPS jika GPS belum aktif\n\n"+
                "3. Tap tombol GPS (pojok kanan atas) untuk menemukan posisi anda saat ini\n\n"+
                "4. Gunakan tombol (+) dan (-) untuk merubah ukuran skala peta\n\n"+
                "5. Pilih rumah sakit dengan menekan tanda(marker) untuk mendapatkan informasi tentang rumah sakit\n\n"+
                "6. Akan muncul pop up window, pilih aplikasi untuk membuka map tersebut\n\n"+
                "7. Aplikasi akan menunjukkan jalur untuk pengguna menuju rumah sakit tersebut\n"+
                "\n\n"+
                "»»» MELAKUKAN PANGGILAN «««  \n\n"+
                "1. Tap tombol Panggil\n\n"+
                "2. Pilih Kota Administrasi\n\n"+
                "3. Pilih rumah sakit yang ingin di hubungi\n\n"+
                "4. Aplikasi akan otomatis melakukan panggilan\n");
        builder.setCancelable(false);
        builder.setPositiveButton("Exit", null);
        AlertDialog dialog = builder.show();
        // Must call show() prior to fetching text view (ini bikin center)
        TextView messageView = (TextView)dialog.findViewById(android.R.id.message);
        messageView.setGravity(Gravity.CENTER_VERTICAL);
    }

    public void Info(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Info Aplikasi");
        builder.setIcon(R.drawable.info_adp);
        builder.setMessage("Jakarta Hospital Finder adalah " +
                "aplikasi pada perangkat mobile berbasis Android " +
                "yang memudahkan para pengguna untuk menemukan " +
                "lokasi serta menghubungi Rumah Sakit yang ada di daerah Jakarta dengan cepat."+
                "\n\n\n"+
                "Nama : Angga Dwi Prasetya\n"+
                "NIM : 1186040007 \n"+
                "Jurusan : Sistem Informasi\n"+
                "\n"+
                "INSTITUT BISNIS NUSANTARA\n"+
                "Center of Competence");
        builder.setCancelable(false);
        builder.setPositiveButton("Exit", null);
        AlertDialog dialog = builder.show();
        // Must call show() prior to fetching text view (ini bikin center)
        TextView messageView = (TextView)dialog.findViewById(android.R.id.message);
        messageView.setGravity(Gravity.CENTER_HORIZONTAL);
    }
}
