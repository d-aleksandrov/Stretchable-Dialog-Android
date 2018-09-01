package my.guitariz.stretchabledialog

import android.content.Context
import kotlinx.android.synthetic.main.dialog_text.*

class StretchedTextDialog(context: Context, text: String) : BaseFullscreenDialog(context, R.layout.dialog_text) {
    init {
        dialog_text.text = text
        dialog_ok.setOnClickListener { dismiss() }
    }
}