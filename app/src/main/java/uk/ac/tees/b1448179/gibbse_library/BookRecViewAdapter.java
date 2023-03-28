package uk.ac.tees.b1448179.gibbse_library;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookRecViewAdapter extends RecyclerView.Adapter<BookRecViewAdapter.ViewHolder> {

    private static final String TAG = "BookRecViewAdapter"; //to show log called
    private ArrayList<Books> books = new ArrayList<>();
    private Context mContext;

    public BookRecViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    //create method for recyclerview
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_book,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Log.d(TAG, "onBindViewHolder: Called");
        //set name for book
        holder.txtBookName.setText(books.get(position).getName()); //add glide dependencies
        Glide.with(mContext)
                .asBitmap()
                .load(books.get(position).getImageUrl())
                .into(holder.imgBook);

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create an intent to switch to book activity on click
                Intent intent = new Intent(mContext, BookActivity.class);
                mContext.startActivity(intent);
                Toast.makeText(mContext, books.get(position).getName() + "  Selected and Loaded!", Toast.LENGTH_SHORT).show();
            }
        });

        holder.txtAuthor.setText(books.get(position).getAuthor());
        holder.txtDescription.setText(books.get(position).getShortDesc());


        //check if expanded or not
        if (books.get(position).isExpanded()){
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expandedRelLayout.setVisibility(View.VISIBLE);
            holder.downArrow.setVisibility(View.GONE);
        }else {
            holder.expandedRelLayout.setVisibility(View.GONE);
            holder.downArrow.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    //create setter method for books array


    public void setBooks(ArrayList<Books> books) {
        this.books = books;
        notifyDataSetChanged(); //for updates
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private CardView parent;
        private ImageView imgBook;
        private TextView txtBookName;

        //declaring variables for dropdown
        private ImageView downArrow, upArrow;
        private RelativeLayout expandedRelLayout;
        private TextView txtAuthor, txtDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            imgBook = itemView.findViewById(R.id.imgBook);
            txtBookName = itemView.findViewById(R.id.txtBookName);

            //initializing variables for drop down
            downArrow = itemView.findViewById(R.id.btnDownArrow);
            upArrow = itemView.findViewById(R.id.btnUpArrow);
            expandedRelLayout = itemView.findViewById(R.id.expandableRelLayout);
            txtAuthor = itemView.findViewById(R.id.txtAuthor);
            txtDescription = itemView.findViewById(R.id.txtShortDesc);

            //set on click listener for down arrow
            downArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Books book = books.get(getAdapterPosition());  //getbook from view holder
                    book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAdapterPosition());

                }
            });

            //set on click listener for down up
            upArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Books book = books.get(getAdapterPosition());  //getbook from view holder
                    book.setExpanded(!book.isExpanded()); //invert isExpanded view
                    notifyItemChanged(getAdapterPosition());
                }
            });



        }
    }
}
