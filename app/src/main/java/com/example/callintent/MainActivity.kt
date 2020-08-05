package com.example.callintent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var phone_number=findViewById<EditText>(R.id.etPhoneNumber).text

        btnCall.setOnClickListener {
            try {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone_number"))
                startActivity(intent)
            } catch (e: Exception) {
                Log.i("error", e.printStackTrace().toString())
            }
        }
    }
}