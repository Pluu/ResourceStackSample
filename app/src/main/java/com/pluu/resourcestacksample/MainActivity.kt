package com.pluu.resourcestacksample

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.setPadding
import com.pluu.composer.add
import com.pluu.composer.button
import com.pluu.composer.setContentView
import com.pluu.util.dp2Px

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView {
            val defaultButtonStyle: Button.() -> Unit = {
                val buttonMinHeight = dp2Px(60f)
                minimumHeight = buttonMinHeight
                textSize = 18f
            }
            add(::ScrollView) {
                add(::LinearLayout) {
                    orientation = LinearLayout.VERTICAL
                    setPadding(dp2Px(10f))
                    button(
                        text = "Default Theme",
                        measureResult = defaultButtonStyle
                    ) {
                        startActivity(Intent(this@MainActivity, DefaultActivity::class.java))
                    }
                    button(
                        text = "Styled Theme",
                        measureResult = defaultButtonStyle
                    ) {
                        startActivity(Intent(this@MainActivity, StyledActivity::class.java))
                    }
                }
            }
        }
    }
}