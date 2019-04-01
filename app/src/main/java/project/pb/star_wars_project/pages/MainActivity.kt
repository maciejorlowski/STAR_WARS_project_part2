package project.pb.star_wars_project.pages

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
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

    override fun isNetworkAvailable(): Boolean {
        val connectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE)
        return if (connectivityManager is ConnectivityManager) {
            val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
            networkInfo?.isConnected ?: false
        } else false
    }
}