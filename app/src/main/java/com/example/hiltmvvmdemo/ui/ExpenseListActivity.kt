package com.example.hiltmvvmdemo.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hiltmvvmdemo.adapter.AlertsAdapter
import com.example.hiltmvvmdemo.database.AlertViewModel
import com.example.hiltmvvmdemo.databinding.ActivityExpenseListBinding
import com.example.hiltmvvmdemo.models.Alert
import com.example.hiltmvvmdemo.models.AlertsResponseClass
import com.example.hiltmvvmdemo.models.Product
import com.example.hiltmvvmdemo.util.ApiState
import com.example.hiltmvvmdemo.util.Utilities.showToast
import com.example.hiltmvvmdemo.viewmodel.AlertsListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ExpenseListActivity : AppCompatActivity(), AlertsAdapter.OnItemClickListener {
    private lateinit var binding: ActivityExpenseListBinding
    private lateinit var postAdapter: AlertsAdapter
    private val mainViewModel: AlertsListViewModel by viewModels()
//    val mainViewModel by viewModels<AlertsListViewModel>()

    private lateinit var context: Context
//    private val alertViewModel: AlertViewModel by viewModels()
//    val alertViewModel by viewModels<AlertViewModel>()

//    val viewModel: AlertViewModel = hiltViewModel()
//    val viewModel = hiltViewModel<AlertViewModel>()

    private var alertsList: List<Product> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExpenseListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        intializeViews()
        intializeData()
    }

    private fun intializeViews() {
        context = this
        postAdapter = AlertsAdapter(ArrayList(), this, context)
        binding.rvExpenseList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@ExpenseListActivity)
            adapter = postAdapter
        }
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            override fun onMove(
                v: RecyclerView,
                h: RecyclerView.ViewHolder,
                t: RecyclerView.ViewHolder
            ) = false

            override fun onSwiped(h: RecyclerView.ViewHolder, dir: Int) =
                deleteItemFromDb(h.adapterPosition)
        }).attachToRecyclerView(binding.rvExpenseList)
    }

    private fun deleteItemFromDb(adapterPosition: Int) {
//        alertViewModel.delete(alertsList.get(adapterPosition))
        lifecycleScope.launch {
            delay(1000L)

        }

    }

    private fun callApi() {
        mainViewModel.getExpenseListItem()
        lifecycleScope.launchWhenStarted {
            mainViewModel.postStateFlow.collect { it ->
                when (it) {
                    is ApiState.Loading -> {
                    }
                    is ApiState.Failure -> {
                        Log.e("TAG", "callApi: 87 ${it.msg}" )
                        showToast(context, it.msg.toString())
                    }
                    is ApiState.Success<*> -> {
                        binding.rvExpenseList.isVisible = true
                        var result = it.result as ArrayList<Product>
                        alertsList = result
                        postAdapter.setData(result)
                        postAdapter.notifyDataSetChanged()
//                        for (i in 0 until result.alerts.size) {
//                            //saving to db
//                           alertViewModel.insert(result.alerts.get(i))
//                        }
                    }
                    is ApiState.Empty -> {

                    }
                }
            }
        }
    }

    private fun intializeData() {
        /*alertViewModel.getList.observe(this, Observer {response->
            alertsList = (response as ArrayList<Alert>)
            if (alertsList.size>0){
                //load from db
                postAdapter.setData(response as ArrayList<Alert>)
                postAdapter.notifyDataSetChanged()
            }
            else{
                // get data from server
                callApi()
            }
        })*/
        callApi()
    }

    override fun onItemClicked(data: Product) {

    }
}


