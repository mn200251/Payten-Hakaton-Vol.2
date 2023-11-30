package com.example.mojkonobar.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp


@Composable
fun rememberCoffee2(): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "coffee",
            defaultWidth = 40.0.dp,
            defaultHeight = 40.0.dp,
            viewportWidth = 40.0f,
            viewportHeight = 40.0f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1f,
                stroke = null,
                strokeAlpha = 1f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(18.375f, 28.25f)
                quadToRelative(-3.917f, 0f, -6.708f, -2.729f)
                quadToRelative(-2.792f, -2.729f, -2.792f, -6.646f)
                verticalLineTo(8.208f)
                quadToRelative(0f, -0.375f, 0.313f, -0.687f)
                quadToRelative(0.312f, -0.313f, 0.687f, -0.313f)
                horizontalLineToRelative(19.25f)
                quadToRelative(1.625f, 0f, 2.75f, 1.146f)
                reflectiveQuadTo(33f, 11.125f)
                quadToRelative(0f, 1.583f, -1.125f, 2.708f)
                quadToRelative(-1.125f, 1.125f, -2.75f, 1.125f)
                horizontalLineToRelative(-1.292f)
                verticalLineToRelative(3.917f)
                quadToRelative(0f, 3.917f, -2.791f, 6.646f)
                quadToRelative(-2.792f, 2.729f, -6.667f, 2.729f)
                close()
                moveTo(9.875f, 14f)
                horizontalLineToRelative(16.958f)
                verticalLineTo(8.208f)
                horizontalLineTo(9.875f)
                close()
                moveToRelative(8.458f, 13.292f)
                quadToRelative(3.542f, 0f, 6.021f, -2.48f)
                quadToRelative(2.479f, -2.479f, 2.479f, -5.937f)
                verticalLineToRelative(-3.917f)
                horizontalLineTo(9.875f)
                verticalLineToRelative(3.917f)
                quadToRelative(0f, 3.458f, 2.479f, 5.937f)
                quadToRelative(2.479f, 2.48f, 5.979f, 2.48f)
                close()
                moveTo(27.833f, 14f)
                horizontalLineToRelative(1.292f)
                quadToRelative(1.25f, 0f, 2.083f, -0.833f)
                quadToRelative(0.834f, -0.834f, 0.834f, -2.084f)
                quadToRelative(0f, -1.208f, -0.854f, -2.041f)
                quadToRelative(-0.855f, -0.834f, -2.063f, -0.834f)
                horizontalLineToRelative(-1.292f)
                close()
                moveTo(9.375f, 32.792f)
                quadToRelative(-0.208f, 0f, -0.354f, -0.146f)
                reflectiveQuadToRelative(-0.146f, -0.354f)
                quadToRelative(0f, -0.209f, 0.146f, -0.354f)
                quadToRelative(0.146f, -0.146f, 0.354f, -0.146f)
                horizontalLineToRelative(20.042f)
                quadToRelative(0.166f, 0f, 0.312f, 0.146f)
                quadToRelative(0.146f, 0.145f, 0.146f, 0.354f)
                quadToRelative(0f, 0.208f, -0.146f, 0.354f)
                reflectiveQuadToRelative(-0.312f, 0.146f)
                close()
                moveToRelative(9f, -17.834f)
                close()
            }
        }.build()
    }
}

@Composable
fun rememberFastfood(): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "fastfood",
            defaultWidth = 40.0.dp,
            defaultHeight = 40.0.dp,
            viewportWidth = 40.0f,
            viewportHeight = 40.0f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1f,
                stroke = null,
                strokeAlpha = 1f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(3.375f, 26.708f)
                quadToRelative(-0.583f, 0f, -0.937f, -0.396f)
                quadToRelative(-0.355f, -0.395f, -0.271f, -0.895f)
                quadToRelative(0.5f, -3.667f, 3.645f, -5.896f)
                quadToRelative(3.146f, -2.229f, 8.646f, -2.229f)
                quadToRelative(5.459f, 0f, 8.604f, 2.229f)
                quadToRelative(3.146f, 2.229f, 3.688f, 5.896f)
                quadToRelative(0.083f, 0.5f, -0.292f, 0.895f)
                quadToRelative(-0.375f, 0.396f, -0.916f, 0.396f)
                close()
                moveToRelative(26.083f, 11.334f)
                verticalLineToRelative(-2.625f)
                horizontalLineToRelative(3.25f)
                lineToRelative(2.334f, -23.625f)
                horizontalLineTo(18.917f)
                lineToRelative(-0.167f, -1.209f)
                quadToRelative(-0.042f, -0.583f, 0.354f, -1f)
                quadToRelative(0.396f, -0.416f, 0.979f, -0.416f)
                horizontalLineToRelative(6.875f)
                verticalLineTo(3.292f)
                quadToRelative(0f, -0.5f, 0.375f, -0.896f)
                reflectiveQuadTo(28.25f, 2f)
                quadToRelative(0.583f, 0f, 0.958f, 0.396f)
                reflectiveQuadToRelative(0.375f, 0.896f)
                verticalLineToRelative(5.875f)
                horizontalLineToRelative(7.042f)
                quadToRelative(0.583f, 0f, 0.979f, 0.416f)
                quadToRelative(0.396f, 0.417f, 0.313f, 1f)
                lineToRelative(-2.584f, 25.042f)
                quadToRelative(-0.125f, 1.042f, -0.895f, 1.729f)
                quadToRelative(-0.771f, 0.688f, -1.896f, 0.688f)
                close()
                moveToRelative(0f, -2.625f)
                horizontalLineToRelative(3.25f)
                horizontalLineToRelative(-3.25f)
                close()
                moveToRelative(-6f, -11.334f)
                quadToRelative(-0.875f, -1.916f, -3.166f, -3.041f)
                quadToRelative(-2.292f, -1.125f, -5.917f, -1.125f)
                quadToRelative(-3.583f, 0f, -5.875f, 1.125f)
                reflectiveQuadToRelative(-3.208f, 3.041f)
                close()
                moveToRelative(-9.083f, 0f)
                close()
                moveTo(3.333f, 32.25f)
                quadToRelative(-0.583f, 0f, -0.958f, -0.375f)
                reflectiveQuadTo(2f, 30.958f)
                quadToRelative(0f, -0.583f, 0.375f, -0.958f)
                reflectiveQuadToRelative(0.958f, -0.375f)
                horizontalLineToRelative(22.125f)
                quadToRelative(0.542f, 0f, 0.938f, 0.375f)
                quadToRelative(0.396f, 0.375f, 0.396f, 0.958f)
                quadToRelative(0f, 0.542f, -0.396f, 0.917f)
                reflectiveQuadToRelative(-0.938f, 0.375f)
                close()
                moveToRelative(0f, 5.792f)
                quadToRelative(-0.583f, 0f, -0.958f, -0.375f)
                reflectiveQuadTo(2f, 36.75f)
                quadToRelative(0f, -0.583f, 0.375f, -0.958f)
                reflectiveQuadToRelative(0.958f, -0.375f)
                horizontalLineToRelative(22.125f)
                quadToRelative(0.542f, 0f, 0.938f, 0.395f)
                quadToRelative(0.396f, 0.396f, 0.396f, 0.938f)
                quadToRelative(0f, 0.542f, -0.396f, 0.917f)
                reflectiveQuadToRelative(-0.938f, 0.375f)
                close()
            }
        }.build()
    }
}


@Composable
fun rememberFoodBank(): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "food_bank",
            defaultWidth = 40.0.dp,
            defaultHeight = 40.0.dp,
            viewportWidth = 40.0f,
            viewportHeight = 40.0f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1f,
                stroke = null,
                strokeAlpha = 1f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(9.542f, 34.75f)
                quadToRelative(-1.084f, 0f, -1.855f, -0.771f)
                quadToRelative(-0.77f, -0.771f, -0.77f, -1.854f)
                verticalLineTo(16.417f)
                quadToRelative(0f, -0.625f, 0.271f, -1.188f)
                quadToRelative(0.27f, -0.562f, 0.77f, -0.937f)
                lineToRelative(10.459f, -7.834f)
                quadToRelative(0.708f, -0.5f, 1.583f, -0.5f)
                reflectiveQuadToRelative(1.583f, 0.5f)
                lineToRelative(10.459f, 7.834f)
                quadToRelative(0.5f, 0.375f, 0.77f, 0.937f)
                quadToRelative(0.271f, 0.563f, 0.271f, 1.188f)
                verticalLineToRelative(15.708f)
                quadToRelative(0f, 1.083f, -0.771f, 1.854f)
                quadToRelative(-0.77f, 0.771f, -1.854f, 0.771f)
                close()
                moveToRelative(0f, -2.625f)
                horizontalLineToRelative(20.916f)
                verticalLineTo(16.417f)
                lineTo(20f, 8.583f)
                lineTo(9.542f, 16.417f)
                close()
                moveToRelative(7.166f, -8.833f)
                verticalLineToRelative(5.791f)
                quadToRelative(0f, 0.334f, 0.25f, 0.563f)
                quadToRelative(0.25f, 0.229f, 0.584f, 0.229f)
                quadToRelative(0.333f, 0f, 0.583f, -0.25f)
                quadToRelative(0.25f, -0.25f, 0.25f, -0.583f)
                verticalLineToRelative(-5.709f)
                quadToRelative(1f, 0f, 1.729f, -0.729f)
                quadToRelative(0.729f, -0.729f, 0.729f, -1.729f)
                verticalLineTo(16.75f)
                quadToRelative(0f, -0.292f, -0.25f, -0.542f)
                quadToRelative(-0.25f, -0.25f, -0.583f, -0.25f)
                quadToRelative(-0.333f, 0f, -0.562f, 0.25f)
                quadToRelative(-0.23f, 0.25f, -0.23f, 0.542f)
                verticalLineToRelative(4.125f)
                horizontalLineToRelative(-0.833f)
                verticalLineTo(16.75f)
                quadToRelative(0f, -0.292f, -0.25f, -0.542f)
                quadToRelative(-0.25f, -0.25f, -0.583f, -0.25f)
                quadToRelative(-0.334f, 0f, -0.584f, 0.25f)
                quadToRelative(-0.25f, 0.25f, -0.25f, 0.542f)
                verticalLineToRelative(4.125f)
                horizontalLineToRelative(-0.791f)
                verticalLineTo(16.75f)
                quadToRelative(0f, -0.292f, -0.25f, -0.542f)
                quadToRelative(-0.25f, -0.25f, -0.584f, -0.25f)
                quadToRelative(-0.333f, 0f, -0.583f, 0.25f)
                quadToRelative(-0.25f, 0.25f, -0.25f, 0.542f)
                verticalLineToRelative(4.125f)
                quadToRelative(0f, 1f, 0.729f, 1.708f)
                quadToRelative(0.729f, 0.709f, 1.729f, 0.709f)
                close()
                moveToRelative(7.417f, 6.583f)
                quadToRelative(0.292f, 0f, 0.542f, -0.25f)
                quadToRelative(0.25f, -0.25f, 0.25f, -0.583f)
                verticalLineTo(16.625f)
                quadToRelative(0f, -0.25f, -0.188f, -0.437f)
                quadTo(24.542f, 16f, 24.25f, 16f)
                quadToRelative(-1.167f, 0f, -1.896f, 0.979f)
                quadToRelative(-0.729f, 0.979f, -0.729f, 2.271f)
                verticalLineToRelative(4.25f)
                quadToRelative(0f, 0.25f, 0.208f, 0.438f)
                quadToRelative(0.209f, 0.187f, 0.459f, 0.187f)
                horizontalLineToRelative(1f)
                verticalLineToRelative(4.958f)
                quadToRelative(0f, 0.334f, 0.229f, 0.563f)
                quadToRelative(0.229f, 0.229f, 0.604f, 0.229f)
                close()
                moveToRelative(-14.583f, 2.25f)
                horizontalLineToRelative(20.916f)
                horizontalLineTo(9.542f)
                close()
            }
        }.build()
    }
}


@Composable
fun rememberCoffee(): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "coffee",
            defaultWidth = 40.0.dp,
            defaultHeight = 40.0.dp,
            viewportWidth = 40.0f,
            viewportHeight = 40.0f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1f,
                stroke = null,
                strokeAlpha = 1f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(18.417f, 29.75f)
                quadToRelative(-4.709f, 0f, -8.105f, -3.333f)
                quadToRelative(-3.395f, -3.334f, -3.395f, -7.959f)
                verticalLineTo(7.875f)
                quadToRelative(0f, -1.042f, 0.791f, -1.833f)
                quadToRelative(0.792f, -0.792f, 1.834f, -0.792f)
                horizontalLineToRelative(21.333f)
                quadToRelative(2.25f, 0f, 3.854f, 1.562f)
                quadToRelative(1.604f, 1.563f, 1.604f, 3.813f)
                reflectiveQuadToRelative(-1.604f, 3.792f)
                quadToRelative(-1.604f, 1.541f, -3.854f, 1.541f)
                horizontalLineToRelative(-0.958f)
                verticalLineToRelative(2.5f)
                quadToRelative(0f, 4.625f, -3.396f, 7.959f)
                quadToRelative(-3.396f, 3.333f, -8.104f, 3.333f)
                close()
                moveTo(9.542f, 13.333f)
                horizontalLineToRelative(17.75f)
                verticalLineTo(7.875f)
                horizontalLineTo(9.542f)
                close()
                moveToRelative(8.875f, 13.792f)
                quadToRelative(3.666f, 0f, 6.271f, -2.563f)
                quadToRelative(2.604f, -2.562f, 2.604f, -6.104f)
                verticalLineToRelative(-2.5f)
                horizontalLineTo(9.542f)
                verticalLineToRelative(2.5f)
                quadToRelative(0f, 3.542f, 2.604f, 6.104f)
                quadToRelative(2.604f, 2.563f, 6.271f, 2.563f)
                close()
                moveToRelative(11.5f, -13.792f)
                horizontalLineToRelative(0.958f)
                quadToRelative(1.167f, 0f, 2f, -0.791f)
                quadToRelative(0.833f, -0.792f, 0.833f, -1.917f)
                quadToRelative(0f, -1.167f, -0.833f, -1.958f)
                quadToRelative(-0.833f, -0.792f, -2f, -0.792f)
                horizontalLineToRelative(-0.958f)
                close()
                moveTo(8.25f, 34.75f)
                quadToRelative(-0.583f, 0f, -0.958f, -0.396f)
                reflectiveQuadToRelative(-0.375f, -0.937f)
                quadToRelative(0f, -0.542f, 0.375f, -0.917f)
                reflectiveQuadToRelative(0.958f, -0.375f)
                horizontalLineToRelative(23.333f)
                quadToRelative(0.542f, 0f, 0.917f, 0.375f)
                reflectiveQuadToRelative(0.375f, 0.917f)
                quadToRelative(0f, 0.583f, -0.375f, 0.958f)
                reflectiveQuadToRelative(-0.917f, 0.375f)
                close()
                moveToRelative(10.167f, -18.792f)
                close()
            }
        }.build()
    }
}


@Composable
fun rememberLocalPizza(): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "local_pizza",
            defaultWidth = 40.0.dp,
            defaultHeight = 40.0.dp,
            viewportWidth = 40.0f,
            viewportHeight = 40.0f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1f,
                stroke = null,
                strokeAlpha = 1f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(20f, 34.125f)
                quadToRelative(-0.625f, 0f, -1.208f, -0.292f)
                quadToRelative(-0.584f, -0.291f, -1f, -0.875f)
                lineTo(5.125f, 13.833f)
                quadToRelative(-0.625f, -0.958f, -0.437f, -2.083f)
                quadToRelative(0.187f, -1.125f, 1.062f, -1.75f)
                quadToRelative(3.167f, -2.208f, 6.771f, -3.479f)
                reflectiveQuadTo(20f, 5.25f)
                quadToRelative(3.875f, 0f, 7.5f, 1.271f)
                reflectiveQuadTo(34.292f, 10f)
                quadToRelative(0.875f, 0.625f, 1.041f, 1.75f)
                quadToRelative(0.167f, 1.125f, -0.416f, 2.042f)
                lineTo(22.208f, 32.958f)
                quadToRelative(-0.416f, 0.584f, -1f, 0.875f)
                quadToRelative(-0.583f, 0.292f, -1.208f, 0.292f)
                close()
                moveToRelative(0f, -2.583f)
                lineToRelative(12.875f, -19.334f)
                quadToRelative(-2.917f, -1.875f, -6.167f, -3.104f)
                reflectiveQuadTo(20f, 7.875f)
                quadToRelative(-3.458f, 0f, -6.708f, 1.229f)
                reflectiveQuadToRelative(-6.125f, 3.104f)
                close()
                moveTo(15.542f, 16.5f)
                quadToRelative(0.958f, 0f, 1.625f, -0.667f)
                quadToRelative(0.666f, -0.666f, 0.666f, -1.625f)
                quadToRelative(0f, -0.958f, -0.666f, -1.625f)
                quadToRelative(-0.667f, -0.666f, -1.625f, -0.666f)
                quadToRelative(-1f, 0f, -1.667f, 0.666f)
                quadToRelative(-0.667f, 0.667f, -0.667f, 1.625f)
                quadToRelative(0f, 0.959f, 0.667f, 1.625f)
                quadToRelative(0.667f, 0.667f, 1.667f, 0.667f)
                close()
                moveToRelative(4.5f, 8.667f)
                quadToRelative(0.958f, 0f, 1.625f, -0.667f)
                quadToRelative(0.666f, -0.667f, 0.666f, -1.625f)
                quadToRelative(0f, -1f, -0.666f, -1.667f)
                quadToRelative(-0.667f, -0.666f, -1.625f, -0.666f)
                quadToRelative(-1f, 0f, -1.667f, 0.666f)
                quadToRelative(-0.667f, 0.667f, -0.667f, 1.667f)
                quadToRelative(0f, 0.958f, 0.667f, 1.625f)
                reflectiveQuadToRelative(1.667f, 0.667f)
                close()
                moveToRelative(0f, -5.459f)
                close()
            }
        }.build()
    }
}