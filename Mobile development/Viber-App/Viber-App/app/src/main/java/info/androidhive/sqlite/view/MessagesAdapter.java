package info.androidhive.sqlite.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import info.androidhive.sqlite.R;
import info.androidhive.sqlite.database.model.Contact;
import info.androidhive.sqlite.database.model.Message;

public class MessagesAdapter  extends RecyclerView.Adapter<MessagesAdapter.MyViewHolder> {

private Context context;
private List<Message> messageList;

public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView messages;
    public TextView reciver;
    public TextView dot;
    public TextView timestamp;

    public MyViewHolder(View view) {
        super(view);
        messages = view.findViewById(R.id.messageContent);
        reciver = view.findViewById(R.id.phoneNumber);
        dot = view.findViewById(R.id.dot);
        timestamp = view.findViewById(R.id.timestamp);
    }
}

    public MessagesAdapter(Context context, List<Message> messageList) {
        this.context = context;
        this.messageList = messageList;
    }

    @Override
    public MessagesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.message_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MessagesAdapter.MyViewHolder holder, int position) {
        Message message = messageList.get(position);

        holder.messages.setText(message.getContent());

        holder.reciver.setText((String.valueOf(message.getReciver())));

        // Displaying dot from HTML character code
        holder.dot.setText(Html.fromHtml("&#8226;"));

        // Formatting and displaying timestamp
        holder.timestamp.setText(formatDate(message.getTimestamp()));
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    /**
     * Formatting timestamp to `MMM d` format
     * Input: 2018-02-21 00:15:42
     * Output: Feb 21
     */
    private String formatDate(String dateStr) {
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = fmt.parse(dateStr);
            SimpleDateFormat fmtOut = new SimpleDateFormat("MMM d");
            return fmtOut.format(date);
        } catch (ParseException e) {

        }

        return "";
    }
}


