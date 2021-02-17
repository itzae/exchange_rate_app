package com.itgonca.exchangerateapp.utils.extensions

import java.text.SimpleDateFormat
import java.util.*

/**
 * This method obtains the date specified in the [Date] object so that it can be returned in a String
 * @param isPastDays this flag is used to validate if a specific date will be converted and
 * calculated, in this case days past the current date
 * @param dateParam this object contains the date to convert
 * @return [String]
 */
fun getDate(isPastDays: Boolean = false, dateParam: Date? = null): String {
    val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)
    return if (isPastDays && dateParam != null)
        simpleDateFormat.format(dateParam)
    else
        simpleDateFormat.format(Date())
}

/**
 * This method calculates the days past to the current date
 * @param days are the days spent to calculate
 * @return [String]
 */
fun getDateByDays(days: Int): String {
    val calendar = Calendar.getInstance()
    calendar.add(Calendar.DAY_OF_YEAR, -days)
    return getDate(true, calendar.time)
}