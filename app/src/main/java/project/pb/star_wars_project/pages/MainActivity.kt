package project.pb.star_wars_project.pages

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import project.pb.star_wars_project.models.interfaces.MainInteractions
import project.pb.star_wars_project.models.interfaces.TopBarInteractions
import project.pb.star_wars_project.R
import project.pb.star_wars_project.functional.navigation.NavManager
import project.pb.star_wars_project.pages.home.MenuFragment
import project.pb.star_wars_project.pages.modules.bar.top.TopBarFragment
import project.pb.star_wars_project.pages.result.ResultFragment
import project.pb.star_wars_project.pages.searching.SearchingFragment

class MainActivity : FragmentActivity(), MainInteractions {


    val TAG = javaClass.simpleName


    override val navManager: NavManager = NavManager(this)
    private var topBar : TopBarFragment = TopBarFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        topBar = fragmentManager.findFragmentById(R.id.top_fragment) as TopBarFragment

        navManager.navigate(MenuFragment(),false)
    }

    override fun topBar(): TopBarInteractions {
        return topBar
    }

    override fun backStackCount(): Int {
        return supportFragmentManager.backStackEntryCount
    }
}