package com.example.practicaparcelable

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.practicaparcelable.databinding.Fragment1Binding
import com.example.practicaparcelable.models.Professor

class Fragment1 : Fragment() {

    private var _binding: Fragment1Binding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = Fragment1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.registerButton.setOnClickListener{
            val name = _binding?.nameInput?.text
            val lastName = _binding?.lastNameInput?.text
            if (name.isNullOrEmpty() || lastName.isNullOrEmpty()) {
                Toast.makeText(requireContext(), "Por favor, llene todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val professor = Professor(name.toString(), lastName.toString())
            val action = Fragment1Directions.actionFragment1ToFragment2(professor)
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

