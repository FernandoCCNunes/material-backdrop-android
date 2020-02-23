package com.nando.materialbackdrop

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.backdrop.view.*


open class Backdrop: CoordinatorLayout {

    private val TAG = "Backdrop"

    private val backPanel: ViewGroup by lazy {backdrop_back_panel}
    private val frontPanel: ViewGroup by lazy {backdrop_front_panel}
    private val bottomSheetBehavior: BottomSheetBehavior<ViewGroup> by lazy {
        BottomSheetBehavior.from(frontPanel)
    }

    private var initialState: Int = 0
    private var canDrag: Boolean = false
    private var minHeight: Float = 0f
    private var expandedOffset: Float = 0f
    private var fitsToContents: Boolean = false

    // Listeners

    private val bottomSheetCallback: BottomSheetBehavior.BottomSheetCallback by lazy {
        object: BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                if (onBottomSheetSlideListener != null) onBottomSheetSlideListener!!(bottomSheet, slideOffset)
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (onBottomSheetStateChangedListener != null) onBottomSheetStateChangedListener!!(bottomSheet, newState)
            }
        }
    }
    private var onBottomSheetSlideListener: ((bottomSheet: View, slideOffset: Float) -> Unit)? = null
    private var onBottomSheetStateChangedListener: ((bottomSheet: View, newState: Int) -> Unit)? = null

    private var onHeaderNavigationIconClickListener: ((icon: View) -> Unit)? = null
    private var headerMenuItemClickListener: ((item: MenuItem) -> Boolean)? = null

    // Back Panel Header
    var headerNavigationIcon: Int = -1
    var headerTitle: String? = null
    var headerMenu: Int? = null





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

        if (typedArray.hasValue(R.styleable.Backdrop_initialState)) {
            initialState = typedArray.getInt(R.styleable.Backdrop_initialState, 0)
        }

        if (typedArray.hasValue(R.styleable.Backdrop_canDrag)) {
            canDrag = typedArray.getBoolean(R.styleable.Backdrop_canDrag, false)
        }

        if (typedArray.hasValue(R.styleable.Backdrop_minHeight)) {
            minHeight = typedArray.getDimension(R.styleable.Backdrop_minHeight, 0f)
        }

        if (typedArray.hasValue(R.styleable.Backdrop_expandedOffset)) {
            expandedOffset = typedArray.getDimension(R.styleable.Backdrop_expandedOffset, 0f)
        }

        if (typedArray.hasValue(R.styleable.Backdrop_fitsToContents)) {
            fitsToContents = typedArray.getBoolean(R.styleable.Backdrop_fitsToContents, false)
        }

        // Header

        if (typedArray.hasValue(R.styleable.Backdrop_headerNavigationIcon)) {
            headerNavigationIcon = typedArray.getResourceId(R.styleable.Backdrop_headerNavigationIcon, -1)
        }

        if (typedArray.hasValue(R.styleable.Backdrop_headerTitle)) {
            headerTitle = typedArray.getString(R.styleable.Backdrop_headerTitle)
        }

        if (typedArray.hasValue(R.styleable.Backdrop_headerMenu)) {
            headerMenu = typedArray.getResourceId(R.styleable.Backdrop_headerMenu, -1)
        }
    }

    private fun inflateLayout() {
        inflate(context, R.layout.backdrop, this)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()

        setBottomSheetBehaviour()
        setBackPanelHeader()
    }

    private fun setBottomSheetBehaviour() {
        val params = frontPanel.layoutParams as LayoutParams
        params.behavior = BottomSheetBehavior<ViewGroup>()
        frontPanel.requestLayout()
        bottomSheetBehavior.setExpandedOffset(expandedOffset.toInt())
        bottomSheetBehavior.peekHeight = minHeight.toInt()
        bottomSheetBehavior.isDraggable = canDrag
        bottomSheetBehavior.isFitToContents = fitsToContents
        when(initialState) {
            0 -> bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            1 -> bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            2 -> bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        }
    }

    private fun setBackPanelHeader() {
        addOnHeaderNavigationIconClickListener()
        addOnHeaderMenuItemClickListener()

        if (headerNavigationIcon != -1) {
            backdrop_back_panel_header.setNavigationIcon(headerNavigationIcon)
        }

        if (headerTitle != null) {
            backdrop_back_panel_header.title = headerTitle
        }

        if (headerMenu != null) {
            backdrop_back_panel_header.inflateMenu(headerMenu!!)

        }
    }

    private fun addBottomSheetCalbackListener() {
        Log.d(TAG, "adding BottomSheetCallback listener to the view")
        bottomSheetBehavior.addBottomSheetCallback(bottomSheetCallback)
    }

    private fun removeBottomSheetCalbackListener() {
        Log.d(TAG, "removing BottomSheetCallback listener from view")
        bottomSheetBehavior.removeBottomSheetCallback(bottomSheetCallback)
    }

    private fun addOnHeaderNavigationIconClickListener() {
        backdrop_back_panel_header.setNavigationOnClickListener {
            if (onHeaderNavigationIconClickListener != null) onHeaderNavigationIconClickListener!!(it)
        }
    }

    private fun addOnHeaderMenuItemClickListener() {
        backdrop_back_panel_header.setOnMenuItemClickListener {
            if (headerMenuItemClickListener != null) {
                headerMenuItemClickListener!!(it)
            }
            false
        }
    }

    fun expandFrontLayer() {
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
    }

    fun collapseFrontLayer() {
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
    }

    fun toggleFrontLayer() {
        if (isFrontLayerExpanded()) collapseFrontLayer()
        else expandFrontLayer()
    }

    fun isFrontLayerExpanded(): Boolean = bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED

    fun setOnBottomSheetSlideListener(listener: (bottomSheet: View, slideOffset: Float) -> Unit) {
        onBottomSheetSlideListener = listener
    }

    fun setOnBottomSheetStateChangedListener(listener: (bottomSheet: View, newState: Int) -> Unit) {
        onBottomSheetStateChangedListener = listener
    }

    fun setOnHeaderNavigationIconClickListener(listener: (icon: View) -> Unit) {
        onHeaderNavigationIconClickListener = listener
    }

    fun setOnHeaderMenuItemClickListener(listener: (item: MenuItem) -> Boolean) {
        this.headerMenuItemClickListener = listener
    }



    private fun debug(message: String) {
        Log.d("Backdrop", message)
    }


    override fun onDetachedFromWindow() {
        removeBottomSheetCalbackListener()
        super.onDetachedFromWindow()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        addBottomSheetCalbackListener()
    }
}