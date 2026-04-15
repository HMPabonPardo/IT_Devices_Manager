package com.poligran.inventarioapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TransaccionesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_transacciones, container, false)
        val rvTransacciones = view.findViewById<RecyclerView>(R.id.rvListaTransacciones)

        // Datos simulados idénticos a tu Mockup
        val listaDatos = listOf(
            Transaccion("Portátil 123456", "SIS054H • Líder de Sistemas", android.R.drawable.ic_menu_camera),
            Transaccion("Portátil 123456", "SIS054H • Líder de Sistemas", android.R.drawable.ic_menu_camera),
            Transaccion("Portátil 123456", "SIS054H • Líder de Sistemas", android.R.drawable.ic_menu_camera),
            Transaccion("Portátil 123456", "SIS054H • Gerente de Projecto", android.R.drawable.ic_menu_camera)
        )

        rvTransacciones.layoutManager = LinearLayoutManager(requireContext())
        rvTransacciones.adapter = TransaccionAdapter(listaDatos)

        return view
    }
}