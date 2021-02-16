package com.itgonca.exchangerateapp.common

/**
 * This class handles the current state of the UI
 * [Loading] It is the status that indicates that a task is loading
 * [Success] It is the status that indicates that a task has been completed successfully
 * [Error] It is the status that indicates that the task has suffered an exception
 */
sealed class StateUI<out T : Any> {
    object Loading : StateUI<Nothing>()
    data class Success<out T : Any>(val data: T) : StateUI<T>()
    data class Error(
        val type: Int,
        val title: String? = null,
        val message: String? = null,
        val exception: Throwable? = null
    ) : StateUI<Nothing>()
}