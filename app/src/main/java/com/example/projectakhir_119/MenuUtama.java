package com.example.projectakhir_119;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MenuUtama extends Activity {
    //inisialisasi
    private int increment = 0;
    private EditText modalField, pemasukkanField;
    private Button hitungButton, lihatButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inisiasi();
    }

    public void inisiasi(){

        modalField = findViewById(R.id.modal);
        pemasukkanField = findViewById(R.id.pemasukkan);

        hitungButton = findViewById(R.id.hitung);
        lihatButton = findViewById(R.id.lihat);
        String[][] data = new String[1000][3];

        hitungButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //inisialisasi
                int modal = Integer.valueOf(modalField.getText().toString());
                int pemasukkan = Integer.valueOf(pemasukkanField.getText().toString());
                //modal lebih kecil dari pemasukan maka untung
                if(modal < pemasukkan){
                    int untung = pemasukkan - modal;
                    data[increment][0] = "Modal Anda Rp." + modal;
                    data[increment][1] = "Pemasukkan Anda hari ini Rp." + pemasukkan;
                    data[increment][2] = "Anda untung sebesar Rp." + untung;
                    //jika modal lebih besar dari pemasukan maka rugi
                }else if(modal > pemasukkan){
                    int rugi = modal - pemasukkan;
                    data[increment][0] = "Modal Anda Rp." + modal;
                    data[increment][1] = "Pemasukkan Anda hari ini Rp." + pemasukkan;
                    data[increment][2] = "Anda rugi sebesar Rp." + rugi;
                    //jika modal dahn pemasukan sama maka balik modal
                }else{
                    data[increment][0] = "Modal Anda Rp." + modal;
                    data[increment][1] = "Pemasukkan Anda hari ini Rp." + pemasukkan;
                    data[increment][2] = "Anda balik modal";
                }
                //memunculkan pesan
                Toast.makeText(MenuUtama.this, "Data berhasil ditambahkan", Toast.LENGTH_SHORT).show();

                increment++;

            }
        });
        //Untuk Menampilkan data
        lihatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //menampung semua String atau data text
                StringBuffer buffer = new StringBuffer();
                //pesan yang akan muncul
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuUtama.this);
                //ketika kita klik sebuah layar maka alert akan tertutup otomatis
                builder.setCancelable(true);
                //judul dari alert
                builder.setTitle("Data Keuangan");
                //kenapa 1 karena ada data yang akan kita inputkan dan data itu cuma 1 data
                int nomor = 1;
                //ketika i lebih kecil dari panjang data yang saya buat yaitu 1000 maka i akan terus nambah
                for(int i = 0; i < data.length; i++){
                    //jika data baris i dan kolom 0 tidak sama dengan null dan baris i dan kolom 1 tidak kosong dan baris i dan kolom 2 tidak kosong
                    if(data[i][0] != null && data[i][1] != null && data[i][2] != null){
                        //maka muncul pesan
                        buffer.append("Day " + nomor + "\n");
                        buffer.append(data[i][0] + "\n");
                        buffer.append(data[i][1] + "\n");
                        buffer.append(data[i][2] + "\n\n");
                        builder.setMessage(buffer.toString());
                    }
                    //jika kondisi masih seperti diatas maka nomor akan bertambah
                    nomor++;
                }

                builder.show();
            }
        });
    }
}
