/**
 * IMPORTANT: Make sure you are using the correct package name. 
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;



import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {


    int quantity = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        CheckBox whippedCream = (CheckBox) findViewById(R.id.whipped_cream);
        CheckBox choc = (CheckBox) findViewById(R.id.chocolate);
        EditText name = (EditText) findViewById(R.id.name);

        String nameText = name.getText().toString();
        boolean hasWhippedCream = whippedCream.isChecked();
        boolean hasChocolate = choc.isChecked();
        int price = calculatePrice();

        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate, nameText);
        displayMessage(priceMessage);
//        Intent intent = new Intent(Intent.ACTION_SENDTO);
//        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
//        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for " + nameText);
//        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }
    }

    /**
     * Calculates the price of the order.
     *
     * @paramquantity is the number of cups of coffee ordered
     */
    private int calculatePrice() {
        CheckBox whippedCream = (CheckBox) findViewById(R.id.whipped_cream);
        CheckBox choc = (CheckBox) findViewById(R.id.chocolate);
        int price = 5;
        boolean hasWhippedCream = whippedCream.isChecked();
        boolean hasChocolate = choc.isChecked();

        if (hasWhippedCream) {
            price += 1;
        }

        if (hasChocolate) {
            price += 2;
        }

        int totalPrice = quantity * price;
        return totalPrice;
    }

    private String createOrderSummary(int priceOfOrder, boolean hasWhippedCream, boolean hasChocolate, String nameText){
        String name = "Name: " + nameText + "\n";
        name += "Add whipped cream? " + hasWhippedCream + "\n";
        name += "Add chocolate? " + hasChocolate + "\n";
        name  += "Quantity: " + quantity + "\n";
        name += "Total: $" + priceOfOrder;
        name += "\nThank You!";
        return name;
    }

    /**
     * This method increments the quantity when the plus button is clicked
     */
    public void increment(View view){
        if (quantity < 100) {
            quantity += 1;
        }
        display(quantity);
    }

    /**
     * This method decrements the quantity when the minus button is clicked.
     */
    public void decrement(View view){
        if(quantity > 1) {
            quantity -= 1;
        }
        display(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */

    private void displayMessage(String m){
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(m);
    }
}