package ahmadi.mostafa.mytictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TableLayout
import android.widget.Toast

import java.lang.Exception


class MainActivity : AppCompatActivity() {

    enum class PLAYINGPLAYER {
        FIRST_PLAYER, SECOND_PLAYER
    }

    enum class WINNER {
        PLAYER_ONE, PLAYER_TWO, NO_ONE
    }

    lateinit var imageButton1: ImageButton
    lateinit var imageButton2: ImageButton
    lateinit var imageButton3: ImageButton
    lateinit var imageButton4: ImageButton
    lateinit var imageButton5: ImageButton
    lateinit var imageButton6: ImageButton
    lateinit var imageButton7: ImageButton
    lateinit var imageButton8: ImageButton
    lateinit var imageButton9: ImageButton
    lateinit var btnReset: Button
    lateinit var tableLayout: TableLayout
    var playingPlayer: PLAYINGPLAYER? = null
    var winnerOfGame: WINNER? = null
    var player1Options: ArrayList<Int> = ArrayList()
    var player2Options: ArrayList<Int> = ArrayList()
    var allDisabledImageButtons: ArrayList<ImageButton?> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindingView()
        playingPlayer = PLAYINGPLAYER.FIRST_PLAYER
    }

    private fun bindingView() {
        tableLayout = findViewById(R.id.tableLayout)
        imageButton1 = findViewById(R.id.imageButton1)
        imageButton2 = findViewById(R.id.imageButton2)
        imageButton3 = findViewById(R.id.imageButton3)
        imageButton4 = findViewById(R.id.imageButton4)
        imageButton5 = findViewById(R.id.imageButton5)
        imageButton6 = findViewById(R.id.imageButton6)
        imageButton7 = findViewById(R.id.imageButton7)
        imageButton8 = findViewById(R.id.imageButton8)
        imageButton9 = findViewById(R.id.imageButton9)
        btnReset = findViewById(R.id.btnReset)
        btnReset.setOnClickListener {
            player1Options.clear()
            player2Options.clear()
            allDisabledImageButtons.clear()
            playingPlayer = PLAYINGPLAYER.FIRST_PLAYER
            winnerOfGame = WINNER.NO_ONE

            imageButton1.setImageResource(R.drawable.square)
            imageButton2.setImageResource(R.drawable.square)
            imageButton3.setImageResource(R.drawable.square)
            imageButton4.setImageResource(R.drawable.square)
            imageButton5.setImageResource(R.drawable.square)
            imageButton6.setImageResource(R.drawable.square)
            imageButton7.setImageResource(R.drawable.square)
            imageButton8.setImageResource(R.drawable.square)
            imageButton9.setImageResource(R.drawable.square)
            imageButton1.isEnabled=true
            imageButton2.isEnabled=true
            imageButton3.isEnabled=true
            imageButton4.isEnabled=true
            imageButton5.isEnabled=true
            imageButton6.isEnabled=true
            imageButton7.isEnabled=true
            imageButton8.isEnabled=true
            imageButton9.isEnabled=true

        }
    }

    fun imageButtonTapped(view: View) {

        val selectedImageButton: ImageButton = view as ImageButton
        var optionNumber = 0
        when (selectedImageButton.id) {
            R.id.imageButton1 -> optionNumber = 1
            R.id.imageButton2 -> optionNumber = 2
            R.id.imageButton3 -> optionNumber = 3
            R.id.imageButton4 -> optionNumber = 4
            R.id.imageButton5 -> optionNumber = 5
            R.id.imageButton6 -> optionNumber = 6
            R.id.imageButton7 -> optionNumber = 7
            R.id.imageButton8 -> optionNumber = 8
            R.id.imageButton9 -> optionNumber = 9
        }

        action(optionNumber, selectedImageButton)

    }

    private fun action(optionNumber: Int, _selectedImageButton: ImageButton) {

        var selectedImageButton = _selectedImageButton

        if (playingPlayer == PLAYINGPLAYER.FIRST_PLAYER) {

            selectedImageButton.setImageResource(R.drawable.x_letter)
            selectedImageButton.isEnabled = false
            player1Options.add(optionNumber)
            allDisabledImageButtons.add(selectedImageButton)
            playingPlayer = PLAYINGPLAYER.SECOND_PLAYER

        }
        if (playingPlayer == PLAYINGPLAYER.SECOND_PLAYER) {
            var notSelectedImageNumbers = ArrayList<Int>()
            for (imageNumber in 1..9) {
                if (!(player1Options.contains(imageNumber))) {
                    if (!(player2Options.contains(imageNumber))) {
                        notSelectedImageNumbers.add(imageNumber)
                    }
                }
            }

            try {
                var randomNumber = (Math.random() * notSelectedImageNumbers.size).toInt()
                var imageNumber = notSelectedImageNumbers[randomNumber]

                when (imageNumber) {
                    1 -> selectedImageButton = imageButton1
                    2 -> selectedImageButton = imageButton2
                    3 -> selectedImageButton = imageButton3
                    4 -> selectedImageButton = imageButton4
                    5 -> selectedImageButton = imageButton5
                    6 -> selectedImageButton = imageButton6
                    7 -> selectedImageButton = imageButton7
                    8 -> selectedImageButton = imageButton8
                    9 -> selectedImageButton = imageButton9
                }

                selectedImageButton.setImageResource(R.drawable.o_letter)
                player2Options.add(imageNumber)
                selectedImageButton.isEnabled = false
                allDisabledImageButtons.add(selectedImageButton)


            } catch (e: Exception) {
                e.printStackTrace()
            }

            playingPlayer = PLAYINGPLAYER.FIRST_PLAYER

        }

        specifyWinnerOfGame()
    }

    private fun specifyWinnerOfGame() {

        if (player1Options.contains(1)
            && player1Options.contains(2)
            && player1Options.contains(3)
        ) {
            winnerOfGame = WINNER.PLAYER_ONE
        } else if (player2Options.contains(1)
            && player2Options.contains(2)
            && player2Options.contains(3)
        ) {
            winnerOfGame = WINNER.PLAYER_TWO
        } else if (player1Options.contains(4)
            && player1Options.contains(5)
            && player1Options.contains(6)
        ) {
            winnerOfGame = WINNER.PLAYER_ONE
        } else if (player2Options.contains(4)
            && player2Options.contains(5)
            && player2Options.contains(6)
        ) {
            winnerOfGame = WINNER.PLAYER_TWO
        } else if (player1Options.contains(7)
            && player1Options.contains(8)
            && player1Options.contains(9)
        ) {
            winnerOfGame = WINNER.PLAYER_ONE
        } else if (player2Options.contains(7)
            && player2Options.contains(8)
            && player2Options.contains(9)
        ) {
            winnerOfGame = WINNER.PLAYER_TWO
        } else if (player1Options.contains(1)
            && player1Options.contains(4)
            && player1Options.contains(7)
        ) {
            winnerOfGame = WINNER.PLAYER_ONE
        } else if (player2Options.contains(1)
            && player2Options.contains(4)
            && player2Options.contains(7)
        ) {
            winnerOfGame = WINNER.PLAYER_TWO
        } else if (player1Options.contains(2)
            && player1Options.contains(5)
            && player1Options.contains(8)
        ) {
            winnerOfGame = WINNER.PLAYER_ONE
        } else if (player2Options.contains(2)
            && player2Options.contains(5)
            && player2Options.contains(8)
        ) {
            winnerOfGame = WINNER.PLAYER_TWO
        } else if (player1Options.contains(3)
            && player1Options.contains(6)
            && player1Options.contains(9)
        ) {
            winnerOfGame = WINNER.PLAYER_ONE
        } else if (player2Options.contains(3)
            && player2Options.contains(6)
            && player2Options.contains(9)
        ) {
            winnerOfGame = WINNER.PLAYER_TWO
        } else if (player1Options.contains(1)
            && player1Options.contains(5)
            && player1Options.contains(9)
        ) {
            winnerOfGame = WINNER.PLAYER_ONE
        } else if (player2Options.contains(1)
            && player2Options.contains(5)
            && player2Options.contains(9)
        ) {
            winnerOfGame = WINNER.PLAYER_TWO
        } else if (player1Options.contains(3)
            && player1Options.contains(5)
            && player1Options.contains(7)
        ) {
            winnerOfGame = WINNER.PLAYER_ONE
        } else if (player2Options.contains(3)
            && player2Options.contains(5)
            && player2Options.contains(7)
        ) {
            winnerOfGame = WINNER.PLAYER_TWO
        }
        if (winnerOfGame == WINNER.PLAYER_ONE) {
            Toast.makeText(this, "player 1 win", Toast.LENGTH_LONG).show();
            disableAll()
            return
        } else if (winnerOfGame == WINNER.PLAYER_TWO) {
            Toast.makeText(this, "player 2 win", Toast.LENGTH_LONG).show();
            disableAll()
            return
        }
        checkDrawStatus()
    }

    private fun disableAll() {
        imageButton1.isEnabled = false
        imageButton2.isEnabled = false
        imageButton3.isEnabled = false
        imageButton4.isEnabled = false
        imageButton5.isEnabled = false
        imageButton6.isEnabled = false
        imageButton7.isEnabled = false
        imageButton8.isEnabled = false
        imageButton9.isEnabled = false

    }

    private fun checkDrawStatus() {
        if (allDisabledImageButtons.size == 9
            && winnerOfGame != WINNER.PLAYER_ONE
            && winnerOfGame != WINNER.PLAYER_TWO
        ) {
            Toast.makeText(this, "DRAW ! No one won the game ", Toast.LENGTH_LONG).show();
            disableAll()

        }
    }

}