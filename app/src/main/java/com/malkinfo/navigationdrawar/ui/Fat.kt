package com.malkinfo.navigationdrawar.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.malkinfo.navigationdrawar.R
import com.malkinfo.navigationdrawar.databinding.FragmentFatBinding
import java.lang.Math.log10


class Fat : BaseFragment<FragmentFatBinding>(R.layout.fragment_fat) {




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val switch1 = binding.switch1
        val switch2 = binding.switch2

        binding.switch2.isChecked = true


        fun forWomen() {

            try {
                val v1 = binding.editTextBel.text.toString().toInt()
                val v2 = binding.editTextBoy.text.toString().toInt()
                val v3 = binding.editTextBoyun.text.toString().toInt()
                val v4 = binding.editTextKalA.text.toString().toInt()


                val sonuc = (495 / (1.29579 - 0.35004 * log10((v1 + v4 - v3).toDouble()) + 0.22100 * log10(v2.toDouble())))-450
                binding.editTextNumber5.text = sonuc.toString()

            } catch (e: Exception) {
                print(e.message)
            }
        }

        fun forMan(){
            try {
                val v1 = binding.editTextBel.text.toString().toInt()
                val v2 = binding.editTextBoy.text.toString().toInt()
                val v3 = binding.editTextBoyun.text.toString().toInt()
                val v4 = binding.editTextKalA.text.toString().toInt()


                val sonuc = (495/1.0324 - 0.19077 *Math.log10((v1-v3).toDouble())+0.15456*Math.log10(v2.toDouble()))-450
                binding.editTextNumber5.text = sonuc.toString()
            } catch (e: Exception) {
                print(e.message)
            }
        }

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