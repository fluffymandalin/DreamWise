package com.example.dreamwise

import android.app.DatePickerDialog
import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dreamwise.recyclerview.DreamOption
import java.util.Calendar

class DreamOptionAdapter(private val context: Context, private val dreamOptions: List<DreamOption>) :
    RecyclerView.Adapter<DreamOptionAdapter.DreamOptionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DreamOptionViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_dream_option, parent, false)
        return DreamOptionViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DreamOptionViewHolder, position: Int) {
        val currentItem = dreamOptions[position]
        holder.textViewName.text = currentItem.name
        holder.itemView.setOnClickListener {
            showDateDialog()
        }
    }

    override fun getItemCount() = dreamOptions.size

    class DreamOptionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewName: TextView = itemView.findViewById(R.id.textViewDreamName)
    }

    private fun showDateDialog() {
        val calendar = Calendar.getInstance()
        DatePickerDialog(context, { _, year, month, dayOfMonth ->
            showDreamDescriptionDialog(year, month, dayOfMonth)
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show()
    }

    private fun showDreamDescriptionDialog(year: Int, month: Int, dayOfMonth: Int) {
        val editText = EditText(context)
        editText.hint = "Describe your dream"

        AlertDialog.Builder(context)
            .setTitle("Enter Dream Description")
            .setView(editText)
            .setPositiveButton("Save") { dialog, _ ->
                val description = editText.text.toString()
                saveDream(description, year, month, dayOfMonth)
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.cancel()
            }
            .create()
            .show()
    }

    // Placeholder function to handle dream saving logic
    private fun saveDream(description: String, year: Int, month: Int, dayOfMonth: Int) {
        // Implementation depends on how and where you want to save this data
        // For example, inserting it into a Room database or sending it to a server
    }
}
