package aldwin.tablante.com.spotify


/**
 * Created by Bobby on 17/12/2017.
 */

import android.app.Fragment
import android.app.FragmentContainer
import android.app.FragmentManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import org.w3c.dom.Text
import android.os.Bundle
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.FragmentTransaction
import android.widget.Toast

class RecipeRecycler (dataMusic: ArrayList<Music>, context: Context) : RecyclerView.Adapter<RecipeRecycler.Musicy>(){

    var mContext = context
    var dataMusic: ArrayList<Music> = dataMusic
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Musicy {
        var view = LayoutInflater.from(parent!!.context).inflate(R.layout.item, parent, false)
        var view2 = LayoutInflater.from(parent!!.context).inflate(R.layout.fragment_blank, parent, false)

        return Musicy(view,view2)
    }

    override fun onBindViewHolder(holder: Musicy?, position: Int) {
        var dish = dataMusic[position]
        var title = dish.dtitle
        var frag = title
        var description = dish.ddescription
        holder!!.titlev.text = "" + title
        holder.descript.text = "" + description
       holder.frageee.text=""
        holder.setReclicker(object:Musiclick{

            override fun onMusicClick(view: View, pos: Int) {
                holder.frageee.text = "" + title
                holder.titlev.setTextColor(Color.parseColor("green"))
                        //Frag(mContext).showFragment()



            }
        })




    }


    override fun getItemCount(): Int {
        return dataMusic.size
    }


    class Musicy(itemView: View,itemView2: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        override fun onClick(p0: View?) {
            this.reClicker!!.onMusicClick(p0!!, adapterPosition)
        }



        val titlev: TextView
        val descript: TextView
        var frageee: TextView
        var reClicker:Musiclick? = null


        init {


            titlev = itemView.findViewById<TextView>(R.id.titleview)
            descript = itemView.findViewById<TextView>(R.id.description)
            frageee = itemView2.findViewById(R.id.fragmentation)
            itemView.setOnClickListener(this)
        }

        fun setReclicker(Musiclicker: Musiclick) {
            this.reClicker = Musiclicker

        }





    }

}
