package project.pb.star_wars_project.models.interfaces

import project.pb.star_wars_project.functional.navigation.NavManager


interface MainInteractions {
    val navManager: NavManager
    fun topBar(): TopBarInteractions
    fun backStackCount() : Int

}