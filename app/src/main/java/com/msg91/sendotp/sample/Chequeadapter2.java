package com.msg91.sendotp.sample;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class Chequeadapter2 extends RecyclerView.Adapter<Chequeadapter2.ProductViewHolder> {
    Intent i;


    private Context mCtx;
    private List<Cheque2> productList;

    public Chequeadapter2(Context mCtx, List<Cheque2> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.recycler_c2, null);
        return new ProductViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, int position) {
        final   Cheque2 cheque;   cheque = productList.get(position);
//
//                        holder.d.setText(cheque.getPrize4());
//                        holder.b.setText(cheque.getPrize3());
                        holder.a.setText(cheque.getPrize1());
                        holder.blog.setText(cheque.getImage());
                        holder.datem.setText(cheque.getUser());
                        holder.txtt.setText(cheque.getStatus());
                        holder.c.setText(cheque.getPrize2());
                       // Picasso.get().load(cheque.getPrize()).into(holder.date);

holder.whatsapp.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {


        Uri uri = Uri.parse("smsto:" + cheque.getStatus());
        Intent i = new Intent(Intent.ACTION_SENDTO, uri);
        i.putExtra("sms_body","hi");
        i.setPackage("com.whatsapp");
        mCtx.startActivity(i);


    }
});

        holder.req.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+cheque.getStatus()));
                mCtx.startActivity(intent);





            }
        });
      //  SharedPreferences sharedPreferences = mCtx.getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);

        //Creating editor to store values to shared preferences

       // mCtx.startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));
    }




    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {



        TextView text, txtt, datem, blog, a,c;
        //  ImageView date;
        Button req,whatsapp;


        public ProductViewHolder(View itemView) {
            super(itemView);


            a = itemView.findViewById(R.id.pph311);
           c = itemView.findViewById(R.id.pph511);
            txtt = itemView.findViewById(R.id.pph211);
            datem = itemView.findViewById(R.id.pph111);
            blog = itemView.findViewById(R.id.t_discription111);
            req = itemView.findViewById(R.id.req112);
            whatsapp= itemView.findViewById(R.id.req2);


        }

//    @Override
//    public int getItemCount() {
//        return productList.size();
//    }
//
//    class ProductViewHolder extends RecyclerView.ViewHolder {
//
//

//        public ProductViewHolder(View itemView) {
//            super(itemView);
//
//

////            review=itemView.findViewById(R.id.re);
////            viewreview=itemView.findViewById(R.id.ve);
////          //  pid=itemView.findViewById(R.id.productidd);
//
//        }
//
//    }

    }

}