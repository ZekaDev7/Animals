package com.example.myapplication.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myapplication.R
import com.example.myapplication.data.UserDataUiEvents
import com.example.myapplication.ui.AnimalCard
import com.example.myapplication.ui.ButtonComponent
import com.example.myapplication.ui.TextComponent
import com.example.myapplication.ui.TextFieldComponent
import com.example.myapplication.ui.TopBar
import com.example.myapplication.ui.UserInputViewModel

@Composable
fun UserInputScreen(userInputViewModel: UserInputViewModel, showWelcomeScreen: (valuesPair: Pair<String, String>) -> String) {

    Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        ) {
            TopBar("Hi There \uD83D\uDE0A")
            TextComponent(
                textValue = "Let's learn about You!",
                textSize = 24.sp
            )

            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(
                textValue = "This app will prepare a details page based on input provided by you!",
                textSize = 18.sp
            )

            Spacer(modifier = Modifier.size(60.dp))

            TextComponent(textValue = "Name", textSize = 18.sp)

            Spacer(modifier = Modifier.size(10.dp))

            TextFieldComponent(onTextChanged = {
                userInputViewModel.onEvent(
                    UserDataUiEvents.UserNameEntered(it)
                )
            })

            TextComponent(textValue = "What do you like", textSize = 18.sp)

            Row(
                modifier = Modifier
            ) {

                AnimalCard(image = R.drawable.ic_launcher_foreground, animalSelected = {
                    userInputViewModel.onEvent(
                        UserDataUiEvents.AnimalSelected(it)
                    )
                }, selected = userInputViewModel.uiState.value.animalSelected == "Dog")

                AnimalCard(image = R.drawable.ic_launcher_background, animalSelected = {
                    userInputViewModel.onEvent(
                        UserDataUiEvents.AnimalSelected(it)
                    )
                }, selected = userInputViewModel.uiState.value.animalSelected == "Cat")
            }

            if (userInputViewModel.isValidate()) {
                ButtonComponent(
                    goToDetailsScreen = {

                    }
                )
            }
        }
    }
}