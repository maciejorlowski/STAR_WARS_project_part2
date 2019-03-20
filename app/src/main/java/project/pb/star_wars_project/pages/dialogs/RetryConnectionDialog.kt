package project.pb.star_wars_project.pages.dialogs

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import kotlinx.android.synthetic.main.dialog_retry_connection.*
import project.pb.star_wars_project.R

class RetryConnectionDialog : DialogFragment() {

    interface RetryConnection {
        fun onFinishConnection(success : Boolean)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_retry_connection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        dialog.setTitle(getString(R.string.toast_noConnection))

        dialog.window.setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        )
        retry_connection_text.setOnClickListener(::retryConnection)
        go_back_btn.setOnClickListener(::goBack)
    }

    private fun retryConnection(view: View) {
            val listener: RetryConnectionDialog.RetryConnection =
                targetFragment as RetryConnectionDialog.RetryConnection
            listener.onFinishConnection(true)
            dismiss()
        }

    private fun goBack(view: View) {
        val listener: RetryConnectionDialog.RetryConnection =
            targetFragment as RetryConnectionDialog.RetryConnection
        listener.onFinishConnection(false)
        dismiss()
    }
}