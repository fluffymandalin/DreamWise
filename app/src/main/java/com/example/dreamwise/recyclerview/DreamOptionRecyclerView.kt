package com.example.dreamwise
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dreamwise.recyclerview.DreamOption

class DreamOptionRecyclerView : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DreamOptionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dream_option_recycler_view)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val dreamOptions = listOf(
            DreamOption(1, "Nightmare", "Experience the thrill of a nightmare."),
            DreamOption(2, "Sweet Dream", "Enjoy a sweet, pleasant dream.")
        )

        adapter = DreamOptionAdapter(this, dreamOptions) // Correct the variable name here
        recyclerView.adapter = adapter
    }

    operator fun get(position: Int) {

    }
}
