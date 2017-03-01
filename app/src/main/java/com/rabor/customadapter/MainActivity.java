package com.rabor.customadapter;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.rabor.customadapter.data.Company;
import com.rabor.customadapter.data.CompanyData;

import java.util.List;

public class MainActivity extends ListActivity {

    // define constant
    private static final int REQUEST_CODE = 100;
    // return the list of companies
    List<Company> companies = new CompanyData().getCompanies();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create the custom adapter and set it
        CustomAdapter adapter = new CustomAdapter(this, R.layout.listview_header_row, companies);
        setListAdapter(adapter);
    }

    // this function is used by the adapter
    @Override
    protected void onListItemClick(ListView parent, View v, int position, long id) {
        super.onListItemClick(parent, v, position, id);

        // returns the position of the list of companies
        Company company = companies.get(position);

        Intent intent = new Intent(this, DetailActivity.class);

        intent.putExtra("companyName", company.companyName);
        intent.putExtra("imageResource", company.imageResource);
        intent.putExtra("phone", company.phone);
        intent.putExtra("website", company.website);
        intent.putExtra("email", company.email);

        // sometimes you want to get a result back from an activity when it ends.
        // For example, you may start an activity that lets the user pick a person
        // in a list of contacts; when it ends, it returns the person that was
        // selected.
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            String companyName = data.getStringExtra("companyName");
            String action = data.getStringExtra("action");

            if(action.equals("add")) {
                Toast.makeText(this, "Adding 1" + companyName, Toast.LENGTH_LONG).show();
            }
        }
    }
}
