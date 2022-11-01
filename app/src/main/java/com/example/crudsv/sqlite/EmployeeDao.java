package com.example.crudsv.sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.crudsv.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    private SQLiteDatabase db;

    public EmployeeDao(Context context) {
        DBHelper helper = new DBHelper(context);

        db = helper.getWritableDatabase();
    }
    @SuppressLint("Range")
    public List<Employee> get(String sql, String ...selectArgs){
        List<Employee> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectArgs);

        while (cursor.moveToNext()){
            Employee emp = new Employee();
            emp.setIdCate(cursor.getString(cursor.getColumnIndex("idCate")));
            emp.setName(cursor.getString(cursor.getColumnIndex("name")));

            list.add(emp);
        }
        return list;
    }
    public List<Employee> getAll(){
        String sql2 = "SELECT * FROM Category";

        return get(sql2);
    }
    public Employee getByIdCate(String id){
        String sql2 = "SELECT * FROM Category WHERE id = ?";

        List<Employee> list = get(sql2, id);

        return list.get(0);
    }
    public long insert(Employee emp) {
        ContentValues values = new ContentValues();
        values.put("id",emp.getIdCate());
        values.put("name",emp.getName());;

        return db.insert("Category",null,values);
    }

    public long update(Employee emp) {
        ContentValues values = new ContentValues();
        values.put("name",emp.getName());

        return db.update("Category", values, "id=?",new String[]{emp.getIdCate()});
    }
    public int delete(String id){
        return db.delete("Category","id=?", new String[]{id});
    }
}
