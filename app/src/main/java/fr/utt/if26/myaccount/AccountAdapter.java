package fr.utt.if26.myaccount;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.ViewHolder> {
    List<Line> account;

    public AccountAdapter(List<Line> account) {
        this.account = account;
    }

    @NonNull
    @Override
    public AccountAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.account_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AccountAdapter.ViewHolder holder, int position) {
        holder.title.setText(account.get(position).getTitle());
        holder.date.setText(account.get(position).getDay()+"/"+account.get(position).getMonth()+"/"+account.get(position).getYear());
        holder.category.setText(account.get(position).getCategory());
        if(account.get(position).isExpense()){
            holder.expense.setText("expense");
        }else{
            holder.expense.setText("income");
        }
    }

    @Override
    public int getItemCount() {
        return account.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView title;
        public TextView date;
        public TextView category;
        public TextView expense;
        public TextView amount;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title= itemView.findViewById(R.id.row_title);
            date= itemView.findViewById(R.id.row_date);
            category= itemView.findViewById(R.id.row_category);
            expense= itemView.findViewById(R.id.row_expense);
            amount= itemView.findViewById(R.id.row_amount);

        }
    }
}
