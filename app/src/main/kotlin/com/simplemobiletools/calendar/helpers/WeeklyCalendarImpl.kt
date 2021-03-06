package com.simplemobiletools.calendar.helpers

import android.content.Context
import com.simplemobiletools.calendar.extensions.dbHelper
import com.simplemobiletools.calendar.interfaces.WeeklyCalendar
import com.simplemobiletools.calendar.models.Event
import com.simplemobiletools.commons.helpers.WEEK_SECONDS
import java.util.*

class WeeklyCalendarImpl(val callback: WeeklyCalendar, val context: Context) {
    var mEvents = ArrayList<Event>()

    fun updateWeeklyCalendar(weekStartTS: Int) {
        val endTS = weekStartTS + WEEK_SECONDS
        context.dbHelper.getEvents(weekStartTS, endTS, applyTypeFilter = true) {
            mEvents = it
            callback.updateWeeklyCalendar(it)
        }
    }
}
