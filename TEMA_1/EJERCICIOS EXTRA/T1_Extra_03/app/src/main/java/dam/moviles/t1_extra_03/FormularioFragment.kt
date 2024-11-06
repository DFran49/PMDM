package dam.moviles.t1_extra_03

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import dam.moviles.t1_extra_03.databinding.FragmentFormularioBinding
import kotlin.random.Random

private var _binding: FragmentFormularioBinding? = null
public val binding: FragmentFormularioBinding
    get() = checkNotNull(_binding)
private lateinit var viewModel: FormularioFragmentViewModel


class FormularioFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        inicializarViewModel()
        inicializarBinding(inflater, container)
        viewModel.restaurarApp()
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun inicializarBinding(inflater: LayoutInflater, container: ViewGroup?) {
        _binding = FragmentFormularioBinding.inflate(inflater,container,false)
    }

    private fun inicializarViewModel() {
        viewModel = ViewModelProvider(this).get(FormularioFragmentViewModel::class.java)
    }
}