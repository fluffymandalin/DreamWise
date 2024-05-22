package com.example.dreamwise
import android.app.DatePickerDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dreamwise.recyclerview.DreamOption
import java.util.Calendar

class DreamOptionAdapter(private val context: Context, private val dreamOptions: List<DreamOption>) :
    RecyclerView.Adapter<DreamOptionAdapter.DreamOptionViewHolder>() {

    // Creates new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DreamOptionViewHolder {
        // Inflate the custom layout
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_dream_option, parent, false)
        return DreamOptionViewHolder(itemView)
    }

    // Replaces the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: DreamOptionViewHolder, position: Int) {
        // Get element from your dataset at this position
        val currentItem = dreamOptions[position]
        // Replace the contents of the view with that element
        holder.textViewName.text = currentItem.name  // Ensure textViewName is correctly linked in item_dream_option.xml
        holder.itemView.setOnClickListener {
            showDateDialog()
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dreamOptions.size

    // Provide a reference to the views for each data item
    class DreamOptionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewName: TextView = itemView.findViewById(R.id.textViewDreamName)  // Ensure the ID is correct
    }

    // Function to show a DatePickerDialog
    private fun showDateDialog() {
        val calendar = Calendar.getInstance()
        DatePickerDialog(context, DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
            // Handle the picked date here (e.g., update a TextView or log it)
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show()
    }
}
