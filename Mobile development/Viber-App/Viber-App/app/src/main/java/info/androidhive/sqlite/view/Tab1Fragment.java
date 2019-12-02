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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import info.androidhive.sqlite.R;
import info.androidhive.sqlite.database.DatabaseHelper;
import info.androidhive.sqlite.database.model.Contact;
import info.androidhive.sqlite.utils.MyDividerItemDecoration;
import info.androidhive.sqlite.utils.RecyclerTouchListener;


public class Tab1Fragment extends Fragment {
    private static final String TAG = "Tab1Fragment";

    private ContactsAdapter mAdapter;
    private List<Contact> contactsList = new ArrayList<>();
    private CoordinatorLayout coordinatorLayout;
    private RecyclerView recyclerView;
    private TextView noConatactsView;



    private DatabaseHelper db;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1_fragment,container,false);

        coordinatorLayout = view.findViewById(R.id.coordinator_layout);
        recyclerView = view.findViewById(R.id.recycler_view);

        db = new DatabaseHelper(this.getContext());

        contactsList.addAll(db.getAllContacts());

        // TABS LOGIC

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showContactDialog(false, null, -1);
            }
        });

        mAdapter = new ContactsAdapter(getContext(), contactsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new MyDividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL, 16));
        recyclerView.setAdapter(mAdapter);


        /**
         * On long press on RecyclerView item, open alert dialog
         * with options to choose
         * Edit and Delete
         * */
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

    /**
     * Inserting new contact in db
     * and refreshing the list
     */
    private void createContact(String contact, long phone) {
        // inserting contact in db and getting
        // newly inserted contact id
        long id = db.insertContact(contact,phone);

        // get the newly inserted contact from db
        Contact n = db.getContact(id);

        if (n != null) {
            // adding new contact to array list at 0 position
            contactsList.add(0, n);

            // refreshing the list
            mAdapter.notifyDataSetChanged();

        }
    }

    /**
     * Updating contact in db and updating
     * item in the list by its position
     */
    private void updateContact(String contact, String phone, int position) {
        Contact n = contactsList.get(position);
        // updating contact text
        long phoneNumber = Long.parseLong(phone);
        n.setName(contact);
        n.setPhone(phoneNumber);

        // updating contact in db
        db.updateContact(n);

        // refreshing the list
        contactsList.set(position, n);
        mAdapter.notifyItemChanged(position);

    }

    /**
     * Deleting contact from SQLite and removing the
     * item from the list by its position
     */
    private void deleteContact(int position) {
        // deleting the contact from db
        db.deleteContact(contactsList.get(position));

        // removing the contact from the list
        contactsList.remove(position);
        mAdapter.notifyItemRemoved(position);

    }

    /**
     * Opens dialog with Edit - Delete options
     * Edit - 0
     * Delete - 0
     */
    private void showActionsDialog(final int position) {
        CharSequence colors[] = new CharSequence[]{"Edit", "Delete"};

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Choose option");
        builder.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    showContactDialog(true, contactsList.get(position), position);
                } else {
                    deleteContact(position);
                }
            }
        });
        builder.show();
    }


    /**
     * Shows alert dialog with EditText options to enter / edit
     * a contact.
     * when shouldUpdate=true, it automatically displays old contact and changes the
     * button text to UPDATE
     */
    private void showContactDialog(final boolean shouldUpdate, final Contact contact, final int position) {
        LayoutInflater layoutInflaterAndroid = LayoutInflater.from(getContext());
        View view = layoutInflaterAndroid.inflate(R.layout.contact_dialog, null);

        AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(getContext());
        alertDialogBuilderUserInput.setView(view);

        final EditText inputContact = view.findViewById(R.id.note);
        final EditText phone = view.findViewById(R.id.phone);

        TextView dialogTitle = view.findViewById(R.id.dialog_title);
        dialogTitle.setText(!shouldUpdate ? getString(R.string.lbl_new_contact_title) : getString(R.string.lbl_edit_contact_title));

        if (shouldUpdate && contact != null) {
            inputContact.setText(contact.getName());
            phone.setText(String.valueOf(contact.getPhone()));

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
                if (TextUtils.isEmpty(inputContact.getText().toString())) {
                    Toast.makeText(getContext(), "Enter contact!", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    alertDialog.dismiss();
                }

                // check if user updating contact
                if (shouldUpdate && contact != null) {
                    // update contact by it's id
                    updateContact(inputContact.getText().toString(),phone.getText().toString(), position);
                } else {
                    if (phone.getText().toString().contains("[a-zA-Z]+") == false
                            && phone.getText().toString().length() != 10){
                        Toast.makeText(getContext(), "Enter vaid phone number!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    // create new contact
                    long phoneNumber = Long.parseLong(phone.getText().toString());
                    createContact(inputContact.getText().toString(), phoneNumber);
                }
            }
        });
    }

}
