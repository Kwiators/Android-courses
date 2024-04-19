package com.example.businesscardapp

import androidx.compose.ui.graphics.Color
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFF7C566)
                ) {
                    BuissnesCardComposable()
                }
            }
        }
    }
}


@Composable
fun BuissnesCardComposable(){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        MainPart(
            name = stringResource(id = R.string.name),
            title = stringResource(id = R.string.title),
            icon = painterResource(id = R.drawable.andro)
        )
        ContactPart(
            number = stringResource(id = R.string.phone_number),
            url = stringResource(id = R.string.github_url),
            email = stringResource(id = R.string.email),
            phoneIcon = painterResource(id = R.drawable.baseline_call_24),
            gitIcon = painterResource(id = R.drawable.baseline_folder_24),
            emailIcon = painterResource(id = R.drawable.baseline_email_24)
        )
    }
}




@Composable
fun MainPart(
    name: String,
    title: String,
    icon: Painter,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 40.dp )
    ) {
        Image(
            painter = icon,
            contentDescription = null,
            Modifier
//                .background(Color(0xFF141E46))
        )
            Text(
                text = name,
                modifier.padding(top = 15.dp, bottom = 2.dp),
                textAlign = TextAlign.Center,
                fontSize = 38.sp,
                fontWeight = FontWeight.Bold
            )
        Text(
            text = title,
            modifier,
            fontSize = 30.sp,
            fontWeight = FontWeight(460)
        )
    }
}


@Composable
fun ContactPart(
    number: String,
    url: String,
    email: String,
    phoneIcon: Painter,
    gitIcon: Painter,
    emailIcon: Painter,
    modifier: Modifier = Modifier
){
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 160.dp)

        ) {
            Icon(painter = phoneIcon, contentDescription = null, tint = Color.Unspecified)
            Text(
                text = number,
                modifier.padding(start = 3.dp),
                fontSize = 25.sp,
                fontWeight = FontWeight(440)

            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 5.dp)

        ) {
            Icon(painter = gitIcon, contentDescription = null, tint = Color.Unspecified)
            Text(
                text = url,
                modifier.padding(start = 3.dp),
                fontSize = 25.sp,
                fontWeight = FontWeight(440)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 5.dp)

        ) {
            Icon(painter = emailIcon, contentDescription = null, tint = Color.Unspecified)
            Text(
                text = email,
                modifier.padding(start = 3.dp),
                fontSize = 22.sp,
                fontWeight = FontWeight(440)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFF7C566)
        ) {
            BuissnesCardComposable()
        }
    }
}