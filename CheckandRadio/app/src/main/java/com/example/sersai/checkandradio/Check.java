package com.example.sersai.checkandradio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class Check extends AppCompatActivity {
    CheckBox chkBoxCycling;
    CheckBox chkBoxTeaching;
    CheckBox chkBoxBlogging;
    TextView txtHobby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        initialUISetup();
    }

    public void initialUISetup() {
        chkBoxCycling = (CheckBox) findViewById(R.id.chkBoxCycling);
        chkBoxTeaching = (CheckBox) findViewById(R.id.chkBoxTeaching);
        chkBoxBlogging = (CheckBox) findViewById(R.id.chkBoxBlogging);
        TextView txtHobby = (TextView) findViewById(R.id.txtHobby);
        chkBoxCycling.setOnCheckedChangeListener(new Mia());
        chkBoxTeaching.setOnCheckedChangeListener(new Mia());
        chkBoxBlogging.setOnCheckedChangeListener(new Mia());
    }

    class Mia implements CheckBox.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                if (buttonView == chkBoxCycling) {
                    showTextNotification("Me gushta pedaleal");
                }
                if (buttonView == chkBoxTeaching) {
                    showTextNotification("Me gushta enseñal");
                }
                if (buttonView == chkBoxBlogging) {
                    showTextNotification("Soy youtubeh");
                }
            }
        }
    }// clase interna

    public void showTextNotification(String msgToDisplay) {
        Toast.makeText(this, msgToDisplay, Toast.LENGTH_SHORT).show();
    }
}
