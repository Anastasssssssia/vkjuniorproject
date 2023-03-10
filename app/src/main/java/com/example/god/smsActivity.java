package com.example.god;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.gsm.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class smsActivity extends Activity {

    private Button shareIntent;
    private Button send;
    private EditText phoneNo;
    private EditText messageBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        phoneNo = (EditText) findViewById(R.id.mobileNumber);
        messageBody = (EditText) findViewById(R.id.smsBody);

        send = (Button) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = phoneNo.getText().toString();
                String sms = messageBody.getText().toString();

                try {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(number, null, sms, null, null);
                    Toast.makeText(getApplicationContext(),
                            "SMS отправлено!",Toast.LENGTH_LONG).show();
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(),
                            "SMS не отправлено, попытайтесь еще!", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });

        shareIntent = (Button) findViewById(R.id.sendViaIntent);
        shareIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                    sendIntent.putExtra("sms_body", messageBody.getText().toString());
                    sendIntent.setType("vnd.android-dir/mms-sms");
                    startActivity(sendIntent);
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(),
                            "SMS не отправлено, попытайтесь еще!", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });
    }
}