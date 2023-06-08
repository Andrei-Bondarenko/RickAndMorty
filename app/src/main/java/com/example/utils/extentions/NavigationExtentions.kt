package com.example.utils.extentions

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import androidx.lifecycle.Lifecycle
import com.example.rickandmorty.R

private const val PREVIOUS_FRAGMENT_TAG_ARG = "PREVIOUS_FRAGMENT_TAG_ARG"
private var backPressedTime = 0L
private const val minBackPressedTime = 2000
private const val minBackStackEntryCount = 2

fun Fragment.replace(fragment: Fragment, id:Int) {
    val fragmentManager = requireActivity().supportFragmentManager
    val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
    fragmentTransaction.addToBackStack(null)
        .replace(id, fragment)
        .commit()
}
fun Fragment.popScreen() {
    requireActivity().hideKeyboard()

    val fragmentManager = parentFragment?.childFragmentManager ?: childFragmentManager
    if (fragmentManager.backStackEntryCount < minBackStackEntryCount) {
//        requireActivity().popFeature()
    } else {
        whenStateAtLeast(Lifecycle.State.STARTED) { fragmentManager.popBackStack() }
    }
}

fun Fragment.replaceScreen(
    fragment: Fragment,
    popCurrent: Boolean = false,
    clearBackStack: Boolean = false,
    addToBackStack: Boolean = true,
    requestCode: Int? = null,
    tag: String = fragment::class.java.name,
    fragmentManager: FragmentManager = activity?.supportFragmentManager ?: childFragmentManager
) = whenStateAtLeast(Lifecycle.State.STARTED) {
    requireActivity().hideKeyboard()
    if (clearBackStack)
        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    fragmentManager.commit {
        if (popCurrent) {
            this@replaceScreen.popScreen()
            getCurrentScreen()
                ?.let { it.getPreviousTag() ?: it::class.java.name }
                ?.let { fragment.appendArgs(PREVIOUS_FRAGMENT_TAG_ARG to it) }
        }
        replace(R.id.fragmentContainer, fragment, tag)
        if (addToBackStack) addToBackStack(tag)
        if (requestCode != null) fragment.setTargetFragment(this@replaceScreen, requestCode)
    }
}

private fun Fragment.getPreviousTag(): String? = arguments?.getString(PREVIOUS_FRAGMENT_TAG_ARG)

fun Fragment.getCurrentScreen(): Fragment? =
    childFragmentManager.findFragmentById(R.id.fragmentContainer)
