package com.malkinfo.navigationdrawar.extension
import android.os.Bundle
import android.util.Log
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.fragment.findNavController

fun Fragment.navigateSafe(
    @IdRes resId: Int,
    bundle: Bundle? = null,
    navOptions: NavOptions? = null,
    navigatorExtras: Navigator.Extras? = null,
) {
    try {
        findNavController().navigate(
            resId,
            bundle,
            navOptions,
            navigatorExtras
        )
    } catch (exp: Exception) {
        Log.e("FRAGMENT", exp.toString())
    }
}

fun Fragment.test(): String {
    return "atakan";
}