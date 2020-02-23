package com.nando.materialbackdrop


import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatDrawableManager
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.backdrop.view.*


open class Backdropp {
/*
    private val sheetBehavior: BottomSheetBehavior<LinearLayout> by lazy {
        BottomSheetBehavior.from(
            backdrop_front_layout
        )
    }

    val header: MaterialToolbar by lazy { backdrop_back_layout_header }
    val subheader: MaterialToolbar by lazy { backdrop_front_layout_header }

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


    // Listeners
    private var headerNavigationIconClickListener: ((view: View) -> Unit)? = null
    private var subheaderNavigationIconClickListener: ((view: View) -> Unit)? = null
    private var headerMenuItemClickListener: ((item: MenuItem) -> Boolean)? = null
    private var subheaderMenuItemClickListener: ((item: MenuItem) -> Boolean)? = null


    constructor(context: Context) : super(context) {
        inflateLayout()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        setupAttributes(attrs)
        inflateLayout()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        setupAttributes(attrs, defStyleAttr)
        inflateLayout()
    }

    private fun inflateLayout() {
        inflate(context, R.layout.backdrop, this)


    }

    override fun onFinishInflate() {
        super.onFinishInflate()

        setBottomSheetBehaviour()
        setOnHeaderNavigationIconClickListener()
        setOnSubHeaderNavigationIconClickListener()
        setOnHeaderMenuItemClickListener()
        setOnSubHeaderMenuItemClickListener()

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
            val icon =
                AppCompatDrawableManager.get().getDrawable(context, subHeaderNavigationIcon!!)
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
                backdrop_front_layout_header.setTitleTextColor(
                    ContextCompat.getColor(
                        context,
                        subHeaderTitleColor!!
                    )
                )
            }
        }
    }

    private fun setBottomSheetBehaviour() {
        sheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED

    }


    private fun setupAttributes(attrs: AttributeSet?) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.Backdrop, 0, 0)
        getAttributes(typedArray)
        typedArray.recycle()
    }

    private fun setupAttributes(attrs: AttributeSet?, defStyleAttr: Int) {
        val typedArray =
            context.obtainStyledAttributes(attrs, R.styleable.Backdrop, defStyleAttr, 0)
        getAttributes(typedArray)
        typedArray.recycle()
    }

    private fun getAttributes(typedArray: TypedArray) {

        // Navigation
        *//*if (typedArray.hasValue(R.styleable.Backdrop_headerNavigationIcon)) {
            headerNavigationIcon =
                typedArray.getResourceId(R.styleable.Backdrop_headerNavigationIcon, -1)
        }

        if (typedArray.hasValue(R.styleable.Backdrop_headerExpandedNavigationIcon)) {
            headerExpandedNavigationIcon =
                typedArray.getResourceId(R.styleable.Backdrop_headerExpandedNavigationIcon, -1)
        } else {
            headerExpandedNavigationIcon = headerNavigationIcon
        }

        if (typedArray.hasValue(R.styleable.Backdrop_headerNavigationIcon)) {
            subHeaderNavigationIcon =
                typedArray.getResourceId(R.styleable.Backdrop_subHeaderNavigationIcon, -1)
        }

        if (typedArray.hasValue(R.styleable.Backdrop_headerExpandedNavigationIcon)) {
            subHeaderExpandedNavigationIcon =
                typedArray.getResourceId(R.styleable.Backdrop_subHeaderExpandedNavigationIcon, -1)
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
            subHeaderExpandedTitle =
                typedArray.getString(R.styleable.Backdrop_subHeaderExpandedTitle)
        } else {
            subHeaderExpandedTitle = subHeaderTitle
        }

        // Menu
        if (typedArray.hasValue(R.styleable.Backdrop_headerMenu)) {
            headerMenu = typedArray.getResourceId(R.styleable.Backdrop_headerMenu, -1)
        }

        if (typedArray.hasValue(R.styleable.Backdrop_headerExpandedMenu)) {
            headerExpandedMenu =
                typedArray.getResourceId(R.styleable.Backdrop_headerExpandedMenu, -1)
        } else {
            headerExpandedMenu = headerMenu
        }

        if (typedArray.hasValue(R.styleable.Backdrop_subHeaderMenu)) {
            subHeaderMenu = typedArray.getResourceId(R.styleable.Backdrop_subHeaderMenu, -1)
        }

        if (typedArray.hasValue(R.styleable.Backdrop_subHeaderExpandedMenu)) {
            subHeaderExpandedMenu =
                typedArray.getResourceId(R.styleable.Backdrop_subHeaderExpandedMenu, -1)
        } else {
            subHeaderExpandedMenu = subHeaderMenu
        }


        // Colors
        if (typedArray.hasValue(R.styleable.Backdrop_headerBackgroundColor)) {
            headerBackgroundColor =
                typedArray.getColorStateList(R.styleable.Backdrop_headerBackgroundColor)
        }

        if (typedArray.hasValue(R.styleable.Backdrop_headerNavigationIconColor)) {
            headerNavigationIconColor =
                typedArray.getColorStateList(R.styleable.Backdrop_headerNavigationIconColor)
        }

        if (typedArray.hasValue(R.styleable.Backdrop_headerTitleColor)) {
            headerTitleColor = typedArray.getColorStateList(R.styleable.Backdrop_headerTitleColor)
        }

        if (typedArray.hasValue(R.styleable.Backdrop_backgroundColor)) {
            backgroundColor = typedArray.getColorStateList(R.styleable.Backdrop_backgroundColor)
        }

        if (typedArray.hasValue(R.styleable.Backdrop_subHeaderBackgroundColor)) {
            subHeaderBackgroundColor =
                typedArray.getColorStateList(R.styleable.Backdrop_subHeaderBackgroundColor)
        }

        if (typedArray.hasValue(R.styleable.Backdrop_subHeaderNavigationIconColor)) {
            subHeaderNavigationIconColor =
                typedArray.getColorStateList(R.styleable.Backdrop_subHeaderNavigationIconColor)
        }

        if (typedArray.hasValue(R.styleable.Backdrop_subHeaderTitleColor)) {
            subHeaderTitleColor =
                typedArray.getColorStateList(R.styleable.Backdrop_subHeaderTitleColor)
        }

        if (typedArray.hasValue(R.styleable.Backdrop_foregroundColor)) {
            foregroundColor = typedArray.getColorStateList(R.styleable.Backdrop_foregroundColor)
        }*//*

    }

    fun expandFrontLayer() {
        sheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
    }

    fun collapseFrontLayer() {
        sheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
    }

    fun toggleFrontLayer() {
        if (isFrontLayerExpanded()) collapseFrontLayer()
        else expandFrontLayer()
    }

    fun isFrontLayerExpanded(): Boolean = sheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED


    private fun setOnHeaderNavigationIconClickListener() {
        header.setNavigationOnClickListener {
            if (headerNavigationIconClickListener != null) {
                headerNavigationIconClickListener!!(it)
            }
        }
    }

    fun setOnHeaderNavigationIconClickListener(listener: (view: View) -> Unit) {
        this.headerNavigationIconClickListener = listener
    }

    private fun setOnSubHeaderNavigationIconClickListener() {
        subheader.setNavigationOnClickListener {
            if (subheaderNavigationIconClickListener != null) {
                subheaderNavigationIconClickListener!!(it)
            }
        }
    }

    fun setOnSubHeaderNavigationIconClickListener(listener: (view: View) -> Unit) {
        this.subheaderNavigationIconClickListener = listener
    }

    private fun setOnHeaderMenuItemClickListener() {
        header.setOnMenuItemClickListener {
            if (headerMenuItemClickListener != null) {
                headerMenuItemClickListener!!(it)
            }
            false
        }
    }

    fun setOnHeaderMenuItemClickListener(listener: (item: MenuItem) -> Boolean) {
        this.headerMenuItemClickListener = listener
    }

    private fun setOnSubHeaderMenuItemClickListener() {
        subheader.setOnMenuItemClickListener {
            if (subheaderMenuItemClickListener != null) {
                subheaderMenuItemClickListener!!(it)
            }
            false
        }
    }

    fun setOnSubHeaderMenuItemClickListener(listener: (item: MenuItem) -> Boolean) {
        this.subheaderMenuItemClickListener = listener
    }

    private fun Int?.isValid(): Boolean = this != null && this != -1*/

}