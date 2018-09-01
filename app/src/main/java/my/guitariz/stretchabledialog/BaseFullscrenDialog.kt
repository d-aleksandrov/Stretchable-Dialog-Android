package my.guitariz.stretchabledialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.AudioManager
import android.view.KeyEvent
import android.view.Window
import android.view.WindowManager

open class BaseFullscreenDialog(context: Context, viewID: Int) : Dialog(context) {
    init {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setCancelable(false)
        setContentView(viewID)
        window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        onBackPressed { dismiss() }
    }

    protected fun onBackPressed(handler: () -> Unit) {
        setOnKeyListener { _, keyCode, _ ->
            val audioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
            when (keyCode) {
                KeyEvent.KEYCODE_BACK -> {
                    handler()
                    return@setOnKeyListener true
                }
                KeyEvent.KEYCODE_VOLUME_DOWN -> {
                    audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_LOWER, AudioManager.FLAG_PLAY_SOUND)
                    return@setOnKeyListener true
                }
                KeyEvent.KEYCODE_VOLUME_UP -> {
                    audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND)
                    return@setOnKeyListener true
                }
            }

            return@setOnKeyListener false
        }
    }
}