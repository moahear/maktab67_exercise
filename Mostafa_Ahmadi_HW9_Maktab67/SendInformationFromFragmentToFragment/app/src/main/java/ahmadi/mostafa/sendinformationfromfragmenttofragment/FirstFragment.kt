package ahmadi.mostafa.sendinformationfromfragmenttofragment

import ahmadi.mostafa.sendinformationfromfragmenttofragment.databinding.FragmentFirstBinding
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class FirstFragment: Fragment(R.layout.fragment_first) {
    private lateinit var binding:FragmentFirstBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentFirstBinding.bind(view)
        with(binding){
            btnRegister.setOnClickListener {

                if (edtFullName.text.toString().isBlank() || edtUserName.text.toString()
                        .isBlank() || edtEmail.text.toString().isBlank() || edtPassword.text.toString()
                        .isBlank() || edtRepeatPassword.text.toString().isBlank()

                ) {
                    Toast.makeText(
                        view.context,
                        "بعضی از اطلاعات وارد نشده ، لطفا آنها را کامل کنید",
                        Toast.LENGTH_SHORT
                    ).show();
                } else if (edtPassword.text.toString() != edtRepeatPassword.text.toString()) {
                    Toast.makeText(view.context, "پسوردهای وارد شده مطابقت ندارند", Toast.LENGTH_SHORT).show();
                } else {
                    val bundles = bundleOf(
                        "FullName" to binding.edtFullName.text.toString(),
                        "UserName" to binding.edtUserName.text.toString(),
                        "Email" to binding.edtEmail.text.toString(),
                        "Password" to binding.edtPassword.text.toString(),
                        "Gender" to if (binding.radioButtonMale.isChecked) "Male" else "Female"

                    )
                    parentFragmentManager.commit {
                        setReorderingAllowed(true)
                        replace<SecondFragment>(R.id.fragment_container, args = bundles)
                    }
                }
            }
        }
    }

}