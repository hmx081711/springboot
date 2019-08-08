package com.springboot.dataSource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DatasourceController {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/item")
    public Map<String, Object> showItem(@RequestParam(value = "itemId",defaultValue ="883893") long itemId) throws SQLException {

        Map<String,Object> map = new HashMap<>();
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            Statement statement = conn.createStatement();
            String sql = "SELECT title,price FROM tb_item WHERE id =" + itemId;
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                long price = resultSet.getLong("price");
                map.put("title",title);
                map.put("price",price);
            }
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    @RequestMapping("/items")
    public List<Map<String,Object>> showItems() {
        return jdbcTemplate.execute(new StatementCallback<List<Map<String, Object>>>() {
            @Override
            public List<Map<String, Object>> doInStatement(Statement statement) throws SQLException, DataAccessException {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM tb_item");
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();

                List<Map<String, Object>> list = new ArrayList<>();
                while (resultSet.next()) {
                    HashMap<String,Object> map = new HashMap<>();
                    for (int i = 1; i <= columnCount; i++) {
                        Object object = resultSet.getObject(i);
                        map.put(metaData.getColumnName(i),object);
                    }
                    list.add(map);
                }
                return list;
            }
        });
    }

    @RequestMapping("/insert")
    public String insertItem(@RequestParam(value = "title") String title,
                                                 @RequestParam("price")Long price) {
        String sql = "INSERT INTO tb_item(id,num,cid,title,price,created,updated) VALUES(1433,22,560,?,?,'2015-03-08 21:33:18','2015-03-08 21:33:18')";
        Boolean status = jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

                ps.setString(1, title);
                ps.setLong(2, price);
                return ps.executeUpdate() > 0;
            }
        });
        if (status) {
            return "ok";
        }
        return "operation Invalid";
    }
}
