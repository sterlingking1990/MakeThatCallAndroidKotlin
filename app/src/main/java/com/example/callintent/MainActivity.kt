package com.example.callintent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //access the phone number entered from the  edit text view
        var phone_number=findViewById<EditText>(R.id.etPhoneNumber).text

        //set on click listener and declare and intent to make call
        btnCall.setOnClickListener {
                //if phone number is empty send a toast
                if(isNumberEmpty(phone_number)){
                    Toast.makeText(this,"Phone number should be entered and in proper format",Toast.LENGTH_SHORT).show()
                }
                //if the user entered phone number
                else {
                    //trigger an implicit intent to make call using the action dial
                    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone_number"))

                    //check if there exist a call app that can receive the intent to avoid app crashing - ref: https://developer.android.com/guide/components/intents-common
                    if (intent.resolveActivity(packageManager) != null) {
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this,"Please install a call app to initiate this process",Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }

    private fun isNumberEmpty(num:Editable):Boolean{
     return num.isEmpty()
    }
}