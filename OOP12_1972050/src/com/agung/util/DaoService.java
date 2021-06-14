/*
 * @author 1972050 - Agung Wijaya Al Halim
 */

package com.agung.util;

import java.sql.SQLException;
import java.util.List;

public interface DaoService<X> {
    List<X> fetchAll() throws SQLException,ClassNotFoundException;
    int addData(X t) throws SQLException,ClassNotFoundException;
    int updateData(X t)throws SQLException,ClassNotFoundException;
    int deleteData(X t)throws SQLException,ClassNotFoundException;
}
