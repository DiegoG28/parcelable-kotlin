package com.example.practicaparcelable

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.practicaparcelable.databinding.Fragment2Binding


class Fragment2 : Fragment() {

    private var _binding: Fragment2Binding? = null

    private val binding get() = _binding!!

    private var name: String ? = ""
    private var lastName: String ? = ""
    private val args: Fragment2Args by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        name = args.professor.name
        lastName = args.professor.lastName
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = Fragment2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val welcomeTextView = _binding?.welcomeText
        val welcomeText = resources.getString(R.string.welcome_text, name, lastName)
        welcomeTextView?.text = welcomeText
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}