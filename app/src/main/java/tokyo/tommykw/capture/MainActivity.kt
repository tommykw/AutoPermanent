package tokyo.tommykw.capture

import android.content.Context
import android.media.MediaPlayer
import android.media.MediaRecorder
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View
import android.view.Menu
import android.view.MenuItem
import android.widget.Button

import java.io.IOException

class MainActivity : AppCompatActivity() {
    private val recordButton: RecordButton? = null
    private var mediaRecorder: MediaRecorder? = null
    private val playButton: PlayButton? = null
    private var mediaPlayer: MediaPlayer? = null

    private fun onRecord(inStart: Boolean) {
        if (inStart) {
            startRecording()
        } else {
            stopRecording()
        }
    }

    private fun onPlay(inStart: Boolean) {
        if (inStart) {
            startPlaying()
        } else {
            stopPlaying()
        }
    }

    private fun startPlaying() {
        mediaPlayer = MediaPlayer()
        try {
            mediaPlayer!!.setDataSource(fileName)
            mediaPlayer!!.prepare()
            mediaPlayer!!.start()
        } catch (e: IOException) {
            Log.e(TAG, "prepare failed")
        }

    }

    private fun stopPlaying() {
        mediaPlayer!!.release()
        mediaPlayer = null
    }

    private fun startRecording() {
        mediaRecorder = MediaRecorder()
        mediaRecorder!!.setAudioSource(MediaRecorder.AudioSource.MIC)
        mediaRecorder!!.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
        mediaRecorder!!.setOutputFile(fileName)
        mediaRecorder!!.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)

        try {
            mediaRecorder!!.prepare();
        } catch (e: IOException) {
            Log.e(TAG, "prepare failed");
        }
    }

    private fun stopRecording() {
        mediaRecorder!!.stop();
        mediaRecorder!!.release();
        mediaRecorder = null;
    }

    private class RecordButton(context: Context) : Button(context) {
        var startRecording = true
        val clicker = View.OnClickListener {
            onRecord(startRecording)
            if (startRecording) {
                text = "Stop recording"
            } else {
                text = "Start recording"
            }
            startRecording = startRecording!
        }

        init {
            text = "Start recording"
            setOnClickListener(clicker)
        }
    }

    private class PlayButton(context: Context) : Button(context) {
        var startPlaying = true
        val clicker = View.OnClickListener {
            onPlay(startPlaying)
            if (startPlaying) {
                text = "Stop playing"
            } else {
                text = "Start playing"
            }
            startPlaying = startPlaying!
        }

        init {
            text = "Start playing";
            setOnClickListener(clicker)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show() }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    companion object {
        private val TAG = MainActivity::class.java!!.getSimpleName()
        private val fileName: String? = null
    }
}
