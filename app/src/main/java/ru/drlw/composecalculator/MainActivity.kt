package ru.drlw.composecalculator

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.objecthunter.exp4j.ExpressionBuilder
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
                    val message = remember { mutableStateOf("0") }
                    Column {
                        Card(
                            Modifier
                                .fillMaxWidth()
                                .weight(1f)
                                .padding(start = 10.dp, end = 10.dp),
                            shape = RoundedCornerShape(32.dp)
                        ) {
                            Greeting(message.value, modifier = Modifier)
                        }
                        ButtonsField(modifier = Modifier.weight(2f), message)
                    }

                }
            }
        }
    }
}

@Composable
fun ButtonsField(modifier: Modifier = Modifier, message: MutableState<String>) {
    Column(verticalArrangement = Arrangement.SpaceEvenly, modifier = modifier) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            OperationButton(operator = "(") {
                if (message.value == "0") {
                    message.value = "("
                } else {
                    if (message.value
                            .last()
                            .toString() in listOf("*", "-", "+", "/")
                    ) {
                        message.value += "("
                    }
                }
            }
            OperationButton(operator = ")") {
                if (message.value
                        .last()
                        .toString() !in listOf(
                        "-",
                        "+",
                        "/",
                        "(",
                        "*", "."
                    )
                ) message.value += ")"
            }
            DeleteLastButton(message)
            OperationButton(operator = "/") {
                if (message.value
                        .last()
                        .toString() !in listOf(
                        "-",
                        "+",
                        "/",
                        "%",
                        "*", "."
                    )
                ) message.value += "/"
            }
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            NumButton("7", message)
            NumButton("8", message)
            NumButton("9", message)
            OperationButton(operator = "*") {
                if (message.value
                        .last()
                        .toString() !in listOf(
                        "-",
                        "+",
                        "/",
                        "*", "."
                    )
                ) message.value += "*"
            }
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            NumButton("4", message)
            NumButton("5", message)
            NumButton("6", message)
            OperationButton(operator = "-") {
                if (message.value
                        .last()
                        .toString() !in listOf(
                        "-",
                        "+",
                        "/",
                        "*", "."
                    )
                ) message.value += "-"
            }
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            NumButton("1", message)
            NumButton("2", message)
            NumButton("3", message)
            OperationButton(operator = "+") {
                if (message.value
                        .last()
                        .toString() !in listOf(
                        "-",
                        "+",
                        "/",
                        "*", "."
                    )
                ) message.value += "+"
            }
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            NumButton("00", message)
            NumButton("0", message)
            OperationButton(operator = ".") {
                if (message.value
                        .last()
                        .toString() !in listOf(
                        "-",
                        "+",
                        "/",
                        "%",
                        "*", "."
                    )
                ) message.value += "."
            }
            EqualButton(message)
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
            text = text, fontSize = 40.sp, lineHeight = 32.sp
        )
    }
}

@Composable
fun OperationButton(
    operator: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .size(67.dp),
        shape = RoundedCornerShape(32.dp)
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .clickable(onClick = onClick),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = operator, fontSize = 32.sp)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DeleteLastButton(message: MutableState<String>) {
    Card(
        Modifier
            .height(67.dp)
            .width(67.dp),
        shape = RoundedCornerShape(32.dp)
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .combinedClickable(
                    onClick = {
                        if (message.value.length == 1) message.value = "0" else message.value =
                            message.value.dropLast(1)
                    },
                    onLongClick = { message.value = "0" }
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "X", fontSize = 32.sp)
        }
    }
}

@Composable
fun EqualButton(message: MutableState<String>) {
    val context = LocalContext.current
    val backgroundColor: Color = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        if (isSystemInDarkTheme()) {
            dynamicDarkColorScheme(context).primary
        } else {
            dynamicLightColorScheme(context).primary
        }
    } else {
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
                .clickable {
                    try {
                        if (message.value
                                .last()
                                .toString() !in listOf("*", "-", "/", ".", "+", "(")
                        ) {
                            val result = ExpressionBuilder(message.value)
                                .build()
                                .evaluate()
                            message.value = if (result % 1 == 0.0) {
                                result
                                    .toInt()
                                    .toString()
                            } else {
                                result.toString()
                            }
                        }
                    } catch (_: Exception) {

                    }
                },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "=", fontSize = 32.sp)
        }
    }
}

@Composable
fun NumButton(num: String, message: MutableState<String>) {
    Card(
        Modifier
            .height(67.dp)
            .width(67.dp),
        shape = RoundedCornerShape(32.dp)
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .clickable {
                    if (message.value == "0") message.value = num else message.value += num
                },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = num, fontSize = 32.sp)
        }
    }
}