package edu.ggc.gozinta;

import java.text.DecimalFormat;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class BillCalculator extends MainActivity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.billcalculator);
		final EditText bill = (EditText)findViewById(R.id.txtBill);
		final EditText numPeople = (EditText)findViewById(R.id.txtPeople);
		final Spinner group = (Spinner)findViewById(R.id.txtServiceQuality);
		final Button tipCalculator = (Button) findViewById(R.id.btnTip);
		tipCalculator.setOnClickListener(new OnClickListener() {
		final TextView result = ((TextView)findViewById(R.id.txtResult));
			@Override
			public void onClick(View v) 
			{
				//Get the number of people
				numberOfPeople = Integer.parseInt(numPeople.getText().toString());

				//Get the restaurant's bill
				billAmount = Double.parseDouble(bill.getText().toString());
				
				//Calculate the tip
				tipAmount = billAmount * 0.18;

				//total
				totalCost = billAmount + tipAmount;
				costPerPerson = totalCost / numberOfPeople;
				DecimalFormat currency = new DecimalFormat("$###,###.##");
				groupChoice = group.getSelectedItem().toString();
				result.setText("Total Cost For Each Person " + "is " + currency.format(costPerPerson) + " And the Service was "+ groupChoice );



			}
		});
	}

}
