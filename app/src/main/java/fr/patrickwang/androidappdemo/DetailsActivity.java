package fr.patrickwang.androidappdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import fr.patrickwang.androidappdemo.factory.ResponseFactory;
import fr.patrickwang.androidappdemo.models.Response;

public class DetailsActivity extends AppCompatActivity {
    private final String SELECTED_RESPONSE_EXTRA = "SELECTED_RESPONSE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        Response response = intent.getParcelableExtra(SELECTED_RESPONSE_EXTRA);

        updateDisplay(response);
    }

    /**
     * This method dynamically displays detailed information of a Response inside the main LinearLayout.
     * @param response The Response object whose information we want to display
     */
    private void updateDisplay(Response response) {
        // We retrieve the only layout component created in the XML file
        LinearLayout mainLinearLayout = (LinearLayout) findViewById(R.id.details_linear_layout);

        HashMap<String, String> responseMap = response.getDetails();
        for (Map.Entry<String, String> entry : responseMap.entrySet()) {
            // The next block is related to the dynamic creation of a new LinearLayout, which will contain two TextViews displayed side-by-side: titleTextView and contentsTextView
            // mainLinearLayoutParams allows us to define layout parameters
            // In particular, the WeightSum parameter allows us to define the width of the LinearLayout. Widgets inside this LinearLayout can use the Weight parameter to take a fraction
            // of this total WeightSum.
            LinearLayout.LayoutParams mainLinearLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            LinearLayout linearLayout = new LinearLayout(getApplicationContext());
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            linearLayout.setWeightSum(10.0f);

            // Here, we define two different weights of 2.5 and 7.5 for our TextViews (for a total of 10, as defined by the WeightSum)
            LinearLayout.LayoutParams titleTextViewLinearLayoutParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 2.5f);
            LinearLayout.LayoutParams contentsTextViewLinearLayoutParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 7.5f);

            TextView titleTextView = new TextView(getApplicationContext());
            titleTextView.setText(entry.getKey());
            titleTextView.setTextSize(18);
            // Here, we add the titleTextView to the linearLayout with the titleTextViewLinearLayoutParams layout parameters.
            // This means the parameters are attached to the TextView and not the LinearLayout.
            linearLayout.addView(titleTextView, titleTextViewLinearLayoutParams);

            TextView contentTextView = new TextView(getApplicationContext());
            contentTextView.setText(entry.getValue());
            contentTextView.setTextSize(18);
            // This method is used to truncate a text which would be too long to display
            contentTextView.setEllipsize(TextUtils.TruncateAt.END);
            // We can also force a TextView to render only a line
            contentTextView.setSingleLine(true);
            linearLayout.addView(contentTextView, contentsTextViewLinearLayoutParams);

            mainLinearLayout.addView(linearLayout, mainLinearLayoutParams);
        }
    }
}
