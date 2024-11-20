package com.example.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class UsersAdapter extends BaseAdapter {
    private List<Users> users;
    private Context context;

    public UsersAdapter(List<Users> users, Context context) {
        this.users = users;
        this.context = context;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(context).inflate(R.layout.users_item, viewGroup,false);

        TextView emailtextView = view.findViewById(R.id.emailTextView);
        TextView passwordTextView = view.findViewById(R.id.passwordTextView);

        emailtextView.setText(users.get(i).getEmail());
        passwordTextView.setText(users.get(i).getPassword());

        return view;
    }
}
