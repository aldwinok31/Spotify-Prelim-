package aldwin.tablante.com.spotify

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast


import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val manager = supportFragmentManager
    var adapter :RecipeRecycler?=null
    var dataDishes : ArrayList<Music> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val title_list =   arrayOf("More Than Words","American Idiot","Hotel California","Europa","How Deep is you love")
        val description_list = arrayOf("Extreme" , "Green day","Eagle","Carlo Santana","Bee Gees")


        for(i in 0..title_list.size-1) {

            dataDishes.add(Music(title_list[i], description_list[i]))

        }
        adapter = RecipeRecycler(dataDishes,applicationContext)
        var layout_manager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layout_manager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
        Toast.makeText(this,"Name", Toast.LENGTH_SHORT).show()
//showFragmentOne()
    }

 fun showFragmentOne(){
val transaction = manager.beginTransaction()
val fragment = BlankFragment()
    transaction.replace(R.id.linearLayout,fragment)
    transaction.addToBackStack(null)
    transaction.show(fragment)
    transaction.commit()
}

}
