package com.nando.materialbackdrop

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import androidx.coordinatorlayout.widget.CoordinatorLayout

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
    }

    private fun verifyResourceVariables() {
        if (headerNavigationIcon == -1) headerNavigationIcon = null
        if (headerExpandedNavigationIcon == -1) headerExpandedNavigationIcon = null
        if (subHeaderNavigationIcon == -1) subHeaderNavigationIcon = null
        if (subHeaderExpandedNavigationIcon == -1) subHeaderExpandedNavigationIcon = null
    }
}