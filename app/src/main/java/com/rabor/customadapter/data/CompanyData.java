package com.rabor.customadapter.data;

import com.rabor.customadapter.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leticia.rabor on 2/27/2017.
 */
public class CompanyData {

    // Array of companies
    private List<Company> companies = new ArrayList<Company>();

    // an array list of companies
    public List<Company> getCompanies() {
        return companies;
    }

    public CompanyData() {
        addItem(new Company("Android", R.drawable.android,
                "1-800-111-2222", "http://www.android.com", "support@android.com"));
        addItem(new Company("Microsoft", R.drawable.windows,
                "1-800-111-3333", "http://www.microsoft.com", "support@microsoft.com"));
        addItem(new Company("Ebay", R.drawable.ebay,
                "1-800-111-4444", "http://www.ebay.com", "support@ebay.com"));
        addItem(new Company("Apple", R.drawable.apple,
                "1-800-111-5555", "http://www.apple.com", "support@apple.com"));
        addItem(new Company("Amazon", R.drawable.amazon,
                "1-800-111-6666", "http://www.amazon.com", "support@amazon.com"));
        addItem(new Company("Google", R.drawable.google,
                "1-800-111-7777", "http://www.google.com", "support@google.com"));
    }

    private void addItem(Company item) {
        companies.add(item);
    }
}
