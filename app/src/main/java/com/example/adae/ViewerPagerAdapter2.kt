package com.example.adae

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.adae.databinding.BoardItemBinding
import com.example.adae.models.Board


class ViewerPagerAdapter2(private val boardList: List<Board>, private val onItemSelected: OnItemSelected? = null):
    RecyclerView.Adapter<ViewerPagerAdapter2.BoardViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.board_item, parent, false)
        return BoardViewHolder(view, onItemSelected)
    }


    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
             holder.bind(boardList[position])

    }

    override fun getItemCount(): Int {
       return boardList.size
    }

inner class BoardViewHolder(itemView: View, private val onItemSelected: OnItemSelected? = null): RecyclerView.ViewHolder(itemView) {

    private val binding = BoardItemBinding.bind(itemView)

    private val contenedor = binding.container
    private val imagen = binding.imageView
    private val titulo = binding.titulo
    private val descripcion = binding.descripcion
    private val boton = binding.siguiente

    fun bind(board: Board) = with(itemView) {
        contenedor.background = ContextCompat.getDrawable(context, board.fondo)
        imagen.setImageResource(board.imagen)
        titulo.text = board.titulo
        descripcion.text = board.descripcion

        if (adapterPosition.equals(boardList.size - 1)) {

            boton.text = "Finalizar"
        }
        boton.setOnClickListener{
            onItemSelected?.onClickListener(adapterPosition)
        }
    }

}



    interface OnItemSelected{
        fun onClickListener(position: Int)
    }

}