package com.example.hiltmvvmdemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hiltmvvmdemo.databinding.EachRowBinding
import com.example.hiltmvvmdemo.models.Product

class AlertsAdapter(
    private var results: List<Product>,
    private val itemClickListener: OnItemClickListener,
    var context: Context
) : RecyclerView.Adapter<AlertsAdapter.MyViewHolder>() {
    private lateinit var eachRowBinding: EachRowBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        eachRowBinding = EachRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(eachRowBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = results[position]
        holder.eachRowBinding.expenseResponse = data
        holder.eachRowBinding.executePendingBindings()
        holder.bind(data, itemClickListener)
    }

    override fun getItemCount(): Int = results.size

    class MyViewHolder(eachRowBinding: EachRowBinding) :
        RecyclerView.ViewHolder(eachRowBinding.root) {
        var eachRowBinding: EachRowBinding
        init {
            this.eachRowBinding = eachRowBinding
        }
        fun bind(
            data: Product,
            itemClickListener: OnItemClickListener
        ) {
            eachRowBinding.cvExpenseList.setOnClickListener {
                itemClickListener.onItemClicked(data)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClicked(data: Product)
    }

    fun setData(expensesResponse: List<Product>) {
        this.results = expensesResponse
    }
}
