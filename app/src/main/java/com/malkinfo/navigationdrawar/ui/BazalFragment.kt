package com.malkinfo.navigationdrawar.ui

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider

import com.malkinfo.navigationdrawar.R
import com.malkinfo.navigationdrawar.database.MyDatabase
import com.malkinfo.navigationdrawar.database.MyDatabase_Impl
import com.malkinfo.navigationdrawar.database.model.Result
import com.malkinfo.navigationdrawar.databinding.FragmentBazalBinding
import com.tanasi.sflix.database.repo.Repo
import com.tanasi.sflix.database.viewmodel.UserViewModel
import com.tanasi.sflix.database.viewmodel.UserViewModelFactory


class BazalFragment : BaseFragment<FragmentBazalBinding>(R.layout.fragment_bazal) {

    private lateinit var viewModel: UserViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val switch1 = binding.switch1
        val switch2 = binding.switch2
        val db = MyDatabase_Impl.getInstance(requireContext())

        val application = requireActivity().application
        val repo = Repo(db) // db, MyDatabase nesnesidir
        viewModel = ViewModelProvider(this, UserViewModelFactory(application, repo)).get(UserViewModel::class.java)
        binding.switch2.isChecked = true

        fun forWomen() {

            try {
                val v1 = binding.editTextAge.text.toString().toInt()
                val v2 = binding.editTextLength.text.toString().toInt()
                val v3 = binding.editTextWeight.text.toString().toInt()

                val sonuc = (655 + 9.6 * v3 + 1.8 * v2 - 4.7 * v1)
                binding.sonuc.text = sonuc.toString()

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
                binding.sonuc.text = sonuc.toString()
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
            var result = ""
            binding.textViewResult.text = result

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

        binding.kaydetButton.setOnClickListener {
            val sonuc = binding.sonuc.text.toString().toInt()

            // Sonucu veritabanına kaydetmek için gerekli veri nesnesini oluşturun
//            val result = com.malkinfo.navigationdrawar.database.model.Result(sonuc)
            val user = Result(0, sonuc)

            viewModel.addUser(user)
            // Veritabanı işlemini başlatın


            // Kaydetme işlemi tamamlandıktan sonra kullanıcıya geri bildirimde bulunun (isteğe bağlı)
            Toast.makeText(requireContext(), "Sonuç kaydedildi", Toast.LENGTH_SHORT).show()
        }
    }
}
