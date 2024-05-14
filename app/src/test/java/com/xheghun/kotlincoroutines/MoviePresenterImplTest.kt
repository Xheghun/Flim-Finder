package com.xheghun.kotlincoroutines

import android.util.Log
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.xheghun.kotlincoroutines.domain.repository.MovieRepository
import com.xheghun.kotlincoroutines.ui.movies.MoviesPresenterImpl
import com.xheghun.kotlincoroutines.ui.movies.MoviesView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.createTestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.powermock.api.mockito.PowerMockito
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(PowerMockRunner::class)
@PrepareForTest(Log::class)
class MoviePresenterImplTest {
    private val testDispatcher = UnconfinedTestDispatcher()
    private val testCoroutineScope = createTestCoroutineScope(testDispatcher)
    private val repository = mock<MovieRepository>()
    private val view = mock<MoviesView>()

    private val presenter by lazy { MoviesPresenterImpl(repository) }

    @Before
    fun setup() {
        PowerMockito.mockStatic(Log::class.java)
        Dispatchers.setMain(testDispatcher)

        presenter.setView(view)
    }

    @Test
    fun `test get data should show result on view`() = testCoroutineScope.runTest {
        //arrange
        whenever(repository.getMovies()).thenReturn(listOf())

        //act
        presenter.getData()
        advanceTimeBy(500)

        //assert
        verify(repository).getMovies()
        verify(view).showMovies(any())

    }
}