package ahmadi.mostafa.mathquiz

import ahmadi.mostafa.mathquiz.databinding.ActivityMainBinding
import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    lateinit var questions: ArrayList<Question>
    lateinit var cheatText: Array<String?>
    lateinit var isAnswered: Array<Boolean>
    lateinit var backgroundColorBtn: Array<Pair<Int,Int>>
    lateinit var binding:ActivityMainBinding
    var questionNumber:Int=1
    private val getResult =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) {
            if(it.resultCode == Activity.RESULT_OK){
               cheatText[questionNumber-1]=it.data?.getStringExtra("CHEAT_ANSWER")
                binding.txtCheat.text=cheatText[questionNumber-1]
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    fun init(){
        questions=ArrayList<Question>(10)
        isAnswered=Array<Boolean>(10){false}
        cheatText=Array<String?>(10){""}
        backgroundColorBtn=Array<Pair<Int,Int>>(10){ Pair(resources.getColor(R.color.purple_500),resources.getColor(R.color.purple_500)) }
        questions.add(Question("1 is one ?",true))
        questions.add(Question("2 is three ?",false))
        questions.add(Question("3 is three ?",true))
        questions.add(Question("4 is two ?",false))
        questions.add(Question("5 is five ?",true))
        questions.add(Question("6 is six ?",true))
        questions.add(Question("7 is five ?",false))
        questions.add(Question("8 is eight ?",true))
        questions.add(Question("9 is seven ?",false))
        questions.add(Question("10 is ten ?",true))
        setTitleQuestion()
        viewBinding()

    }
    private fun setTitleQuestion(){
        when(questionNumber){
            1 -> {
                binding.txtTitle.text = questions[0].title
            }
            2 -> {
                binding.txtTitle.text = questions[1].title
            }
            3 -> {
                binding.txtTitle.text = questions[2].title
            }
            4 -> {
                binding.txtTitle.text = questions[3].title
            }
            5 -> {
                binding.txtTitle.text = questions[4].title
            }
            6 -> {
                binding.txtTitle.text = questions[5].title
            }
            7 -> {
                binding.txtTitle.text = questions[6].title
            }
            8 -> {
                binding.txtTitle.text = questions[7].title
            }
            9 -> {
                binding.txtTitle.text = questions[8].title
            }
            10 -> {
                binding.txtTitle.text = questions[9].title
            }
        }
    }
    private fun viewBinding(){
        binding.btnPrev.setOnClickListener {
            questionNumber--
            binding.btnPrev.isEnabled = questionNumber != 1
            binding.btnNext.isEnabled = questionNumber != 10
            binding.txtCheat.text=cheatText[questionNumber-1]
            setTitleQuestion()
            if (isAnswered[questionNumber-1]){
                binding.btnTrue.setBackgroundColor(backgroundColorBtn[questionNumber-1].first)
                binding.btnFalse.setBackgroundColor(backgroundColorBtn[questionNumber-1].second)
                binding.btnFalse.isEnabled=false
                binding.btnTrue.isEnabled=false
            }
            else{
                binding.btnFalse.isEnabled=true
                binding.btnTrue.isEnabled=true
                binding.btnTrue.setBackgroundColor(resources.getColor(R.color.purple_500))
               binding.btnFalse.setBackgroundColor(resources.getColor(R.color.purple_500))
            }

        }

        binding.btnNext.setOnClickListener {
            questionNumber++
            binding.btnNext.isEnabled = questionNumber != 10
            binding.btnPrev.isEnabled = questionNumber != 1
          binding.txtCheat.text=cheatText[questionNumber-1]
            setTitleQuestion()
            if (isAnswered[questionNumber-1]){
                binding.btnTrue.setBackgroundColor(backgroundColorBtn[questionNumber-1].first)
                binding.btnFalse.setBackgroundColor(backgroundColorBtn[questionNumber-1].second)
                binding.btnFalse.isEnabled=false
                binding.btnTrue.isEnabled=false
            }
            else{
                binding.btnFalse.isEnabled=true
                binding.btnTrue.isEnabled=true
               binding.btnTrue.setBackgroundColor(resources.getColor(R.color.purple_500))
                binding.btnFalse.setBackgroundColor(resources.getColor(R.color.purple_500))
            }
        }

        binding.btnTrue.setOnClickListener {
            if (questions[questionNumber-1].answer) {
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show();
            }
            binding.btnTrue.setBackgroundColor(Color.RED)
            backgroundColorBtn[questionNumber-1]= Pair(Color.RED,resources.getColor(R.color.purple_500))
            binding.btnFalse.isEnabled=false
            binding.btnTrue.isEnabled=false
            isAnswered[questionNumber-1]=true
        }

        binding.btnFalse.setOnClickListener {
            if (!questions[questionNumber-1].answer) {
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show();
            }
            binding.btnFalse.setBackgroundColor(Color.RED)
            backgroundColorBtn[questionNumber-1]= Pair(resources.getColor(R.color.purple_500),Color.RED)
            binding.btnFalse.isEnabled=false
            binding.btnTrue.isEnabled=false
            isAnswered[questionNumber-1]=true
        }
        binding.btnCheat.setOnClickListener {
            val intent= Intent(this@MainActivity,CheatActivity::class.java)
            intent.putExtra("CORRECT_ANSWER",questions[questionNumber-1].answer.toString())
            getResult.launch(intent)
        }

    }
}