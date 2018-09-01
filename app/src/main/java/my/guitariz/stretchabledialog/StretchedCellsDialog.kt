package my.guitariz.stretchabledialog

import android.content.Context
import android.view.View
import kotlinx.android.synthetic.main.cell_for_recycler.view.*
import kotlinx.android.synthetic.main.dialog_recycler.*

class StretchedCellsDialog(context: Context, datas:List<String>) : BaseFullscreenDialog(context, R.layout.dialog_recycler){
    init {
        dialog_ok.setOnClickListener { dismiss() }

        val cells:List<Pair<Int, (View)->Unit>> = datas.map { str ->
            R.layout.cell_for_recycler to { view:View ->
                view.cell_text.text = str
                Unit
            }
        }

        dialog_recycler.adapter.addPairs( cells )
    }
}