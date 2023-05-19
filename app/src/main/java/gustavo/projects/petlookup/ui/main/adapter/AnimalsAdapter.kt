package gustavo.projects.petlookup.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import gustavo.projects.petlookup.R
import gustavo.projects.petlookup.models.Animals

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
    private val animalName: TextView = itemView.findViewById(R.id.animalName)
    private val animalBreed: TextView = itemView.findViewById(R.id.animalBreed)
    private val animalAge: TextView = itemView.findViewById(R.id.animalAge)

    fun bindView(animals: Animals) {
        animalName.text = animals.name
        animalBreed.text = animals.breeds?.primary
        animalAge.text = animals.age
    }
}