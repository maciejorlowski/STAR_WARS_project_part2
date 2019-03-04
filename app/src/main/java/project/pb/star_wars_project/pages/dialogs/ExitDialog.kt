package project.pb.star_wars_project.pages.dialogs

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import kotlinx.android.synthetic.main.dialog_exit.*

import project.pb.star_wars_project.R

class ExitDialog : DialogFragment() {

    interface ExitApplicationListener {
        fun onExitApplication()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_exit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        accept_btn.setOnClickListener(::onSubmitClicked)
        cancel_btn.setOnClickListener(::onCancelClicked)

        dialog.setTitle(getString(R.string.exitdialog_title))

        dialog.window.setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        )
    }

    private fun onSubmitClicked(view: View) {
        val listener: ExitDialog.ExitApplicationListener = targetFragment as ExitDialog.ExitApplicationListener
        listener.onExitApplication()
        dismiss()
    }

    private fun onCancelClicked(view: View) {
        dismiss()
    }

    override fun onResume() {
        super.onResume()
        val width = resources.getDimensionPixelSize(R.dimen.exitdialog_width)
        val height = resources.getDimensionPixelSize(R.dimen.exitdialog_height)
        dialog.window!!.setLayout(width, height)

    }

}