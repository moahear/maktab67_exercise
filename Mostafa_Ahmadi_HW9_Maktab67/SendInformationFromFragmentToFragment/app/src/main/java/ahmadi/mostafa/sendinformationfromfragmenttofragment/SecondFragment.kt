package ahmadi.mostafa.sendinformationfromfragmenttofragment

import ahmadi.mostafa.sendinformationfromfragmenttofragment.databinding.FragmentFirstBinding
import ahmadi.mostafa.sendinformationfromfragmenttofragment.databinding.FragmentSecondBinding
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace

class SecondFragment:Fragment(R.layout.fragment_second) {
    private lateinit var binding:FragmentSecondBinding
    lateinit var userInfo: UserInfo
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentSecondBinding.bind(view)
       binding.txtFullName.text=arguments?.getString("FullName")
       binding.txtUserName.text=arguments?.getString("UserName")
       binding.txtEmail.text=arguments?.getString("Email")
        binding.txtPassword.text=arguments?.getString("Password")
        binding.txtGender.text=arguments?.getString("Gender")
        binding.btnSave.setOnClickListener {
            userInfo = UserInfo(view.context)
            userInfo.saveUserInformation(
                binding.txtFullName.text.toString(),
                binding.txtUserName.text.toString(),
                binding.txtEmail.text.toString(),
                binding.txtPassword.text.toString(),
                binding.txtGender.text.toString()
            )
            Toast.makeText(view.context, "اطلاعات با موفقیت ذخیره شد", Toast.LENGTH_SHORT).show();
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace<FirstFragment>(R.id.fragment_container)
            }

        }
    }

}