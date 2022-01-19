package ahmadi.mostafa.logininformationapi21

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.doOnLayout
import androidx.core.view.marginEnd
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputEditText


class MainActivity : AppCompatActivity() {

    lateinit var userInfo: UserInfo
    lateinit var btnShowInfo: Button
    lateinit var btnRegister: Button
    private var gender = Gender.MALE
    lateinit var scrollView: ScrollView
    lateinit var edtFullName: TextInputEditText
    lateinit var edtUserName: TextInputEditText
    lateinit var edtEmail: TextInputEditText
    lateinit var edtPassword: TextInputEditText
    lateinit var edtRepeatPassword: TextInputEditText
    lateinit var radioGroup: RadioGroup
    lateinit var btnHideInfo: Button
    lateinit var registerLayout: ConstraintLayout
    lateinit var showInfoLayout: ConstraintLayout
    lateinit var txtFullName: TextView
    lateinit var txtUserName: TextView
    lateinit var txtEmail: TextView
    lateinit var txtPassword: TextView
    lateinit var txtGender: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        userInfo = UserInfo(this)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun init() {
        bindViews()
        btnShowInfo.setOnClickListener {
            showInfoLayout.visibility = View.VISIBLE
            // scrollView.smoothScrollTo(0,scrollView.bottom)
            userInfo = UserInfo(this)
            txtFullName.text = userInfo.fullName
            txtUserName.text = userInfo.userName
            txtEmail.text = userInfo.email
            txtGender.text = userInfo.gender
            txtPassword.text = userInfo.password
            scrollView.doOnLayout { scrollView.fullScroll(View.FOCUS_DOWN) }

        }
        btnHideInfo.setOnClickListener {
            showInfoLayout.visibility = View.INVISIBLE
            //scrollView.smoothScrollTo(0,scrollView.top)
            scrollView.doOnLayout { scrollView.fullScroll(View.FOCUS_UP) }

        }
        radioGroup.setOnCheckedChangeListener { radioGroup, i ->
            gender = if (i == R.id.radioButtonFemale) Gender.FEMALE else {
                Gender.MALE
            }
        }
        btnRegister.setOnClickListener {

            //Toast.makeText(this, "ewewewew", Toast.LENGTH_SHORT).show();
            if (edtFullName.text.toString().isBlank() || edtUserName.text.toString()
                    .isBlank() || edtEmail.text.toString().isBlank() || edtPassword.text.toString()
                    .isBlank() || edtRepeatPassword.text.toString().isBlank()

            ) {
                Toast.makeText(
                    this,
                    "بعضی از اطلاعات وارد نشده ، لطفا آنها را کامل کنید",
                    Toast.LENGTH_SHORT
                ).show();
            } else if (edtPassword.text.toString() != edtRepeatPassword.text.toString()) {
                Toast.makeText(this, "پسوردهای وارد شده مطابقت ندارند", Toast.LENGTH_SHORT).show();
            } else {
                userInfo.saveUserInformation(
                    edtFullName.text.toString(),
                    edtUserName.text.toString(),
                    edtEmail.text.toString(),
                    edtPassword.text.toString(),
                    gender
                )
                Toast.makeText(this, "اطلاعات با موفقیت ذخیره شد", Toast.LENGTH_SHORT).show();
            }

        }

    }

    private fun bindViews() {
        btnShowInfo = findViewById(R.id.btnShowInfo)
        btnRegister = findViewById(R.id.btnRegister)
        btnHideInfo = findViewById(R.id.btnHideInfo)
        registerLayout = findViewById(R.id.registerLayout)
        showInfoLayout = findViewById(R.id.showInfoLayout)
        edtFullName = findViewById(R.id.edtFullName)
        scrollView = findViewById(R.id.scrollView)
        edtUserName = findViewById(R.id.edtUserName)
        edtEmail = findViewById(R.id.edtEmail)
        edtPassword = findViewById(R.id.edtPassword)
        edtRepeatPassword = findViewById(R.id.edtRepeatPassword)
        radioGroup = findViewById(R.id.radioGroup)
        txtFullName = findViewById(R.id.txtFullName)
        txtUserName = findViewById(R.id.txtUserName)
        txtEmail = findViewById(R.id.txtEmail)
        txtPassword = findViewById(R.id.txtPassword)
        txtGender = findViewById(R.id.txtGender)
    }

    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this, R.style.AlertDialogTextAlignment)
        builder.setTitle("توجه!")
        builder.setMessage("می خواهید خارج شوید؟")
        builder.setIcon(android.R.drawable.ic_dialog_info)
        builder.setPositiveButton("بله") { a, b -> finish() }
        builder.setPositiveButtonIcon(getDrawable(R.drawable.ic_baseline_check_24))
        builder.setNegativeButton("خیر") { a, b -> }
        builder.setNegativeButtonIcon(getDrawable(R.drawable.ic_baseline_close_24))
        // val dialog= //.window?.decorView?.layoutDirection= View.LAYOUT_DIRECTION_RTL
        // dialog.show()//.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(resources.getColor(android.R.color.black))
        val dialog = builder.create()
        with(dialog) {
            show()
            with(getButton(AlertDialog.BUTTON_NEGATIVE)) {
                setTextColor(Color.parseColor("#0000ff"))
                background = resources.getDrawable(R.drawable.background_dialog, theme)
                textSize = 12f
                height = 10
            }
            with(getButton(AlertDialog.BUTTON_POSITIVE)) {
                setTextColor(Color.parseColor("#0000ff"))
                background = resources.getDrawable(R.drawable.background_dialog, theme)
                textSize = 12f
                height = 10
            }
        }
    }
}