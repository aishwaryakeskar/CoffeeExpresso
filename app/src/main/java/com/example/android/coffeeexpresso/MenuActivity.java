package com.example.android.coffeeexpresso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    String drinks = "Drinks ordered: ";
    String name;
    int basePrice = 0;
    int americanoPrice = 50;
    int cappuccinoPrice = 80;
    int chocolatePrice = 60;
    int cocoaPrice = 50;
    int frappePrice = 80;
    int fredoPrice = 60;
    int glacePrice = 50;
    int irishPrice = 80;
    int lattePrice = 60;
    int expressoPrice = 70;
    int macchiatoPrice = 80;
    int mochaPrice = 60;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);



        Button order = (Button) findViewById(R.id.order_button);

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText customerName = (EditText) findViewById(R.id.name_edittext);
                name = customerName.getText().toString();

                CheckBox americano = (CheckBox) findViewById(R.id.americanoch);
                CheckBox cappuccino = (CheckBox) findViewById(R.id.cappuccinoch);
                CheckBox chocolate = (CheckBox) findViewById(R.id.chocolatech);
                CheckBox cocoa = (CheckBox) findViewById(R.id.cocoach);
                CheckBox expresso = (CheckBox) findViewById(R.id.expressoch);
                CheckBox frappe = (CheckBox) findViewById(R.id.frappech);
                CheckBox fredo = (CheckBox) findViewById(R.id.fredoch);
                CheckBox glace = (CheckBox) findViewById(R.id.glacech);
                CheckBox irish = (CheckBox) findViewById(R.id.irishch);
                CheckBox latte = (CheckBox) findViewById(R.id.lattech);
                CheckBox macchiato = (CheckBox) findViewById(R.id.macchiatoch);
                CheckBox mocha = (CheckBox) findViewById(R.id.mochach);

                boolean hasAmericano = americano.isChecked();
                boolean hasCappuccino = cappuccino.isChecked();
                boolean hasChocolate = chocolate.isChecked();
                boolean hasCocoa = cocoa.isChecked();
                boolean hasExpresso = expresso.isChecked();
                boolean hasFrappe = frappe.isChecked();
                boolean hasFredo = fredo.isChecked();
                boolean hasGlace = glace.isChecked();
                boolean hasIrish = irish.isChecked();
                boolean hasLatte = latte.isChecked();
                boolean hasMacchiato = macchiato.isChecked();
                boolean hasMocha = mocha.isChecked();

                if(hasAmericano){
                    basePrice = basePrice + americanoPrice;
                    drinks += "\nAmericano\tRs. 50";
                }
                if(hasCappuccino){
                    basePrice = basePrice + cappuccinoPrice;
                    drinks += "\nCappuccino\tRs. 80";
                }
                if(hasChocolate){
                    basePrice = basePrice + chocolatePrice;
                    drinks += "\nChocolate\tRs. 60";
                }
                if(hasCocoa){
                    basePrice = basePrice + cocoaPrice;
                    drinks += "\nCocoa\tRs. 50";
                }
                if(hasExpresso){
                    basePrice = basePrice + expressoPrice;
                    drinks += "\nExpresso\tRs. 70";
                }
                if(hasFrappe){
                    basePrice = basePrice + frappePrice;
                    drinks += "\nFrappe\tRs. 80";
                }
                if(hasFredo){
                    basePrice = basePrice + fredoPrice;
                    drinks += "\nFredo\tRs. 60";
                }
                if(hasGlace){
                    basePrice = basePrice + glacePrice;
                    drinks += "\nGlace\tRs. 50";
                }
                if(hasIrish){
                    basePrice = basePrice + irishPrice;
                    drinks += "\nIrish\tRs. 80";
                }
                if(hasLatte){
                    basePrice = basePrice + lattePrice;
                    drinks += "\nLatte\tRs. 60";
                }
                if(hasMacchiato){
                    basePrice = basePrice + macchiatoPrice;
                    drinks += "\nMacchiato\tRs. 80";
                }
                if(hasMocha){
                    basePrice = basePrice + mochaPrice;
                    drinks += "\nMocha\tRs. 60";
                }


                String message = createOrderSummary(basePrice, drinks , name);

                Intent orderIntent = new Intent(MenuActivity.this,OrderActivity.class);
                orderIntent.putExtra("name", name);
                orderIntent.putExtra("Order", message);
                startActivity(orderIntent);
            }
        });
    }

    private String createOrderSummary(int price, String drinksOrder , String name){
        String priceMessage = "Name: " + name;
        priceMessage += "\n\n" + drinksOrder;
        priceMessage += "\n\nTotal: Rs. " + price;
        priceMessage += "\n\n" + getString(R.string.thank_you);
        return priceMessage;

    }

}
