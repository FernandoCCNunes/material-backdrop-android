package com.nando.materialbackdrop

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.widget.AppCompatDrawableManager
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import kotlinx.android.synthetic.main.backdrop.view.*


class Backdrop: CoordinatorLayout {

    // Navigation Icon
    private var headerNavigationIcon: Int? = null
    private var headerExpandedNavigationIcon: Int? = null
    private var subHeaderNavigationIcon: Int? = null
    private var subHeaderExpandedNavigationIcon: Int? = null

    // Title
    private var headerTitle: String? = null
    private var headerExpandedTitle: String? = null
    private var subHeaderTitle: String? = null
    private var subHeaderExpandedTitle: String? = null

    // Menu
    private var headerMenu: Int? = null
    private var headerExpandedMenu: Int? = null
    private var subHeaderMenu: Int? = null
    private var subHeaderExpandedMenu: Int? = null

    // Keep Actionbar
    private var headerKeepActionBarWhenExpanded: Boolean = true
    private var subHeaderKeepActionBarWhenExpanded: Boolean = true


    // Colors
    private var headerBackgroundColor: ColorStateList? = null
    private var headerNavigationIconColor: ColorStateList? = null
    private var headerTitleColor: ColorStateList? = null
    private var backgroundColor: ColorStateList? = null
    private var subHeaderBackgroundColor: ColorStateList? = null
    private var subHeaderNavigationIconColor: ColorStateList? = null
    private var subHeaderTitleColor: ColorStateList? = null
    private var foregroundColor: ColorStateList? = null


    constructor(context: Context) : super(context) {
        inflateLayout()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context) {
        setupAttributes(attrs)
        inflateLayout()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context) {
        setupAttributes(attrs, defStyleAttr)
        inflateLayout()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(context) {
        setupAttributes(attrs, defStyleAttr, defStyleRes)
        verifyResourceVariables()
        inflateLayout()

    }

    private fun inflateLayout() {
        inflate(context, R.layout.backdrop, this)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()

        // Header

        if (headerNavigationIcon != null) {
            val icon = AppCompatDrawableManager.get().getDrawable(context, headerNavigationIcon!!)
            if (headerNavigationIconColor != null) {
                DrawableCompat.setTintList(icon, headerNavigationIconColor)
            }
            backdrop_back_layout_header.navigationIcon = icon
        }

        if (headerTitle != null) {
            backdrop_back_layout_header.title = headerTitle
            if (headerTitleColor != null) {
                backdrop_back_layout_header.setTitleTextColor(headerTitleColor!!)
            }
        }

        if (headerMenu != null) {
            backdrop_back_layout_header.inflateMenu(headerMenu!!)
        }


        // SubHeader


        if (subHeaderNavigationIcon != null) {
            val icon = AppCompatDrawableManager.get().getDrawable(context, subHeaderNavigationIcon!!)
            if (subHeaderNavigationIconColor != null) {
                DrawableCompat.setTintList(icon, headerNavigationIconColor)
            }
            backdrop_front_layout_header.navigationIcon = icon
        }

        if (subHeaderTitle != null) {
            backdrop_front_layout_header.title = subHeaderTitle
            if (subHeaderTitleColor != null) {
                backdrop_front_layout_header.setTitleTextColor(subHeaderTitleColor!!)
            } else if (subHeaderTitleColor.isValid()) {
                Log.d("Backdrop", "subHeaderTitleColor -> $subHeaderTitleColor")
                backdrop_front_layout_header.setTitleTextColor(ContextCompat.getColor(context, subHeaderTitleColor!!))
            }
        }
    }


    private fun setupAttributes(attrs: AttributeSet?) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.Backdrop, 0, 0)
        getAttributes(typedArray)
        typedArray.recycle()
    }

    private fun setupAttributes(attrs: AttributeSet?, defStyleAttr: Int) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.Backdrop, defStyleAttr, 0)
        getAttributes(typedArray)
        typedArray.recycle()
    }

    private fun setupAttributes(attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.Backdrop, defStyleAttr, defStyleRes)
        getAttributes(typedArray)
        typedArray.recycle()
    }

    private fun getAttributes(typedArray: TypedArray) {

        // Navigation
        if (typedArray.hasValue(R.styleable.Backdrop_headerNavigationIcon)) {
            headerNavigationIcon = typedArray.getResourceId(R.styleable.Backdrop_headerNavigationIcon, -1)
        }

        if (typedArray.hasValue(R.styleable.Backdrop_headerExpandedNavigationIcon)) {
            headerExpandedNavigationIcon = typedArray.getResourceId(R.styleable.Backdrop_headerExpandedNavigationIcon, -1)
        } else {
            headerExpandedNavigationIcon = headerNavigationIcon
        }

        if (typedArray.hasValue(R.styleable.Backdrop_headerNavigationIcon)) {
            subHeaderNavigationIcon = typedArray.getResourceId(R.styleable.Backdrop_subHeaderNavigationIcon, -1)
        }

        if (typedArray.hasValue(R.styleable.Backdrop_headerExpandedNavigationIcon)) {
            subHeaderExpandedNavigationIcon = typedArray.getResourceId(R.styleable.Backdrop_subHeaderExpandedNavigationIcon, -1)
        } else {
            subHeaderExpandedNavigationIcon = subHeaderNavigationIcon
        }

        // Title
        if (typedArray.hasValue(R.styleable.Backdrop_headerTitle)) {
            headerTitle = typedArray.getString(R.styleable.Backdrop_headerTitle)
        }

        if (typedArray.hasValue(R.styleable.Backdrop_headerExpandedTitle)) {
            headerExpandedTitle = typedArray.getString(R.styleable.Backdrop_headerExpandedTitle)
        } else {
            headerExpandedTitle = headerTitle
        }

        if (typedArray.hasValue(R.styleable.Backdrop_subHeaderTitle)) {
            subHeaderTitle = typedArray.getString(R.styleable.Backdrop_subHeaderTitle)
        }

        if (typedArray.hasValue(R.styleable.Backdrop_subHeaderExpandedTitle)) {
            subHeaderExpandedTitle = typedArray.getString(R.styleable.Backdrop_subHeaderExpandedTitle)
        } else {
            subHeaderExpandedTitle = subHeaderTitle
        }

        // Menu
        if (typedArray.hasValue(R.styleable.Backdrop_headerMenu)) {
            headerMenu = typedArray.getResourceId(R.styleable.Backdrop_headerMenu, -1)
        }

        if (typedArray.hasValue(R.styleable.Backdrop_headerExpandedMenu)) {
            headerExpandedMenu = typedArray.getResourceId(R.styleable.Backdrop_headerExpandedMenu, -1)
        } else {
            headerExpandedMenu = headerMenu
        }

        if (typedArray.hasValue(R.styleable.Backdrop_subHeaderMenu)) {
            subHeaderMenu = typedArray.getResourceId(R.styleable.Backdrop_subHeaderMenu, -1)
        }

        if (typedArray.hasValue(R.styleable.Backdrop_subHeaderExpandedMenu)) {
            subHeaderExpandedMenu = typedArray.getResourceId(R.styleable.Backdrop_subHeaderExpandedMenu, -1)
        } else {
            subHeaderExpandedMenu = subHeaderMenu
        }

        // Keep ActionBar
        if (typedArray.hasValue(R.styleable.Backdrop_headerKeepActionBarWhenExpanded)) {
            headerKeepActionBarWhenExpanded = typedArray.getBoolean(R.styleable.Backdrop_headerKeepActionBarWhenExpanded, true)
        }

        if (typedArray.hasValue(R.styleable.Backdrop_subHeaderKeepActionBarWhenExpanded)) {
            subHeaderKeepActionBarWhenExpanded = typedArray.getBoolean(R.styleable.Backdrop_subHeaderKeepActionBarWhenExpanded, true)
        }



        // Colors
        if (typedArray.hasValue(R.styleable.Backdrop_headerBackgroundColor)) {
            headerBackgroundColor = typedArray.getColorStateList(R.styleable.Backdrop_headerBackgroundColor)
        }

        if (typedArray.hasValue(R.styleable.Backdrop_headerNavigationIconColor)) {
            headerNavigationIconColor = typedArray.getColorStateList(R.styleable.Backdrop_headerNavigationIconColor)
        }

        if (typedArray.hasValue(R.styleable.Backdrop_headerTitleColor)) {
            headerTitleColor = typedArray.getColorStateList(R.styleable.Backdrop_headerTitleColor)
        }

        if (typedArray.hasValue(R.styleable.Backdrop_backgroundColor)) {
            backgroundColor = typedArray.getColorStateList(R.styleable.Backdrop_backgroundColor)
        }

        if (typedArray.hasValue(R.styleable.Backdrop_subHeaderBackgroundColor)) {
            subHeaderBackgroundColor = typedArray.getColorStateList(R.styleable.Backdrop_subHeaderBackgroundColor)
        }

        if (typedArray.hasValue(R.styleable.Backdrop_subHeaderNavigationIconColor)) {
            subHeaderNavigationIconColor = typedArray.getColorStateList(R.styleable.Backdrop_subHeaderNavigationIconColor)
        }

        if (typedArray.hasValue(R.styleable.Backdrop_subHeaderTitleColor)) {
            subHeaderTitleColor = typedArray.getColorStateList(R.styleable.Backdrop_subHeaderTitleColor)
        }

        if (typedArray.hasValue(R.styleable.Backdrop_foregroundColor)) {
            foregroundColor = typedArray.getColorStateList(R.styleable.Backdrop_foregroundColor)
        }
















    }



    private fun verifyResourceVariables() {
        if (headerNavigationIcon == -1) headerNavigationIcon = null
        if (headerExpandedNavigationIcon == -1) headerExpandedNavigationIcon = null
        if (subHeaderNavigationIcon == -1) subHeaderNavigationIcon = null
        if (subHeaderExpandedNavigationIcon == -1) subHeaderExpandedNavigationIcon = null
    }

    private fun Int?.isValid() : Boolean =  this != null && this != -1
}