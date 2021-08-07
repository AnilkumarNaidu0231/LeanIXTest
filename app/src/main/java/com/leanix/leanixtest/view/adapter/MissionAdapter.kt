package com.leanix.leanixtest.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.leanix.leanixtest.R
import com.leanix.leanixtest.databinding.ItemMissionBinding
import com.leanix.leanixtest.model.Launche
import com.leanix.leanixtest.utils.Utils
import kotlinx.android.synthetic.main.item_mission.view.*
import java.text.SimpleDateFormat

class MissionAdapter(private var items: List<Launche>?) :
    RecyclerView.Adapter<MissionAdapter.ViewHolder>() {

    private lateinit var  itemMissionBinding: ItemMissionBinding
    override fun getItemCount(): Int {
        return items.let { it?.size!! }
    }

   lateinit var onClick:OnClick;



    fun setOnitemClickListener(onClick: OnClick){
        this.onClick=onClick
    }

    interface OnClick{
        fun getItemPosition(launche: Launche)
    }
    class ViewHolder(layout: View) : RecyclerView.ViewHolder(layout) {
        var txtName: TextView? = null
        var txtComment: TextView? = null
        var imgMissionpatch: ImageView? = null

        init {
            this.txtName = layout.txtName
            this.txtComment = layout.txtComment
            this.imgMissionpatch=layout.imgMissionpatch
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items?.get(position)
         holder.txtName?.text = item?.mission_name
         holder.txtComment?.text = item?.launch_date_local?.let { Utils.missionLaunchDate(it) }

        holder.itemView.setOnClickListener {
            item?.let { it1 -> onClick.getItemPosition(it1) }

        }


        holder.imgMissionpatch?.let {
            Glide.with(holder.itemView.context)
                .load(item?.links?.mission_patch)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(it)
        };
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        itemMissionBinding= ItemMissionBinding.inflate(LayoutInflater
            .from(parent.context), parent, false);
        return ViewHolder(itemMissionBinding.root)
    }
}