package com.itgonca.exchangerateapp.features.home.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.itgonca.domain.model.Historical
import com.itgonca.domain.usescases.GetHistoricalUsesCase
import com.itgonca.exchangerateapp.common.StateUI
import com.itgonca.exchangerateapp.data.repository.FakeHistoricalRepository
import com.itgonca.exchangerateapp.util.TestCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner
import java.lang.RuntimeException

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    private lateinit var historicalUsesCase: GetHistoricalUsesCase

    private lateinit var viewModel: HomeViewModel

    @Mock
    private lateinit var historicalDataObserver: Observer<StateUI<List<Historical>>>

    @Before
    fun setUp(){
        historicalUsesCase = GetHistoricalUsesCase(FakeHistoricalRepository())
        viewModel = HomeViewModel(historicalUsesCase)
    }

    @Test
    fun getResponseFromServer200_whenFetch_returnSuccess() {
        testCoroutineRule.runBlockingTest {
            doReturn(emptyList<Historical>())
                .`when`(historicalUsesCase)
                .getHistorical("2021-02-14")
            viewModel.historicalData.observeForever(historicalDataObserver)
            verify(historicalUsesCase).getHistorical("2021-01-14")
            verify(historicalDataObserver).onChanged(StateUI.Error(1,RuntimeException("errorMessage").toString()))
            viewModel.historicalData.removeObserver(historicalDataObserver)
        }
    }

    @Test
    fun getResponseFromServerError_whenFetch_returnError(){
        testCoroutineRule.runBlockingTest {
            val errorMessage = "An error occurred while getting the data"
            doThrow(RuntimeException(errorMessage))
                .`when`(historicalUsesCase)
                .getHistorical("2021-02-14")
            viewModel.historicalData.observeForever(historicalDataObserver)
            verify(historicalUsesCase).getHistorical("2021-02-14")
            verify(historicalDataObserver).onChanged(StateUI.Error(1,RuntimeException(errorMessage).toString()))
            viewModel.historicalData.removeObserver(historicalDataObserver)

        }
    }
}