// Generated code from Butter Knife. Do not modify!
package au.elegantmedia.com.contactapp.adapters;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import au.elegantmedia.com.contactapp.R;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ContactAdapter$ViewHolder_ViewBinding implements Unbinder {
  private ContactAdapter.ViewHolder target;

  @UiThread
  public ContactAdapter$ViewHolder_ViewBinding(ContactAdapter.ViewHolder target, View source) {
    this.target = target;

    target.nName = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'nName'", TextView.class);
    target.nEmail = Utils.findRequiredViewAsType(source, R.id.tv_email, "field 'nEmail'", TextView.class);
    target.nPhone = Utils.findRequiredViewAsType(source, R.id.tv_phone, "field 'nPhone'", TextView.class);
    target.imageButton = Utils.findRequiredViewAsType(source, R.id.contact_img, "field 'imageButton'", ImageButton.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ContactAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.nName = null;
    target.nEmail = null;
    target.nPhone = null;
    target.imageButton = null;
  }
}
