package ca.knowledge.kapp.components.sideDrawer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.Icon
import androidx.tv.material3.Text
import ca.knowledge.kapp.R

@Composable
fun SideMenuItemView(
    navigationItem: NavigationItem,
    drawerState: DrawerState,
    selected: Boolean,
    onClick:() -> Unit
) {
    var hasFocus by remember { mutableStateOf(false) }

    Button(
        onClick = { onClick() },
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .background(Color.Transparent)
            .onFocusChanged { focusState ->
                hasFocus = focusState.isFocused
            },
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
        ) {
            Column {
                Icon(
                    painter = painterResource(id = navigationItem.icon),
                    contentDescription = "Icon",
                    tint = if (hasFocus) Color.White else Color.Gray,
                    modifier = Modifier.padding(end = 8.dp).size(20.dp)
                )
                if (selected) {
                    HorizontalDivider(thickness = 2.dp, modifier = Modifier.width(20.dp).padding(top = 4.dp), color = Color.Cyan)
                }
            }

            if (drawerState == DrawerState.Opened) {
                Text(
                    text = navigationItem.title,
                    color = Color.White,
                    fontSize = 14.sp,
                )
            }
        }
    }
}

enum class NavigationItem(
    val title: String,
    val icon: Int
) {
    Home(
        icon = R.drawable.ic_home,
        title = "Home"
    ),
    Documentaries(
        icon = R.drawable.ic_doc,
        title = "Documentaries"
    ),
    Search(
        icon = R.drawable.ic_search,
        title = "Search"
    ),
    SignIn(
    icon = R.drawable.ic_person,
    title = "SignIn"
    ),
    Settings(
        icon = R.drawable.ic_settings,
        title = "Settings"
    )
}