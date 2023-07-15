package com.example.tokobijikopiapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tokobijikopiapp.R
import com.example.tokobijikopiapp.model.Coffe


class CoffeListAdapter(
    private val onItemClickListener: (Coffe) -> Unit
): ListAdapter<Coffe, CoffeListAdapter.CoffeViewHolder>(WORDS_COMPARATOR)  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeViewHolder {
        return CoffeViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: CoffeViewHolder, position: Int) {
        val coffe = getItem(position)
        holder.bind(coffe)
        holder.itemView.setOnClickListener {
            onItemClickListener(coffe)
        }
    }

    class CoffeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val addressTextView: TextView = itemView.findViewById(R.id.addressTextView)

        fun bind(coffe: Coffe?) {
            nameTextView.text = coffe?.name
            addressTextView.text = coffe?.address
        }

        companion object {
            fun create(parent: ViewGroup): CoffeListAdapter.CoffeViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_coffe, parent, false)
                return CoffeViewHolder(view)
            }
        }
    }

    companion object{
        private val WORDS_COMPARATOR = object : DiffUtil.ItemCallback<Coffe>(){
            override fun areItemsTheSame(oldItem: Coffe, newItem: Coffe): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Coffe, newItem: Coffe): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}