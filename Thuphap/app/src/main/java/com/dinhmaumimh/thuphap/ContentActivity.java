package com.dinhmaumimh.thuphap;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ContentActivity extends AppCompatActivity {
    TextView tieude,noidung,tacgia;
    Typeface tp;
    SQlite sq;
    String tieudeid;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        tieude = (TextView)findViewById(R.id.txttd);
        noidung = (TextView)findViewById(R.id.txtnd);
        tacgia = (TextView)findViewById(R.id.txttg);
        tp = Typeface.createFromAsset(getAssets(),"Fonts/TMC_Ong_Do.TTF");
        tieude.setTypeface(tp);
        noidung.setTypeface(tp);
        tacgia.setTypeface(tp);
        sq = new SQlite(ContentActivity.this);
        Intent it = getIntent();
        id = it.getIntExtra("id",0);
        Thuphap tp = sq.tim(id);
        tieude.setText(tp.getTieude());
        noidung.setText(tp.getNoidung());
        tacgia.setText(tp.getTacgia());

    }
}
