package Data;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import javax.persistence.NoResultException;
import java.io.*;
import java.net.URL;
import java.util.List;

public class DataContext implements AutoCloseable {

    Transaction tran;

    public DataContext()
    {
        tran = DataAccess.getSession().beginTransaction();
    }

    public Session getSession()
    {
        return DataAccess.getSession();
    }

    private String readSQL(String sqlFilePath)
    {
        URL url = getClass().getResource("/Data/SQL/" + sqlFilePath + ".sql");
        String sql;
        try
        {
            sql = Resources.toString(url, Charsets.UTF_8);
        }
        catch (IOException ex)
        {
            System.out.println("Unable to read file executeSQLFileList: " + sqlFilePath + " " + ex.getMessage());
            return null;
        }

        return sql;
    }

    private <T> NativeQuery<T> buildQuery(String sqlFilePath, Class c, SqlParameter... params)
    {
        String sql = readSQL(sqlFilePath);
        NativeQuery<T> query = getSession()
                .createNativeQuery(sql, c);

        for(SqlParameter p : params)
        {
            query.setParameter(p.getName(), p.getValue());
        }

        return query;
    }

    private <T> NativeQuery<T> buildQuery(String sqlFilePath, SqlParameter... params)
    {
        String sql = readSQL(sqlFilePath);
        NativeQuery<T> query = getSession()
                .createNativeQuery(sql);

        for(SqlParameter p : params)
        {
            query.setParameter(p.getName(), p.getValue());
        }

        return query;
    }

    public <T> List<T> executeSQLList(String sqlFilePath, Class c, SqlParameter... params)
    {
        List<T> result;

        try
        {
            NativeQuery<T> query = buildQuery(sqlFilePath, c, params);
            result = query.getResultList();
        }
        catch (NoResultException ex)
        {
            result = null;
        }

        return result;
    }

    public <T> T executeSQLSingle(String sqlFilePath, Class c, SqlParameter... params)
    {
        T result;
        try
        {
            NativeQuery<T> query = buildQuery(sqlFilePath, c, params);
            result = query.getSingleResult();
        }
        catch (NoResultException ex)
        {
            result = null;
        }

        return result;
    }

    public <T> T executeSQLSingle(String sqlFilePath, SqlParameter... params)
    {
        T result;
        try
        {
            NativeQuery<T> query = buildQuery(sqlFilePath, params);
            result =query.getSingleResult();
        }
        catch(NoResultException ex)
        {
            result = null;
        }

        return result;
    }

    public int executeUpdateOrDelete(String sqlFilePath, SqlParameter... params)
    {
        String sql = readSQL(sqlFilePath);
        NativeQuery query = getSession()
                .createNativeQuery(sql);

        for(SqlParameter p : params)
        {
            query.setParameter(p.getName(), p.getValue());
        }

        return query.executeUpdate();
    }

    @Override
    public void close()  {
        tran.commit();
    }
}
