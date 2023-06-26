package com.malkinfo.navigationdrawar.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import com.malkinfo.navigationdrawar.R
import com.malkinfo.navigationdrawar.adapter.AppAdapter
import com.malkinfo.navigationdrawar.model.Kcal
import com.malkinfo.navigationdrawar.service.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class HomeFragment : Fragment() {

    private val BASE_URL = "https://raw.githubusercontent.com/"
    private val appList = ArrayList<Kcal>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AppAdapter
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = AppAdapter(requireContext(), appList)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        loadData()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home2, container, false)
    }

    private fun loadData() {
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        val apiService = retrofit.create(ApiService::class.java)

        compositeDisposable.add(
            apiService.getKcalData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    handleResponse(response)
                }, { error ->
                    handleError(error)
                })
        )
    }

    private fun handleResponse(response: List<Kcal>) {
        appList.clear()
        appList.addAll(response)
        adapter.notifyDataSetChanged()
        println("response: $response")

    }

    private fun handleError(error: Throwable) {
        println("İstek hatası: ${error.message}")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        compositeDisposable.clear()
    }
}