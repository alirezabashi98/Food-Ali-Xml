package com.alirezabashi98.foodalixml.utility

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide

fun Context.glideSetImage(url: String, view: ImageView) =
    Glide.with(this).load(url).centerCrop().into(view)

fun Context.glideSetImage(drawable: Drawable, view: ImageView) =
    Glide.with(this).load(drawable).centerCrop().into(view)