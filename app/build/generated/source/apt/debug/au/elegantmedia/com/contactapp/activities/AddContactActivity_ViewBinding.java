// Generated code from Butter Knife. Do not modify!
package au.elegantmedia.com.contactapp.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import au.elegantmedia.com.contactapp.R;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AddContactActivity_ViewBinding implements Unbinder {
  private AddContactActivity target;

  private View view2131558524;

  private View view2131558529;

  private View view2131558530;

  @UiThread
  public AddContactActivity_ViewBinding(AddContactActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AddContactActivity_ViewBinding(final AddContactActivity target, View source) {
    this.target = target;

    View view;
    target.mName = Utils.findRequiredViewAsType(source, R.id.et_name, "field 'mName'", EditText.class);
    target.mEmail = Utils.findRequiredViewAsType(source, R.id.et_email, "field 'mEmail'", EditText.class);
    target.mPhone = Utils.findRequiredViewAsType(source, R.id.et_phone, "field 'mPhone'", EditText.class);
    view = Utils.findRequiredView(source, R.id.contact_img, "field 'imageButton' and method 'Image'");
    target.imageButton = Utils.castView(view, R.id.contact_img, "field 'imageButton'", ImageButton.class);
    view2131558524 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.Image();
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_save, "method 'saveContact'");
    view2131558529 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.saveContact();
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_cancel, "method 'cancel'");
    view2131558530 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.cancel();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    AddContactActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mName = null;
    target.mEmail = null;
    target.mPhone = null;
    target.imageButton = null;

    view2131558524.setOnClickListener(null);
    view2131558524 = null;
    view2131558529.setOnClickListener(null);
    view2131558529 = null;
    view2131558530.setOnClickListener(null);
    view2131558530 = null;
  }
}
