package ca.knowledge.kapp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.fragment.app.FragmentActivity
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Surface
import ca.knowledge.kapp.ui.theme.KnowledgeTheme

class MainActivity: FragmentActivity() {
    @OptIn(ExperimentalTvMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KnowledgeTheme {
                Surface(modifier = Modifier.fillMaxSize(), shape = RectangleShape) {
                    RootView()
                }
            }
        }
    }
}
