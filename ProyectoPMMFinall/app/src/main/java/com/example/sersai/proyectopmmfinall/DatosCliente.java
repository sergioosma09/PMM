package com.example.sersai.proyectopmmfinall;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class DatosCliente extends BaseAdapter {
    private Context context;
    private ArrayList<Usuario> userModelArrayList;

    public DatosCliente(Context context, ArrayList<Usuario> userModelArrayList) {

        this.context = context;
        this.userModelArrayList = userModelArrayList;
    }


    @Override
    public int getCount() {
        return userModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return userModelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.lista_item, null, true);

            holder.tvnombre = (TextView) convertView.findViewById(R.id.name);
            holder.tvedad= (TextView) convertView.findViewById(R.id.etedad);
            holder.tvdescrip = (TextView) convertView.findViewById(R.id.etdescripcion);


            convertView.setTag(holder);
        }else {
            holder = (ViewHolder)convertView.getTag();
        }

        holder.tvnombre.setText("Nombre: " + userModelArrayList.get(position).getName());
        holder.tvedad.setText("Edad: " + userModelArrayList.get(position).getEdad());
        holder.tvdescrip.setText("Descripcion: " + userModelArrayList.get(position).getDescripcion());

        return convertView;
    }
    private class ViewHolder {

        protected TextView tvnombre, tvedad, tvdescrip;
    }

}
