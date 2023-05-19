package gustavo.projects.petlookup.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import gustavo.projects.petlookup.R
import gustavo.projects.petlookup.network.models.Animals

class AnimalsAdapter(
    private val listOfAnimals: MutableList<Animals>
): RecyclerView.Adapter<AnimalsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_row, parent, false)
        return AnimalsViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimalsViewHolder, position: Int) {
        return holder.bindView(listOfAnimals[position])
    }

    override fun getItemCount(): Int {
        return listOfAnimals.size
    }

}

class AnimalsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val animalId: TextView = itemView.findViewById(R.id.animalId)

    fun bindView(animals: Animals) {
        animalId.text = animals.id.toString()
    }
}