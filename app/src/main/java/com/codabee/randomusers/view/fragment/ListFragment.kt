package com.codabee.randomusers.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codabee.randomusers.R
import com.codabee.randomusers.model.ApiResults
import com.codabee.randomusers.view.adapters.UserAdapter
import com.codabee.randomusers.view_model.ApiviewModel


class ListFragment : Fragment() {
    val apiViewModel = ApiviewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler)
        val adapter : UserAdapter = UserAdapter(apiViewModel.state.value?: ApiResults(results = listOf()))
        recyclerView.adapter = adapter
        apiViewModel.launchApi()
        apiViewModel.state.observe(viewLifecycleOwner){
            adapter.results = it
            adapter.notifyDataSetChanged()
        }
    }
}