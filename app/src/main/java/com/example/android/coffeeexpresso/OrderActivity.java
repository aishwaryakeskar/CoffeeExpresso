package com.example.android.coffeeexpresso;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String orderSummary = intent.getStringExtra("Order");

        TextView msg = (TextView) findViewById(R.id.order_text);
        msg.setText("Your order is placed!\n\n" + orderSummary);

        Button emailBtn = (Button) findViewById(R.id.email_button);
        emailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = getIntent();
                String name = intent.getStringExtra("name");
                String orderSummary = intent.getStringExtra("Order");

                composeEmail(orderSummary, name);

            }
        });

    }

    public void composeEmail(String order, String name) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Coffee Expresso order for " + name);
        intent.putExtra(Intent.EXTRA_TEXT, order);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
