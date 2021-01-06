package zeus0789.unicorn.filepicker.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import zeus0789.unicorn.filepicker.R;
import zeus0789.unicorn.filepicker.models.DirectoryModel;


/**
 * Created by Abhishek Tiwari on 05-01-2021.
 */
public class DirectoryStackAdapter extends RecyclerView.Adapter<DirectoryStackAdapter.ViewHolder> {

    private Context context;
    private ArrayList<DirectoryModel> directoryList;
    private onDirectoryStackListener onDirectoryStackListener;

    public interface onDirectoryStackListener{
        void onDirClicked(DirectoryModel model);
    }

    public DirectoryStackAdapter(Context context, ArrayList<DirectoryModel> directoryList, onDirectoryStackListener listener) {
        this.context = context;
        this.directoryList = directoryList;
        this.onDirectoryStackListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout_directory_stack, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_dir_name.setText(directoryList.get(position).getName());

        if(position == getItemCount()-1){
            holder.tv_dir_name.setTextColor(context.getResources().getColor(R.color.myColorAccent));
        }else{
            holder.tv_dir_name.setTextColor(context.getResources().getColor(R.color.white));
        }

        holder.itemView.setOnClickListener((v)->{
            onDirectoryStackListener.onDirClicked(directoryList.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return directoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_dir_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_dir_name = itemView.findViewById(R.id.tv_dir_name);
        }
    }
}
