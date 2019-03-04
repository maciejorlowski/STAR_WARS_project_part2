package project.pb.star_wars_project.base

import android.content.Context
import android.support.v4.app.Fragment
import project.pb.star_wars_project.models.interfaces.MainInteractions
import java.lang.Exception


open class BaseFragment : Fragment(){

    val TAG = javaClass.simpleName

    var actions: MainInteractions? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            actions = context as? MainInteractions
        } catch (ex: Exception) {
            throw IllegalStateException("Activity must implement correct action interface") as Throwable;
        }

    }

    override fun onDetach() {
        super.onDetach()
        actions = null
    }



}