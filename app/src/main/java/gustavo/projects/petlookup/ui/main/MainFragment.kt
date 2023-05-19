package gustavo.projects.petlookup.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import gustavo.projects.petlookup.R
import gustavo.projects.petlookup.ui.main.adapter.AnimalsAdapter

@AndroidEntryPoint
class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.mRecyclerView)

        view.findViewById<Button>(R.id.getAnimalsBtn).setOnClickListener {
            viewModel.onGetAnimalsBtnClick()
        }

        viewModel.listOfAnimals.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                recyclerView.apply {
                    layoutManager = LinearLayoutManager(requireContext())
                    adapter = AnimalsAdapter(it.toMutableList())
                }
            }
        }
    }
}