package tokyo.tommykw.capture

import android.content.Context
import android.view.View
import android.widget.Button

/**
 * Created by tommy on 15/12/14.
 */
class PlayButton(context: Context) : Button(context) {
    interface ClickInterface {
        fun onPlay(startPlaying: Boolean)
    }

    var listener:(ClickInterface)? = null
    var startPlaying = true
    val clicker = View.OnClickListener {
        listener?.onPlay(startPlaying)
        if (startPlaying) {
            text = "Stop playing"
        } else {
            text = "Start playing"
        }
        startPlaying = !startPlaying
    }

    init {
        text = "Start playing";
        setOnClickListener(clicker)
    }
}
