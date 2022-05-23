package com.malkinfo.navigationdrawar.ui

import android.annotation.SuppressLint
import android.graphics.Insets.add
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.core.view.OneShotPreDrawListener.add
import androidx.databinding.DataBindingUtil.setContentView
import com.malkinfo.navigationdrawar.R
import com.malkinfo.navigationdrawar.adapter.AppAdapter
import com.malkinfo.navigationdrawar.extension.navigateSafe
import com.malkinfo.navigationdrawar.model.CustomApp


class HomeFragment : Fragment() {






    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)





        val list = ArrayList<CustomApp>()

        val deneme = CustomApp("Dukan Diyeti","İlk olarak 2000 yılında ortaya çıkan Dukan Diyeti, Fransız Hekim Pierre Dukan tarafından hazırlanmıştır. Dukan’a göre kilo vermenin anahtarının protein olduğu ve dışarıdan yağ tüketmek ile vücuttaki yağların yakılamayacağı belirtilmektedir. Dukan Diyeti Listesi teorilerine göre; vücut tükettiği proteini yakmak için daha fazla kalori harcarken, karbonhidrat ve yağı yakmak için çok az kalori harcar. Bu yüzden Dukan Diyeti protein ağırlıklı bir beslenme programıdır ve karbonhidrat kaynağı olarak başlangıçta sadece yulaf kepeğinin tüketilmesine izin verir."
            ,R.drawable.dukan)
        list.add(deneme)
        val deneme1 = CustomApp("Ketojenik Diyet","Ketojenik diyet, karbonhidrat ve protein kaynaklarının oldukça kısıtlı olduğu ve diyet içeriğinin çok büyük bir kısmının yağlardan oluştuğu diyetler olarak tanımlanabilir. Normal sağlıklı beslenme planlarında kaçınılan pek çok besin türü, bu diyetlerde temel enerji kaynağı olarak tercih edilir. Yüksek yağ içeriği, düşük karbonhidrat ve protein içeriği nedeniyle bu diyetlerin uygulanması zor olup uzun süre devam ettirilmesi hem zorlayıcı hem de sağlık açısından riskli olabilmektedir."
            ,R.drawable.ketojenik)
        list.add(deneme1)
        val deneme2 = CustomApp("İsveç Diyeti","İsveç diyeti genel olarak tanımlamak gerekirse 6 günden az yapılmayan ve 13 gün ile sınırlı olan, diğer protein diyetlerinin aksine tüketimin sınırlı olduğu bir diyet. Günlere göre değişmekle birlikte günlük 1000 kalorinin altında yiyeceğin tüketildiği İsveç diyeti, halk arasında bu isimle anılsa da dünya çapında \"Rigshospitalet Diyeti\" adıyla biliniyor.",
            R.drawable.isvecdiyeti)
        list.add(deneme2)
        val deneme3 = CustomApp("Karatay Diyeti","Aralarda ağzınıza bir lokma bile alınmaması gerektiği belirtilir. Karatay; 4-5 saat açlık durumda depo edilmiş yağların yakılacağını savunmaktadır.Ekmeğin şeker olduğunu savunan Karatay ekmeği de reddetmektedir. Kolesterolün bir antioksidan olduğu kalp damar hastalıklarına sebep olmadığını savunur. Yağların kolesterolü yükseltmediğini sadece şekerin (karbonhidratların) yükselttiğini söyler. İnsan Vücudu bir makinedir ve yağ olmadan asla çalışamaz diyen Canan Karatay zeytinyağı, tereyağ, yumurta, kırmızı et, kelle paça, zeytin gibi besinleri sınırsız tüketebileceğimizi söyler."
            ,R.drawable.karataydiyeti)
        list.add(deneme3)
        val deneme4 = CustomApp("Montignac Diyeti"," Montignac Diyeti,uygulaması kolay ve basit bir diyettir. Bu diyeti, diğer diyetlerden ayıran en önemli özellik ise proteinlerle karbonhidratların farklı öğünlerde tüketilmesi olarak geçer. Bu diyette proteinler ve karbonhidratlar aynı öğünde tüketilmez."
            ,R.drawable.montignac)
        list.add(deneme4)
        val deneme5 = CustomApp("Vejeteryan Diyeti","Vejetaryen beslenmede diyetin temelinde kırmızı et, kümes hayvanları ve balık gibi hayvan etleri yerine tahıllar, kuru baklagiller, soya, sebzeler, meyveler ve yağlı tohumlar gibi bitkisel kaynaklı besinlerin tüketilmesi gelmektedir."
            ,R.drawable.vejeteryanbeslenme)
        list.add(deneme5)


        val adapter = AppAdapter(
            requireContext(),
            list
        )

        val list_view = requireView().findViewById<ListView>(R.id.list_view)
        list_view.adapter = adapter

        list_view.setOnItemClickListener { adapterView, view, i, l ->
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home2, container, false)

    }



}