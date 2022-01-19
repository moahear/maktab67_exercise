package ahmadi.mostafa.logininformationapi21
import android.content.Context
import android.content.SharedPreferences

class UserInfo(private val context: Context) {
    private val sharedPreferences =context.getSharedPreferences("user_information",Context.MODE_PRIVATE)
    private val editor=sharedPreferences.edit()
    fun saveUserInformation(fullName:String , userName:String , email:String , password:String , gender:Gender) {
    editor.putString("full_name",fullName)
    editor.putString("user_name",userName)
    editor.putString("email",email)
    editor.putString("password",password)
    editor.putString("gender",gender.name)
        editor.apply()
    }
     val fullName:String?=sharedPreferences.getString("full_name","")
     val userName:String?=sharedPreferences.getString("user_name","")
     val email:String?=sharedPreferences.getString("email","")
     val password:String?=sharedPreferences.getString("password","")
     val gender:String?=sharedPreferences.getString("gender","")

}