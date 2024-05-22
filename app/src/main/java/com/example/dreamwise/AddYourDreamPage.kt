package com.example.dreamwise



import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class AddYourDreamPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_your_dream) // Make sure to replace "layout_with_button" with your actual layout file name.

        val addYourDreamButton: Button = findViewById(R.id.addyourdreambutton)
        addYourDreamButton.setOnClickListener {
            // Directly start DreamOptionRecyclerView
            val intent = Intent(this, DreamOptionRecyclerView::class.java)
            startActivity(intent)
        }
    }
}
