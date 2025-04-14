package ca.knowledge.kapp.components.sideDrawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ca.knowledge.kapp.R

@Composable
fun SideDrawer(
    modifier: Modifier = Modifier,
    selectNavigationItem: NavigationItem,
    onNavigationIteClick: (NavigationItem) -> Unit,
    onCloseClick:() -> Unit,
    drawerState: DrawerState,
    onDrawerClick: (DrawerState) -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start
    ) {
        Box(modifier = Modifier.fillMaxWidth().padding(top = 10.dp, start = 12.dp)) {
            Image(
                modifier = Modifier.size(34.dp),
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = "App logo",
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
        Column(Modifier.fillMaxWidth().align(Alignment.Start)) {
            NavigationItem.entries.toTypedArray().take(4).forEach { navigationItem ->
                SideMenuItemView(
                    navigationItem = navigationItem,
                    drawerState = drawerState,
                    selected = navigationItem == selectNavigationItem,
                    onClick = { onNavigationIteClick(navigationItem) }
                )
                Spacer(modifier = Modifier.height(4.dp))
            }

            Spacer(modifier = Modifier.weight(1f))

            NavigationItem.entries.toTypedArray().takeLast(1).forEach { navigationItem ->
                SideMenuItemView(
                    navigationItem = navigationItem,
                    drawerState = drawerState,
                    selected = navigationItem == selectNavigationItem,
                    onClick = {
                        when (navigationItem) {
                            NavigationItem.Settings -> {
                                onNavigationIteClick(navigationItem)
                            }

                            else -> {}
                        }
                    }
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}