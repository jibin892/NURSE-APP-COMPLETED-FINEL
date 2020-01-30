package com.msg91.sendotp.sample;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Chequeadapter extends RecyclerView.Adapter<Chequeadapter.ProductViewHolder> {
    Intent i;

    private Context mCtx;
    private List<Cheque> productList;

    public Chequeadapter(Context mCtx, List<Cheque> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.recycler_c, null);
        return new ProductViewHolder(view);

    }
    @Override
    public void onBindViewHolder(final ProductViewHolder holder, int position) {
        final   Cheque cheque;   cheque = productList.get(position);

        //loading the image
                         holder.c.setText(cheque.getPrize2());
                         holder.b.setText(cheque.getPrize3());
                        holder.a.setText(cheque.getPrize1());
                        holder.blog.setText(cheque.getImage());
                        holder.datem.setText(cheque.getUser());
                        holder.txtt.setText(cheque.getStatus());
                        Picasso.get().load(cheque.getPrize()).into(holder.date);



holder.req.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {


        Intent i=new Intent(mCtx,Request.class);
       // i.putExtra("BitmapImage", image);
         // your bitmap

        i.putExtra("image", cheque.getPrize());
        i.putExtra("name",cheque.getUser());
        i.putExtra("name1",cheque.getImage());
        i.putExtra("name2",cheque.getStatus());
        //i.putExtra("name3",cheque.getPrize());
        mCtx.startActivity(i);
    }
});
      //  SharedPreferences sharedPreferences = mCtx.getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);

        //Creating editor to store values to shared preferences


    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {



        TextView text,txtt,datem,blog,a,b,c;
        ImageView date;
        Button req;
        public ProductViewHolder(View itemView) {
            super(itemView);


            a=itemView.findViewById(R.id.pph3);

            b=itemView.findViewById(R.id.pph4);
            c=itemView.findViewById(R.id.pph5);
            txtt=itemView.findViewById(R.id.pph2);
            date=itemView.findViewById(R.id.t_name1);
            datem=itemView.findViewById(R.id.pph1);
            blog=itemView.findViewById(R.id.t_discription1);
           req=itemView.findViewById(R.id.req);
//            review=itemView.findViewById(R.id.re);
//            viewreview=itemView.findViewById(R.id.ve);
//          //  pid=itemView.findViewById(R.id.productidd);

        }

    }



}