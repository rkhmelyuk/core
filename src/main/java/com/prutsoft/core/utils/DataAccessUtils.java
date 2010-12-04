/*
 * Copyright 2008-2009 Ruslan Khmelyuk.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.prutsoft.core.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * The utils to work with database and related staffs.
 *
 * @author Ruslan Khmelyuk
 * @version $Rev: 25 $
 * @since 2008-8-20 16:36
 */
public class DataAccessUtils {

    /**
     * Close or try to close the connection.
     * If connection is <code>null</code> or is closed or can't be closed, than this function
     * returns <code>false</code>
     *
     * @param connection the connection to close; can be null.
     * @return true if connection is closed, otherwise false.
     */
    public static boolean close(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                return true;
            }
        }
        catch (SQLException e) {
            // ignore, but return false
        }
        return false;
    }

    /**
     * Close or try to close the statement.
     * If statement is <code>null</code> or can't be closed, than this function
     * returns <code>false</code>
     *
     * @param statement the statement to close; can be null.
     * @return true if statement is closed, otherwise false.
     */
    public static boolean close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
                return true;
            }
        }
        catch (SQLException e) {
            // ignore, but return false
        }
        return false;
    }

    /**
     * Close or try to close the result set.
     * If result set is <code>null</code> or can't be closed, than this function
     * returns <code>false</code>
     *
     * @param resultSet the result set to close; can be null.
     * @return true if result set is closed, otherwise false.
     */
    public static boolean close(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
                return true;
            }
        }
        catch (SQLException e) {
            // ignore, but return false
        }
        return false;
    }
}
