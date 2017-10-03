package au.elegantmedia.com.contactapp.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import au.elegantmedia.com.contactapp.R;
import au.elegantmedia.com.contactapp.models.Contact;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Devinda on 9/25/17.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    List<Contact> contactList;
    Context context;

    public ContactAdapter(List<Contact> contactList, Context context) {
        this.contactList = contactList;
        this.context = context;
    }

    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactAdapter.ViewHolder holder, int position) {
        Contact contact = contactList.get(position);

        holder.nName.setText(contact.getName());
        holder.nEmail.setText(contact.getEmail());
        holder.nPhone.setText(contact.getPhone());
        holder.imageButton.setImageURI(Uri.parse(contact.getImage()));
        // holder.nImageView.setI
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //        @BindView(R.id.iv_pic)
//        ImageView nImageView;
        @BindView(R.id.tv_name)
        TextView nName;
        @BindView(R.id.tv_email)
        TextView nEmail;
        @BindView(R.id.tv_phone)
        TextView nPhone;
        @BindView(R.id.contact_img)
        ImageButton imageButton;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
