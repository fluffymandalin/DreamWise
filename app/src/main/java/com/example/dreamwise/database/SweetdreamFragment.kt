package com.example.dreamwise.database

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.dreamwise.R
import java.util.Date

class SweetdreamFragment : Fragment() {
    private lateinit var viewModel: DreamViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DreamViewModel::class.java)

        val saveButton = view.findViewById<Button>(R.id.saveDream)
        val descriptionEditText = view.findViewById<EditText>(R.id.dreamDescription)

        saveButton.setOnClickListener {
            val description = descriptionEditText.text.toString()
            val currentDate = Date()  // This should ideally be fetched from a DatePicker
            val dreamEntry = DreamEntry(type = "Sweet Dream", description = description, date = currentDate)
            viewModel.insertDreamEntry(dreamEntry)
        }
    }
}
