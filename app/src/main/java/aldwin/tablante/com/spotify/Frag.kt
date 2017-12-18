package aldwin.tablante.com.spotify
import android.app.FragmentManager
import android.content.Context
import android.support.v7.app.AppCompatActivity

/**
 * Created by Bobby on 17/12/2017.
 */
class Frag(context: Context){
 var   mcontext = context
    fun showFragment(){
val fragment = BlankFragment()
//        val fragmentTransaction = (mcontext as AppCompatActivity).supportFragmentManager
val fragmentman = (mcontext as AppCompatActivity).supportFragmentManager
        .beginTransaction()
        fragmentman.replace(R.id.linearLayout3,fragment)
        fragmentman.show(fragment)
        fragmentman.commit()


    }

}