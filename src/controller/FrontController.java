package controller;

import factory.BeanFactory;

public class FrontController {
    private BeanFactory factory;

    public FrontController() {
        factory = BeanFactory.getInstance();
    }


}
