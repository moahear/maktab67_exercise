package ahmadi.mostafa.one

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.addTextChangedListener
import soup.neumorphism.NeumorphButton
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var edtPassword: EditText
    lateinit var edtUserName: EditText
    lateinit var btnShowToast: Button
    lateinit var btnDice: Button
    lateinit var imgView: ImageView
    lateinit var constraintlayout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    fun init() {
        bindViews()
        btnShowToast.setOnClickListener {

            val toastView = layoutInflater.inflate(
                R.layout.layout_toast,
                findViewById(R.id.containerLayoutToast)
            )
            with(Toast(this)) {
                duration = Toast.LENGTH_SHORT
                setGravity(Gravity.TOP, 0, 0)
                view = toastView
                show()
            }

        }

        btnDice.setOnClickListener {
            val i = Random.nextInt(1, 7)
            when (i) {
                1 -> imgView.setImageResource(R.drawable.dice_1)
                2 -> imgView.setImageResource(R.drawable.dice_2)
                3 -> imgView.setImageResource(R.drawable.dice_3)
                4 -> imgView.setImageResource(R.drawable.dice_4)
                5 -> imgView.setImageResource(R.drawable.dice_5)
                6 -> imgView.setImageResource(R.drawable.dice_6)
                // else -> imgView.setImageResource(R.drawable.empty_dice)
            }
        }

        edtPassword.addTextChangedListener {
            btnShowToast.isEnabled =
                !(edtPassword.text.isNullOrBlank() || edtUserName.text.isNullOrBlank())
        }
        edtUserName.addTextChangedListener {
            btnShowToast.isEnabled =
                !(edtPassword.text.isNullOrBlank() || edtUserName.text.isNullOrBlank())

        }

    }

    fun bindViews() {
        edtPassword = findViewById(R.id.edt_password)
        edtUserName = findViewById(R.id.edt_user_name)
        btnShowToast = findViewById(R.id.btn_show_toast)
        btnDice = findViewById(R.id.btn_dice)
        imgView = findViewById(R.id.imgg)

    }
}