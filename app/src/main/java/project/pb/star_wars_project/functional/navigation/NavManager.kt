package project.pb.star_wars_project.functional.navigation

import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import project.pb.star_wars_project.base.BaseFragment
import project.pb.star_wars_project.R


class NavManager(val activity: FragmentActivity) {
    fun goBack() = activity.onBackPressed()
    fun navigate(to: BaseFragment, addToBackStack: Boolean = true) {
        activity.supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_holder, to)
            .apply {
                if (addToBackStack) {
                    addToBackStack(to.javaClass.simpleName)
                }
            }
            .commit()
    }
    fun clearStack() {
        activity.supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }
}