package factory;

import controller.BookController;
import controller.CartController;
import controller.OrderController;
import controller.UserContoller;
import domain.dao.*;
import service.book.BookService;
import service.book.BookServiceImpl;
import service.cart.CartService;
import service.cart.CartServiceImpl;
import service.order.OrderService;
import service.order.OrderServiceImpl;
import service.user.UserService;
import service.user.UserServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class BeanFactory {
    private ParentDao dao;

    public Map<String, Object> map;
    private static BeanFactory instance;

    private BeanFactory() {
        BookService bookService = new BookServiceImpl(new BookDao());
        UserService userService = new UserServiceImpl(new UserDao());
        CartService cartService = new CartServiceImpl(new CartDao());
        OrderService orderService = new OrderServiceImpl(new OrderDao());

        map = new HashMap<>();
        map.put("user", new UserContoller(userService));
        map.put("book", new BookController(bookService));
        map.put("cart", new CartController(cartService));
        map.put("order", new OrderController(orderService));

    }

    public static BeanFactory getInstance() {
        if (instance == null) {
            instance = new BeanFactory();
        }
        return instance;
    }

    public Object getController(String type) {
        return map.get(type);
    }
}
