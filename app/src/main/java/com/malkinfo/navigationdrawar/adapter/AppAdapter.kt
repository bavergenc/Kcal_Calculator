package com.malkinfo.navigationdrawar.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.malkinfo.navigationdrawar.R
import com.malkinfo.navigationdrawar.model.CustomApp

class AppAdapter(
	val context: Context,
	val appList: List<CustomApp>
) : BaseAdapter() {


	override fun getCount(): Int = appList.size

	override fun getItem(p0: Int): CustomApp = appList[p0]

	override fun getItemId(p0: Int): Long = p0.toLong()

	override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
		var convertView: View? = view
		if (view == null) {
			convertView = LayoutInflater.from(context).inflate(R.layout.fragment_details, parent, false)
		}

		val app = appList.get(position)
		val image: ImageView? = convertView?.findViewById(R.id.imageView2)
		val name: TextView? = convertView?.findViewById(R.id.nametext)
		val surname: TextView? = convertView?.findViewById(R.id.surnametext)

		name?.text = app.name
		surname?.text = app.surname
		image?.setImageDrawable(context.getDrawable(app.image))

		return convertView!!
	}
}


