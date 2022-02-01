package ahmadi.mostafa.mathquiz

import ahmadi.mostafa.mathquiz.databinding.ActivityCheatBinding
import ahmadi.mostafa.mathquiz.databinding.ActivityMainBinding
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class CheatActivity : AppCompatActivity() {
    lateinit var binding: ActivityCheatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCheatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){


            binding.btnShowAnswer.setOnClickListener {
                txtCorrectAnswer.text=intent.getStringExtra("CORRECT_ANSWER")
                val intent= Intent()
                intent.putExtra("CHEAT_ANSWER","Cheating is Wrong")
                setResult(RESULT_OK,intent)

            }
        }


    }
}