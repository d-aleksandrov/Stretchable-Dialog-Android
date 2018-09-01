package my.guitariz.stretchabledialog

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_present_button.setOnClickListener {
            StretchedTextDialog(this, main_text_edit.text.toString()).show()
        }

        main_present_recycler.setOnClickListener {
            StretchedCellsDialog(this, main_text_edit.text.toString().split(' ')).show()
        }
        main_present_big_list.setOnClickListener {
            StretchedCellsDialog(this, (0..100).map{it.toString()}).show()
        }
    }
}
