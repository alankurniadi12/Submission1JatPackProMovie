package com.example.sub1moviejatpackpro.home

import android.view.View
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import kotlinx.android.synthetic.main.items_tv_show.view.*
import org.hamcrest.Matcher

class MyCustomeViewAction {
    object MyViewAction{
        fun clickChildViewWithId(): ViewAction{
            return object: ViewAction {
                override fun getDescription(): String {
                    return "Click on child view specifield Id"
                }

                override fun getConstraints(): Matcher<View>? {
                    return null
                }

                override fun perform(uiController: UiController?, view: View) {
                    val v = view.btn_play_tv
                    v.performClick()
                }

            }
        }
    }

}