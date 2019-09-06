package com.example.myprogressproject.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import com.bumptech.glide.Glide
import com.example.myprogressproject.R
import com.example.myprogressproject.model.ElementOfCurrentProf
import kotlinx.android.synthetic.main.item_of_current_prof.view.*


/**
 * Adapter - переходник, который отвечает за связь кода с view компонентами
 */
class ItemsOfCurrentProfAdapter(private val buttonClickListener: ButtonClickListener): RecyclerView.Adapter<BaseViewHolder>() {

    private val itemsList = ArrayList<ElementOfCurrentProf>()

    //-----------------------------------------------   Метод для создания объектов ViewHolder   -----------------------------------------------
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_of_current_prof, parent, false)
        return ItemsViewHolder(view)
    }

    //-----------------------------------------------   Сообщает количество элементов в списке   -----------------------------------------------
    override fun getItemCount(): Int = itemsList.size

    //-----------------------------------------------   Отвечает за связь java-объекта и view   -----------------------------------------------
    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(position)
    }

    //-----------------------------------------------   Установить список элементов   -----------------------------------------------
    fun setItems(elementsList: Collection<ElementOfCurrentProf>) {
        itemsList.addAll(elementsList)
        notifyDataSetChanged()
    }

    //-----------------------------------------------   Очистить список элементов   -----------------------------------------------
    fun clearItems() {
        itemsList.clear()
        notifyDataSetChanged()
    }

    // -----------------------------------------------   Предоставляет прямую ссылку на каждый View-компонент   -----------------------------------------------
    // -----------------------------------------------   Используется для кэширования View-компонентов и последующего быстрого доступа к ним   -----------------------------------------------
    private inner class ItemsViewHolder(private val view: View) : BaseViewHolder(view) {
        override fun bind(position: Int) {
            val item = itemsList[position]
            view.item_name_text_view.text = view.context.getString(R.string.item_prof_name, item.name, item.progressTotal)
            view.progress_bar.progress = item.progressCurrent
            view.start_text_view.text = item.progressCurrent.toString()
            view.end_text_view.text = item.progressTotal.toString()
            // Загружаем картинку
            Glide
                .with(view.context)
                .load(item.imageUrl)
                .into(view.item_image)
            view.plus_ib.setOnClickListener {
                    if (item.progressCurrent < item.progressTotal) {
                        item.progressCurrent++
                        view.start_text_view.text = item.progressCurrent.toString()
                        buttonClickListener.updateItem(item)
                        view.plus_ib.isClickable = item.progressCurrent < item.progressTotal
                    }
                }
            view.minus_ib.setOnClickListener {
                    if (item.progressCurrent <= item.progressTotal && item.progressCurrent > 0) {
                        item.progressCurrent--
                        view.start_text_view.text = item.progressCurrent.toString()
                        buttonClickListener.updateItem(item)
                        view.minus_ib.isClickable = item.progressCurrent > 0
                    }
                 }
        }
    }

    interface ButtonClickListener {
        fun updateItem(item: ElementOfCurrentProf)
    }
}