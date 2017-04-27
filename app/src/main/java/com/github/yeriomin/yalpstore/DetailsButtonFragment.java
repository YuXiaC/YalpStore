package com.github.yeriomin.yalpstore;

import android.view.View;
import android.widget.Button;

import com.github.yeriomin.yalpstore.model.App;

public abstract class DetailsButtonFragment extends DetailsFragment {

    protected Button button;

    public DetailsButtonFragment(DetailsActivity activity, App app) {
        super(activity, app);
        this.button = getButton();
    }

    abstract protected Button getButton();

    abstract protected boolean shouldBeVisible();

    abstract protected View.OnClickListener getOnClickListener();

    @Override
    public void draw() {
        if (null == button) {
            return;
        }
        button.setVisibility(shouldBeVisible() ? View.VISIBLE : View.GONE);
        button.setOnClickListener(getOnClickListener());
    }

    protected void disableButton(int buttonId, int stringId) {
        Button button = (Button) activity.findViewById(buttonId);
        button.setText(stringId);
        button.setEnabled(false);
    }
}
