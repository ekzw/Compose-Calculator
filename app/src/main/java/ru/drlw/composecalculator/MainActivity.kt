package ru.drlw.composecalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
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
    Button(
        onClick = { /*TODO*/ },
        Modifier
            .height(67.dp)
            .width(67.dp)
    ) {
        Text("AC")
    }
}

@Composable
fun PercentButton() {
    Button(
        onClick = { /*TODO*/ },
        Modifier
            .height(67.dp)
            .width(67.dp)
    ) {
        Text("%")
    }
}

@Composable
fun DeleteLastButton() {
    Button(
        onClick = { /*TODO*/ },
        Modifier
            .height(67.dp)
            .width(67.dp)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.baseline_close_24),
            contentDescription = null,
            Modifier.fillMaxSize()
        )
    }
}

@Composable
fun DivButton() {
    Button(
        onClick = { /*TODO*/ },
        Modifier
            .height(67.dp)
            .width(67.dp)
    ) {
        Text("/")
    }
}

@Composable
fun MulButton() {
    Button(
        onClick = { /*TODO*/ },
        Modifier
            .height(67.dp)
            .width(67.dp)
    ) {
        Text("*")
    }
}

@Composable
fun MinusButton() {
    Button(
        onClick = { /*TODO*/ },
        Modifier
            .height(67.dp)
            .width(67.dp)
    ) {
        Text("-")
    }
}

@Composable
fun PlusButton() {
    Button(
        onClick = { /*TODO*/ },
        Modifier
            .height(67.dp)
            .width(67.dp)
    ) {
        Text("+")
    }
}

@Composable
fun EqualButton() {
    Button(
        onClick = { /*TODO*/ },
        Modifier
            .height(67.dp)
            .width(67.dp)
    ) {
        Text("=")
    }
}

@Composable
fun DotButton() {
    Button(
        onClick = { /*TODO*/ },
        Modifier
            .height(67.dp)
            .width(67.dp)
    ) {
        Text(".")
    }
}

@Composable
fun NumButton(num: String) {
    Button(
        onClick = { /*TODO*/ },
        Modifier
            .height(67.dp)
            .width(67.dp)
    ) {
        Text(num)
    }
}