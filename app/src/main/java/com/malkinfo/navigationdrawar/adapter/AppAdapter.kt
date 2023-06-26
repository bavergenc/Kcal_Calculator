package com.malkinfo.navigationdrawar.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.malkinfo.navigationdrawar.R
import com.malkinfo.navigationdrawar.databinding.FragmentDetailsBinding
import com.malkinfo.navigationdrawar.model.Kcal

class AppAdapter(
	val context: Context,
	val appList: ArrayList<Kcal>
) : RecyclerView.Adapter<AppAdapter.ReciyclerViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReciyclerViewHolder {
		val mBinding = FragmentDetailsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
		return ReciyclerViewHolder(mBinding)
	}

	override fun onBindViewHolder(holder: ReciyclerViewHolder, position: Int) {

		holder.list_item_binding.name.text = appList.get(position).name
		holder.list_item_binding.kcal.text = appList.get(position).calories
		holder.list_item_binding.fat.text = appList.get(position).fatContent
		holder.list_item_binding.protein.text = appList.get(position).proteinContent

		Glide.with(context).load(appList[position].image).into(holder.list_item_binding.imageView2)

	}

	override fun getItemCount(): Int = appList.size
	class ReciyclerViewHolder(var list_item_binding: FragmentDetailsBinding):RecyclerView.ViewHolder(list_item_binding.root)


}