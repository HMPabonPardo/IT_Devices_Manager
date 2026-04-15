package com.poligran.inventarioapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class MenuFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_menu, container, false)
        val btnTransacciones = view.findViewById<Button>(R.id.btnMenuTransacciones)

        btnTransacciones.setOnClickListener {
            // Al hacer clic, carga la lista en el lado derecho
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContenedorContenido, TransaccionesFragment())
                .commit()
        }
        return view
    }
}