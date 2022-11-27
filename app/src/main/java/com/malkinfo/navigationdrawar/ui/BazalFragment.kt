package com.malkinfo.navigationdrawar.ui

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.malkinfo.navigationdrawar.R
import com.malkinfo.navigationdrawar.databinding.FragmentBazalBinding


class BazalFragment : BaseFragment<FragmentBazalBinding>(R.layout.fragment_bazal) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val switch1 = binding.switch1
        val switch2 = binding.switch2

        binding.switch2.isChecked = true

        val women = binding.switch1.setOnClickListener {}
        val man = binding.switch2.setOnClickListener {}
        val age = binding.editTextAge.setOnClickListener {}
        val length = binding.editTextLength.setOnClickListener {}
        val weight = binding.editTextWeight.setOnClickListener {}


        fun forWomen() {

            try {
                val v1 = binding.editTextAge.text.toString().toInt()
                val v2 = binding.editTextLength.text.toString().toInt()
                val v3 = binding.editTextWeight.text.toString().toInt()

                val sonuc = (655 + 9.6 * v3 + 1.8 * v2 - 4.7 * v1)
                binding.editTextNumber5.text = sonuc.toString()

            } catch (e: Exception) {
                print(e.message)
            }
        }

        fun forMan(){
            try {
                val v1 = binding.editTextAge.text.toString().toInt()
                val v2 = binding.editTextLength.text.toString().toInt()
                val v3 = binding.editTextWeight.text.toString().toInt()

                val sonuc = (66 + 13.7 * v3 + 5 * v2 - 6.8 * v1)
                binding.editTextNumber5.text = sonuc.toString()
            } catch (e: Exception) {
                print(e.message)
            }
        }

        binding.hesaplaButton.setBackgroundColor(Color.WHITE)
        binding.hesaplaButton.setOnClickListener {
            if (switch1.isChecked) {
                forWomen()
            } else if (switch2.isChecked) {
                forMan()

            }
        }

        switch1.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                switch1.isChecked = true
                switch2.isChecked = false
            } else {
                Toast.makeText(requireContext(), "seçiniz", Toast.LENGTH_LONG).show()
            }
        }

        switch2.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                switch1.isChecked = false
                switch2.isChecked = true
            } else {
                Toast.makeText(requireContext(), "seçiniz", Toast.LENGTH_LONG).show()
            }
        }
    }
}
