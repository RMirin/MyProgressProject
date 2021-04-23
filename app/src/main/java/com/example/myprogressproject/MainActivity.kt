package com.example.myprogressproject

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myprogressproject.adapter.ItemsOfCurrentProfAdapter
import com.example.myprogressproject.adapter.ItemsOfCurrentProfAdapter.ButtonClickListener
import com.example.myprogressproject.database.ElementsRepository
import com.example.myprogressproject.model.ElementOfCurrentProf
import com.example.myprogressproject.room_database.ElementDataSource
import com.example.myprogressproject.room_database.ElementsDatabase
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(),
    ButtonClickListener {
    override fun updateItem(item: ElementOfCurrentProf) {
        val disposable = Observable.create(ObservableOnSubscribe<Any> { e ->
            elementsRepository?.updateElement(item)
            e.onComplete()
        })
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                //success
            },
                {
                    throwable -> Toast.makeText(this@MainActivity, "${throwable.message}", Toast.LENGTH_SHORT).show()
                },
                {})
        compositeDisposable!!.add(disposable)
    }

    val adapter: ItemsOfCurrentProfAdapter = ItemsOfCurrentProfAdapter(this)
    private var elementsList:MutableList<ElementOfCurrentProf> = ArrayList()

    //Database
    private var compositeDisposable:CompositeDisposable ?= null
    private var elementsRepository: ElementsRepository ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //layout manager отвечает за форму отображения элементов. Здесь - линейный список
        current_prof_items_res_view.layoutManager = LinearLayoutManager(this)
        current_prof_items_res_view.adapter = adapter

        //Init
        compositeDisposable = CompositeDisposable()

        //Database
        val elementsDatabase = ElementsDatabase.getInstance(this)
        elementsRepository = ElementsRepository.getInstance(ElementDataSource.getInstance(elementsDatabase.elementDAO()))

        //Load data from db
        loadItems()
    }

    private fun loadItems() {
        val disposable = elementsRepository!!.allElements
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({elements -> onGetElementsSuccess(elements) })
            {
                throwable -> Toast.makeText(this@MainActivity,"${throwable.message}", Toast.LENGTH_SHORT).show()
            }
        compositeDisposable!!.clear()
        compositeDisposable!!.add(disposable)
    }

    private fun onGetElementsSuccess(elements: MutableList<ElementOfCurrentProf>?) {
        elementsList.clear()
        if (elements != null) {
            elementsList.addAll(elements)
            adapter.setItems(elementsList)
            adapter.notifyDataSetChanged()
        }
    }
}
