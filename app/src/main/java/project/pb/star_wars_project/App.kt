package project.pb.star_wars_project

import android.app.Application
import project.pb.star_wars_project.functional.rest.Rest
import project.pb.star_wars_project.functional.rest.RestInterface

class App : Application() {

    companion object {
       lateinit var service : RestInterface
    }

    val TAG = javaClass.simpleName

    override fun onCreate() {
        super.onCreate()
        service = Rest.create()

    }


}