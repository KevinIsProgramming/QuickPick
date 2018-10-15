package com.mad.quickpick.home;

import com.mad.quickpick.BasePresenter;
import com.mad.quickpick.BaseView;

public interface HomeInterface {

    /**
     * This specifies the contract between the view and the presenter.
     */
    interface View extends BaseView<Presenter>{

    }

    interface Presenter extends BasePresenter {

    }
}
