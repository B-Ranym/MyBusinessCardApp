package com.example.mybusinesscard

import com.example.mybusinesscard.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mybusinesscard.ui.theme.BusinessCardTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF073042)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.height(50.dp))

        // Logo and name section
        LogoAndNameSection()

        // Contact information
        ContactInformationSection()

        Spacer(modifier = Modifier.height(50.dp))
    }
}

@Composable
fun LogoAndNameSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id =R.drawable.android_logo),
            contentDescription = "Android Logo",
            modifier = Modifier.size(100.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Ranym BOUCHOUCHA",
            color = Color.White,
            fontSize = 32.sp
        )

        Text(
            text = "Software Developer ",
            color = Color(0xFF3ddc84),
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ContactInformationSection() {
    Column(
        modifier = Modifier.padding(bottom = 24.dp)
    ) {
        Divider(
            modifier = Modifier.padding(horizontal = 32.dp),
            color = Color.LightGray
        )

        ContactInfoItem(
            icon = Icons.Rounded.Phone,
            text = "+216 (22) 333 444"
        )

        ContactInfoItem(
            icon = Icons.Rounded.Share,
            text = "@ranymHandle"
        )

        ContactInfoItem(
            icon = Icons.Rounded.Email,
            text = "ranym@Handle.com"
        )
    }
}

@Composable
fun ContactInfoItem(icon: ImageVector, text: String) {
    Divider(
        modifier = Modifier.padding(horizontal = 32.dp),
        color = Color.LightGray
    )

    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF3ddc84),
            modifier = Modifier.padding(end = 16.dp)
        )

        Text(
            text = text,
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}
