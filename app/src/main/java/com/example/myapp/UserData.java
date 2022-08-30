import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myapp.ProfileRecyclerData;

public class UserData extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "contactsManager";
    private static final String USERS = "contacts";
    private static final String TABLE_CONTACTS = "contacts";
    private static final String USERS_ID = "id";
    private static final String USERS_EMAIL="email";
    private static final String USERS_NAME = "name";
    int idCount=0;
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + USERS + "("
                + USERS_ID + " INTEGER PRIMARY KEY," + USERS_NAME + " TEXT"+ USERS_EMAIL+")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    void addContact(ProfileRecyclerData contact) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(USERS_ID, ++idCount);
        values.put(USERS_NAME, contact.getName());
        values.put(USERS_EMAIL, contact.getEmail());

        db.insert(TABLE_CONTACTS, null, values);
        db.close();
    }

    ProfileRecyclerData getContact(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new String[] { USERS_ID,
                        USERS_NAME, USERS_EMAIL }, USERS_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

//        ProfileRecyclerData contact = new ProfileRecyclerData(Integer.parseInt(cursor.getString(0)),
//                cursor.getString(1), cursor.getString(2));
        // return contact
    }
}
