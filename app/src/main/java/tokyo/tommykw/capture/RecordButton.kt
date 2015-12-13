package tokyo.tommykw.capture

import android.content.Context
import android.view.View
import android.widget.Button

/**
 * Created by tommy on 15/12/14.
 */
class RecordButton(context: Context) : Button(context) {
    interface ClickInterface {
        fun onRecord(startRecording:Boolean)
    }

    var listener:ClickInterface? = null
    var startRecording = true
    val clicker = View.OnClickListener {
        listener?.onRecord(startRecording)
        if (startRecording) {
            text = "Stop recording"
        } else {
            text = "Start recording"
        }
        startRecording = !startRecording
    }

    init {
        text = "Start recording"
        setOnClickListener(clicker)
    }
}