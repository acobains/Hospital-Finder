package project.adp.hospitalfinder;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.net.Uri;
import android.content.Intent;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class Peta extends FragmentActivity {
    final int RQS_GooglePlayServices = 1;
    private GoogleMap myMap;

    public void onCreate(Bundle SavedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.peta);

//ini buat deteksi GPS nya ADP
        final LocationManager manager = (LocationManager) getSystemService( Context.LOCATION_SERVICE );

        if ( !manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder
                    .setTitle("Alert")
                    .setMessage("GPS tidak aktif, Mohon aktifkan GPS anda")
                    .setCancelable(false)
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick( final DialogInterface dialog, final int id) {
                            startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                        }
                    });
            final AlertDialog alert = builder.create();
            alert.show();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "GPS Aktif", Toast.LENGTH_LONG).show();
        }
//sampe sini nih broooooooooooooooooooooooooooooooooooooooooooooooooo

        FragmentManager myFragmentManager = getSupportFragmentManager();
        SupportMapFragment mySupportMapFragment = (SupportMapFragment) myFragmentManager.findFragmentById(R.id.map);
        myMap = mySupportMapFragment.getMap();

        //==================== Jakarta Timur ====================

        LatLng harapanjayakarta = new LatLng(-6.194863, 106.906348);
        MarkerOptions markerHarapanJayakarta = new MarkerOptions();
        markerHarapanJayakarta.position(harapanjayakarta);
        markerHarapanJayakarta.title("RS Harapan Jayakarta");
        markerHarapanJayakarta.snippet("RS Harapan Jayakarta");
        markerHarapanJayakarta.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        myMap.addMarker(markerHarapanJayakarta);

        LatLng harum = new LatLng(-6.248048, 106.909502);
        MarkerOptions markerHarum = new MarkerOptions();
        markerHarum.position(harum);
        markerHarum.title("RS Harum");
        markerHarum.snippet("Harum Sisma Medika General Hospital");
        markerHarum.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        myMap.addMarker(markerHarum);

        LatLng hermina = new LatLng(-6.220809, 106.864829);
        MarkerOptions markerHermina = new MarkerOptions();
        markerHermina.position(hermina);
        markerHermina.title("RSIA Hermina Jatinegara");
        markerHermina.snippet("RS Ibu dan Anak Hermina Jatinegara");
        markerHermina.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        myMap.addMarker(markerHermina);

        LatLng yadikapondokbambu = new LatLng(-6.237287, 106.899050);
        MarkerOptions markerYadikaPondokBambu = new MarkerOptions();
        markerYadikaPondokBambu.position(yadikapondokbambu);
        markerYadikaPondokBambu.title("RSIA Yadika");
        markerYadikaPondokBambu.snippet("RS Ibu dan Anak Yadika Pondok Bambu");
        markerYadikaPondokBambu.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        myMap.addMarker(markerYadikaPondokBambu);

        LatLng islampondokkopi = new LatLng(-6.220003, 106.939637);
        MarkerOptions markerIslamPondokKopi = new MarkerOptions();
        markerIslamPondokKopi.position(islampondokkopi);
        markerIslamPondokKopi.title("RS Islam Jakarta Pondok Kopi ");
        markerIslamPondokKopi.snippet("RS Islam Pondok Kopi Jakarta");
        markerIslamPondokKopi.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        myMap.addMarker(markerIslamPondokKopi);

        LatLng kartika = new LatLng(-6.175943, 106.884976);
        MarkerOptions markerKartika = new MarkerOptions();
        markerKartika.position(kartika);
        markerKartika.title("RSU Kartika");
        markerKartika.snippet("RS Umum Kartika Pulo Mas");
        markerKartika.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        myMap.addMarker(markerKartika);

        LatLng polri = new LatLng(-6.269703, 106.871006);
        MarkerOptions markerPolri = new MarkerOptions();
        markerPolri.position(polri);
        markerPolri.title("RS POLRI");
        markerPolri.snippet("RS Kepolisian Pusat SUKANTO");
        markerPolri.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        myMap.addMarker(markerPolri);

        LatLng mediros = new LatLng(-6.179877, 106.903723);
        MarkerOptions markerMediros = new MarkerOptions();
        markerMediros.position(mediros);
        markerMediros.title("RS Mediros");
        markerMediros.snippet("RS Mediros Jakarta");
        markerMediros.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        myMap.addMarker(markerMediros);

        LatLng premierjatinegara = new LatLng(-6.221445, 106.868824);
        MarkerOptions markerPremierJatinegara = new MarkerOptions();
        markerPremierJatinegara.position(premierjatinegara);
        markerPremierJatinegara.title("RS Premier Jatinegara");
        markerPremierJatinegara.snippet("RS Premier Jatinegara");
        markerPremierJatinegara.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        myMap.addMarker(markerPremierJatinegara);

        LatLng pusdikkes = new LatLng(-6.276852, 106.869028);
        MarkerOptions markerPusdikkes = new MarkerOptions();
        markerPusdikkes.position(pusdikkes);
        markerPusdikkes.title("RS Pusdikkes");
        markerPusdikkes.snippet("RS Pusdikkes Ditkesad Kramatjati");
        markerPusdikkes.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        myMap.addMarker(markerPusdikkes);

        LatLng antariksa = new LatLng(-6.256493, 106.891943);
        MarkerOptions markerAntariksa = new MarkerOptions();
        markerAntariksa.position(antariksa);
        markerAntariksa.title("RSPAU Esnawan Antariksa");
        markerAntariksa.snippet("RS Pusat TNI AU (Dr. Esnawan Antariksa)");
        markerAntariksa.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        myMap.addMarker(markerAntariksa);

        LatLng pasarrebo = new LatLng(-6.303492, 106.862185);
        MarkerOptions markerPasarRebo = new MarkerOptions();
        markerPasarRebo.position(pasarrebo);
        markerPasarRebo.title("RSUD Pasar Rebo");
        markerPasarRebo.snippet("RS Umum Daerah Pasar Rebo");
        markerPasarRebo.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        myMap.addMarker(markerPasarRebo);

        LatLng uki = new LatLng(-6.250604, 106.872319);
        MarkerOptions markerUki = new MarkerOptions();
        markerUki.position(uki);
        markerUki.title("RSU UKI");
        markerUki.snippet("RS Umum UKI Cawang");
        markerUki.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        myMap.addMarker(markerUki);

        LatLng harapanbunda = new LatLng(-6.302557, 106.867685);
        MarkerOptions markerHarapanBunda = new MarkerOptions();
        markerHarapanBunda.position(harapanbunda);
        markerHarapanBunda.title("RSU Harapan Bunda");
        markerHarapanBunda.snippet("RS Umum Harapan Bunda");
        markerHarapanBunda.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        myMap.addMarker(markerHarapanBunda);

        LatLng pusatpersahabatan = new LatLng(-6.203241, 106.884727);
        MarkerOptions markerPusatPersahabatan = new MarkerOptions();
        markerPusatPersahabatan.position(pusatpersahabatan);
        markerPusatPersahabatan.title("RSU Pusat Persahabatan");
        markerPusatPersahabatan.snippet("RS Umum Pusat Persahabatan");
        markerPusatPersahabatan.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        myMap.addMarker(markerPusatPersahabatan);

        LatLng budhiasih = new LatLng(-6.255769, 106.863047);
        MarkerOptions markerPusatBudhiAsih = new MarkerOptions();
        markerPusatBudhiAsih.position(budhiasih);
        markerPusatBudhiAsih.title("RSUD Budhi Asih");
        markerPusatBudhiAsih.snippet("RSUD Budhi Asih");
        markerPusatBudhiAsih.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        myMap.addMarker(markerPusatBudhiAsih);

        LatLng omni = new LatLng(-6.180279, 106.883997);
        MarkerOptions markerOmni = new MarkerOptions();
        markerOmni.position(omni);
        markerOmni.title("RS OMNI Medical Center");
        markerOmni.snippet("RS OMNI Medical Center Pulo Mas");
        markerOmni.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        myMap.addMarker(markerOmni);

        LatLng dharmanugraha = new LatLng(-6.195864, 106.886418);
        MarkerOptions markerDharmaNugraha = new MarkerOptions();
        markerDharmaNugraha.position(dharmanugraha);
        markerDharmaNugraha.title("RS Dharma Nugraha");
        markerDharmaNugraha.snippet("RS Dharma Nugraha Jakarta");
        markerDharmaNugraha.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        myMap.addMarker(markerDharmaNugraha);

        LatLng thamrinpondokgede = new LatLng(-6.287768, 106.875000);
        MarkerOptions markerThamrinPondokGede = new MarkerOptions();
        markerThamrinPondokGede.position(thamrinpondokgede);
        markerThamrinPondokGede.title("RS MH Thamrin Pondok Gede");
        markerThamrinPondokGede.snippet("RS MH Thamrin Pondok Gede");
        markerThamrinPondokGede.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        myMap.addMarker(markerThamrinPondokGede);

        LatLng haji = new LatLng(-6.289864, 106.889122);
        MarkerOptions markerHaji = new MarkerOptions();
        markerHaji.position(haji);
        markerHaji.title("RS Haji Jakarta");
        markerHaji.snippet("RS Haji Jakarta");
        markerHaji.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        myMap.addMarker(markerHaji);

        LatLng binawaluya = new LatLng(-6.308262, 106.870884);
        MarkerOptions markerBinaWaluya = new MarkerOptions();
        markerBinaWaluya.position(binawaluya);
        markerBinaWaluya.title("RS Binawaluya");
        markerBinaWaluya.snippet("RS Jantung Binawaluya");
        markerBinaWaluya.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        myMap.addMarker(markerBinaWaluya);

        LatLng ketergantunganobat = new LatLng(-6.346902, 106.872228);
        MarkerOptions markerKetergantunganObat = new MarkerOptions();
        markerKetergantunganObat.position(ketergantunganobat);
        markerKetergantunganObat.title("RS Ketergantungan Obat");
        markerKetergantunganObat.snippet("RS Ketergantungan Obat Jakarta Timur");
        markerKetergantunganObat.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        myMap.addMarker(markerKetergantunganObat);

        LatLng restukasih = new LatLng(-6.265657, 106.866482);
        MarkerOptions markerRestuKasih = new MarkerOptions();
        markerRestuKasih.position(restukasih);
        markerRestuKasih.title("RSIA Restu Kasih");
        markerRestuKasih.snippet("RS Ibu & Anak Restu Kasih");
        markerRestuKasih.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        myMap.addMarker(markerRestuKasih);

        LatLng durensawit = new LatLng(-6.231950, 106.909571);
        MarkerOptions markerDurenSawit = new MarkerOptions();
        markerDurenSawit.position(durensawit);
        markerDurenSawit.title("RS Duren Sawit");
        markerDurenSawit.snippet("RS Duren Sawit");
        markerDurenSawit.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        myMap.addMarker(markerDurenSawit);

        LatLng sammarie = new LatLng(-6.229300, 106.897288);
        MarkerOptions markerSamMarie = new MarkerOptions();
        markerSamMarie.position(sammarie);
        markerSamMarie.title("RSIA SamMarie");
        markerSamMarie.snippet("RS Ibu & Anak SamMarie");
        markerSamMarie.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        myMap.addMarker(markerSamMarie);

        LatLng bundaaliyah = new LatLng(-6.233148, 106.897063);
        MarkerOptions markerBundaAliyah = new MarkerOptions();
        markerBundaAliyah.position(bundaaliyah);
        markerBundaAliyah.title("RSIA Bunda Aliyah");
        markerBundaAliyah.snippet("RS Ibu & Anak Bunda Aliyah");
        markerBundaAliyah.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        myMap.addMarker(markerBundaAliyah);

        LatLng antammedika = new LatLng(-6.192649, 106.902592);
        MarkerOptions markerAntamMedika = new MarkerOptions();
        markerAntamMedika.position(antammedika);
        markerAntamMedika.title("RS Antam Medika");
        markerAntamMedika.snippet("RS Antam Medika Rawamangun");
        markerAntamMedika.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        myMap.addMarker(markerAntamMedika);

        LatLng alverniaagusta = new LatLng(-6.193853, 106.891591);
        MarkerOptions markerAlverniaAgusta = new MarkerOptions();
        markerAlverniaAgusta.position(alverniaagusta);
        markerAlverniaAgusta.title("RSIA Alvernia Agusta");
        markerAlverniaAgusta.snippet("RS Ibu & Anak Alvernia Agusta");
        markerAlverniaAgusta.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        myMap.addMarker(markerAlverniaAgusta);

        LatLng rawamangun = new LatLng(-6.196447, 106.885469);
        MarkerOptions markerRawamangun = new MarkerOptions();
        markerRawamangun.position(rawamangun);
        markerRawamangun.title("RSK Bedah Rawamangun");
        markerRawamangun.snippet("RS Khusus Bedah Rawamangun");
        markerRawamangun.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        myMap.addMarker(markerRawamangun);

        LatLng columbiaasia = new LatLng(-6.182550, 106.891162);
        MarkerOptions markerColumbiaAsia = new MarkerOptions();
        markerColumbiaAsia.position(columbiaasia);
        markerColumbiaAsia.title("RS Columbia Asia");
        markerColumbiaAsia.snippet("RS Columbia Asia");
        markerColumbiaAsia.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        myMap.addMarker(markerColumbiaAsia);

        LatLng euis = new LatLng(-6.245360, 106.942687);
        MarkerOptions markerEuis = new MarkerOptions();
        markerEuis.position(euis);
        markerEuis.title("RSIA Dr. Euis");
        markerEuis.snippet("RS Ibu & Anak Dr. Euis");
        markerEuis.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        myMap.addMarker(markerEuis);

        LatLng cijantung = new LatLng(-6.307413, 106.858943);
        MarkerOptions markerCijantung = new MarkerOptions();
        markerCijantung.position(cijantung);
        markerCijantung.title("RS Cijantung");
        markerCijantung.snippet("RS Cijantung Kesdam Jaya");
        markerCijantung.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        myMap.addMarker(markerCijantung);

        LatLng restimulya = new LatLng(-6.208844, 106.941784);
        MarkerOptions markerRestiMulya = new MarkerOptions();
        markerRestiMulya.position(restimulya);
        markerRestiMulya.title("RSIA Resti Mulya");
        markerRestiMulya.snippet("RS Ibu & Anak Resti Mulya");
        markerRestiMulya.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        myMap.addMarker(markerRestiMulya);


        //==================== Jakarta Barat ====================

        LatLng harapankita = new LatLng(-6.185236, 106.798501);
        MarkerOptions markerHarapanKita = new MarkerOptions();
        markerHarapanKita.position(harapankita);
        markerHarapanKita.title("RSAB Harapan Kita");
        markerHarapanKita.snippet("RS Anak & Bunda Harapan Kita");
        markerHarapanKita.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        myMap.addMarker(markerHarapanKita);

        LatLng kankerdharmais = new LatLng(-6.187209, 106.797555);
        MarkerOptions markerKankerDharmais = new MarkerOptions();
        markerKankerDharmais.position(kankerdharmais);
        markerKankerDharmais.title("RS Kanker Dharmais");
        markerKankerDharmais.snippet("Dharmais Hosptal National Cancer Center");
        markerKankerDharmais.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        myMap.addMarker(markerKankerDharmais);

        LatLng pelni = new LatLng(-6.192905, 106.804573);
        MarkerOptions markerPelni = new MarkerOptions();
        markerPelni.position(pelni);
        markerPelni.title("RS Pelni Petamburan");
        markerPelni.snippet("RS Pelni Petamburan Jakarta");
        markerPelni.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        myMap.addMarker(markerPelni);

        LatLng siloam = new LatLng(-6.190866, 106.763507);
        MarkerOptions markerSiloam = new MarkerOptions();
        markerSiloam.position(siloam);
        markerSiloam.title("RS Siloam Kebon Jeruk");
        markerSiloam.snippet("RS Siloam Kebon Jeruk");
        markerSiloam.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        myMap.addMarker(markerSiloam);

        LatLng patria = new LatLng(-6.197296, 106.792677);
        MarkerOptions markerPatria = new MarkerOptions();
        markerPatria.position(patria);
        markerPatria.title("RS Patria IKKT");
        markerPatria.snippet("RS Patria IKKT");
        markerPatria.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        myMap.addMarker(markerPatria);

        LatLng medikapermata = new LatLng(-6.218352, 106.777872);
        MarkerOptions markerMedikaPermata = new MarkerOptions();
        markerMedikaPermata.position(medikapermata);
        markerMedikaPermata.title("RS Medika Permata Hijau");
        markerMedikaPermata.snippet("RS Medika Permata Hijau");
        markerMedikaPermata.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        myMap.addMarker(markerMedikaPermata);

        LatLng herminadaanmogot = new LatLng(-6.152932, 106.712289);
        MarkerOptions markerHerminaDaanMogot = new MarkerOptions();
        markerHerminaDaanMogot.position(herminadaanmogot);
        markerHerminaDaanMogot.title("RS Hermina Daan Mogot");
        markerHerminaDaanMogot.snippet("RS Hermina Daan Mogot");
        markerHerminaDaanMogot.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        myMap.addMarker(markerHerminaDaanMogot);

        LatLng royaltaruma = new LatLng(-6.166665, 106.785430);
        MarkerOptions markerRoyalTaruma = new MarkerOptions();
        markerRoyalTaruma.position(royaltaruma);
        markerRoyalTaruma.title("RS Royal Taruma");
        markerRoyalTaruma.snippet("RS Royal Taruma");
        markerRoyalTaruma.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        myMap.addMarker(markerRoyalTaruma);

        LatLng binasehat = new LatLng(-6.185515, 106.770597);
        MarkerOptions markerBinaSehat = new MarkerOptions();
        markerBinaSehat.position(binasehat);
        markerBinaSehat.title("RS Bina Sehat Mandiri");
        markerBinaSehat.snippet("RS Bina Sehat Mandiri");
        markerBinaSehat.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        myMap.addMarker(markerBinaSehat);

        LatLng puriindah = new LatLng(-6.186276, 106.735520);
        MarkerOptions markerPuriIndah = new MarkerOptions();
        markerPuriIndah.position(puriindah);
        markerPuriIndah.title("RS Puri Indah");
        markerPuriIndah.snippet("RS Puri Indah");
        markerPuriIndah.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        myMap.addMarker(markerPuriIndah);

        LatLng cengkareng = new LatLng(-6.142923, 106.734852);
        MarkerOptions markerCengkareng = new MarkerOptions();
        markerCengkareng.position(cengkareng);
        markerCengkareng.title("RSUD Cengkareng");
        markerCengkareng.snippet("RS Umum Daerah Cengkareng");
        markerCengkareng.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        myMap.addMarker(markerCengkareng);

        LatLng kedoya = new LatLng(-6.168186, 106.765093);
        MarkerOptions markerKedoya = new MarkerOptions();
        markerKedoya.position(kedoya);
        markerKedoya.title("RS Grha Kedoya");
        markerKedoya.snippet("RS Grha Kedoya");
        markerKedoya.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        myMap.addMarker(markerKedoya);

        LatLng eyecenterkedoya = new LatLng(-6.189643, 106.761589);
        MarkerOptions markerEyeCenterKedoya = new MarkerOptions();
        markerEyeCenterKedoya.position(eyecenterkedoya);
        markerEyeCenterKedoya.title("RS Jakarta Eye Center Kedoya");
        markerEyeCenterKedoya.snippet("RS Jakarta Eye Center Kedoya");
        markerEyeCenterKedoya.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        myMap.addMarker(markerEyeCenterKedoya);

        LatLng jantungharapankita = new LatLng(-6.185350, 106.798587);
        MarkerOptions markerJantungHarapanKita = new MarkerOptions();
        markerJantungHarapanKita.position(jantungharapankita);
        markerJantungHarapanKita.title("RS Jantung Harapan Kita");
        markerJantungHarapanKita.snippet("RS Jantung Harapan Kita");
        markerJantungHarapanKita.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        myMap.addMarker(markerJantungHarapanKita);

        LatLng cintakasih = new LatLng(-6.132001, 106.737093);
        MarkerOptions markerCintaKasih = new MarkerOptions();
        markerCintaKasih.position(cintakasih);
        markerCintaKasih.title("RSKB Cinta Kasih Tzu Chi");
        markerCintaKasih.snippet("RS Khusus Bedah Cinta Kasih Tzu Chi");
        markerCintaKasih.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        myMap.addMarker(markerCintaKasih);

        LatLng bhaktimulia = new LatLng(-6.199623, 106.800546);
        MarkerOptions markerBhaktiMulia = new MarkerOptions();
        markerBhaktiMulia.position(bhaktimulia);
        markerBhaktiMulia.title("RS Bhakti Mulia");
        markerBhaktiMulia.snippet("RS Bhakti Mulia");
        markerBhaktiMulia.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        myMap.addMarker(markerBhaktiMulia);

        LatLng aries = new LatLng(-6.157585, 106.809796);
        MarkerOptions markerAries = new MarkerOptions();
        markerAries.position(aries);
        markerAries.title("RSIA Aries");
        markerAries.snippet("RS Ibu & Anak Aries");
        markerAries.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        myMap.addMarker(markerAries);

        LatLng soehartoheerjan = new LatLng(-6.162767, 106.788280);
        MarkerOptions markerSoehartoHeerjan = new MarkerOptions();
        markerSoehartoHeerjan.position(soehartoheerjan);
        markerSoehartoHeerjan.title("RSJ Dr. Soeharto Heerjan");
        markerSoehartoHeerjan.snippet("RS Jiwa Dr. Soeharto Heerjan");
        markerSoehartoHeerjan.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        myMap.addMarker(markerSoehartoHeerjan);

        //==================== Jakarta Selatan ====================

        LatLng agung = new LatLng(-6.209198, 106.847435);
        MarkerOptions markerAgung = new MarkerOptions();
        markerAgung.position(agung);
        markerAgung.title("RS Agung");
        markerAgung.snippet("RS Sultan Agung");
        markerAgung.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        myMap.addMarker(markerAgung);

        LatLng bersalinasih = new LatLng(-6.248097, 106.800954);
        MarkerOptions markerBersalinAsih = new MarkerOptions();
        markerBersalinAsih.position(bersalinasih);
        markerBersalinAsih.title("RSIA Asih");
        markerBersalinAsih.snippet("RS Ibu & Anak Asih Jakarta");
        markerBersalinAsih.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        myMap.addMarker(markerBersalinAsih);

        LatLng budhijaya = new LatLng(-6.218976, 106.845052);
        MarkerOptions markerBudhiJaya = new MarkerOptions();
        markerBudhiJaya.position(budhijaya);
        markerBudhiJaya.title("RSIA Budhi Jaya");
        markerBudhiJaya.snippet("RS Ibu & Anak Budhi Jaya");
        markerBudhiJaya.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        myMap.addMarker(markerBudhiJaya);

        LatLng fatmawati = new LatLng(-6.294792, 106.795541);
        MarkerOptions markerFatmawati = new MarkerOptions();
        markerFatmawati.position(fatmawati);
        markerFatmawati.title("RSUP Fatmawati");
        markerFatmawati.snippet("RSUP Fatmawati Jakarta");
        markerFatmawati.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        myMap.addMarker(markerFatmawati);

        LatLng gandaria = new LatLng(-6.243934, 106.790658);
        MarkerOptions markerGandaria = new MarkerOptions();
        markerGandaria.position(gandaria);
        markerGandaria.title("RS Gandaria");
        markerGandaria.snippet("RS Gandaria Jakarta");
        markerGandaria.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        myMap.addMarker(markerGandaria);

        LatLng harapankartini = new LatLng(-6.238282, 106.769781);
        MarkerOptions markerHarapanKartini = new MarkerOptions();
        markerHarapanKartini.position(harapankartini);
        markerHarapanKartini.title("RSB Kartini");
        markerHarapanKartini.snippet("RS Bersalin Kartini");
        markerHarapanKartini.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        myMap.addMarker(markerHarapanKartini);

        LatLng jakarta = new LatLng(-6.218471, 106.816376);
        MarkerOptions markerJakarta = new MarkerOptions();
        markerJakarta.position(jakarta);
        markerJakarta.title("RS Jakarta");
        markerJakarta.snippet("Jakarta Hospital");
        markerJakarta.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        myMap.addMarker(markerJakarta);

        LatLng jakartamedical = new LatLng(-6.271360, 106.830178);
        MarkerOptions markerJakartaMedical = new MarkerOptions();
        markerJakartaMedical.position(jakartamedical);
        markerJakartaMedical.title("RS Jakarta Medical Center");
        markerJakartaMedical.snippet("RS Jakarta Medical Center");
        markerJakartaMedical.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        myMap.addMarker(markerJakartaMedical);

        LatLng kemang = new LatLng(-6.285937, 106.818856);
        MarkerOptions markerKemang = new MarkerOptions();
        markerKemang.position(kemang);
        markerKemang.title("RSIA Kemang Medical Care");
        markerKemang.snippet("RS Ibu & Anak Kemang Medical Care");
        markerKemang.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        myMap.addMarker(markerKemang);

        LatLng thtbedah = new LatLng(-6.236757, 106.811291);
        MarkerOptions markerThtBedah = new MarkerOptions();
        markerThtBedah.position(thtbedah);
        markerThtBedah.title("RSK THT Bedah Ciranjang");
        markerThtBedah.snippet("RS Khusus THT Bedah Ciranjang");
        markerThtBedah.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        myMap.addMarker(markerThtBedah);

        LatLng mataaini = new LatLng(-6.214231, 106.828538);
        MarkerOptions markerMataAini = new MarkerOptions();
        markerMataAini.position(mataaini);
        markerMataAini.title("RSK Mata Aini");
        markerMataAini.snippet("RS Khusus Mata Aini Prof. Dr. Isak Salim");
        markerMataAini.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        myMap.addMarker(markerMataAini);

        LatLng medistra = new LatLng(-6.239856, 106.833630);
        MarkerOptions markerMedistra = new MarkerOptions();
        markerMedistra.position(medistra);
        markerMedistra.title("RS Medistra");
        markerMedistra.snippet("RS Medistra Jakarta");
        markerMedistra.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        myMap.addMarker(markerMedistra);

        LatLng mmc = new LatLng(-6.219967, 106.832312);
        MarkerOptions markerMMC = new MarkerOptions();
        markerMMC.position(mmc);
        markerMMC.title("RS MMC");
        markerMMC.snippet("Metropolitan Medical Center Hospital (MMC)");
        markerMMC.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        myMap.addMarker(markerMMC);

        LatLng pondokindah = new LatLng(-6.283770, 106.781458);
        MarkerOptions markerPondokIndah = new MarkerOptions();
        markerPondokIndah.position(pondokindah);
        markerPondokIndah.title("RS Pondok Indah");
        markerPondokIndah.snippet("RS Pondok Indah Jakarta");
        markerPondokIndah.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        myMap.addMarker(markerPondokIndah);

        LatLng prikasih = new LatLng(-6.314706, 106.793780);
        MarkerOptions markerPrikasih = new MarkerOptions();
        markerPrikasih.position(prikasih);
        markerPrikasih.title("RS Prikasih");
        markerPrikasih.snippet("RS Prikasih Jakarta");
        markerPrikasih.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        myMap.addMarker(markerPrikasih);

        LatLng puricinere = new LatLng(-6.321878, 106.782574);
        MarkerOptions markerPuriCinere = new MarkerOptions();
        markerPuriCinere.position(puricinere);
        markerPuriCinere.title("RS Puri Cinere");
        markerPuriCinere.snippet("RS Puri Cinere");
        markerPuriCinere.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        myMap.addMarker(markerPuriCinere);

        LatLng pusatpertamina = new LatLng(-6.239739, 106.793529);
        MarkerOptions markerPusatPertamina = new MarkerOptions();
        markerPusatPertamina.position(pusatpertamina);
        markerPusatPertamina.title("RS Pusat Pertamina");
        markerPusatPertamina.snippet("RS Pusat Pertamina");
        markerPusatPertamina.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        myMap.addMarker(markerPusatPertamina);

        LatLng dharmawangsa = new LatLng(-6.254921, 106.802821);
        MarkerOptions markerDharmawangsa = new MarkerOptions();
        markerDharmawangsa.position(dharmawangsa);
        markerDharmawangsa.title("RS Sanatorium Dharmawangsa");
        markerDharmawangsa.snippet("RS Sanatorium Dharmawangsa");
        markerDharmawangsa.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        myMap.addMarker(markerDharmawangsa);

        LatLng setiamitra = new LatLng(-6.281120, 106.795833);
        MarkerOptions markerSetiaMitra = new MarkerOptions();
        markerSetiaMitra.position(setiamitra);
        markerSetiaMitra.title("RS Setia Mitra");
        markerSetiaMitra.snippet("RS Setia Mitra Jakarta");
        markerSetiaMitra.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        myMap.addMarker(markerSetiaMitra);

        LatLng tebet = new LatLng(-6.242837, 106.850770);
        MarkerOptions markerTebet = new MarkerOptions();
        markerTebet.position(tebet);
        markerTebet.title("RS Tebet");
        markerTebet.snippet("RS Tebet Jakarta");
        markerTebet.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        myMap.addMarker(markerTebet);

        LatLng triadipa = new LatLng(-6.250859, 106.842123);
        MarkerOptions markerTriaDipa = new MarkerOptions();
        markerTriaDipa.position(triadipa);
        markerTriaDipa.title("RS Tria Dipa");
        markerTriaDipa.snippet("RS Tria Dipa");
        markerTriaDipa.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        myMap.addMarker(markerTriaDipa);

        LatLng siagaraya = new LatLng(-6.272804, 106.839115);
        MarkerOptions markerSiagaRaya = new MarkerOptions();
        markerSiagaRaya.position(siagaraya);
        markerSiagaRaya.title("RS Siaga Raya");
        markerSiagaRaya.snippet("RS Siaga Raya Jakarta");
        markerSiagaRaya.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        myMap.addMarker(markerSiagaRaya);

        LatLng zahirah = new LatLng(-6.335762, 106.823551);
        MarkerOptions markerZahirah = new MarkerOptions();
        markerZahirah.position(zahirah);
        markerZahirah.title("RS Zahirah");
        markerZahirah.snippet("RS Umum Zahirah");
        markerZahirah.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        myMap.addMarker(markerZahirah);

        LatLng yadika = new LatLng(-6.255176, 106.777846);
        MarkerOptions markerYadika = new MarkerOptions();
        markerYadika.position(yadika);
        markerYadika.title("RSIA Yadika");
        markerYadika.snippet("RS Ibu dan Anak Yadika Kebayoran Lama");
        markerYadika.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        myMap.addMarker(markerYadika);

        LatLng marinircilandak = new LatLng(-6.304860, 106.810490);
        MarkerOptions markerMarinirCilandak = new MarkerOptions();
        markerMarinirCilandak.position(marinircilandak);
        markerMarinirCilandak.title("RS Marinir Cilandak");
        markerMarinirCilandak.snippet("RS Marinir Cilandak Jakarta");
        markerMarinirCilandak.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        myMap.addMarker(markerMarinirCilandak);

        LatLng muhtamanpuring = new LatLng(-6.241691, 106.787309);
        MarkerOptions markerMuhTamanPuring = new MarkerOptions();
        markerMuhTamanPuring.position(muhtamanpuring);
        markerMuhTamanPuring.title("RSIA Muhammadiyah Taman Puring");
        markerMuhTamanPuring.snippet("RS Ibu dan Anak Muhammadiyah Taman Puring");
        markerMuhTamanPuring.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        myMap.addMarker(markerMuhTamanPuring);

        LatLng asrimampang = new LatLng(-6.254523, 106.832315);
        MarkerOptions markerAsriMampang = new MarkerOptions();
        markerAsriMampang.position(asrimampang);
        markerAsriMampang.title("RS Asri Mampang");
        markerAsriMampang.snippet("RS Asri Mampang Jakarta");
        markerAsriMampang.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        myMap.addMarker(markerAsriMampang);

        LatLng siloamsimatupang = new LatLng(-6.292320, 106.784286);
        MarkerOptions markerSiloamSimatupang = new MarkerOptions();
        markerSiloamSimatupang.position(siloamsimatupang);
        markerSiloamSimatupang.title("RS Siloam TB Simatupang");
        markerSiloamSimatupang.snippet("RS Siloam TB Simatupang");
        markerSiloamSimatupang.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        myMap.addMarker(markerSiloamSimatupang);

        LatLng mayapada = new LatLng(-6.298600, 106.786178);
        MarkerOptions markerMayapada = new MarkerOptions();
        markerMayapada.position(mayapada);
        markerMayapada.title("RS Mayapada");
        markerMayapada.snippet("RS Mayapada");
        markerMayapada.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        myMap.addMarker(markerMayapada);

        LatLng brawijaya = new LatLng(-6.257470, 106.807593);
        MarkerOptions markerBrawijaya = new MarkerOptions();
        markerBrawijaya.position(brawijaya);
        markerBrawijaya.title("RSIA Brawijaya");
        markerBrawijaya.snippet("RS Ibu & Anak Brawijaya Jakarta");
        markerBrawijaya.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        myMap.addMarker(markerBrawijaya);

        LatLng suyoto = new LatLng(-6.267650, 106.766887);
        MarkerOptions markerSuyoto = new MarkerOptions();
        markerSuyoto.position(suyoto);
        markerSuyoto.title("RS Dr.Suyoto");
        markerSuyoto.snippet("RS Dr. Suyoto Jakarta");
        markerSuyoto.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        myMap.addMarker(markerSuyoto);

        LatLng avisena = new LatLng(-6.232418, 106.762531);
        MarkerOptions markerAvisena = new MarkerOptions();
        markerAvisena.position(avisena);
        markerAvisena.title("RSIA Avisena");
        markerAvisena.snippet("RS Ibu & Anak Avisena");
        markerAvisena.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        myMap.addMarker(markerAvisena);

        LatLng pasarminggu = new LatLng(-6.294319, 106.819871);
        MarkerOptions markerPasarMinggu = new MarkerOptions();
        markerPasarMinggu.position(pasarminggu);
        markerPasarMinggu.title("RSUD Pasar Minggu");
        markerPasarMinggu.snippet("RS Umum Daerah Pasar Minggu");
        markerPasarMinggu.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        myMap.addMarker(markerPasarMinggu);


        //==================== Jakarta Utara ====================

        LatLng atmajaya = new LatLng(-6.126365, 106.792991);
        MarkerOptions markerAtmaJaya = new MarkerOptions();
        markerAtmaJaya.position(atmajaya);
        markerAtmaJaya.title("RS Atma Jaya");
        markerAtmaJaya.snippet("RS Atma Jaya");
        markerAtmaJaya.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
        myMap.addMarker(markerAtmaJaya);

        LatLng family = new LatLng(-6.133472, 106.790300);
        MarkerOptions markerFamily = new MarkerOptions();
        markerFamily.position(family);
        markerFamily.title("RSIA Family");
        markerFamily.snippet("RS Ibu & Anak Family");
        markerFamily.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
        myMap.addMarker(markerFamily);

        LatLng gadingpluit = new LatLng(-6.166330, 106.915979);
        MarkerOptions markerGadingPluit = new MarkerOptions();
        markerGadingPluit.position(gadingpluit);
        markerGadingPluit.title("RS Gading Pluit");
        markerGadingPluit.snippet("RS Gading Pluit Jakarta");
        markerGadingPluit.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
        myMap.addMarker(markerGadingPluit);

        LatLng herminapodomoro = new LatLng(-6.145417, 106.861495);
        MarkerOptions markerHerminaPodomoro = new MarkerOptions();
        markerHerminaPodomoro.position(herminapodomoro);
        markerHerminaPodomoro.title("RSIA Hermina Podomoro");
        markerHerminaPodomoro.snippet("RS Ibu & Anak Hermina Podomoro");
        markerHerminaPodomoro.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
        myMap.addMarker(markerHerminaPodomoro);

        LatLng infeksi = new LatLng(-6.130389, 106.861999);
        MarkerOptions markerInfeksi = new MarkerOptions();
        markerInfeksi.position(infeksi);
        markerInfeksi.title("RS Infeksi Prof. Dr. Sulianti Saroso");
        markerInfeksi.snippet("Sulianti Saroso Infectious Disease Hospital");
        markerInfeksi.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
        myMap.addMarker(markerInfeksi);

        LatLng islamsukapura = new LatLng(-6.139791, 106.920957);
        MarkerOptions markerIslamSukapura = new MarkerOptions();
        markerIslamSukapura.position(islamsukapura);
        markerIslamSukapura.title("RS Islam Jakarta Sukapura");
        markerIslamSukapura.snippet("RS Islam Jakarta Sukapura");
        markerIslamSukapura.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
        myMap.addMarker(markerIslamSukapura);

        LatLng koja = new LatLng(-6.108946, 106.900191);
        MarkerOptions markerKoja = new MarkerOptions();
        markerKoja.position(koja);
        markerKoja.title("RSUD Koja");
        markerKoja.snippet("RS Umum Daerah Koja");
        markerKoja.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
        myMap.addMarker(markerKoja);

        LatLng mitragading = new LatLng(-6.151869, 106.897153);
        MarkerOptions markerMitraGading = new MarkerOptions();
        markerMitraGading.position(mitragading);
        markerMitraGading.title("RS Mitra Keluarga Kelapa Gading");
        markerMitraGading.snippet("RS Mitra Keluarga Kelapa Gading");
        markerMitraGading.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
        myMap.addMarker(markerMitraGading);

        LatLng oilia = new LatLng(-6.109551, 106.886344);
        MarkerOptions markerOilia = new MarkerOptions();
        markerOilia.position(oilia);
        markerOilia.title("RS Oilia Medical Centre");
        markerOilia.snippet("RS Oilia Medical Centre");
        markerOilia.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
        myMap.addMarker(markerOilia);

        LatLng pelabuhan = new LatLng(-6.124876, 106.917656);
        MarkerOptions markerPelabuhan = new MarkerOptions();
        markerPelabuhan.position(pelabuhan);
        markerPelabuhan.title("RS Pelabuhan");
        markerPelabuhan.snippet("RS Pelabuhan Jakarta Utara");
        markerPelabuhan.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
        myMap.addMarker(markerPelabuhan);

        LatLng purimedika = new LatLng(-6.129097, 106.890197);
        MarkerOptions markerPuriMedika = new MarkerOptions();
        markerPuriMedika.position(purimedika);
        markerPuriMedika.title("RS Puri Medika");
        markerPuriMedika.snippet("RS Puri Medika");
        markerPuriMedika.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
        myMap.addMarker(markerPuriMedika);

        LatLng royalprogress = new LatLng(-6.139358, 106.865438);
        MarkerOptions markerRoyalProgress = new MarkerOptions();
        markerRoyalProgress.position(royalprogress);
        markerRoyalProgress.title("RS Royal Progress");
        markerRoyalProgress.snippet("RS Royal Progress");
        markerRoyalProgress.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
        myMap.addMarker(markerRoyalProgress);

        LatLng sukmul = new LatLng(-6.112293, 106.882163);
        MarkerOptions markerSukmul = new MarkerOptions();
        markerSukmul.position(sukmul);
        markerSukmul.title("RS Sukmul Sisma Medika");
        markerSukmul.snippet("RS Sukmul Sisma Medika");
        markerSukmul.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
        myMap.addMarker(markerSukmul);

        LatLng satyanegara = new LatLng(-6.138961, 106.861645);
        MarkerOptions markerSatyaNegara = new MarkerOptions();
        markerSatyaNegara.position(satyanegara);
        markerSatyaNegara.title("RS Satya Negara");
        markerSatyaNegara.snippet("RS Satya Negara Sunter");
        markerSatyaNegara.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
        myMap.addMarker(markerSatyaNegara);

        LatLng pluit = new LatLng(-6.125689, 106.799595);
        MarkerOptions markerPluit = new MarkerOptions();
        markerPluit.position(pluit);
        markerPluit.title("RS Pluit");
        markerPluit.snippet("RS Pluit Jakarta");
        markerPluit.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
        myMap.addMarker(markerPluit);

        LatLng pantaiindahkapuk = new LatLng(-6.111843, 106.752663);
        MarkerOptions markerPantaiIndahKapuk = new MarkerOptions();
        markerPantaiIndahKapuk.position(pantaiindahkapuk);
        markerPantaiIndahKapuk.title("RS Pantai Indah Kapuk");
        markerPantaiIndahKapuk.snippet("RS Pantai Indah Kapuk");
        markerPantaiIndahKapuk.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
        myMap.addMarker(markerPantaiIndahKapuk);

        LatLng port = new LatLng(-6.110364, 106.889438);
        MarkerOptions markerPort = new MarkerOptions();
        markerPort.position(port);
        markerPort.title("RS Port Medical Centre");
        markerPort.snippet("RS Port Medical Centre");
        markerPort.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
        myMap.addMarker(markerPort);


        //==================== Jakarta Pusat ====================

        LatLng abdiwaluyo = new LatLng(-6.189845, 106.829292);
        MarkerOptions markerAbdiWaluyo = new MarkerOptions();
        markerAbdiWaluyo.position(abdiwaluyo);
        markerAbdiWaluyo.title("RS Abdi Waluyo");
        markerAbdiWaluyo.snippet("RS Abdi Waluyo Jakarta");
        markerAbdiWaluyo.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        myMap.addMarker(markerAbdiWaluyo);

        LatLng bersalinbudikemuliaan = new LatLng(-6.180532, 106.818362);
        MarkerOptions markerBersalinBudiKemuliaan = new MarkerOptions();
        markerBersalinBudiKemuliaan.position(bersalinbudikemuliaan);
        markerBersalinBudiKemuliaan.title("RSIA Budi Kemuliaan");
        markerBersalinBudiKemuliaan.snippet("RS Ibu & Anak Budi Kemuliaan");
        markerBersalinBudiKemuliaan.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        myMap.addMarker(markerBersalinBudiKemuliaan);

        LatLng bunda = new LatLng(-6.196123, 106.836490);
        MarkerOptions markerBunda = new MarkerOptions();
        markerBunda.position(bunda);
        markerBunda.title("RSIA Bunda");
        markerBunda.snippet("RS Ibu & Anak Bunda Jakarta Pusat");
        markerBunda.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        myMap.addMarker(markerBunda);

        LatLng evasari = new LatLng(-6.193567, 106.859729);
        MarkerOptions markerEvasari = new MarkerOptions();
        markerEvasari.position(evasari);
        markerEvasari.title("RSIA Evasari");
        markerEvasari.snippet("RS Ibu dan Anak Evasari");
        markerEvasari.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        myMap.addMarker(markerEvasari);

        LatLng husada = new LatLng(-6.147486, 106.829290);
        MarkerOptions markerHusada = new MarkerOptions();
        markerHusada.position(husada);
        markerHusada.title("RS Husada");
        markerHusada.snippet("RS Husada Jakarta");
        markerHusada.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        myMap.addMarker(markerHusada);

        LatLng islam = new LatLng(-6.170301, 106.870694);
        MarkerOptions markerIslam = new MarkerOptions();
        markerIslam.position(islam);
        markerIslam.title("RS Islam Jakarta Cempaka Putih");
        markerIslam.snippet("RS Islam Jakarta Cempaka Putih ");
        markerIslam.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        myMap.addMarker(markerIslam);

        LatLng jec = new LatLng(-6.198357, 106.836982);
        MarkerOptions markerJec = new MarkerOptions();
        markerJec.position(jec);
        markerJec.title("RS Jakarta Eye Center Menteng");
        markerJec.snippet("Jakarta Eye Center Menteng (JEC)");
        markerJec.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        myMap.addMarker(markerJec);

        LatLng proklamasi = new LatLng(-6.202211, 106.846998);
        MarkerOptions markerProklamasi = new MarkerOptions();
        markerProklamasi.position(proklamasi);
        markerProklamasi.title("RSK THT-Bedah Proklamasi");
        markerProklamasi.snippet("RS Khusus THT-Bedah (KL) Proklamasi");
        markerProklamasi.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        myMap.addMarker(markerProklamasi);

        LatLng estetika = new LatLng(-6.199368, 106.837314);
        MarkerOptions markerEstetika = new MarkerOptions();
        markerEstetika.position(estetika);
        markerEstetika.title("RSK Bedah Bina Estetika");
        markerEstetika.snippet("RS Khusus Bedah Bina Estetika");
        markerEstetika.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        myMap.addMarker(markerEstetika);

        LatLng nizar = new LatLng(-6.171279, 106.815351);
        MarkerOptions markerNizar = new MarkerOptions();
        markerNizar.position(nizar);
        markerNizar.title("RSK THT Prof. Nizar");
        markerNizar.snippet("RS Khusus Prof. Nizar");
        markerNizar.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        myMap.addMarker(markerNizar);

        LatLng kramat128 = new LatLng(-6.185492, 106.844060);
        MarkerOptions markerKramat128 = new MarkerOptions();
        markerKramat128.position(kramat128);
        markerKramat128.title("RS Kramat 128");
        markerKramat128.snippet("RS Kramat 128 Jakarta");
        markerKramat128.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        myMap.addMarker(markerKramat128);

        LatLng mhtahmrin = new LatLng(-6.193588, 106.851987);
        MarkerOptions markerMHThamrin = new MarkerOptions();
        markerMHThamrin.position(mhtahmrin);
        markerMHThamrin.title("RS MH Thamrin Salemba");
        markerMHThamrin.snippet("RS Muhammad Husni Thamrin Salemba");
        markerMHThamrin.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        myMap.addMarker(markerMHThamrin);

        LatLng mitrakemayoran = new LatLng(-6.151954, 106.858539);
        MarkerOptions markerMitraKemayoran = new MarkerOptions();
        markerMitraKemayoran.position(mitrakemayoran);
        markerMitraKemayoran.title("RS Mitra Kemayoran");
        markerMitraKemayoran.snippet("RS Mitra Kemayoran Jakarta");
        markerMitraKemayoran.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        myMap.addMarker(markerMitraKemayoran);

        LatLng mitramentengabadi = new LatLng(-6.187045, 106.838360);
        MarkerOptions markerMitraMentengAbadi = new MarkerOptions();
        markerMitraMentengAbadi.position(mitramentengabadi);
        markerMitraMentengAbadi.title("RS Menteng Mitra Afia");
        markerMitraMentengAbadi.snippet("RS Menteng Mitra Afia");
        markerMitraMentengAbadi.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        myMap.addMarker(markerMitraMentengAbadi);

        LatLng siloamsemanggi = new LatLng(-6.219025, 106.817172);
        MarkerOptions markerSiloamSemanggi = new MarkerOptions();
        markerSiloamSemanggi.position(siloamsemanggi);
        markerSiloamSemanggi.title("RS MRCCC Siloam Semanggi");
        markerSiloamSemanggi.snippet("RS MRCCC Siloam Semanggi");
        markerSiloamSemanggi.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        myMap.addMarker(markerSiloamSemanggi);

        LatLng pgicikini = new LatLng(-6.191309, 106.842021);
        MarkerOptions markerPGICikini = new MarkerOptions();
        markerPGICikini.position(pgicikini);
        markerPGICikini.title("RS PGI Cikini");
        markerPGICikini.snippet("RS PGI Cikini");
        markerPGICikini.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        myMap.addMarker(markerPGICikini);

        LatLng gatot = new LatLng(-6.176517, 106.837575);
        MarkerOptions markerGatot = new MarkerOptions();
        markerGatot.position(gatot);
        markerGatot.title("RSPAD Gatot Subroto");
        markerGatot.snippet("RS Pusat Angkatan Darat Gatot Subroto");
        markerGatot.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        myMap.addMarker(markerGatot);

        LatLng cipto = new LatLng(-6.197045, 106.846719);
        MarkerOptions markerCipto = new MarkerOptions();
        markerCipto.position(cipto);
        markerCipto.title("RSU Cipto Mangunkusumo RSCM");
        markerCipto.snippet("RS Umum Pusat Nasional Dr. Cipto Mangunkusumo");
        markerCipto.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        myMap.addMarker(markerCipto);

        LatLng sahidsahirman = new LatLng(-6.209564, 106.819234);
        MarkerOptions markerSahidSahirman = new MarkerOptions();
        markerSahidSahirman.position(sahidsahirman);
        markerSahidSahirman.title("RS Sahid Sahirman Memorial");
        markerSahidSahirman.snippet("RS Sahid Sahirman Memorial");
        markerSahidSahirman.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        myMap.addMarker(markerSahidSahirman);

        LatLng stcarolus = new LatLng(-6.195391, 106.851231);
        MarkerOptions markerSTCarolus = new MarkerOptions();
        markerSTCarolus.position(stcarolus);
        markerSTCarolus.title("RS Sint Carolus");
        markerSTCarolus.snippet("RS Sint Carolus Jakarta");
        markerSTCarolus.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        myMap.addMarker(markerSTCarolus);

        LatLng tambak = new LatLng(-6.206261, 106.848614);
        MarkerOptions markertambak = new MarkerOptions();
        markertambak.position(tambak);
        markertambak.title("RSIA Tambak");
        markertambak.snippet("RS Ibu & Anak Tambak");
        markertambak.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        myMap.addMarker(markertambak);

        LatLng mridwanmeuraksa = new LatLng(-6.191566, 106.847043);
        MarkerOptions markerMRidwanMeuraksa = new MarkerOptions();
        markerMRidwanMeuraksa.position(mridwanmeuraksa);
        markerMRidwanMeuraksa.title("RS TK. II Moh. Ridwan Meuraksa");
        markerMRidwanMeuraksa.snippet("RS TK. II Mohammad Ridwan Meuraksa");
        markerMRidwanMeuraksa.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        myMap.addMarker(markerMRidwanMeuraksa);

        LatLng mintoharjo = new LatLng(-6.210919, 106.812007);
        MarkerOptions markerMintoharjo = new MarkerOptions();
        markerMintoharjo.position(mintoharjo);
        markerMintoharjo.title("RS TNI AL Dr. Mintoharjo");
        markerMintoharjo.snippet("RS TNI AL Dr. Mintoharjo Jakarta");
        markerMintoharjo.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        myMap.addMarker(markerMintoharjo);

        LatLng tarakan = new LatLng(-6.171614, 106.810273);
        MarkerOptions markerTarakan = new MarkerOptions();
        markerTarakan.position(tarakan);
        markerTarakan.title("RSUD Tarakan");
        markerTarakan.snippet("RS Umum Daerah Tarakan");
        markerTarakan.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        myMap.addMarker(markerTarakan);

        LatLng pertamina = new LatLng(-6.173198, 106.876066);
        MarkerOptions markerPertamina = new MarkerOptions();
        markerPertamina.position(pertamina);
        markerPertamina.title("RS Pertamina Jaya");
        markerPertamina.snippet("Pertamina Jaya Hospital RSJP");
        markerPertamina.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        myMap.addMarker(markerPertamina);


        myMap.addMarker(markerMintoharjo);
        myMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        myMap.getUiSettings().setCompassEnabled(true);
        myMap.getUiSettings().setZoomControlsEnabled(true);
        myMap.getUiSettings().setMyLocationButtonEnabled(true);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        myMap.setMyLocationEnabled(true);
        myMap.animateCamera(CameraUpdateFactory.newLatLngZoom(mintoharjo, 13));

        myMap.setOnMarkerClickListener(new OnMarkerClickListener(){

            @Override
            public boolean onMarkerClick(Marker arg0) {
                // TODO Auto-generated method stub
                try {
                    StringBuilder urlString = new StringBuilder();
                    String daddr = (String.valueOf(arg0.getPosition().latitude)+","+String.valueOf(arg0.getPosition().longitude));
                    urlString.append("http://maps.google.com/maps?f=d&hl=en");
                    urlString.append("&saddr="+String.valueOf(myMap.getMyLocation().getLatitude())+","+String.valueOf(myMap.getMyLocation().getLongitude()));
                    urlString.append("&daddr="+daddr);
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(urlString.toString()));
                    startActivity(i);
                } catch (Exception ee) {
                    Toast.makeText(getApplicationContext(), "Lokasi Anda Belum Didapatkan, Silahkan Aktifkan GPS", Toast.LENGTH_LONG).show();
                }
                return false;
            }

        });

        myMap.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {

            @Override
            public void onInfoWindowClick(Marker arg0) {
                // TODO Auto-generated method stub

            }

        });
    }

}
