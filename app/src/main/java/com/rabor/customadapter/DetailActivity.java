package com.rabor.customadapter;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    // define variables
    private String companyName;
    private TextView phoneTV, nameTV, emailTV, websiteTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // gets the data that was passed in from the intent of the Main Activity
        Intent intent = getIntent();

        companyName = intent.getStringExtra("companyName");
        int imageResource = intent.getIntExtra("imageResource", 0);
        String phone = intent.getStringExtra("phone");
        String website = intent.getStringExtra("website");
        String email = intent.getStringExtra("email");

        // get reference to the widget
        nameTV = (TextView) findViewById(R.id.nameTV);
        nameTV.setText(companyName);
        phoneTV = (TextView) findViewById(R.id.phoneTV);
        phoneTV.setText(phone);
        websiteTV = (TextView) findViewById(R.id.websiteTV);
        websiteTV.setText(website);
        emailTV = (TextView) findViewById(R.id.emailTV);
        emailTV.setText(email);

        ImageView image = (ImageView) findViewById(R.id.logoImageView);
        image.setImageResource(imageResource);
    }

    public void phoneClick(View view) {
        try {
            String phone_no = phoneTV.getText().toString().replaceAll("-", "");

            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:" + phone_no));

            startActivity(callIntent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(getApplicationContext(), "Call Failed", Toast.LENGTH_LONG).show();
        }
    }

    public void smsClick(View view) {
        String number = phoneTV.getText().toString();
        String message = "";

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + number));
        intent.putExtra("sms body", message);
        startActivity(intent);

    }

    public void browserClick(View view) {
        String link = websiteTV.getText().toString();
        Uri uri = Uri.parse(link);

        Intent viewIntent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(viewIntent);
    }

    public void emailClick(View view) {
        String em = emailTV.getText().toString();
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL, new String[] {em});
        i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
        i.putExtra(Intent.EXTRA_TEXT, "body of email");

        try {
            startActivity(Intent.createChooser(i, "send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There are no email clients installed", Toast.LENGTH_LONG).show();
        }
    }
}
