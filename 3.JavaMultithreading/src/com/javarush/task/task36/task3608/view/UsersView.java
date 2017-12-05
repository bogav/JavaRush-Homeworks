package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

/**
 * Created by Admin on 14.09.2017.
 */
public class UsersView implements View {
    private Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void refresh(ModelData modelData) {
        if (!modelData.isDisplayDeletedUserList()) {
            System.out.println("All users:");
            for (User item : modelData.getUsers())
                System.out.println("\t" + item);
        }else {
            System.out.println("All deleted users:");
            for (User item : modelData.getUsers())
                System.out.println("\t" + item);
        }
        System.out.println("===================================================");
    }

    public void fireEventShowAllUsers() {
        controller.onShowAllUsers();
    }

    public void fireEventShowDeletedUsers() { controller.onShowAllDeletedUsers(); }

    public void fireEventOpenUserEditForm(long id) { controller.onOpenUserEditForm(id); }

}
