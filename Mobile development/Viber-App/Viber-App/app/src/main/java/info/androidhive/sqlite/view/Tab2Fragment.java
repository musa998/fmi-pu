package info.androidhive.sqlite.view;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import info.androidhive.sqlite.R;
import info.androidhive.sqlite.database.DatabaseHelper;
import info.androidhive.sqlite.database.model.Contact;
import info.androidhive.sqlite.database.model.Message;
import info.androidhive.sqlite.utils.MyDividerItemDecoration;
import info.androidhive.sqlite.utils.RecyclerTouchListener;


public class Tab2Fragment extends Fragment {
    private static final String TAG = "Tab2Fragment";

    private MessagesAdapter mAdapter;
    private List<Message> messageList = new ArrayList<>();
    private CoordinatorLayout coordinatorLayout;
    private RecyclerView recyclerView;

    private DatabaseHelper db;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab2_fragment,container,false);

        coordinatorLayout = view.findViewById(R.id.coordinator_layout2);
        recyclerView = view.findViewById(R.id.recycler_view2);

        db = new DatabaseHelper(this.getContext());

        messageList.addAll(db.getAllMessages());
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMessageDialog(false, null, -1);
            }
        });

        mAdapter = new MessagesAdapter(getContext(), messageList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new MyDividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL, 16));
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(),
                recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, final int position) {
            }

            @Override
            public void onLongClick(View view, int position) {
                showActionsDialog(position);
            }
        }));

        return view;
    }
    private void createMessage(String content, long reciver) {
        // inserting message in db and getting
        // newly inserted note id
        long id = db.insertMessage(content,reciver);

        // get the newly inserted note from db
        Message n = db.getMessage(id);

        if (n != null) {
            // adding new message to array list at 0 position
            messageList.add(0, n);

            // refreshing the list
            mAdapter.notifyDataSetChanged();

        }
    }
    private void updateMessage(String message,String content, int position) {
        Message m = messageList.get(position);
        // updating message text
        m.setContent(message);
        // updating note in db
        db.updateMessage(m);

        // refreshing the list
        messageList.set(position, m);
        mAdapter.notifyItemChanged(position);

    }
    private void deleteMessage(int position) {
        // deleting the message from db
        db.deleteMessage(messageList.get(position));

        // removing the note from the list
        messageList.remove(position);
        mAdapter.notifyItemRemoved(position);
    }
    private void showActionsDialog(final int position) {
        CharSequence colors[] = new CharSequence[]{"Edit", "Delete"};

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Choose option");
        builder.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    showMessageDialog(true, messageList.get(position), position);
                } else {
                    deleteMessage(position);
                }
            }
        });
        builder.show();
    }
    private void showMessageDialog(final boolean shouldUpdate, final Message note, final int position) {
        LayoutInflater layoutInflaterAndroid = LayoutInflater.from(getContext());
        View view = layoutInflaterAndroid.inflate(R.layout.message_dialog, null);

        AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(getContext());
        alertDialogBuilderUserInput.setView(view);

        final EditText inputContent = view.findViewById(R.id.messageContent);
        final EditText inputReciver = view.findViewById(R.id.phoneNumber);

        TextView dialogTitle = view.findViewById(R.id.dialog_title);
        dialogTitle.setText(!shouldUpdate ? getString(R.string.lbl_new_contact_title) : getString(R.string.lbl_edit_contact_title));

        if (shouldUpdate && note != null) {
            inputContent.setText(note.getContent());
        }
        alertDialogBuilderUserInput
                .setCancelable(false)
                .setPositiveButton(shouldUpdate ? "update" : "save", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogBox, int id) {

                    }
                })
                .setNegativeButton("cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogBox, int id) {
                                dialogBox.cancel();
                            }
                        });

        final AlertDialog alertDialog = alertDialogBuilderUserInput.create();
        alertDialog.show();

        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show toast message when no text is entered
                if (TextUtils.isEmpty(inputContent.getText().toString())) {
                    Toast.makeText(getContext(), "Enter message!", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    alertDialog.dismiss();
                }

                // check if user updating note
                if (shouldUpdate && note != null) {
                    // update note by it's id
                    updateMessage(inputContent.getText().toString(),inputReciver.getText().toString(), position);
                } else {

                    // create new note
                    long phoneNumber = Long.parseLong(inputReciver.getText().toString());
                    createMessage(inputContent.getText().toString(), phoneNumber);
                }
            }
        });
    }




}
