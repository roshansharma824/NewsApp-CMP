package com.exmaple.newsapp.presentation.ui.navigation.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItemScreen(val route: String, val icon: ImageVector, val title: String) {

    data object Home : BottomNavItemScreen("home_screen", Icons.Outlined.Home, "Home")
    data object Search : BottomNavItemScreen("search_screen", Icons.Outlined.Search, "Search")
    data object Favorite : BottomNavItemScreen("favorite_screen", Icons.Outlined.Favorite, "Favorite")
    data object Profile : BottomNavItemScreen("profile_screen", Icons.Outlined.Person, "Profile")

    data object Detail : BottomNavItemScreen("detail_screen/{dataId}", Icons.Outlined.Favorite, "Detail") {
        fun passDataId(dataId: String): String = "detail_screen/${dataId}"
    }

//    data object EditNote:Screen("edit_note_screen/{${NOTE_ARGUMENT_KEY}}"){
//        fun passNoteId(noteId: String): String = "edit_note_screen/${noteId}"
//    }


}
