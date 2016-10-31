package cn.edu.gdmec.s07150808.mycontacts1;

import android.content.ContentValues;
import android.content.Context;


/**
 * Created by chen on 2016/10/21.
 */
public class ContactsTable {
  private final static String TABLENAME="contactsTable";
    private MyDB db;
    public ContactsTable(Context context){
        db=new MyDB(context);
        if(!db.isTableExits(TABLENAME)) {
            String tableSql = "CREATE TABLE IF NOT EXISTS " + TABLENAME + " (id_DB integer " + " primary key AUTOINCREMENT," +
                    User.NAME + " VARCHAR," + User.PHONE + " VARCHAR," + User.QQ + " VARCHAR," + User.ADDRESS + " VARCHAR," + User.WORKPLACE + " VARCHAR)";
            db.createTable(tableSql);
        }
    }
    public boolean addData(User user){
        ContentValues values=new ContentValues();
        values.put(User.NAME,user.getName());
        values.put(User.PHONE,user.getPhone());
        values.put(User.QQ,user.getQq());
        values.put(User.ADDRESS,user.getAddress());
        values.put(User.WORKPLACE,user.getWorkplace());

        return  db.save(TABLENAME,values);
    }
}
