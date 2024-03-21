package ru.drlw.composecalculator

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.drlw.composecalculator.ui.theme.ComposeCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Card(
                            Modifier
                                .fillMaxWidth()
                                .weight(1f)
                                .padding(start = 10.dp, end = 10.dp),
                            shape = RoundedCornerShape(32.dp)
                        ) {
                            Greeting("Текст тут..", modifier = Modifier)
                        }
                        ButtonsField(modifier = Modifier.weight(2f))
                    }

                }
            }
        }
    }
}

@Composable
fun ButtonsField(modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.SpaceEvenly, modifier = modifier) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            ACButton()
            PercentButton()
            DeleteLastButton()
            DivButton()
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            NumButton("7")
            NumButton("8")
            NumButton("9")
            MulButton()
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            NumButton("4")
            NumButton("5")
            NumButton("6")
            MinusButton()
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            NumButton("1")
            NumButton("2")
            NumButton("3")
            PlusButton()
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            NumButton("00")
            NumButton("0")
            DotButton()
            EqualButton()
        }
    }
}


@Composable
fun Greeting(text: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 32.dp, bottom = 32.dp, start = 32.dp, end = 32.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text, fontSize = 40.sp
        )
    }
}

@Composable
fun ACButton() {
    Card(
        Modifier
            .height(67.dp)
            .width(67.dp),
        shape = RoundedCornerShape(32.dp)
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .clickable { },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "AC", fontSize = 32.sp)
        }
    }
}

@Composable
fun PercentButton() {
    Card(
        Modifier
            .height(67.dp)
            .width(67.dp),
        shape = RoundedCornerShape(32.dp)
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .clickable { },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "%", fontSize = 32.sp)
        }
    }
}

@Composable
fun DeleteLastButton() {
    Card(
        Modifier
            .height(67.dp)
            .width(67.dp),
        shape = RoundedCornerShape(32.dp)
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .clickable { },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "X", fontSize = 32.sp)
        }
    }
}

@Composable
fun DivButton() {
    Card(
        Modifier
            .height(67.dp)
            .width(67.dp),
        shape = RoundedCornerShape(32.dp)
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .clickable { },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "/", fontSize = 32.sp)
        }
    }
}

@Composable
fun MulButton() {
    Card(
        Modifier
            .height(67.dp)
            .width(67.dp),
        shape = RoundedCornerShape(32.dp)
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .clickable { },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "*", fontSize = 32.sp)
        }
    }
}

@Composable
fun MinusButton() {
    Card(
        Modifier
            .height(67.dp)
            .width(67.dp),
        shape = RoundedCornerShape(32.dp)
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .clickable { },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "-", fontSize = 32.sp)
        }
    }
}

@Composable
fun PlusButton() {
    Card(
        Modifier
            .height(67.dp)
            .width(67.dp),
        shape = RoundedCornerShape(32.dp)
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .clickable { },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "+", fontSize = 32.sp)
        }
    }
}

@Composable
fun EqualButton() {
    val context = LocalContext.current
    val backgroundColor: Color = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        if (isSystemInDarkTheme()) {
            dynamicDarkColorScheme(context).primary
        } else {
            dynamicLightColorScheme(context).primary
        }
    }else{
        MaterialTheme.colorScheme.primary
    }
    Card(
        Modifier
            .height(67.dp)
            .width(67.dp),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor,
        ),
        shape = RoundedCornerShape(32.dp)
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .clickable { },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "=", fontSize = 32.sp)
        }
    }
}

@Composable
fun DotButton() {
    Card(
        Modifier
            .height(67.dp)
            .width(67.dp),
        shape = RoundedCornerShape(32.dp)
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .clickable { },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = ".", fontSize = 32.sp)
        }
    }
}

@Composable
fun NumButton(num: String) {
    Card(
        Modifier
            .height(67.dp)
            .width(67.dp),
        shape = RoundedCornerShape(32.dp)
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .clickable { },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = num, fontSize = 32.sp)
        }
    }
}