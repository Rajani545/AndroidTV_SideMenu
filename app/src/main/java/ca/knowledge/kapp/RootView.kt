package ca.knowledge.kapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ca.knowledge.kapp.components.DefaultScreen
import ca.knowledge.kapp.home.HomeScreen
import ca.knowledge.kapp.components.sideDrawer.SideDrawer
import ca.knowledge.kapp.components.sideDrawer.DrawerState
import ca.knowledge.kapp.components.sideDrawer.NavigationItem
import ca.knowledge.kapp.ui.theme.brandBlack

@Composable
fun RootView() {
    var drawerState by remember { mutableStateOf(DrawerState.Closed) }
    var selectedNavigationItem by remember { mutableStateOf(NavigationItem.Home) }
    var hasFocus by remember { mutableStateOf(false) }

    val backgroundColor: List<Color> = if(drawerState == DrawerState.Opened) listOf(brandBlack, brandBlack.copy(alpha = 0.3f))
                                        else listOf(brandBlack,brandBlack.copy(alpha = 0.8f))
    Box(modifier = Modifier.fillMaxSize().background(brandBlack)) {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            DefaultScreen(
                title = selectedNavigationItem.title,
                drawerState = drawerState,
                onDrawerClick = { drawerState = it }
            )
        }
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .onFocusChanged { focusState ->
                    hasFocus = focusState.isFocused
                    drawerState = if(hasFocus) DrawerState.Opened else DrawerState.Closed
                }
                .width(if (drawerState == DrawerState.Opened) 230.dp else 80.dp)
                .background(Brush.horizontalGradient(backgroundColor))
        ) {
            SideDrawer(
                modifier = Modifier.fillMaxSize(),
                selectNavigationItem = selectedNavigationItem,
                onNavigationIteClick = {
                    selectedNavigationItem = it
                    drawerState = DrawerState.Closed
                                       },
                onCloseClick = { drawerState = DrawerState.Closed },
                drawerState = drawerState,
                onDrawerClick = { drawerState = it },
            )
        }
    }
}

@Preview(device = Devices.TV_720p)
@Composable
fun SimpleComposablePreview() {
    RootView()
}