package com.example.imagesglide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        //get parameters
        val name = intent.getStringExtra("name")
        Toast.makeText(this, "Name: $name", Toast.LENGTH_SHORT).show()
    }
}