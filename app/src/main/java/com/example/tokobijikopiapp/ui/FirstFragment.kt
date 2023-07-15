package com.example.tokobijikopiapp.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tokobijikopiapp.R
import com.example.tokobijikopiapp.application.CoffeApp
import com.example.tokobijikopiapp.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private lateinit var applicationContext: Context
    private val coffeViewModel: CoffeViewModel by viewModels {
        CoffeViewModelFactory((applicationContext as CoffeApp).repository)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        applicationContext = requireContext().applicationContext
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CoffeListAdapter {coffe ->
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(coffe)
            findNavController().navigate(action)
        }

        binding.dataRecyclerView2.adapter = adapter
        binding.dataRecyclerView2.layoutManager = LinearLayoutManager(context)
        coffeViewModel.allCoffe.observe(viewLifecycleOwner){ coffe ->
            coffe.let {
                if(coffe.isEmpty()){
                    binding.emptyTextView.visibility = View.VISIBLE
                    binding.illustrationImageView.visibility = View.VISIBLE
                } else{
                    binding.emptyTextView.visibility = View.GONE
                    binding.illustrationImageView.visibility = View.GONE
                }
                adapter.submitList(coffe)
            }
        }

        binding.addFAB.setOnClickListener {
           val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(null)
            findNavController().navigate(action)
        }
        binding.contactFAB.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_ContactFragment)
        }
        binding.catalogFAB.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_CatalogFragment)
        }
        binding.aboutFAB.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_AboutFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}