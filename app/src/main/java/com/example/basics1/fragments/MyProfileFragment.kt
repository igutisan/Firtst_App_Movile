package com.example.basics1.fragments


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.basics1.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.imageview.ShapeableImageView


class MyProfileFragment : Fragment() {
    private lateinit var profileImage: ShapeableImageView
    private lateinit var tvFullName: TextView
    private lateinit var tvEmail: TextView
    private lateinit var tvPhone: TextView
    private lateinit var btnEditProfile: MaterialButton

    private lateinit var sharedPreferences: SharedPreferences

    companion object {
        private const val PREF_NAMES = "UserData"
        private const val NAME_KEY = "name"
        private const val LAST_NAME_KEY = "lastName"
        private const val EMAIL_KEY = "email"
        private const val PHONE_KEY = "phone"

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_my_profile, container, false)
        initViews(view)
        setupSharedPreferences()
        loadUserData()
        return view
    }

    private fun loadUserData() {
        TODO("Not yet implemented")
        // Carga de datos desde el shared preferences
    }

    private fun setupSharedPreferences() {
        sharedPreferences = requireActivity().getSharedPreferences(
            PREF_NAMES,
            Context.MODE_PRIVATE
        )
    }

    private fun initViews(view:View){
        profileImage = view.findViewById(R.id.profile_image)
        tvFullName = view.findViewById(R.id.tv_full_name)
        tvEmail = view.findViewById(R.id.tv_email)
        tvPhone = view.findViewById(R.id.tv_phone)
        btnEditProfile = view.findViewById(R.id.btn_edit_profile)
    }
}