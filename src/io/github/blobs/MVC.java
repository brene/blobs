package io.github.blobs;

import io.github.blobs.controller.Controller;
import io.github.blobs.controller.IController;
import io.github.blobs.model.Game;
import io.github.blobs.model.IModel;
import io.github.blobs.view.IView;
import io.github.blobs.view.View;

/**
 * Created by root on 08.06.16.
 */
public class MVC {
    private static IModel model;
    private static IView view;
    private static IController controller;

    public static void launch() {
        view = new View();
        model = new Game(view);
        controller = new Controller(model);
        view.setController(controller);
        view.run();
    }

    public static IModel getModel() {
        return model;
    }

    public static IView getView() {
        return view;
    }

    public static IController getController() {
        return controller;
    }
}
