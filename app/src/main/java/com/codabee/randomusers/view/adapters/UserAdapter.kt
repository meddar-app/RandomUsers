package com.codabee.randomusers.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.codabee.randomusers.R
import com.codabee.randomusers.model.ApiResults

class UserAdapter(var results: ApiResults) : RecyclerView.Adapter<UserViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = results.results[position]
        holder.nameText.text = "${user.name.first} ${user.name.last}"
        holder.countryText.text = user.location.country
        holder.image.load(user.picture.large)
    }

    override fun getItemCount(): Int {
        return results.results.size
    }
}
class UserViewHolder(view: View) : RecyclerView.ViewHolder(view){
    val nameText : TextView = view.findViewById(R.id.name_item)
    val countryText : TextView = view.findViewById(R.id.country_item)
    val image : ImageView = view.findViewById(R.id.image_item)
}