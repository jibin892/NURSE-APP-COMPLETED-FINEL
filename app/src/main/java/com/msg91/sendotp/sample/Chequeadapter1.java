package com.msg91.sendotp.sample;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Chequeadapter1 extends RecyclerView.Adapter<Chequeadapter1.ProductViewHolder> {
    Intent i;


    private Context mCtx;
    private List<Cheque1> productList;

    public Chequeadapter1(Context mCtx, List<Cheque1> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.recycler_c1, null);
        return new ProductViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, int position) {
        final   Cheque1 cheque;   cheque = productList.get(position);

                        holder.d.setText(cheque.getPrize4());
                        holder.b.setText(cheque.getPrize3());
                        holder.a.setText(cheque.getPrize1());
                        holder.blog.setText(cheque.getImage());
                        holder.datem.setText(cheque.getUser());
                        holder.txtt.setText(cheque.getStatus());
                        holder.c.setText(cheque.getPrize2());
                       // Picasso.get().load(cheque.getPrize()).into(holder.date);

        holder.sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Uri uri = Uri.parse("smsto:" + cheque.getUser());
                Intent i = new Intent(Intent.ACTION_SENDTO, uri);
                i.putExtra("sms_body","hi");
                i.setPackage("com.android.mms");
                mCtx.startActivity(i);


            }
        });

        holder.req.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+cheque.getUser()));
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



        TextView text, txtt, datem, blog, a, b, c,d;
        //  ImageView date;
        Button req,sms;


        public ProductViewHolder(View itemView) {
            super(itemView);


            a = itemView.findViewById(R.id.pph31);
            b = itemView.findViewById(R.id.pph41);
           c = itemView.findViewById(R.id.pph51);
            d = itemView.findViewById(R.id.pph61);
            txtt = itemView.findViewById(R.id.pph21);
           // date = itemView.findViewById(R.id.t_name11);
            datem = itemView.findViewById(R.id.pph11);
            blog = itemView.findViewById(R.id.t_discription11);
            req = itemView.findViewById(R.id.req1);
            sms = itemView.findViewById(R.id.sms);


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