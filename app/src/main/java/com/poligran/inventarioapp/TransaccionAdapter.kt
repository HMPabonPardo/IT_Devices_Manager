package com.poligran.inventarioapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TransaccionAdapter(private val listaTransacciones: List<Transaccion>) :
    RecyclerView.Adapter<TransaccionAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivIcono: ImageView = view.findViewById(R.id.ivIconoEquipo)
        val tvNombre: TextView = view.findViewById(R.id.tvNombreEquipo)
        val tvSerial: TextView = view.findViewById(R.id.tvSerialEquipo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_transaccion, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val transaccion = listaTransacciones[position]
        holder.ivIcono.setImageResource(transaccion.idIcono)
        holder.tvNombre.text = transaccion.nombreEquipo
        holder.tvSerial.text = transaccion.serialEquipo
    }

    override fun getItemCount() = listaTransacciones.size
}