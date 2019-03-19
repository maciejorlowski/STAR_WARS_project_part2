package project.pb.star_wars_project.pages.modules.bar.top

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_topbar.*
import project.pb.star_wars_project.models.interfaces.TopBarInteractions
import project.pb.star_wars_project.R
import project.pb.star_wars_project.base.BaseFragment
import project.pb.star_wars_project.pages.dialogs.ExitDialog
import project.pb.star_wars_project.pages.home.MenuFragment


class TopBarFragment : BaseFragment(), TopBarInteractions, ExitDialog.ExitApplicationListener {

    private var music = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_topbar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        top_go_back_btn.setOnClickListener(::onBackButtonPressed)
        topbar_home_btn.setOnClickListener(::onHomeButtonPressed)
        topbar_sound_btn.setOnClickListener(::onSoundButtonPressed)


        Log.d("TAG", "onViewCreated")
    }

    private fun onBackButtonPressed(view: View) {
        Log.d(TAG, actions?.backStackCount().toString())
        if (0 < actions?.backStackCount() ?: 0)
            actions?.navManager?.goBack()
        else {
            val dialog = ExitDialog()
            dialog.setTargetFragment(this, 300)
            dialog.show(fragmentManager, "dialog")
        }

    }

    private fun onHomeButtonPressed(view: View){
        actions?.navManager?.clearStack()
        actions?.navManager?.navigate(MenuFragment(),false)
    }

    private fun onSoundButtonPressed(view: View){
        if(music){
            topbar_sound_btn.setImageResource(android.R.drawable.ic_lock_silent_mode)
            music = !music
            //TODO silence mod ON
        } else {
            topbar_sound_btn.setImageResource(android.R.drawable.ic_lock_silent_mode_off)
            music = !music
            //TODO silence mod OFF
        }
    }


    override fun setTitle(title: String) {
        topbar_title_text.text = title
    }


    override fun onExitApplication() {
        actions?.navManager?.goBack()
    }


}