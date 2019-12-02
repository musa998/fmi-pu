package info.androidhive.sqlite.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.CpuUsageInfo;

import java.util.ArrayList;
import java.util.List;

import info.androidhive.sqlite.database.model.Contact;
import info.androidhive.sqlite.database.model.Message;


public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "viber_db";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        // create contacts table
        db.execSQL(Contact.CREATE_TABLE);
        db.execSQL(Message.CREATE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Contact.TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    public long insertContact(String contact, long phone) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(Contact.COLUMN_NAME, contact);
        values.put(Contact.COLUMN_PHONE, phone);

        // insert row
        long id = db.insert(Contact.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    public Contact getContact(long id) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Contact.TABLE_NAME,
                new String[]{Contact.COLUMN_ID, Contact.COLUMN_NAME,Contact.COLUMN_PHONE, Contact.COLUMN_TIMESTAMP},
                Contact.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        // prepare contact object
        Contact contact = new Contact(
                cursor.getInt(cursor.getColumnIndex(Contact.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(Contact.COLUMN_NAME)),
                cursor.getInt(cursor.getColumnIndex(Contact.COLUMN_PHONE)),
                cursor.getString(cursor.getColumnIndex(Contact.COLUMN_TIMESTAMP)));

        // close the db connection
        cursor.close();

        return contact;
    }

    public List<Contact> getAllContacts() {
        List<Contact> contacts = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + Contact.TABLE_NAME + " ORDER BY " +
                Contact.COLUMN_TIMESTAMP + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact();
                contact.setId(cursor.getInt(cursor.getColumnIndex(Contact.COLUMN_ID)));
                contact.setName(cursor.getString(cursor.getColumnIndex(Contact.COLUMN_NAME)));
                contact.setPhone(cursor.getInt(cursor.getColumnIndex(Contact.COLUMN_PHONE)));
                contact.setTimestamp(cursor.getString(cursor.getColumnIndex(Contact.COLUMN_TIMESTAMP)));

                contacts.add(contact);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return contacts list
        return contacts;
    }

    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + Contact.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();


        // return count
        return count;
    }

    public int updateContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Contact.COLUMN_NAME, contact.getName());

        // updating row
        return db.update(Contact.TABLE_NAME, values, Contact.COLUMN_ID + " = ?",
                new String[]{String.valueOf(contact.getId())});
    }

    public void deleteContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Contact.TABLE_NAME, Contact.COLUMN_ID + " = ?",
                new String[]{String.valueOf(contact.getId())});
        db.close();
    }
    /// MESSAGE LOGIC ---------------------------------------------------------------------------------

    public List<Message> getAllMessages() {
        List<Message> messages = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + Message.TABLE_NAME + " ORDER BY " +
                Message.COLUMN_TIMESTAMP + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Message message = new Message();
                message.setId(cursor.getInt(cursor.getColumnIndex(Message.COLUMN_ID)));
                message.setContent(cursor.getString(cursor.getColumnIndex(Message.COLUMN_CONTENT)));
                message.setReciver(cursor.getInt(cursor.getColumnIndex(Message.COLUMN_RECIVER)));
                message.setTimestamp(cursor.getString(cursor.getColumnIndex(Message.COLUMN_TIMESTAMP)));

                messages.add(message);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return messages list
        return messages;
    }

    public long insertMessage(String content, long reciver) {

        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(Message.COLUMN_CONTENT, content);
        values.put(Message.COLUMN_RECIVER, reciver);

        // insert row
        long id = db.insert(Message.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }


    public Message getMessage(long id) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Message.TABLE_NAME,
                new String[]{Message.COLUMN_ID, Message.COLUMN_CONTENT,Message.COLUMN_RECIVER, Message.COLUMN_TIMESTAMP},
                Message.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        // prepare message object
        Message message = new Message(
                cursor.getInt(cursor.getColumnIndex(Message.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(Message.COLUMN_CONTENT)),
                cursor.getInt(cursor.getColumnIndex(Message.COLUMN_RECIVER)),
                cursor.getString(cursor.getColumnIndex(Message.COLUMN_TIMESTAMP)));

        // close the db connection
        cursor.close();

        return message;
    }
    public int updateMessage(Message message) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Message.COLUMN_CONTENT, message.getContent());

        // updating row
        return db.update(Message.TABLE_NAME, values, Message.COLUMN_ID + " = ?",
                new String[]{String.valueOf(message.getId())});
    }

    public void deleteMessage(Message message) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Message.TABLE_NAME, Message.COLUMN_ID + " = ?",
                new String[]{String.valueOf(message.getId())});
        db.close();
    }


}
