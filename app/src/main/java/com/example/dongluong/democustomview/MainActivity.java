package com.example.dongluong.democustomview;


import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener  {
    SeekBar sbDefaultSeekBar, sbCustomSeekBarr;
    TextView tvDefaultProgessDetail, tvCustomProgessDetail, tvVerticalProgessDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
        switch (seekBar.getId()) {

            case R.id.sbCustomSeekBar:
                tvCustomProgessDetail.setText(progress + "");
                break;

        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
