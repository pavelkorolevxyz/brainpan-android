package xyz.pavelkorolev.brainpan.core.ui

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class BaseFragment constructor(
    @LayoutRes contentLayoutId: Int,
) : Fragment(contentLayoutId) {

    constructor() : this(0)
}
