package factory;

import domain.dao.BookDao;
import service.BookService;

import java.util.HashMap;
import java.util.Map;

public class BeanFactory {
    private BookService service;
    private BookDao dao;

    public Map<String, Object> map;
    private static BeanFactory instance;

    private BeanFactory() {
//        dao = new TodoOracleDao();
//        service = new TodoService(dao);
//
//        map = new HashMap<>();
//        map.put("list", new TodoReadController(service));
//        map.put("register", new TodoInsertController(service));
//        map.put("update", new TodoUpdateController(service));
//        map.put("delete", new TodoDeleteController(service));
//        map.put("read", new TodoReadController(service));
//        map.put("checkedList", new TodoCheckedReadController(service));
//        map.put("uncheckedList", new TodoUncheckedReadController(service));
//        map.put("sort", new TodoSortController(service));
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
