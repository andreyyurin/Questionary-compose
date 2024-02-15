@file:OptIn(ExperimentalGlideComposeApi::class)

package ru.sad.onboarding

import android.graphics.Color
import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import ru.sad.base.R
import ru.sad.base.base.ext.endOffsetForPage
import ru.sad.base.base.ext.offsetForPage
import ru.sad.base.composables.screen.CustomText
import ru.sad.base.composables.screen.CustomTextButton
import ru.sad.onboarding.model.OnBoardingScreenPage
import ru.sad.onboarding.model.OnboardingScreenAction
import ru.sad.onboarding.model.OnboardingScreenEvent
import ru.sad.onboarding.model.OnboardingScreenState
import kotlin.math.abs

private const val ONBOARDING_PAGES_COUNT = 4

@ExperimentalFoundationApi
@Composable
fun OnboardingScreenMain(
    navController: NavHostController,
    viewModel: OnboardingViewModel
) {
    val state = viewModel.state.collectAsState(initial = OnboardingScreenState.Content())
    val pagerState = rememberPagerState { ONBOARDING_PAGES_COUNT }
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp
    val screenWidth = configuration.screenWidthDp

    when (state.value) {
        is OnboardingScreenState.Content -> OnboardingScreen(
            pagerState = pagerState,
            screenHeight = screenHeight,
            screenWidth = screenWidth,
            onClickNext = {
                viewModel.onEvent(OnboardingScreenEvent.ClickNext(it))
            })
    }

    LaunchedEffect(true) {
        viewModel.action.collect { action ->
            when (action) {
                is OnboardingScreenAction.NavigateTo -> {
                    //  navController.navigate(route = action.route)
                }

                OnboardingScreenAction.NextPage -> {
                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(
    pagerState: PagerState,
    onClickNext: (OnBoardingScreenPage) -> Unit,
    screenHeight: Int,
    screenWidth: Int
) {
    HorizontalPager(
        beyondBoundsPageCount = ONBOARDING_PAGES_COUNT,
        pageSize = PageSize.Fixed(screenWidth.dp),
        modifier = Modifier
            .fillMaxWidth()
            .graphicsLayer {

            },
        state = pagerState
    ) { page ->
        when (page) {
            OnBoardingScreenPage.first.ordinal -> {
                OnboardingFirstPageScreen(
                    title = stringResource(id = ru.sad.onboarding.R.string.onboarding_splash_title_first),
                    description = stringResource(id = ru.sad.onboarding.R.string.onboarding_splash_description_first),
                    painter = ru.sad.onboarding.R.drawable.img_page_1,
                    buttonText = stringResource(id = ru.sad.onboarding.R.string.onboarding_splash_btn_first),
                    onClickNext = {
                        onClickNext.invoke(OnBoardingScreenPage.second)
                    },
                    offset = pagerState.offsetForPage(page)
                )
            }

            OnBoardingScreenPage.second.ordinal -> {
                OnboardingSecondPageScreen(
                    title = stringResource(id = ru.sad.onboarding.R.string.onboarding_splash_title_second),
                    description = stringResource(id = ru.sad.onboarding.R.string.onboarding_splash_description_second),
                    painter = ru.sad.onboarding.R.drawable.img_page_2,
                    buttonText = stringResource(id = ru.sad.onboarding.R.string.onboarding_splash_btn_second),
                    onClickNext = {
                        onClickNext.invoke(OnBoardingScreenPage.third)
                    },
                    offset = pagerState.offsetForPage(page)
                )
            }

            OnBoardingScreenPage.third.ordinal -> {
                OnboardingThirdPageScreen(
                    title = stringResource(id = ru.sad.onboarding.R.string.onboarding_splash_title_third),
                    description = stringResource(id = ru.sad.onboarding.R.string.onboarding_splash_description_third),
                    painter = ru.sad.onboarding.R.drawable.img_page_3,
                    hideImage = ru.sad.onboarding.R.drawable.img_page_3_part_1,
                    buttonText = stringResource(id = ru.sad.onboarding.R.string.onboarding_splash_btn_third),
                    onClickNext = {
                        onClickNext.invoke(OnBoardingScreenPage.fourth)
                    },
                    offset = pagerState.offsetForPage(page),
                    screenHeight = screenHeight
                )
            }

            OnBoardingScreenPage.fourth.ordinal -> {
                OnboardingFourthPageScreen(
                    title = stringResource(id = ru.sad.onboarding.R.string.onboarding_splash_title_fourth),
                    description = stringResource(id = ru.sad.onboarding.R.string.onboarding_splash_description_fourth),
                    painter = ru.sad.onboarding.R.drawable.img_page_4_part_2,
                    buttonText = stringResource(id = ru.sad.onboarding.R.string.onboarding_splash_btn_fourth),
                    onClickNext = {
                        onClickNext.invoke(OnBoardingScreenPage.end)
                    },
                    offset = pagerState.offsetForPage(page),
                    screenHeight = screenHeight
                )
            }

            else -> {

            }
        }
    }
}

@Composable
fun OnboardingFirstPageScreen(
    title: String,
    description: String,
    @DrawableRes painter: Int,
    buttonText: String,
    onClickNext: () -> Unit,
    offset: Float = 0.0f
) {
    ConstraintLayout(
        modifier = Modifier
            .background(androidx.compose.ui.graphics.Color.White)
            .fillMaxSize()
    ) {
        val (imageLogo, textTitle, textDescription, buttonContinue) = createRefs()

        val marginStartEnd = dimensionResource(id = R.dimen.size_16_dp)

        val currentOffset =
            if (offset >= 1.0) 1.0f else if (offset <= -1.0f) -1.0f else offset

        val calculatedMarginButton = calculateMargin(50, -100, currentOffset)
        val calculatedMarginTitle = calculateMargin(29, -100, currentOffset)

        CustomText(
            weight = FontWeight.ExtraBold,
            text = title,
            textSize = dimensionResource(id = R.dimen.size_34_sp).value.sp,
            modifier = Modifier.constrainAs(textTitle) {
                top.linkTo(parent.top, calculatedMarginTitle)
                start.linkTo(
                    parent.start,
                    margin = marginStartEnd
                )
                end.linkTo(
                    parent.end,
                    margin = marginStartEnd
                )
                width = Dimension.wrapContent
            }
        )

        CustomText(
            weight = FontWeight.ExtraBold,
            text = description,
            textSize = dimensionResource(id = R.dimen.size_17_sp).value.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.constrainAs(textDescription) {
                top.linkTo(textTitle.bottom)
                start.linkTo(
                    parent.start,
                    margin = marginStartEnd
                )
                end.linkTo(
                    parent.end,
                    margin = marginStartEnd
                )
                width = Dimension.fillToConstraints
            }
        )

        GlideImage(
            model = painter,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .constrainAs(imageLogo) {
                    top.linkTo(textDescription.bottom)
                    bottom.linkTo(buttonContinue.top)
                    start.linkTo(
                        parent.start
                    )
                    end.linkTo(
                        parent.end
                    )
                    height = Dimension.fillToConstraints
                }
                .fillMaxWidth(),
        )

        CustomTextButton(
            onClick = { onClickNext.invoke() },
            text = buttonText,
            textSize = dimensionResource(id = R.dimen.size_14_sp).value.sp,
            modifier = Modifier
                .constrainAs(
                    buttonContinue
                ) {
                    bottom.linkTo(parent.bottom, calculatedMarginButton)
                    start.linkTo(
                        parent.start,
                        margin = marginStartEnd
                    )
                    end.linkTo(
                        parent.end,
                        margin = marginStartEnd
                    )
                    width = Dimension.fillToConstraints
                }
        )
    }
}

@Composable
fun OnboardingSecondPageScreen(
    title: String,
    description: String,
    @DrawableRes painter: Int,
    buttonText: String,
    onClickNext: () -> Unit,
    offset: Float = 0.0f
) {
    ConstraintLayout(
        modifier = Modifier
            .background(androidx.compose.ui.graphics.Color.White)
            .fillMaxSize()
    ) {
        val (imageLogo, textTitle, textDescription, buttonContinue) = createRefs()

        val marginStartEnd = dimensionResource(id = R.dimen.size_16_dp)

        val currentOffset =
            if (offset >= 1.0) 1.0f else if (offset <= -1.0f) -1.0f else offset

        val calculatedMarginButton = calculateMargin(50, -100, currentOffset)
        val calculatedMarginTitle = calculateMargin(29, -100, currentOffset)

        CustomText(
            weight = FontWeight.ExtraBold,
            text = title,
            textSize = dimensionResource(id = R.dimen.size_34_sp).value.sp,
            modifier = Modifier.constrainAs(textTitle) {
                top.linkTo(parent.top, calculatedMarginTitle)
                start.linkTo(
                    parent.start,
                    margin = marginStartEnd
                )
                end.linkTo(
                    parent.end,
                    margin = marginStartEnd
                )
                width = Dimension.wrapContent
            }
        )

        CustomText(
            weight = FontWeight.ExtraBold,
            text = description,
            textSize = dimensionResource(id = R.dimen.size_17_sp).value.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.constrainAs(textDescription) {
                top.linkTo(textTitle.bottom)
                start.linkTo(
                    parent.start,
                    margin = marginStartEnd
                )
                end.linkTo(
                    parent.end,
                    margin = marginStartEnd
                )
                width = Dimension.fillToConstraints
            }
        )

        GlideImage(
            model = painter,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .constrainAs(imageLogo) {
                    top.linkTo(textDescription.bottom)
                    bottom.linkTo(buttonContinue.top)
                    start.linkTo(
                        parent.start
                    )
                    end.linkTo(
                        parent.end
                    )
                    height = Dimension.fillToConstraints
                }
                .fillMaxWidth(),
        )

        CustomTextButton(
            onClick = { onClickNext.invoke() },
            text = buttonText,
            textSize = dimensionResource(id = R.dimen.size_14_sp).value.sp,
            modifier = Modifier
                .constrainAs(
                    buttonContinue
                ) {
                    bottom.linkTo(parent.bottom, calculatedMarginButton)
                    start.linkTo(
                        parent.start,
                        margin = marginStartEnd
                    )
                    end.linkTo(
                        parent.end,
                        margin = marginStartEnd
                    )
                    width = Dimension.fillToConstraints
                }
        )
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun OnboardingThirdPageScreen(
    title: String,
    description: String,
    painter: Int,
    @DrawableRes
    hideImage: Int,
    buttonText: String,
    onClickNext: () -> Unit,
    offset: Float = 0.0f,
    screenHeight: Int
) {
    ConstraintLayout(
        modifier = Modifier
            .background(androidx.compose.ui.graphics.Color.White)
            .fillMaxSize()
    ) {
        val (imageLogo, textTitle, textDescription, buttonContinue, imageHided) = createRefs()

        val marginStartEnd = dimensionResource(id = R.dimen.size_16_dp)

        val currentOffset =
            if (offset >= 1.0) 1.0f else if (offset <= -1.0f) -1.0f else offset

        val calculatedMarginButton = calculateMargin(50, -100, currentOffset)
        val calculatedMarginHideImage = calculateMargin(screenHeight, 0, -currentOffset)
        val marginTop29 = dimensionResource(id = R.dimen.size_29_dp)

        CustomText(
            weight = FontWeight.ExtraBold,
            text = title,
            textSize = dimensionResource(id = R.dimen.size_34_sp).value.sp,
            modifier = Modifier.constrainAs(textTitle) {
                top.linkTo(parent.top, marginTop29)
                start.linkTo(
                    parent.start,
                    margin = marginStartEnd
                )
                end.linkTo(
                    parent.end,
                    margin = marginStartEnd
                )
                width = Dimension.wrapContent
            }
        )

        CustomText(
            weight = FontWeight.ExtraBold,
            text = description,
            textSize = dimensionResource(id = R.dimen.size_17_sp).value.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.constrainAs(textDescription) {
                top.linkTo(textTitle.bottom)
                start.linkTo(
                    parent.start,
                    margin = marginStartEnd
                )
                end.linkTo(
                    parent.end,
                    margin = marginStartEnd
                )
                width = Dimension.fillToConstraints
            }
        )

        GlideImage(
            model = painter,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .constrainAs(imageLogo) {
                    top.linkTo(textDescription.bottom)
                    bottom.linkTo(buttonContinue.top)
                    start.linkTo(
                        parent.start
                    )
                    end.linkTo(
                        parent.end
                    )
                    height = Dimension.fillToConstraints
                }
                .fillMaxWidth(),
        )

        CustomTextButton(
            onClick = { onClickNext.invoke() },
            text = buttonText,
            textSize = dimensionResource(id = R.dimen.size_14_sp).value.sp,
            modifier = Modifier
                .constrainAs(
                    buttonContinue
                ) {
                    bottom.linkTo(parent.bottom, calculatedMarginButton)
                    start.linkTo(
                        parent.start,
                        margin = marginStartEnd
                    )
                    end.linkTo(
                        parent.end,
                        margin = marginStartEnd
                    )
                    width = Dimension.fillToConstraints
                }
        )

        GlideImage(
            model = hideImage,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .constrainAs(imageHided) {
                    top.linkTo(textDescription.bottom, calculatedMarginHideImage)
                    start.linkTo(
                        parent.start
                    )
                    end.linkTo(
                        parent.end
                    )
                    width = Dimension.fillToConstraints
                }
                .fillMaxWidth(),
        )


    }
}


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun OnboardingFourthPageScreen(
    title: String,
    description: String,
    @DrawableRes painter: Int,
    buttonText: String,
    onClickNext: () -> Unit,
    offset: Float = 0.0f,
    screenHeight: Int
) {
    ConstraintLayout(
        modifier = Modifier
            .background(androidx.compose.ui.graphics.Color.White)
            .fillMaxSize()
    ) {
        val (imageLogo, textTitle, textDescription, buttonContinue) = createRefs()

        val marginStartEnd = dimensionResource(id = R.dimen.size_16_dp)
        val marginTop29 = dimensionResource(id = R.dimen.size_29_dp)
        val marginBottom50 = dimensionResource(id = R.dimen.size_50_dp)

        val currentOffset =
            if (offset >= 1.0) 1.0f else if (offset <= -1.0f) -1.0f else offset

        val calculatedMarginImage = calculateMarginWithoutAbs(0, -screenHeight, currentOffset)

        CustomText(
            weight = FontWeight.ExtraBold,
            text = title,
            textSize = dimensionResource(id = R.dimen.size_34_sp).value.sp,
            modifier = Modifier.constrainAs(textTitle) {
                top.linkTo(parent.top, marginTop29)
                start.linkTo(
                    parent.start,
                    margin = marginStartEnd
                )
                end.linkTo(
                    parent.end,
                    margin = marginStartEnd
                )
                width = Dimension.wrapContent
            }
        )

        CustomText(
            weight = FontWeight.ExtraBold,
            text = description,
            textSize = dimensionResource(id = R.dimen.size_17_sp).value.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.constrainAs(textDescription) {
                top.linkTo(textTitle.bottom)
                start.linkTo(
                    parent.start,
                    margin = marginStartEnd
                )
                end.linkTo(
                    parent.end,
                    margin = marginStartEnd
                )
                width = Dimension.fillToConstraints
            }
        )

        GlideImage(
            model = painter,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .constrainAs(imageLogo) {
                    top.linkTo(textDescription.bottom, calculatedMarginImage)
                    start.linkTo(
                        parent.start
                    )
                    end.linkTo(
                        parent.end
                    )
                    width = Dimension.matchParent
                }
                .fillMaxWidth(),
        )

        CustomTextButton(
            onClick = { onClickNext.invoke() },
            text = buttonText,
            textSize = dimensionResource(id = R.dimen.size_14_sp).value.sp,
            modifier = Modifier
                .constrainAs(
                    buttonContinue
                ) {
                    bottom.linkTo(parent.bottom, marginBottom50)
                    start.linkTo(
                        parent.start,
                        margin = marginStartEnd
                    )
                    end.linkTo(
                        parent.end,
                        margin = marginStartEnd
                    )
                    width = Dimension.fillToConstraints
                }
        )
    }
}

private fun calculateMargin(maxMargin: Int, minMargin: Int, currentOffset: Float): Dp {
    val percentDifference = (maxMargin - minMargin) * abs(currentOffset)
    val margin = maxMargin - percentDifference
    return margin.dp
}

private fun calculateMarginWithoutAbs(maxMargin: Int, minMargin: Int, currentOffset: Float): Dp {
    val percentDifference = (maxMargin - minMargin) * (currentOffset)
    val margin = maxMargin - percentDifference
    return margin.dp
}