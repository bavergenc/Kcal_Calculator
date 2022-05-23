package com.malkinfo.navigationdrawar.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.malkinfo.navigationdrawar.R
import com.malkinfo.navigationdrawar.databinding.FragmentIdealkiloBinding


class IdealKiloFragment : BaseFragment<FragmentIdealkiloBinding>(R.layout.fragment_idealkilo) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fun forWomen() {

            try {

                val v2 = binding.editTextLengthh.text.toString().toInt()
                val v3 = binding.editTextWeightt.text.toString().toInt()

                val sonuc = (v3-100)*0.85
                binding.editTextNumber55.text = sonuc.toString()

            } catch (e: Exception) {
                print(e.message)
            }
        }

        fun forMan(){
            try {
                val v2 = binding.editTextLengthh.text.toString().toInt()
                val v3 = binding.editTextWeightt.text.toString().toInt()

                val sonuc = (v3-100)*0.90
                binding.editTextNumber55.text = sonuc.toString()
            } catch (e: Exception) {
                print(e.message)
            }
        }

        binding.hesaplaButton.setOnClickListener {
            if (binding.kadN.isChecked) {
                forWomen()
            } else if (binding.erkek.isChecked) {
                forMan()

            }
        }

        binding.kadN.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                binding.kadN.isChecked = true
                binding.erkek.isChecked = false
            } else {
                Toast.makeText(requireContext(), "seçiniz", Toast.LENGTH_LONG).show()
            }
        }

        binding.erkek.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                binding.kadN.isChecked = false
                binding.erkek.isChecked = true
            } else {
                Toast.makeText(requireContext(), "seçiniz", Toast.LENGTH_LONG).show()
            }
        }



    }


}