package com.example.rewardapp.ui

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class RewardViewModelTest {

    private val testDispatcher = UnconfinedTestDispatcher()
    private lateinit var viewModel: RewardViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        viewModel = RewardViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `initial uiState contains correct title, description and share button text`() {
        val state = viewModel.uiState.value
        assertEquals("#1", state.badgeText)
        assertEquals("Custom Challenges Make It Your Own", state.title)
        assertEquals("Set personalized goals and watch your savings grow.", state.description)
        assertEquals("Share", state.shareButtonText)
    }

    @Test
    fun `onShareClicked emits ShareContent event with title and description`() = runTest {
        var receivedEvent: RewardUiEvent? = null
        val job = backgroundScope.launch(testDispatcher) {
            receivedEvent = viewModel.uiEvent.first()
        }

        viewModel.onShareClicked()

        assertTrue(receivedEvent is RewardUiEvent.ShareContent)
        val shareEvent = receivedEvent as RewardUiEvent.ShareContent
        assertEquals("Custom Challenges Make It Your Own", shareEvent.title)
        assertEquals("Custom Challenges Make It Your Own\nSet personalized goals and watch your savings grow.", shareEvent.text)

        job.cancel()
    }
}
