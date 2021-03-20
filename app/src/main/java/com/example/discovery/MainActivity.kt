package com.example.discovery

import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt

class MainActivity : AppCompatActivity() {

    lateinit var button_mic: ImageButton
    lateinit var button_ytb: ImageButton
    lateinit var button_map: ImageButton
    lateinit var button_music: ImageButton
    lateinit var button_food: ImageButton
    lateinit var button_TV : ImageButton
    lateinit var button_check: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_mic = findViewById(R.id.button_mic)
        button_ytb = findViewById(R.id.button_ytb)
        button_map = findViewById(R.id.button_map)
        button_music = findViewById(R.id.buttton_music)
        button_food = findViewById(R.id.button_food)
        button_TV = findViewById(R.id.button_TV)
        button_check = findViewById(R.id.button_check)

        showButtonImage()
    }


    private fun showButtonImage() {
        val prefManager = PreferenceManager.getDefaultSharedPreferences(this)
        if (!prefManager.getBoolean("didShowPrompt", false)) {
            MaterialTapTargetPrompt.Builder(this)
                    .setTarget(button_mic)
                    .setPrimaryText("Click me!")
                    .setSecondaryText("Bấm vào đây để nói!!")
                    .setBackButtonDismissEnabled(true)
                    .setPromptStateChangeListener { prompt, state ->
                        if (state == MaterialTapTargetPrompt.STATE_FOCAL_PRESSED
                                || state == MaterialTapTargetPrompt.STATE_NON_FOCAL_PRESSED) {
                            val prefEditor = prefManager.edit()
                            prefEditor.putBoolean("didShowPrompt", true)
                            prefEditor.apply()
                            showButtonYtb()
                        }
                    }
                    .show()
        }
    }

    private fun showButtonYtb() {
        MaterialTapTargetPrompt.Builder(this)
                .setTarget(button_ytb)
                .setPrimaryText("Click me!")
                .setSecondaryText("Những thứ thú vị trên youtobe!!")
                .setBackButtonDismissEnabled(true)
                .setPromptStateChangeListener { prompt, state ->
                    if (state == MaterialTapTargetPrompt.STATE_FOCAL_PRESSED
                            || state == MaterialTapTargetPrompt.STATE_NON_FOCAL_PRESSED) {
                        showButtonMap()
                    }
                }
                .show()
//                .setPromptBackground(RectanglePromptBackground())   //Hinh vuong
//                .setPromptFocal(RectanglePromptFocal())

    }

    private fun showButtonMap() {
        MaterialTapTargetPrompt.Builder(this)
                .setTarget(button_map)
                .setPrimaryText("Click me!")
                .setSecondaryText("Đến bất cứ đâu với Google Map!!")
                .setBackButtonDismissEnabled(true)
                .setPromptStateChangeListener { prompt, state ->
                    if (state == MaterialTapTargetPrompt.STATE_FOCAL_PRESSED
                            || state == MaterialTapTargetPrompt.STATE_NON_FOCAL_PRESSED) {
                        showButtonMusic()
                    }
                }
                .show()
    }

    private fun showButtonMusic() {
        MaterialTapTargetPrompt.Builder(this)
                .setTarget(button_music)
                .setPrimaryText("Click me!")
                .setSecondaryText("Nghe nhạc mp3!!")
                .setBackButtonDismissEnabled(true)
                .setPromptStateChangeListener { prompt, state ->
                    if (state == MaterialTapTargetPrompt.STATE_FOCAL_PRESSED
                            || state == MaterialTapTargetPrompt.STATE_NON_FOCAL_PRESSED) {
                        showButtonFood()
                    }
                }
                .show()
    }

    private fun showButtonFood() {
        MaterialTapTargetPrompt.Builder(this)
                .setTarget(button_food)
                .setPrimaryText("Click me!")
                .setSecondaryText("Tìm quán ăn xung quanh!!")
                .setBackButtonDismissEnabled(true)
                .setPromptStateChangeListener { prompt, state ->
                    if (state == MaterialTapTargetPrompt.STATE_FOCAL_PRESSED
                            || state == MaterialTapTargetPrompt.STATE_NON_FOCAL_PRESSED) {
                        showButtonTV()
                    }
                }
                .show()
    }

    private fun showButtonTV() {
        MaterialTapTargetPrompt.Builder(this)
                .setTarget(button_TV)
                .setPrimaryText("Click me!")
                .setSecondaryText("Xem TV trực tuyến!!")
                .setBackButtonDismissEnabled(true)
                .setPromptStateChangeListener { prompt, state ->
                    if (state == MaterialTapTargetPrompt.STATE_FOCAL_PRESSED
                            || state == MaterialTapTargetPrompt.STATE_NON_FOCAL_PRESSED) {
                        showButtonCheck()
                    }
                }
                .show()
    }

    private fun showButtonCheck() {
        MaterialTapTargetPrompt.Builder(this)
                .setTarget(button_check)
                .setPrimaryText("Click me!")
                .setSecondaryText("Phạt nguội!!")
                .setBackButtonDismissEnabled(true)
                .show()
    }

}
