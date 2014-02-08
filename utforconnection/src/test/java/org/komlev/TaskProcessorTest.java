package org.komlev;

import org.junit.Test;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Created by Alex on 08.02.14.
 */
public class TaskProcessorTest {

    @Test
    public void test1() throws SQLException {
        TaskProcessor processor = new TaskProcessor();
        DataSource dataSource = mock(DataSource.class);
        Connection conn = mock(Connection.class);
        PreparedStatement ps = mock(PreparedStatement.class);
        ResultSet rs = mock(ResultSet.class);

        when(dataSource.getConnection()).thenReturn(conn);
        when(conn.prepareStatement(anyString())).thenReturn(ps);
        when(ps.executeQuery()).thenReturn(rs);
        when(rs.next()).thenReturn(true, true, false);
        when(rs.getString(anyString())).thenReturn("R1", "R2");

        processor.setDataSource(dataSource);
        assertEquals(2, processor.execute());
    }
}
