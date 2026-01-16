package com.domain.trending.stock.features.home.presentation.components.dashboard.components

import androidx.compose.animation.core.EaseInOutCubic
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.domain.trending.stock.R
import ir.ehsannarmani.compose_charts.LineChart
import ir.ehsannarmani.compose_charts.models.AnimationMode
import ir.ehsannarmani.compose_charts.models.DividerProperties
import ir.ehsannarmani.compose_charts.models.DotProperties
import ir.ehsannarmani.compose_charts.models.DrawStyle
import ir.ehsannarmani.compose_charts.models.GridProperties
import ir.ehsannarmani.compose_charts.models.LabelProperties
import ir.ehsannarmani.compose_charts.models.Line
import ir.ehsannarmani.compose_charts.models.StrokeStyle

@Composable
fun GraphicContentView()
{
    val values = listOf(100.0, 25.0, 75.0, 60.0, 25.0, 75.0)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 200.dp)
            .clip(shape = RoundedCornerShape(size = 12.dp))
            .border(
                width = 1.5.dp,
                color = colorResource(id = R.color.white_color),
                shape = RoundedCornerShape(size = 12.dp)
            )
            .padding(start = 12.dp, top = 12.dp, bottom = 12.dp, end = 12.dp),
    ) {
        LineChart(
            modifier = Modifier.fillMaxSize(),
            gridProperties = GridProperties(
                enabled = true,
                xAxisProperties = GridProperties.AxisProperties(
                    enabled = true,
                    style = StrokeStyle.Dashed(phase = 2f),
                    color = SolidColor(Color.Gray.copy(alpha = .3f)),
                    thickness = (.5).dp,
                    lineCount = 6
                ),
                yAxisProperties = GridProperties.AxisProperties(enabled = false)
            ),
            dividerProperties = DividerProperties(enabled = false),
            curvedEdges = false,
            labelProperties = LabelProperties(
                enabled = false,
                rotation = LabelProperties.Rotation(degree = 90f)
            ),
            data = remember {
                listOf(
                    Line(
                        values = values,
                        color = SolidColor(value = Color(0xFF53A4F5)),
                        firstGradientFillColor = Color(0xFF53A4F5).copy(alpha = .5f),
                        secondGradientFillColor = Color.Transparent,
                        strokeAnimationSpec = tween(2000, easing = EaseInOutCubic),
                        gradientAnimationDelay = 1000,
                        drawStyle = DrawStyle.Stroke(width = 2.dp),
                        dotProperties = DotProperties(
                            enabled = true,
                            color = SolidColor(Color(0xFF53A4F5)),
                            strokeWidth = 2.5.dp,
                            radius = 2.dp,
                            strokeColor = SolidColor(Color(0xFF53A4F5)),
                        ),
                        curvedEdges = true
                    )
                )
            },
            animationMode = AnimationMode.Together(delayBuilder = { it * 500L }),
        )
    }
}