package com.example.practicingkotlinandandroidstudio.Lemonade

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.practicingkotlinandandroidstudio.R
import com.example.practicingkotlinandandroidstudio.databinding.ActivityLemonadeBinding
import com.google.android.material.snackbar.Snackbar

class Lemonade : AppCompatActivity() {

    private val LEMONADE_STATE = "LEMONADE_STATE"
    private val LEMON_SIZE = "LEMON_SIZE"
    private val SQUEEZE_COUNT = "SQUEEZE_COUNT"
    private val SELECT = "select"
    private val SQUEEZE = "squeeze"
    private val DRINK = "drink"
    private val RESTART = "restart"

    private var lemonadeState = "select"
    private var lemonSize = -1
    private var squeezeCount = -1

    private var lemonTree = LemonTree()
    private var lemonImage: ImageView? = null

    lateinit var binding: ActivityLemonadeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLemonadeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // === DO NOT ALTER THE CODE IN THE FOLLOWING IF STATEMENT ===

        if(savedInstanceState != null) {
            lemonadeState = savedInstanceState.getString(LEMONADE_STATE, "select")
            lemonSize = savedInstanceState.getInt(LEMON_SIZE, -1)
            squeezeCount = savedInstanceState.getInt(SQUEEZE_COUNT, -1)
        }

        // === END IF STATEMENT ===

        lemonImage = binding.imageLemonState
        setViewElements()
        lemonImage!!.setOnClickListener {
            clickLemonImage()
        }

        lemonImage!!.setOnLongClickListener {
            showSnackbar()
        }
    }

    /**
     * === DO NOT ALTER THIS METHOD ===
     *
     * This method saves the state of the app if it is put in the background.
     */

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(LEMONADE_STATE, lemonadeState)
        outState.putString(LEMON_SIZE, lemonSize.toString())
        outState.putString(SQUEEZE_COUNT, squeezeCount.toString())
        super.onSaveInstanceState(outState)
    }

    /**
     * Clicking will elicit a different response depending on the state.
     * This method determines the state and proceeds with the correct action.
     */

    private fun clickLemonImage() {
        when (lemonadeState) {

            SELECT -> {
                lemonSize = lemonTree.pick()
                squeezeCount = 0
                lemonadeState = SQUEEZE
            }

            SQUEEZE -> {
                squeezeCount += 1
                lemonSize = lemonSize -1
                if (lemonSize == 0) {
                    lemonadeState = DRINK
                }
                else {
                    lemonadeState = SQUEEZE
                }
            }

            DRINK -> {
                lemonadeState = RESTART
            }

            RESTART -> lemonadeState = SELECT
        }

        setViewElements()

        // TODO: используйте условный оператор типа "if" или "when", чтобы отслеживать состояние лимонада
        //  при щелчке по изображению нам, возможно, потребуется изменить состояние для перехода к следующему шагу в
        //  прогресс в производстве лимонада (или, по крайней мере, внесите некоторые изменения в текущее состояние в
        //  случае выжимания лимона). Это должно быть сделано в этом условном операторе

        // TODO: Когда изображение щелкается в SELECT состоянии, оно должно стать SQUEEZE
        //  - Переменная lemonSize должна быть установлена с помощью метода 'pick()' в классе LemonTree
        //  - squeezeCount должно быть равно 0, так как мы еще не выжали ни одного лимона.

        // TODO: При нажатии на изображение в состоянии SQUEEZE squeeze Count должно быть равно
        //  УВЕЛИЧЕНО на 1, а lemonSize необходимо уменьшить на 1.
        //  -  Если размер лимона достиг 0, значит, из него выжали сок, и состояние должно стать DRINK
        //  - Кроме того, lemonSize больше не имеет значения и должен быть установлен на -1

        // TODO: При нажатии на изображение в состоянии DRINK состояние должно стать RESTART

        // TODO: При нажатии на изображение в состоянии RESTART состояние должно стать SELECT

        // TODO: наконец, перед завершением работы функции нам нужно настроить элементы представления таким образом, чтобы
        // UI может отражать правильное состояние
    }

    /**
     * Set up the view elements according to the state.
     */

    private fun setViewElements() {

        binding.apply {

            when (lemonadeState) {

                SELECT -> {
                    textAction.text = getString(R.string.lemon_select)
                    imageLemonState.setImageResource(R.drawable.lemon_tree)
                }

                SQUEEZE -> {
                    textAction.text = getString(R.string.lemon_squeeze)
                    imageLemonState.setImageResource(R.drawable.lemon_squeeze)
                }

                DRINK -> {
                    textAction.text = getString(R.string.lemon_drink)
                    imageLemonState.setImageResource(R.drawable.lemon_drink)
                }

                RESTART -> {
                    textAction.text = getString(R.string.lemon_empty_glass)
                    imageLemonState.setImageResource(R.drawable.lemon_restart)
                }
            }
        }

        // TODO: установите условие, которое отслеживает lemonadeState

        // TODO: для каждого состояния textAction TextView должно быть установлено значение соответствующей строки из
        //  файл string resources. Строки именуются в соответствии с состоянием

        // TODO: Кроме того, для каждого состояния lemonImage должно быть установлено в соответствующее
        //  drawable из drawable ресурсов. Объекты рисования имеют те же имена, что и строки
        // но помните, что это рисуемые объекты, а не строки.
    }

    /**
     * === DO NOT ALTER THIS METHOD ===
     *
     * Long clicking the lemon image will show how many times the lemon has been squeezed.
     */

    private fun showSnackbar(): Boolean {
        if (lemonadeState != SQUEEZE) {
            return false
        }

        val squeezeText = getString(R.string.squeeze_count, squeezeCount)
        Snackbar.make(
            binding.constrainLayout,
            squeezeText,
            Snackbar.LENGTH_SHORT
        ).show()
        return true
    }
}

/**
 * A Lemon tree class with a method to "pick" a lemon. The "size" of the lemon is randomized
 * and determines how many times a lemon needs to be squeezed before you get lemonade.
 */

class LemonTree {
    fun pick(): Int {
        return (2..4).random()

    }
}
