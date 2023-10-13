package com.example.businesscard.ui.screen.skills

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.CopyAll
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Recommend
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.businesscard.ui.screen.info.InformationRowView
import com.example.businesscard.ui.theme.BackgroundColor
import com.example.businesscard.ui.theme.CardBordersColor
import com.example.businesscard.ui.theme.CardsBackGround
import com.example.businesscard.ui.theme.ValueColor
import com.example.businesscard.ui.theme.titlesColor
import com.example.businesscard.utils.ContactString.email
import com.example.businesscard.utils.ContactString.github
import com.example.businesscard.utils.SkillsString.android
import com.example.businesscard.utils.SkillsString.cv
import com.example.businesscard.utils.SkillsString.nlp
import com.example.businesscard.utils.SkillsString.recommenderSystem


@SuppressLint("ServiceCast")
@Composable
fun PersonalSkills(rotationClick: () -> Unit) {

    val density = LocalDensity.current //will be used for dynamic text sizes

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){

        Text(
            text = "Skills",
            color = BackgroundColor,
            fontSize = with(density){24.dp.toSp()},
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(top = 5.dp, bottom = 5.dp)
        )

        InformationRowView(
            value =  android,
            icon = Icons.Default.Android
        )

        InformationRowView(
            value = recommenderSystem,
            icon = Icons.Default.Recommend
        )

        InformationRowView(
            value =  nlp,
            icon = Icons.Default.Language
        )

        InformationRowView(
            value =  cv,
            icon = Icons.Default.RemoveRedEye
        )

        Text(
            text = "Contact",
            color = BackgroundColor,
            fontSize = with(density){24.dp.toSp()},
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(top = 15.dp, bottom = 5.dp)
        )

        Row(
            modifier = Modifier
                .padding(top = 5.dp, bottom = 15.dp,start = 20.dp , end = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp),
                tint = titlesColor
            )

            Text(
                text = email,
                color = ValueColor,
                fontSize = with(density){16.dp.toSp()},
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(start = 5.dp, end = 5.dp)
                    .weight(1f)
            )

            val context = LocalContext.current

            var isClicked = false

            Icon(
                imageVector = Icons.Default.CopyAll,
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .clickable{
                        if(!isClicked){
                            val clipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                            val clipData: ClipData = ClipData.newPlainText("email", email)
                            clipboardManager.setPrimaryClip(clipData)
                            isClicked = true
                        }
                    },
                tint = titlesColor
            )
        }

        Row(
            modifier = Modifier
                .padding(top = 5.dp, bottom = 15.dp,start = 20.dp , end = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                imageVector = Icons.Default.Code,
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp),
                tint = titlesColor
            )

            Text(
                text = github,
                color = ValueColor,
                fontSize = with(density){16.dp.toSp()},
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(start = 5.dp, end = 5.dp)
                    .weight(1f)
            )

            val context = LocalContext.current

            var isClicked = false

            Icon(
                imageVector = Icons.Default.CopyAll,
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .clickable{
                        if(!isClicked){
                            val clipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                            val clipData: ClipData = ClipData.newPlainText("github", github)
                            clipboardManager.setPrimaryClip(clipData)
                            isClicked = true
                        }
                    },
                tint = titlesColor
            )
        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            onClick = {
                rotationClick()
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = CardBordersColor, contentColor = CardsBackGround)
        ) {
            Text(
                text = "Personal Info.",
                fontSize = with(density){18.dp.toSp()},
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(top = 5.dp, bottom = 5.dp)
            )
        }
    }
}